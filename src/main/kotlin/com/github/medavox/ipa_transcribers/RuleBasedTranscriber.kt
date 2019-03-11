package com.github.medavox.ipa_transcribers

/***This API takes a context-free approach:
 * Regex is matched to the start of the string only,
 * and the output String is not interpreted as Regex.
 *
 * Therefore, there is no state held by the Transcriber;
 * only simple substitutions matched by Regular expressions may be used.
 **/
abstract class RuleBasedTranscriber:Transcriber, BaseRules {
    abstract val completionStatus:CompletionStatus
    data class UnmatchedOutput(val newWorkingInput:String, val output:(soFar:String) -> String) {
        constructor(newWorkingInput: String, output:String):this(newWorkingInput, {it+output})
    }
    var unhandledChars:String = ""
    fun reportOnceAndCopy(it:String):RuleBasedTranscriber.UnmatchedOutput {
        if(!unhandledChars.contains(it[0])) {
            System.err.println("copying unknown char '${it[0]}' to output...")
            unhandledChars += it[0]
        }
        return RuleBasedTranscriber.UnmatchedOutput(it.substring(1), it[0].toString())
    }
    val reportAndSkip:(String) -> UnmatchedOutput get() = {
        System.err.println("unknown char '${it[0]}'; skipping...")
        UnmatchedOutput(it.substring(1), "")
    }

    val reportAndCopy:(String) -> UnmatchedOutput get() = {
        System.err.println("copying unknown char '${it[0]}' to output...")
        UnmatchedOutput(it.substring(1), it[0].toString())
    }

    val copy:(String) -> UnmatchedOutput get() = {
        UnmatchedOutput(it.substring(1), it[0].toString())
    }

    /*Automatically applies the rule which consumes the most characters*/
    /*fun String.greedy(rules: List<Rule>, onNoRuleMatch: (unmatched: String) -> UnmatchedOutput):String {
        var out:String = ""
        var processingWord = this
        loop@ while(processingWord.isNotEmpty()) {
            //val matchResult:MatchResult? = rule.unconsumedMatcher.find(processingWord)
            val rule:Rule? = rules.filter { it.unconsumedMatcher.find(processingWord)?.range?.start == 0 }
                .sortedBy { it.lettersConsumed }.lastOrNull()
            if(rule == null) {
                //no rule matched; call the lambda!
                val unmatchedOutput = onNoRuleMatch(processingWord)
                processingWord = unmatchedOutput.newWorkingInput
                out = unmatchedOutput.output(out)
            }else {
                out = rule.outputString(out)
                System.out.println("matched rule:$rule")
                //number of letters consumed is the match length, unless explicitly specified
                val actualLettersConsumed = rule.lettersConsumed ?: rule.unconsumedMatcher.find(processingWord)?.value?.length ?: 0
                if(actualLettersConsumed > 0) {
                    processingWord = processingWord.substring(actualLettersConsumed)
                    continue@loop
                }//else keep going through the rule list
            }
        }
        return out
    }*/

    fun String.processWithRules(rules:List<Rule>,
                                onNoRuleMatch:(unmatched:String) -> UnmatchedOutput
    ) : String {
        var out:String = ""
        var processingWord = this
        var consumed = ""
        loop@ while(processingWord.isNotEmpty()) {
            for (rule in rules) {
                val unconsumedMatch:MatchResult? = rule.unconsumedMatcher.find(processingWord)

                //val f = rule.consumedMatcher?.findAll(consumed)?.lastOrNull()
                //if(f != null) System.out.println("rule: $rule; match: ${f.value}, range:${f.range} of $consumed|$processingWord")
                val consumedMatches:Boolean = rule.consumedMatcher == null ||
                    rule.consumedMatcher.findAll(consumed).lastOrNull()?.range?.endInclusive == consumed.length-1

                //if the rule matches the start of the remaining string, and the end of the consumed string
                if(consumedMatches && unconsumedMatch?.range?.start == 0) {
                    //System.out.println("rule '$rule' matches '$processingWord'")
                    out = rule.outputString(out)
                    //System.out.println("matched rule:$rule")
                    //number of letters consumed is the match length, unless explicitly specified
                    val actualLettersConsumed = rule.lettersConsumed ?: unconsumedMatch.value.length
                    if(actualLettersConsumed > 0) {
                        consumed += processingWord.substring(0, actualLettersConsumed)
                        processingWord = processingWord.substring(actualLettersConsumed)
                        continue@loop
                    }//else keep going through the rule list
                }
            }
            //no rule matched; call the lambda!
            val unmatchedOutput = onNoRuleMatch(processingWord)
            processingWord = unmatchedOutput.newWorkingInput
            out = unmatchedOutput.output(out)
        }
        //System.out.println("consumed: $consumed")
        return out
    }
}