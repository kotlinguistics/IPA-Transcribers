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

package com.github.medavox.ipa_transcribers.other

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