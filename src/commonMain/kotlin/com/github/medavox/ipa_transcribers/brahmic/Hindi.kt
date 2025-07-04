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

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.IRule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import com.github.medavox.ipa_transcribers.brahmic.DevanagariBaseRules.devanagariBaseRules

/**Status: surface-level complete
 * Hindi uses the Devanagari writing system, a descendant of the Brahmi writing system
 * that was once widespread across historical India.
 * All Brahmic scripts are abugidas, which means each consonant glyph contains an inherent vowel
 * (usually a schwa) which can be overridden by vowel diacritics.
 *
 * This makes it relatively straightforward to transliterate the content of the orthography into IPA.
 * However, like most languages the pronunciation of Hindi differs from its writing.
 * Specifically, many inherent schwas are dropped.
 *
 * The rules governing which schwas are dropped are fairly complex,
 * and haven't been implemented yet.*/
object Hindi:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.SURFACE_LEVEL_COMPLETE
    private val consonants = "बभदधजझडढफ़गघग़हयकखलमनणञङपफक़रढ़सषशतथचछटठवख़ज़झ़"
    private var lastWasConsonant:Boolean = false
    //todo:use these schwa-deletion rules (and the relevant paper!)
    //todo: nasal assimilation
    //from https://www.quora.com/Are-there-any-strict-rules-for-schwa-deletion-in-Hindi
    //    Final schwa must be deleted. This is the rule that must be applied first.
    // However, if deleting that schwa produces a consonant cluster or other sound that is extremely
    // difficult or impossible to pronounce, the rule does not apply.
    // For example, the schwa is usually retained at the end of "आदित्य" and "कृष्ण."

    //In the scenario vowel-consonant-schwa-consonant-vowel, the schwa is deleted.
    // This rule works from right to left.
    // However, there are some conditions: there must be no morpheme boundary to the left
    // (essentially, the schwa can't begin a new word)
    // and the "output of the rule should not violate the phonotactic constraints of Hindi"
    // (that is, the application of the rule shouldn't produce a consonant cluster or other sound
    // that is extremely difficult or impossible to pronounce).
    // Examples: "मछली," "आदमी," and "दरवाज़ा."

    //The schwa of the first syllable is not deleted ("कमल" is not pronounced as "क्मल्.").
    //A schwa followed by a vowel cannot be deleted.
    // For example, although "पलंग" is pronounced "palang,"
    // simply adding the plural oblique marker "ओं" would give "palangao~,"
    // because that schwa can no longer be deleted. So, "palangao~" is written "पलंगों," not "पलंगओं."
    //(If that example was confusing, just ignore the example --
    // the rule is easy enough to understand.)

    //Schwas in two consecutive syllables cannot both be deleted.
    // (To my understanding, this rule is implied by Rule 2.)

    //The schwa is deleted before the final "-ना" of the infinitive.

    //In case of two letter words, schwa deletion occurs at the word end.
    //Ex. Kam, rab, sab, Har, talk
    //
    //In the case of three letter words,
    // schwa deletion occurs at the word end if the second vowel is short.
    //
    //Kalam, sabak, vichar, Sanam, Kasam, talab.
    //
    //In the case of three letter words,
    // schwa deletion occurs at the second letter if the last vowel is long.
    //
    //Kasbaa, upmaa, balmaa, Sankee, Reshmaa, talvaa
    //
    //In the case of four letter words,
    // schwa deletion occurs at the second letter and at the word end.
    //
    //Ex. Bartan, Salman, hardam, barsaat.
    val rules:List<IRule> = /*listOf(
        //schwa deletion 
            Rule(Regex("[$consonants]"), {lastWasConsonant = true; it}, 0)

        ) +*/ devanagariBaseRules
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}