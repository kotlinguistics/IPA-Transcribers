package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.IRule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmerican.voicedConsonants
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmerican.normaliseAccents
import com.github.medavox.ipa_transcribers.latin.SpanishPanAmerican.removeStressAccents

/**Transcriber for Castillian Spanish,
 * the official variety spoken in the Iberian Peninsula*/
object SpanishPeninsular: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.COMPLETE
    val rules:List<IRule> = SpanishPanAmerican.rules.map{
        when(it.unconsumedMatcher) {
            Regex("c[ie]") -> it.copy(outputString = {_->"θ"})
            Regex("z$voicedConsonants") -> it.copy(outputString = {_->"ð"})
            Regex("z") -> it.copy(outputString = {_->"θ"})
            else -> it
        }
    }
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().normaliseAccents().removeStressAccents().processWithRules(rules, reportAndCopy)
    }
}