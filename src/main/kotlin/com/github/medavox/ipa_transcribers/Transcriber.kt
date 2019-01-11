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
    abstract fun transcribe(nativeText:String):Set<Variant>
    data class Rule(val matcher:Regex, val outputString:String)
    fun processWithRules(nativeText:String, rules:Array<Rule>){
        val american = StringBuilder().append('/')
        var processingWord = nativeText
        loop@ while(processingWord.isNotEmpty()) {
            for (i in 0 until rules.size) {
                //if the rule matches the start of the remaining string
                val matchResult:MatchResult? = rules[i].matcher.find(processingWord)

                if(matchResult?.range?.start == 0) {
                    //System.out.println("rule '${rules[i]}' matches '$processingWord'")

                    american.append(rules[i].outputString)

                    processingWord = processingWord.substring(matchResult.value.length)
                    continue@loop
                }
            }
            //no rule matched; the spanish orthography matches the IPA.
            //just copy it to the output
            american.append(processingWord[0])
            processingWord = processingWord.substring(1)
        }
    }
}