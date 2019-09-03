package com.github.medavox.ipa_transcribers.asian_unique

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import java.text.Normalizer

/**Status:COMPLETE
 * All the 'modern' combining jamo have been transcribed.
 *
 * All Unicode combining-character syllable-initial consonants have been transcribed (unicode block U+1100 - U+1112).
 * All Unicode combining-character vowels have been transcribed (Unicode block U+1161 - U+1175).
 * For Unicode combining-character syllable-final consonants: the simple ones have been transcribed -
 * jamo which are only a single 'plain' letter.
 *
 * Jamo for syllable-final consonant clusters and their liaison (sandhi) rules have been transcribed,
 * thanks to Duolingo (21 June 2019).
 *
 * The liaison: a syllable-final but not word-final consonant is pronounced as part of the
 * next syllable, if the next syllable starts with the null consonant 'ᄋ'.
 *
 * Links:
 *
 * [Hangul unicode characters](https://en.wikipedia.org/wiki/Hangul#Unicode)
 * [Unicode character inspector](https://apps.timwhitlock.info/unicode/inspect)
 * (for checking which identical glyph we have: the choseong, jongseong, or standalone version)
 * https://en.wikipedia.org/wiki/Korean_phonology#Positional_allophones
 * https://en.wikipedia.org/wiki/Help:IPA/Korean
 * https://en.wikipedia.org/wiki/Hangul_consonant_and_vowel_tables
 * (lists all the consonant clusters, but only with the less-precise romanisation)
 * https://linguistics.stackexchange.com/q/2805 describes the syllable-final assimilation rules
 * [An independent reference wiki for the korean language](http://www.koreanwikiproject.com/wiki/index.php?title=IPA)
 * */
object KoreanHangeul: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.COMPLETE
    private val vowels = "ᅡᅢᅣᅤᅥᅦᅧᅨᅩᅪᅫᅬᅭᅮᅯᅰᅱᅲᅳᅴᅵ"
    private val rules:List<Rule> = listOf(

        //syllable-initial (choseong) consonants
        //basic
        Rule("ᄀ", "k"),
        Rule("ᄂ", "n"),
        Rule("ᄃ", "t"),
        Rule("ᄅ", "ɾ"),
        Rule("ᄆ", "m"),
        Rule("ᄇ", "p"),
        Rule("ᄉ", "s"),
        Rule("ᄋ", ""),//silent
        Rule("ᄌ", "tɕ"),

        //tense
        Rule("ᄍ", "t͈ɕ"),
        Rule("ᄄ", "t͈"),
        Rule("ᄈ", "p͈"),
        Rule("ᄊ", "s͈"),
        Rule("ᄁ", "k͈"),

        //aspirated
        Rule("ᄎ", "tɕʰ"),
        Rule("ᄏ", "kʰ"),
        Rule("ᄐ", "tʰ"),
        Rule("ᄑ", "pʰ"),
        Rule("ᄒ", "h"),

        // syllable-final (jongseong) consonants
        Rule("[ᆨㄲᆿ]", "k̚"),
        //Rule("ᆪ", "gs"),
        Rule("ᆫ", "n"),
        //Rule("ᆬ", "nt̚"),
        Rule("ᆯ", "l"),
        Rule("ᆷ", "m"),
        Rule("ᆸ", "p̚"),
        Rule("[ᆮᇀᆾᇂᆺᆻᆽ]", "t̚"),
        Rule("ᆼ", "ŋ"),

        //Sandhi consonant clusters. These rules need to be applied before the normal consonant cluster rules
        Rule("ᆪ ᄋ", "k s"),
        Rule("ᆰ ᄋ", "l k"),
        Rule("ᆬ ᄋ", "n tɕ"),
        Rule("ᆭ ᄋ", "n h"),
        Rule("ᆲ ᄋ", "l p"),
        Rule("ᆳ ᄋ", "l s"),
        Rule("ᆴ ᄋ", "l tʰ"),
        Rule("ᆶ ᄋ", "l h"),
        Rule("ᆱ ᄋ", "l m"),
        Rule("ᆵ ᄋ", "l pʰ"),
        Rule("ᆹ ᄋ", "p s"),

        //consonant cluster rules, from Duolingo
        Rule("[ᆪᆰ]", "k̚"),
        Rule("[ᆬᆭ]", "n"),
        Rule("[ᆲᆳᆴᆶ]", "l"),
        Rule("[ᆱ]", "m"),
        Rule("[ᆵᆹ]", "p"),

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
        //convert older hangul codepoints into their modern combining forms
        //thanks to https://stackoverflow.com/a/41311169
        return Normalizer.normalize(nativeText, Normalizer.Form.NFD).processWithRules(rules, ::reportOnceAndCopy)
    }
}