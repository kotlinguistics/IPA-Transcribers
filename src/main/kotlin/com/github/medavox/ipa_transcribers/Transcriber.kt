package com.github.medavox.ipa_transcribers

import java.lang.StringBuilder

/**Converts text in the native orthography of a language,
 * into a collection of broad IPA transcriptions for important language variants.
 *
 *  The aim here is not to capture the nuances of every dialect/accent of a language;
 *  but rather to provide the pronunciation of a standard or prestige dialect(s)
 *  that every speaker should be able to understand.
 *
 *  For instance, English IPA transcribers should provide American English and British English
 *  transcriptions, but ignore Irish, Scottish, Texan, Indian, African, and International variants.
 *
 *  To get an instance for a particular language,
 *  call [TranscriberFactory.getTranscriberForLang]*/
interface Transcriber {
    fun transcribe(nativeText:String):Set<Variant>
    class RuleSet(rules:Array<Rule>)
    data class Rule(val matcher:Regex, val outputString:() -> String, val lettersConsumed:Int?=null ) {
        constructor( matcher:Regex, outputString:String, lettersConsumed:Int?=null )
                :this(matcher, {outputString}, lettersConsumed)
    }
    fun processWithRules(nativeText:String, rules:Array<Rule>):String {
        val out = StringBuilder()//.append('/')
        var processingWord = nativeText
        loop@ while(processingWord.isNotEmpty()) {
            for (i in 0 until rules.size) {
                //if the rule matches the start of the remaining string
                val matchResult:MatchResult? = rules[i].matcher.find(processingWord)

                if(matchResult?.range?.start == 0) {
                    //System.out.println("rule '${rules[i]}' matches '$processingWord'")

                    out.append(rules[i].outputString())
                    //number of letters consumed is the match length, unless explicitly specified
                    val actualLettersConsumed = rules[i].lettersConsumed ?: matchResult.value.length
                    processingWord = processingWord.substring(actualLettersConsumed)
                    continue@loop
                }
            }
            //no rule matched; the spanish orthography matches the IPA.
            //just copy it to the output
            out.append(processingWord[0])
            processingWord = processingWord.substring(1)
        }
        return out.toString()
    }
}