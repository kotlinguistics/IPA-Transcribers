package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.Language.PeninsularSpanish
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import com.github.medavox.ipa_transcribers.latin.PanAmericanSpanishIpaRuleBased.voicedConsonants
import com.github.medavox.ipa_transcribers.latin.PanAmericanSpanishIpaRuleBased.normaliseAccents
import com.github.medavox.ipa_transcribers.latin.PanAmericanSpanishIpaRuleBased.removeStressAccents

object PeninsularSpanishRuleBased: RuleBasedTranscriber<PeninsularSpanish> {
    val rules:List<Rule> = PanAmericanSpanishIpaRuleBased.rules.map{
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