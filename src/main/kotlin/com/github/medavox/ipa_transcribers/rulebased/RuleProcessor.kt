package com.github.medavox.ipa_transcribers.rulebased

import com.github.medavox.ipa_transcribers.Language
import java.lang.StringBuilder

interface RuleProcessor<T: Language> {
    data class UnmatchedOutput(val newWorkingInput:String, val output:String)
    fun processWithRules(nativeText:String,
                         rules:Array<out GenericRule<T>>,
                         variantBuilders:Map<T, StringBuilder>,
                         onNoRuleMatch:(unmatched:String) -> UnmatchedOutput):Map<T, String> {

        //val out = StringBuilder()//.append('/')
        var processingWord = nativeText
        loop@ while(processingWord.isNotEmpty()) {
            for (rule in rules) {
                //for (i in 0 until rules.size) {
                //if the rule matches the start of the remaining string
                val matchResult:MatchResult? = rule.matcher.find(processingWord)

                if(matchResult?.range?.start == 0) {
                    //System.out.println("rule '${rules[i]}' matches '$processingWord'")
                    when(rule) {
                        is Rule -> {
                            //apply this one rule to all variants
                            for(variant in variantBuilders.entries) {
                                variant.value.append(rule.outputString())
                            }
                        }
                        //apply the explicitly listed rules to each variant,
                        //then apply the default rule to other variants if necessary,
                        // and if the default rule was specified.
                        //if there are unhandled variants after this,
                        //fixme: WAT DO?
                        is VariantRule<T> -> {
                            for (variant in variantBuilders.entries) {
                                variant.value.append(rule.outputForEveryVariant(variant.key))
                            }
                        }
                    }

                    //number of letters consumed is the match length, unless explicitly specified
                    val actualLettersConsumed = rule.lettersConsumed ?: matchResult.value.length
                    processingWord = processingWord.substring(actualLettersConsumed)
                    continue@loop
                }
            }
            //no rule matched; call the lambda!
            val unmatchedOutput = onNoRuleMatch(processingWord)
            processingWord = unmatchedOutput.newWorkingInput
            for(variant in variantBuilders.entries) {
                variant.value.append(unmatchedOutput.output)
            }
        }
        return variantBuilders.mapValues {  it.value.toString() }
    }
}