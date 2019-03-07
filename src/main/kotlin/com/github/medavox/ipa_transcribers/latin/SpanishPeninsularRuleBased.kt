package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmericanRuleBased.voicedConsonants
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmericanRuleBased.normaliseAccents
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmericanRuleBased.removeStressAccents

object SpanishPeninsularRuleBased: RuleBasedTranscriber {
    val rules:List<Rule> = SpanishPanAmericanRuleBased.rules.map{
        when(it.unconsumedMatcher) {
            Regex("c[ie]") -> it.copy(outputString = {"θ"})
            Regex("z$voicedConsonants") -> it.copy(outputString = {"ð"})
            Regex("z") -> it.copy(outputString = {"θ"})
            else -> it
        }
    }
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().normaliseAccents().removeStressAccents().processWithRules(rules, reportAndCopy)
    }
}