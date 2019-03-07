package com.github.medavox.ipa_transcribers

object RuleBasedTemplate : RuleBasedTranscriber {
    val rules:List<Rule> = listOf(

    )
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}