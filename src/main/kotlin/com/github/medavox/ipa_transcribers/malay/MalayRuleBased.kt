package com.github.medavox.ipa_transcribers.malay

import com.github.medavox.ipa_transcribers.Language.IndonesianMalay
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object MalayRuleBased:RuleBasedTranscriber<IndonesianMalay> {
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