package com.github.medavox.ipa_transcribers.indic

import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object MarathiRuleBased:RuleBasedTranscriber {
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(devanagariBaseRules, reportAndCopy)
    }
}