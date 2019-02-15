package com.github.medavox.ipa_transcribers.hindi

import com.github.medavox.ipa_transcribers.Language.Hindi
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object HindiRuleBased:RuleBasedTranscriber<Hindi> {
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(devanagariBaseRules, copyVerbatim)
    }
}