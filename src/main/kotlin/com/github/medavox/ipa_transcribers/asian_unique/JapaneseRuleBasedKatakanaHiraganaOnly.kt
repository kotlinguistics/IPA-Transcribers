package com.github.medavox.ipa_transcribers.asian_unique

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**We can't process Japanese's primary writing system, Kanji, with a rule-based transcriber.
 * But we can process its simpler supplementary writing systems, Katakana and Hiragana.*/
object JapaneseRuleBasedKatakanaHiraganaOnly:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.UNSTARTED
    private val rules:List<Rule> = listOf(

    )
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}