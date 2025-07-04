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

package com.github.medavox.ipa_transcribers.brahmic

import com.github.medavox.ipa_transcribers.*

object Telugu:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.INCOMPLETE

    private fun l(it:String):String{
        return if(it.endsWith("a")) it.substring(0, it.length-1) else it
    }

    private val rules:List<IRule> = listOf(
        //consonants
        Rule("క", "ka"),
        Rule("ఖ", "kʰa"),
        Rule("గ", "ɡa"),
        Rule("ఘ", "ɡʱa"),
        Rule("ఙ", "ŋa"),
        Rule("చ", "tʃa"),
        Rule("ఛ", "tʃʰa"),
        Rule("జ", "dʒa"),
        Rule("ఝ", "dʒʱa"),
        Rule("ఞ", "ɲa"),
        Rule("ట", "ʈa"),
        Rule("ఠ", "ʈʰa"),
        Rule("డ", "ɖa"),
        Rule("ఢ", "ɖʱa"),
        Rule("ణ", "ɳa"),
        Rule("త", "ta"),
        Rule("థ", "tʰa"),
        Rule("ద", "da"),
        Rule("ధ", "dʱa"),
        Rule("న", "na"),
        Rule("ప", "pa"),
        Rule("ఫ", "pʰa"),
        Rule("బ", "ba"),
        Rule("భ", "bʱa"),
        Rule("మ", "ma"),
        Rule("య", "ja"),
        Rule("ర", "ra"),
        Rule("ల", "la"),
        Rule("వ", "ʋa"),
        Rule("ళ", "ɭa"),
        Rule("శ", "ʃa"),
        Rule("ష", "ʂa"),
        Rule("స", "sa"),
        Rule("హ", "ha"),
        Rule("ఱ", "ɽa"),

        //vowels
        RevisingRule("[అ]", {l(it)+"a"}),
        RevisingRule("[ఆా]", {l(it)+"aː"}),
        RevisingRule("[ఇి]", {l(it)+"i"}),
        RevisingRule("[ఈీ]", {l(it)+"iː"}),
        RevisingRule("[ఉు]", {l(it)+"u"}),
        RevisingRule("[ఊూ]", {l(it)+"uː"}),
        RevisingRule("[ఋృ]", {l(it)+"ru"}),
        RevisingRule("[ౠౄ]", {l(it)+"ruː"}),
        RevisingRule("[ఌౢ]", {l(it)+"alu"}),
        RevisingRule("[ౡౣ]", {l(it)+"alu:"}),
        RevisingRule("[ఎె]", {l(it)+"e"}),
        RevisingRule("[ఏే]", {l(it)+"eː"}),
        RevisingRule("[ఐై]", {l(it)+"aj"}),
        RevisingRule("[ఒొ]", {l(it)+"o"}),
        RevisingRule("[ఓో]", {l(it)+"oː"}),
        RevisingRule("[ఔౌ]", {l(it)+"aw"}),

        RevisingRule("్", {l(it)}),

        Rule("","")
    )

    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, ::reportOnceAndCopy)
    }
}