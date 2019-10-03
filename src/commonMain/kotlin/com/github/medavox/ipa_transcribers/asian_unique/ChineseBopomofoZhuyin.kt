package com.github.medavox.ipa_transcribers.asian_unique

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.IRule
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object ChineseBopomofoZhuyin: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.UNSTARTED

    val rules:List<IRule> = listOf(
        //Consonants
        Rule("ㄅ", "p"),
        Rule("ㄆ", "pʰ"),
        Rule("ㄇ", "m"),
        Rule("ㄈ", "f"),
        Rule("ㄉ", "t"),
        Rule("ㄊ", "tʰ"),
        Rule("ㄋ", "n"),
        Rule("ㄌ", "l"),
        Rule("ㄍ", "k"),
        Rule("ㄎ", "kʰ"),
        Rule("ㄏ", "x"),
        Rule("ㄐ", "tɕ"),
        Rule("ㄑ", "tɕʰ"),
        Rule("ㄒ", "ɕ"),
        Rule("ㄓ", "ʈʂ"),
        Rule("ㄔ", "ʈʂʰ"),
        Rule("ㄕ", "ʂ"),
        Rule("ㄖ", "ɻ~ʐ"),//todo: choose one
        Rule("ㄗ", "ts"),
        Rule("ㄘ", "tsʰ"),
        Rule("ㄙ", "s"),

        //Rhymes and medials
        Rule("ㄚ", "a"),
        Rule("ㄛ", "o"),
        Rule("ㄜ", "ɤ"),
        Rule("ㄝ", "e"),
        Rule("ㄞ", "ai"),
        Rule("ㄟ", "ei"),
        Rule("ㄠ", "au"),
        Rule("ㄡ", "ou"),
        Rule("ㄢ", "an"),
        Rule("ㄣ", "ən"),
        Rule("ㄤ", "aŋ"),
        Rule("ㄥ", "əŋ"),
        Rule("ㄦ", "aɚ"),//the erhua marker symbol
        Rule("ㄧ", "i"),
        Rule("ㄨ", "u"),
        Rule("ㄩ", "y"),
        Rule("ㄩ", "y"),
        Rule(" "," ")
    )
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, ::reportOnceAndCopy)
    }
}