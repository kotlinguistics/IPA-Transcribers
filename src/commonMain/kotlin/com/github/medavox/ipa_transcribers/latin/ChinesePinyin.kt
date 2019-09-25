package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**Transcriber for the Hanyu Pinyin Chinese romanisation system to IPA.*/
object ChinesePinyin: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.UNSTARTED

    private val rules:List<Rule> = listOf(
        //initials
        Rule("b", "p"),
        Rule("p", "pʰ"),
        Rule("m", "m"),
        Rule("f", "f"),
        Rule("d", "t"),
        Rule("t", "tʰ"),
        Rule("n", "n"),
        Rule("l", "l"),
        Rule("g", "k"),
        Rule("k", "kʰ"),
        Rule("h", "x"),
        Rule("j", "tɕ"),
        Rule("q", "tɕʰ"),
        Rule("x", "ɕ"),
        Rule("zh", "ʈʂ"),
        Rule("ch", "ʈʂʰ"),
        Rule("sh", "ʂ"),
        Rule("r", "ɻ~ʐ"),
        Rule("z", "ts"),
        Rule("c", "tsʰ"),
        Rule("s", "s")
        )
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, reportAndSkip)
    }
}