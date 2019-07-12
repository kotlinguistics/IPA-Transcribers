package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object SwahiliRuleBased :RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.SURFACE_LEVEL_COMPLETE
    val rules:List<Rule> = listOf(

        Rule("b", "ɓ"),
        Rule("dh", "ð"), // (loanwords only)
        Rule("d", "ɗ"),
        Rule("dʒ", "j"), // alternatively ʄ
        Rule("f", "f"),
        Rule("gh", "ɣ"), // (loanwords only)
        Rule("g", "ɠ"),
        Rule("y", "j"),
        Rule("h", "h"),
        Rule("l", "l"), // [2]
        Rule("kh", "x"), // (loanwords only)
        Rule("k", "k"),
        Rule("mt", "m̩t"),
        Rule("mb", "ᵐb"),
        Rule("mv", "ᶬv"),
        Rule("m", "m"),
        Rule("nch", "n̩"),
        Rule("nd", "ⁿd"),
        Rule("ng", "ᵑɡ"),
        Rule("nj", "ⁿdʒ"),
        Rule("nz", "ⁿz"),
        Rule("ny", "ɲ"),
        Rule("ng", "ŋ"),
        Rule("n", "n"),
        Rule("p", "p"),
        Rule("r", "ɾ"), // [2]
        Rule("sh", "ʃ"),
        Rule("th", "θ"), // (loanwords only)
        Rule("t", "t"),
        Rule("s", "s"),
        Rule("ch", "tʃ"),
        Rule("v", "v"),
        Rule("w", "w"),
        Rule("z", "z"),

        Rule("a", "ɑ"),
        Rule("e", "ɛ"),
        Rule("i", "i"),
        Rule("o", "ɔ"),
        Rule("u", "u")

        //[2] Swahili [l] and [ɾ] are merged for many speakers as an alveolar lateral flap; /ɺ/
        //[3] Stress usually falls on the penultimate syllable of a word.
    )

    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules,reportAndCopy)
    }
}