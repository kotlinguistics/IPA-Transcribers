package com.github.medavox.ipa_transcribers

import java.lang.StringBuilder

interface RuleBasedTranscriber<T:Language>:Transcriber<T> {
    data class UnmatchedOutput(val newWorkingInput:String, val output:(soFar:String) -> String) {
        constructor(newWorkingInput: String, output:String):this(newWorkingInput, {it+output})
    }
    val reportAndSkip:(String) -> UnmatchedOutput get() = {
        System.err.println("unknown char '${it[0]}' in $it; skipping...")
        RuleBasedTranscriber.UnmatchedOutput(it.substring(1), "")
    }

    val copyVerbatim:(String) -> UnmatchedOutput get() = {
        System.err.println("copying unknown char '${it[0]}' to output...")
        RuleBasedTranscriber.UnmatchedOutput(it.substring(1), it[0].toString())
    }

    private fun l(it:String):String{
        return if(it.endsWith("ə")) it.substring(0, it.length-1) else it
    }
    val devanagariBaseRules:List<Rule> get() = listOf(

        //consonants.
        // These have an inherent schwa (which is often romanised as 'a'),
        //if there isn't another vowel attached to that character.
        //so it isn't output in these rules.
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

        Rule("ँ", "̃"), //nasal vowel. Presumably can go over any (or some) other vowels

        //todo:
        //schwa rule

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

    fun String.processWithRules(rules:List<Rule>,
                                onNoRuleMatch:(unmatched:String) -> UnmatchedOutput
    ) : String {
        var out:String = ""
        var processingWord = this
        loop@ while(processingWord.isNotEmpty()) {
            for (rule in rules) {
                val matchResult:MatchResult? = rule.matcher.find(processingWord)

                //if the rule matches the start of the remaining string
                if(matchResult?.range?.start == 0) {
                    //System.out.println("rule '${rules[i]}' matches '$processingWord'")
                    out = rule.outputString(out)
                    //System.out.println("matched rule:$rule")
                    //number of letters consumed is the match length, unless explicitly specified
                    val actualLettersConsumed = rule.lettersConsumed ?: matchResult.value.length
                    if(actualLettersConsumed > 0) {
                        processingWord = processingWord.substring(actualLettersConsumed)
                        continue@loop
                    }//else keep going through the rule list
                }
            }
            //no rule matched; call the lambda!
            val unmatchedOutput = onNoRuleMatch(processingWord)
            processingWord = unmatchedOutput.newWorkingInput
            out = unmatchedOutput.output(out)
        }
        return out
    }
}