package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object MalayRuleBased:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS
    val rules:List<Rule> = listOf(
        Rule("c", "t͡ʃ"),
        Rule("j", "d͡ʒ"),
        Rule("ai", "ai̯"),
        Rule("au", "au̯"),
        Rule("oi", "oi̯̯"),//or ʊi
        Rule("gh", "ɣ"),// or x
        Rule("kh", "x"),
        Rule("ng", "ŋ"),
        Rule("ny", "ɲ"),
        Rule("sy", "ʃ")
    ) + latinBaseRules
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndSkip)
    }
}