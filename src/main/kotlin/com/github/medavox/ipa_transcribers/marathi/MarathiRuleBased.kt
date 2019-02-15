package com.github.medavox.ipa_transcribers.marathi

import com.github.medavox.ipa_transcribers.Language.Marathi
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object MarathiRuleBased:RuleBasedTranscriber<Marathi> {
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(devanagariBaseRules, copyVerbatim)
    }
}