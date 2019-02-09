package com.github.medavox.ipa_transcribers.persian

import com.github.medavox.ipa_transcribers.Language.Persian
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object PersianRuleBased:RuleBasedTranscriber<Persian> {
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(persoArabicBaseRules, copyVerbatim)
    }
}