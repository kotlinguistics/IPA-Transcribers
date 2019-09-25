package com.github.medavox.ipa_transcribers

object RuleBasedTemplate : RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.UNSTARTED
    val rules:List<Rule> = listOf(

    )
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}