/*
IPA Transcribers
Copyright (C) 2018 - 2025  Adam Howard

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object Swahili :RuleBasedTranscriber() {
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