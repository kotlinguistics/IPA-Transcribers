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