package com.github.medavox.ipa_transcribers

import java.lang.StringBuilder

interface RuleBasedTranscriber<T:Language>:Transcriber<T> {
    data class UnmatchedOutput(val newWorkingInput:String, val output:String)
    val reportAndSkip:(String) -> UnmatchedOutput get() = {
        System.err.println("unknown char ${it[0]} in $it; skipping...")
        RuleBasedTranscriber.UnmatchedOutput(it.substring(1), "")
    }

    val copyVerbatim:(String) -> UnmatchedOutput get() = {
        System.err.println("copying unknown char ${it[0]} to output...")
        RuleBasedTranscriber.UnmatchedOutput(it.substring(1), it[0].toString())
    }
    fun String.processWithRules(rules:List<Rule>,
                                onNoRuleMatch:(unmatched:String) -> UnmatchedOutput
    ) : String {
        val out = StringBuilder()//.append('/')
        var processingWord = this
        loop@ while(processingWord.isNotEmpty()) {
            for (rule in rules) {
                val matchResult:MatchResult? = rule.matcher.find(processingWord)

                //if the rule matches the start of the remaining string
                if(matchResult?.range?.start == 0) {
                    //System.out.println("rule '${rules[i]}' matches '$processingWord'")
                    out.append(rule.outputString())

                    //number of letters consumed is the match length, unless explicitly specified
                    val actualLettersConsumed = rule.lettersConsumed ?: matchResult.value.length
                    processingWord = processingWord.substring(actualLettersConsumed)
                    continue@loop
                }
            }
            //no rule matched; call the lambda!
            val unmatchedOutput = onNoRuleMatch(processingWord)
            processingWord = unmatchedOutput.newWorkingInput
            out.append(unmatchedOutput.output)
        }
        return out.toString()
    }
}