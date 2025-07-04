/*
IPA Transcribers
Copyright (C) 2018 - 2025  Adam Howard

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.medavox.ipa_transcribers

/***The engine that ingests rules and input text, and produces output text.
 * This API takes a context-free approach:
 * Regex is matched to the start of the string only,
 * and the output String is not interpreted as Regex.
 *
 * Therefore, there is no state held by the Transcriber;
 * only simple substitutions matched by Regular expressions may be used.
 **/
abstract class RuleBasedTranscriber:Transcriber, BaseRules {
    abstract val completionStatus: CompletionStatus
    data class UnmatchedOutput(val newWorkingInput:String, val output:(soFar:String) -> String) {
        constructor(newWorkingInput: String, output:String):this(newWorkingInput, {it+output})
    }
    private var reportedChars:String = ""

    /**Fallbacks which 'handle' (in some way) any encountered string that has no Rule which consumes it in the current ruleset.
     *
     * ----------*/

    /**Report (log) the first instance of an unmatched String, then copy it verbatim to the output string. */
    fun reportOnceAndCopy(it:String): UnmatchedOutput {
        if(!reportedChars.contains(it[0])) {
            err.println("copying unknown char '${it[0]}'/'${it[0].toInt().unicodeName}' to output...")
            reportedChars += it[0]
        }
        return UnmatchedOutput(it.substring(1), it[0].toString())
    }

    /**Report every instance of the unmatched String, then omit it from the output*/
    val reportAndSkip:(String) -> UnmatchedOutput get() = {
        err.println("unknown char '${it[0]}'; skipping...")
        UnmatchedOutput(it.substring(1), "")
    }

    /**Report every instance of the unmatched String, then copy it verbatim to the output*/
    val reportAndCopy:(String) -> UnmatchedOutput get() = {
        err.println("copying unknown char '${it[0]}' to output...")
        UnmatchedOutput(it.substring(1), it[0].toString())
    }

    /**Copy any unmatched Strings verbatim to the output, without reporting them.*/
    val copy: (String) -> UnmatchedOutput get() = {
        UnmatchedOutput(it.substring(1), it[0].toString())
    }

    /**WIP do not use
     * Applies the rule which consumes the most characters.
     *
     * Attempt 2
     * This greedy matcher matches against the most specific rule,
     *  not the one that consumes the most characters.

        Given the example:
        Rule ("abc", "def", 1),
        Rule("ab", "xy")

        The first rule will match, even though the second one consumes more characters.

        Includes the consumed match (if any) in the specificity metric.
     *///todo: when 2 rules are of equal specificity, use the one that appears first
    fun String.processGreedily(rules:List<IRule>, onNoRuleMatch:(unmatched:String) -> UnmatchedOutput) : String {
        var out: String = ""
        var processingWord: String = this
        var consumed = ""
        loop@ while(processingWord.isNotEmpty()) {
            //get the regex result of the unconsumedInput and alreadyConsumed matchers,
            //because we'll be using them a lot.
            //using a triple makes it easier to keep the IRule together with its MatchResults
            val candidateRules = rules.map {
                Triple<IRule, MatchResult?, MatchResult?>(it,
                    it.unconsumedMatcher.find(processingWord),
                    it.consumedMatcher?.findAll(consumed)?.lastOrNull())
            }.filter {(_, unconsumed, consumedMatch) -> //filter out rules that don't match:
                //the unconsumed matcher must match at the start, and
                unconsumed?.range?.start == 0 &&
                //the consumed matcher must either be null (unspecified), or
                (consumedMatch == null ||
                //it must match at the end of the "already-consumed input" string
                consumedMatch.range.endInclusive == consumed.length-1)
            }.map { (rule, uncon, con) -> //make the unconsumed MatchResult non-null
                Triple<IRule, MatchResult, MatchResult?>(rule, uncon!!, con)
            }

            if(candidateRules.isEmpty()) {//no rule matched; call the lambda!
                val unmatchedOutput = onNoRuleMatch(processingWord)
                processingWord = unmatchedOutput.newWorkingInput
                out = unmatchedOutput.output(out)
            }else {
                //find the rule that matches (but does not necessarily consume) the most characters
                val (rule, unconsumedMatch) = candidateRules.maxBy { (_, uncon, con) ->
                    uncon.value.length + (con?.value?.length ?: 0)
                }!!
                //println("rule '$rule' matches '$processingWord'")
                out = rule.outputString(out, unconsumedMatch.groups)
                //number of letters consumed is the match length, unless explicitly specified
                val actualLettersConsumed = rule.lettersConsumed ?: unconsumedMatch.value.length
                if (actualLettersConsumed > 0) {
                    consumed += processingWord.substring(0, actualLettersConsumed)
                    processingWord = processingWord.substring(actualLettersConsumed)
                    continue@loop
                }//else keep going through the rule list, staying at the same position  in the input
            }
        }
        return out
    }


    /**The default function to use. Acts as the engine of this entire program.
     * More or less single-pass; at each point in the input String, consumes characters using the first rule which matches the input.
     * the read-head is then advanced forwards in the input string by however many characters the executed Rule states it consumed.
     * Once a rule has matched at the current read-head, been executed and has advanced the read-head,
     * start again, looking for a matching Rule in order from the supplied list at the current point in the remaining input.
     */
    fun String.processWithRules(rules:List<IRule>, onNoRuleMatch:(unmatched:String) -> UnmatchedOutput) : String {
        var out: String = ""
        var processingWord: String = this
        var consumed = ""
        loop@ while(processingWord.isNotEmpty()) {
            //uses the first rule which matches -- so rule order matters
            for (rule in rules) {
                val unconsumedMatch:MatchResult? = rule.unconsumedMatcher.find(processingWord)

                val consumedMatches: Boolean = rule.consumedMatcher == null ||// if it's null, that counts as matching:
                        //rules that don't specify a consumedMatcher aren't checked against it

                    //if it has been specified by this rule, it has to match at the end of the already-consumed string
                    rule.consumedMatcher.findAll(consumed).lastOrNull()?.range?.endInclusive == consumed.length-1

                //if the rule matches the start of the remaining string, and the end of the consumed string
                if(consumedMatches && unconsumedMatch?.range?.start == 0) {
                    //println("rule '$rule' matches '$processingWord'")
                    //add the output of this rule to the in-progress output string
                    out = rule.outputString(out, unconsumedMatch.groups)

                    //figure out how far to advance the read-head of the remaining input string
                    //number of letters consumed is the match length, unless explicitly specified otherwise by the rule
                    val actualLettersConsumed = rule.lettersConsumed ?: unconsumedMatch.value.length
                    if(actualLettersConsumed > 0) {
                        //place consumed characters into the consumed string
                        consumed += processingWord.substring(0, actualLettersConsumed)
                        //remove consumed characters from the start of the remaining input string
                        processingWord = processingWord.substring(actualLettersConsumed)
                        continue@loop
                    }//else keep going through the rule list --  rules which consume no chars will fall through to later rules
                }
            }
            //no rule matched; call the fallback lambda
            val unmatchedOutput = onNoRuleMatch(processingWord)
            processingWord = unmatchedOutput.newWorkingInput
            out = unmatchedOutput.output(out)
        }
        //System.out.println("consumed: $consumed")
        return out
    }
}