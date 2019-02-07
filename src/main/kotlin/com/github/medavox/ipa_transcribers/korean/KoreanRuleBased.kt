package com.github.medavox.ipa_transcribers.korean

import com.github.medavox.ipa_transcribers.Language.Korean
import com.github.medavox.ipa_transcribers.Transcriber
import com.github.medavox.ipa_transcribers.rulesystem.Rule
import com.github.medavox.ipa_transcribers.rulesystem.RuleProcessor
import java.text.Normalizer

object KoreanRuleBased:Transcriber<Korean>, RuleProcessor<Korean> {
    private val rules:List<Rule> = listOf(

        //nice and simple vowel rules.
        //the same symbol appears twice,
        // because there are two unicode blocks which represent korean hangul jamo.
        //the ones on the right should be the compatibility block versions.
        Rule(Regex("[ᅡㅏ]"), "a"),
        Rule(Regex("[ᅢㅐ]"), "ɛ"),
        Rule(Regex("[ᅣㅑ]"), "ja"),
        Rule(Regex("[ᅤㅒ]"), "jɛ"),
        Rule(Regex("[ᅥㅓ]"), "ʌ"),
        Rule(Regex("[ᅦㅔ]"), "e"),
        Rule(Regex("[ᅧㅕ]"), "jʌ"),
        Rule(Regex("[ᅨㅖ]"), "je"),
        Rule(Regex("[ᅩㅗ]"), "o"),
        Rule(Regex("[ᅪㅘ]"), "wa"),
        Rule(Regex("[ᅫㅙ]"), "wɛ"),
        Rule(Regex("[ᅬㅚ]"), "ø"),// ~ [we]
        Rule(Regex("[ᅭㅛ]"), "jo"),
        Rule(Regex("[ᅮㅜ]"), "u"),
        Rule(Regex("[ᅯㅝ]"), "wʌ"),
        Rule(Regex("[ᅰㅞ]"), "we"),
        Rule(Regex("[ᅱㅟ]"), "y"),// ~ [ɥi]
        Rule(Regex("[ᅲㅠ]"), "ju"),
        Rule(Regex("[ᅳㅡ]"), "ɯ"),
        Rule(Regex("[ᅴㅢ]"), "ɰi"),
        Rule(Regex("[ᅵㅣ]"), "i")
    )
    override fun transcribe(nativeText: String): String {
        //thanks to https://stackoverflow.com/a/41311169
        return Normalizer.normalize(nativeText, Normalizer.Form.NFD).processWithRules(rules){
            System.err.println("unknown symbol '${it[0]}' in korean output")
            RuleProcessor.UnmatchedOutput(it.substring(1), it[0].toString())
        }
    }
}