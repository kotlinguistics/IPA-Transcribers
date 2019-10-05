package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.IRule
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import com.github.medavox.ipa_transcribers.latin.LatinBaseRules.latinBaseRules

//write google -> IPA arabic transcriber
/**Google Translate's romanisation of Arabic includes vowel information not present in the Arabic text.
 * Maybe they have a lookup dictionary.
 * So this transcriber takes their romanisation and converts it to IPA.
 *
 * However, Google's romanisation also throws away a lot of the original information in the arabic text.
 * For example, glottalised consonants aren't transliterated differently than glottalised consonants,
 * despite these being distinguished in Arabic.*/
object ArabicGoogleRomanised: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.COMPLETE_PARTIAL
    val rules:List<IRule> = listOf<Rule>(
        Rule("'", "ʕ"),
        Rule("gh", "ɣ"),
        Rule("sh", "ʃ"),
        Rule("kh", "x"),
        Rule("th", "θ"),
        Rule("dh", "ð"),
        Rule("j", "ʒ"),
        Rule("h", "ħ"),
        Rule("q", "q")//the same sound is represented with a Q in arabic

    )+ latinBaseRules + westernPunctuation
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}