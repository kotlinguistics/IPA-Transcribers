package com.github.medavox.ipa_transcribers

import java.lang.StringBuilder

interface RuleBasedTranscriber<T:Language>:Transcriber<T> {
    data class UnmatchedOutput(val newWorkingInput:String, val output:String)
    val reportAndSkip:(String) -> UnmatchedOutput get() = {
        System.err.println("unknown char '${it[0]}' in $it; skipping...")
        RuleBasedTranscriber.UnmatchedOutput(it.substring(1), "")
    }

    val copyVerbatim:(String) -> UnmatchedOutput get() = {
        System.err.println("copying unknown char '${it[0]}' to output...")
        RuleBasedTranscriber.UnmatchedOutput(it.substring(1), it[0].toString())
    }

    val devanagariBaseRules:List<Rule> get() = listOf(

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
        val out = StringBuilder()//.append('/')
        var processingWord = this
        loop@ while(processingWord.isNotEmpty()) {
            for (rule in rules) {
                val matchResult:MatchResult? = rule.matcher.find(processingWord)

                //if the rule matches the start of the remaining string
                if(matchResult?.range?.start == 0) {
                    //System.out.println("rule '${rules[i]}' matches '$processingWord'")
                    out.append(rule.outputString())

                    //number of letters consumed is the match length, unless explicitly specified
                    val actualLettersConsumed = rule.lettersConsumed ?: matchResult.value.length
                    processingWord = processingWord.substring(actualLettersConsumed)
                    continue@loop
                }
            }
            //no rule matched; call the lambda!
            val unmatchedOutput = onNoRuleMatch(processingWord)
            processingWord = unmatchedOutput.newWorkingInput
            out.append(unmatchedOutput.output)
        }
        return out.toString()
    }
}