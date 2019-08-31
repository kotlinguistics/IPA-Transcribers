package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmerican.voicedConsonants
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmerican.normaliseAccents
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmerican.removeStressAccents

object SpanishPeninsular: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.COMPLETE
    val rules:List<Rule> = SpanishPanAmerican.rules.map{
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