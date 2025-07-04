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

package com.github.medavox.ipa_transcribers.arabic

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**The language known by the following names:
 * * Persian
 * * Farsi
 * * Tajik
 * * Dari
 * like Modern Standard Arabic, Persian does not write short vowels.
 * This means that any transcription system that relies solely on the orthography (such as this one)
 * *cannot* produce a complete transcription.
 *
 * A lookup dictionary wouldn't even solve this problem. According to Wikipedia:
 *
 * >words distinguished from each other only by short vowels are ambiguous in writing:
 * >Western Persian kerm "worm", karam "generosity", kerem "cream",
 * >and krom "chrome" are all spelled krm (کرم) in Persian
 *
 * "Context" is necessary for first working out which word the vowel-less spelling refers to;
 * and context is no simple thing, requiring more complex tools than regex matching.
 *
 * Even so, this transcriber does the best job possible,
 * given the information that *has* been recorded in the orthography.*/
object Persian:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS

    /**Although persian letters have different representations whether they are initial, medial, or final --
     * all forms are represented by the same unicode character.*/
    val persoArabicBaseRules:List<Rule> get() = listOf(
        Rule("ا", "ɒ"),
        Rule("ب", "b"),
        Rule("پ", "p"),
        Rule("ت", "t"),
        Rule("ث", "s"),
        Rule("ج", "d͡ʒ"),
        Rule("چ", "t͡ʃ"),
        Rule("ح", "h"),
        Rule("خ", "x"),
        Rule("د", "d"),
        Rule("ذ", "z"),
        Rule("ر", "ɾ"),
        Rule("ز", "z"),
        Rule("ژ", "ʒ"),
        Rule("س", "s"),
        Rule("ش", "ʃ"),
        Rule("ص", "s"),
        Rule("ض", "z"),
        Rule("ط", "t"),
        Rule("ظ", "z"),
        Rule("ع", "ʔ"),
        Rule("غ", "ɣ"),
        Rule("ف", "f"),
        Rule("ق", "ɣ"),
        Rule("ک", "k"),
        Rule("گ", "ɡ"),
        Rule("ل", "l"),
        Rule("م", "m"),
        Rule("ن", "n"),
        Rule("و", "ʋ"),// [v] / [uː] / [o] / [ow] / ([w] / [aw] / [oː] in Dari)),
        Rule("ه", "h"),
        Rule("ی", "i"),// / [j] / [ɒː] / ([aj] / [eː] in Dari)),
        Rule(" ", " ")
    )

    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(persoArabicBaseRules, reportAndCopy)
    }
}