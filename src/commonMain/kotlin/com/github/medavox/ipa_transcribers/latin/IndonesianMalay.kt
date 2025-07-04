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
import com.github.medavox.ipa_transcribers.latin.LatinScriptCommonalities.latinBaseRules

/**Transcriber for the language known as Indonesian in Indonesia, and Malay in Malaysia*/
object IndonesianMalay:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS
    val rules:List<Rule> = listOf(
        Rule("c", "t͡ʃ"),
        Rule("j", "d͡ʒ"),
        Rule("ai", "ai̯"),
        Rule("au", "au̯"),
        Rule("oi", "oi̯̯"),//or ʊi
        Rule("gh", "ɣ"),// or x
        Rule("kh", "x"),
        Rule("ng", "ŋ"),
        Rule("ny", "ɲ"),
        Rule("sy", "ʃ")
    ) + latinBaseRules
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndSkip)
    }
}