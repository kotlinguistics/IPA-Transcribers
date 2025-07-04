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

/**Completion Status: SURFACE-LEVEL COMPLETE
 *
 * Pronunciation rules for single letters and simple digraphs have been implemented,
 * but more complex linguistic rules not directly represented in the orthography are as-yet
 * unimplemented.
 **/
object Bengali : RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.SURFACE_LEVEL_COMPLETE

    fun l(it:String):String{
        return if(it.endsWith("ɔ")) it.substring(0, it.length-1) else it
    }

    //bengali's vowel diacritics only APPEAR VISUALLY to come before their consonant:
    //they still combine only with the next consonant in a string!
    // meaning we don't need any complex stack-based parsing; at least not for this.
    //todo: conjunct consonants (consonant cluster letters)
    //todo: inherent vowel dropping
    val rules:List<IRule> = listOf(
        //post-reform consonants -
        //from a character standpoint they are digraphs, using a nuqta ় ,
        //so apply them first
        Rule("ড়", "ɽɔ"),
        Rule("ঢ়", "ɽʱɔ"),
        Rule("য়", "jɔ"),
        //consonants
        Rule("ব", "bɔ"),
        Rule("ভ", "bʱɔ"),
        Rule("দ", "dɔ"),
        Rule("ধ", "dʱɔ"),
        Rule("ড", "ɖɔ"),
        Rule("ঢ", "ɖʱɔ"),
        Rule("[জয]", "dʒɔ"),
        Rule("ঝ", "dʒʱɔ"),
        Rule("গ", "ɡɔ"),
        Rule("ঘ", "ɡʱɔ"),
        Rule("(হ|ঃ)", "ɦɔ"),
        Rule("ক", "kɔ"),
        Rule("খ", "kʰɔ"),
        Rule("ল", "lɔ"),
        Rule("ম", "mɔ"),
        Rule("[নণঞ]", "nɔ"),
        Rule("(ঙ|ং)", "ŋɔ"),
        Rule("প", "pɔ"),
        Rule("ফ", "pʰɔ"),
        Rule("র", "rɔ"),
        Rule("(ড়|ঢ়)", "ɽɔ"),
        Rule("স", "sɔ"),
        Rule("[শষস]", "ʃɔ"),
        Rule("ত", "tɔ"),
        Rule("থ", "tʰɔ"),
        Rule("ট", "ʈɔ"),
        Rule("ঠ", "ʈʰɔ"),
        Rule("চ", "tʃɔ"),
        Rule("ছ", "tʃʰɔ"),

        //special letters
        Rule("ৎ", "̪t"), //final T
        RevisingRule("্", {l(it)}), //suppresses inherent vowel

        //Vowels
        Rule("অ", "ɔ"),

        Rule("[ইঈ]", "i"),
        RevisingRule("(ি|ী)", {l(it)+"i"}),

        Rule("[ঊউ]", "u"),
        RevisingRule("(ু|ূ)", {l(it)+"u"}),

        Rule("ঋ", "ri"),
        RevisingRule("ৃ", {l(it)+"ri"}),


        Rule("আ", "a"),
        RevisingRule("া", {l(it)+"ri"}),

        //complex vowels
        Rule("ঐ", "oi"),
        RevisingRule("ৈ", {l(it)+"oi"}),

        Rule("ঔ", "ou"),
        RevisingRule("ৌ", {l(it)+"ou"}),

        Rule("এ", "e"),
        RevisingRule("ে", {l(it)+"e"}),

        Rule("ও", "ʊ"),
        RevisingRule("ো", {l(it)+"ʊ"}),

        //"deprecated" vowels
        Rule("ঌ", "li"),//supposed to have been removed from the abugida, but you never know...
        RevisingRule("ৢ", {l(it)+"li"}),

        Rule("ৡ", "lːi"),//supposed to have been removed from the abugida, but you never know...
        RevisingRule("ৣ", {l(it)+"lːi"}),

        Rule("ৠ", "rːi"),//supposed to have been removed from the abugida, but you never know...

        //numbers
        Rule("০", "0"),
        Rule("১", "1"),
        Rule("২", "2"),
        Rule("৩", "3"),
        Rule("৪", "4"),
        Rule("৫", "5"),
        Rule("৬", "6"),
        Rule("৭", "7"),
        Rule("৮", "8"),
        Rule("৯", "9"),
        Rule(" ", " "),//space

        //Punctuation
        Rule("।", ".")//devanagari danda 'stick' == full stop.

//Even though the open-mid front unrounded vowel /ɛ/ is one of the seven main vowel sounds in standard Bengali,
// no distinct vowel symbol has been allotted for it in the script since there is no /ɛ/ sound in Sanskrit,
// the primary written language when the script was conceived.

// As a result, the sound is orthographically realised by multiple means in modern Bengali orthography,
// usually using some combination of "এ" e (স্বর এ shôrô e, "vocalic e") /e/, "অ", "আ" a (স্বর আ shôrô a) /a/
// and the যফলা jôfôla (diacritic form of the consonant grapheme য jô).

    )
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, ::reportOnceAndCopy)
    }
}