package com.github.medavox.ipa_transcribers.korean

import com.github.medavox.ipa_transcribers.Language.Korean
import com.github.medavox.ipa_transcribers.Transcriber
import com.github.medavox.ipa_transcribers.rulesystem.Rule
import com.github.medavox.ipa_transcribers.rulesystem.RuleProcessor
import java.text.Normalizer

object KoreanRuleBased:Transcriber<Korean>, RuleProcessor<Korean> {
    private val rules:List<Rule> = listOf(

        //syllable-initial (choseong) consonants
        Rule("ᄀ", "k"),
        Rule("ᄁ", "k͈"),
        Rule("ᄂ", "n"),
        Rule("ᄃ", "t"),
        Rule("ᄄ", "t͈"),
        Rule("ᄅ", "ɾ"),
        Rule("ᄆ", "m"),
        Rule("ᄇ", "p"),
        Rule("ᄈ", "p͈"),
        Rule("ᄉ", "s"),
        Rule("ᄊ", "s͈"),
        Rule("ᄋ", ""),//silent
        Rule("ᄌ", "tɕ"),
        Rule("ᄍ", "t͈ɕ"),
        Rule("ᄎ", "tɕʰ"),
        Rule("ᄏ", "kʰ"),
        Rule("ᄐ", "tʰ"),
        Rule("ᄑ", "pʰ"),
        Rule("ᄒ", "h"),

        // syllable-final (jongseong) consonants
        Rule("[ᆨㄲ]", "k̚"),
        Rule("ᆪ", "gs"),
        Rule("ᆫ", "n"),
        Rule("ᆬ", "nt̚"),
        Rule("ᆮ", "t̚"),
        Rule("ᆯ", "l"),
        Rule("ᆷ", "m"),
        Rule("ᆸ", "p̚"),
        Rule("[ᆺㅆ]", "t̚"),
        Rule("ᆼ", "ŋ"),
        Rule("ᆽ", "t̚"),

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