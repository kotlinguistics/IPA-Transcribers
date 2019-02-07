package com.github.medavox.ipa_transcribers.rulesystem

import com.github.medavox.ipa_transcribers.Language
import java.lang.StringBuilder

interface RuleProcessor<T:Language> {
    data class UnmatchedOutput(val newWorkingInput:String, val output:String)
    fun String.processWithRules(rules:List<Rule>,
                         onNoRuleMatch:(unmatched:String) -> UnmatchedOutput) : String {
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