package com.github.medavox.ipa_transcribers.spanish

import com.github.medavox.ipa_transcribers.Language.PeninsularSpanish
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object PeninsularSpanishRuleBased: RuleBasedTranscriber<PeninsularSpanish> {
    val rules:List<Rule> = PanAmericanSpanishIpaRuleBased.rules.map{
        when(it.matcher) {
            Regex("c[ie]") -> it.copy(outputString = {"θ"})
            Regex("z${PanAmericanSpanishIpaRuleBased.voicedConsonants}") -> it.copy(outputString = {"ð"})
            Regex("z") -> it.copy(outputString = {"θ"})
            else -> it
        }
    }
    override fun transcribe(nativeText: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}