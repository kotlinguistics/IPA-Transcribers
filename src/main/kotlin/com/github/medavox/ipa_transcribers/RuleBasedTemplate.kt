package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.Language.*
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object RuleBasedTemplate : RuleBasedTranscriber<Language> {
    val rules:List<Rule> = listOf(

    )
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}