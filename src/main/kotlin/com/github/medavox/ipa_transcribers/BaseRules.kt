package com.github.medavox.ipa_transcribers

interface BaseRules {

    val westernPunctuation:List<Rule> get() = listOf(
        Rule(" ", " "),
        Rule(",", ","),
        Rule(".", ".")
    )

    private fun l(it:String):String{
        return if(it.endsWith("ə")) it.substring(0, it.length-1) else it
    }
    val devanagariBaseRules:List<Rule> get() = listOf(

        //consonants.
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


        //Vowels. Each vowel has an independent form, and a form which attaches to the previous consonant.
        //Much kudos to Unicode's Devanagari support;
        // the vowels act like separate characters on a character level,
        // but combine with their previous consonant to form the right character visually.
        //this means we use the minimum number of code points possible to represent Devanagari.
        Rule("[आा]", {l(it)+"aː"}),
        Rule("[एे]", {l(it)+"eː"}),
        Rule("[ऐै]", {l(it)+"ɛː"}),
        Rule("[अ]", {l(it)+"ə"}),
        Rule("[ईी]", {l(it)+"iː"}),
        Rule("[इि]", {l(it)+"ɪ"}),
        Rule("[ओो]", {l(it)+"oː"}),
        Rule("[औौ]", {l(it)+"ɔː"}),
        Rule("[ऊू]", {l(it)+"uː"}),
        Rule("[उु]", {l(it)+"ʊ"}),
        Rule("[ऋृ]", {l(it)+"ɾɪ"}),
        Rule("्", {l(it)}),// ् "virama" is a diacritic which suppresses the inherent vowel
        Rule("ं", {l(it)}),// "anusvara" diacritic nasalises the preceding consonant*
        //or in modern hindi and marathi, sometimes its vowel as well. It's comlicated.

        Rule("ँ", "̃"), //nasalised vowel diacritic. Presumably can go over any (or some) other vowels

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

    val latinBaseRules:List<Rule> get() = listOf(
        Rule("a", "a"),
        Rule("b", "b"),

        Rule("d", "d"),
        Rule("e", "e"),
        Rule("f", "f"),
        Rule("g", "ɡ"),
        Rule("h", "h"),
        Rule("i", "i"),

        Rule("k", "k"),
        Rule("l", "l"),
        Rule("m", "m"),
        Rule("n", "n"),
        Rule("o", "o"),
        Rule("p", "p"),

        Rule("s", "s"),
        Rule("t", "t"),
        Rule("u", "u"),
        Rule("v", "v"),
        Rule("w", "w"),

        Rule("y", "j"),
        Rule("z", "z"),
        Rule(" ", " ")
    )

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
        Rule("ط", "s"),
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
        Rule("و", "[v] / [uː] / [o] / [ow] / ([w] / [aw] / [oː] in Dari)"),
        Rule("ه", "h"),
        Rule("ی", "[j] / [i] / [ɒː] / ([aj] / [eː] in Dari)"),
        Rule(" ", " ")
    )

}