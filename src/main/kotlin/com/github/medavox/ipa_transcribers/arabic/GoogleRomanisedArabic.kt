package com.github.medavox.ipa_transcribers.arabic

import com.github.medavox.ipa_transcribers.Language
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
//write google -> IPA arabic transcriber
/**Google Translate's romanisation of Arabic includes vowel information not present in the Arabic text.
 * Maybe they have a lookup dictionary.
 * So this transcriber takes their romanisation and converts it to IPA.
 *
 * However, Google's romanisation also throws away a lot of the original information in the arabic text.
 * For example, glottalised consonants are not transliterated differently than glottalised consonants,
 * despite these being distinguished in Arabic.*/
object GoogleRomanisedArabic: RuleBasedTranscriber {
    val rules:List<Rule> = listOf<Rule>(
        Rule("'", "ʕ"),
        Rule("gh", "ɣ"),
        Rule("sh", "ʃ"),
        Rule("kh", "x"),
        Rule("th", "θ"),
        Rule("dh", "ð"),
        Rule("j", "ʒ"),
        Rule("h", "ħ"),
        Rule("q", "q")//the same sound is repsented with a Q in arabic

    )+ latinBaseRules + westernPunctuation
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}