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

import com.github.medavox.ipa_transcribers.IRule
import com.github.medavox.ipa_transcribers.RevisingRule
import com.github.medavox.ipa_transcribers.Rule

object DevanagariBaseRules {
    private fun l(it:String):String{
        return if(it.endsWith("ə")) it.substring(0, it.length-1) else it
    }
    val devanagariBaseRules:List<IRule> get() = listOf(
        //Consonants
        // These have an inherent schwa (which is often romanised as 'a'),
        //if there isn't another vowel attached to that character.
        Rule("क़", "qə"),//2
        Rule("क", "kə"),//1
        Rule("ख़", "xə"),//2
        Rule("ख", "kʰə"),//1
        Rule("ग़", "ɣə"),//2
        Rule("ग", "ɡə"),//1
        Rule("घ", "ɡʱə"),//1
        Rule("ङ", "ŋə"),//1
        Rule("च", "tʃə"),//1
        Rule("छ", "tʃʰə"),//1
        Rule("ज़", "zə"),//2
        Rule("ज", "dʒə"),//1
        Rule("झ़", "ʒə"),//2
        Rule("झ", "dʒʱə"),//1
        Rule("ञ", "ɲə"),//1
        Rule("ट", "ʈə"),//1
        Rule("ठ", "ʈʰə"),//1
        Rule("ड", "ɖə"),//1
        Rule("ढ़", "ɽʱə"),//2
        Rule("ढ", "ɖʱə"),//1
        Rule("ण", "ɳə"),//1
        Rule("त", "tə"),//1
        Rule("थ", "tʰə"),//1
        Rule("द", "də"),//1
        Rule("ध", "dʱə"),//1
        Rule("न", "nə"),//1
        Rule("प", "pə"),//1
        Rule("फ़", "fə"),//2
        Rule("फ", "pʰə"),//1
        Rule("ब", "bə"),//1
        Rule("भ", "bʱə"),//1
        Rule("म", "mə"),//1
        Rule("य", "jə"),//1
        Rule("र", "ɾə"),//1
        Rule("ल", "lə"),//1
        Rule("व", "ʋə"),//1
        Rule("श", "ʃə"),//1
        Rule("ष", "ʂə"),//1
        Rule("स", "sə"),//1
        Rule("ह", "ɦə"),//1


        //Vowels
        //Each vowel has an independent form, and a form which attaches to the previous consonant.
        //Much kudos to Unicode's Devanagari support;
        // the vowels act like separate characters on a character level,
        // but combine with their previous consonant to form the right character visually.
        //this means the minimum possible number of code points is used to represent Devanagari.
        RevisingRule("[आा]", {l(it)+"aː"}),
        RevisingRule("[एे]", {l(it)+"eː"}),
        RevisingRule("[ऐै]", {l(it)+"ɛː"}),
        RevisingRule("[अ]", {l(it)+"ə"}),
        RevisingRule("[ईी]", {l(it)+"iː"}),
        RevisingRule("[इि]", {l(it)+"ɪ"}),
        RevisingRule("[ओो]", {l(it)+"oː"}),
        RevisingRule("[औौ]", {l(it)+"ɔː"}),
        RevisingRule("[ऊू]", {l(it)+"uː"}),
        RevisingRule("[उु]", {l(it)+"ʊ"}),
        RevisingRule("[ऋृ]", {l(it)+"ɾɪ"}),
        RevisingRule("्", {l(it)}),// ् "virama" is a diacritic which suppresses the inherent vowel
        RevisingRule("ं", {l(it)}),// "anusvara" diacritic nasalises the preceding consonant*
        //or in modern hindi and marathi, sometimes its vowel as well. It's complicated.

        //nasalised vowel diacritic. Presumably can go over any (or some) other vowels
        Rule("ँ", "̃"),

        //numbers, for completeness' sake
        Rule("०", "0"),
        Rule("१", "1"),
        Rule("२", "2"),
        Rule("३", "3"),
        Rule("४", "4"),
        Rule("५", "5"),
        Rule("६", "6"),
        Rule("७", "7"),
        Rule("८", "8"),
        Rule("९", "9"),

        //punctuation
        Rule("।", "."),//danda or 'stick'. equivalent to a full stop.
        Rule(" ", " ")

    )

}