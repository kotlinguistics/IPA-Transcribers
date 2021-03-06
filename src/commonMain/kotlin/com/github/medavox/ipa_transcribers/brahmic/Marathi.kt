package com.github.medavox.ipa_transcribers.brahmic

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import com.github.medavox.ipa_transcribers.brahmic.DevanagariBaseRules.devanagariBaseRules

object Marathi:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.INCOMPLETE

    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(devanagariBaseRules, reportAndCopy)
    }
}