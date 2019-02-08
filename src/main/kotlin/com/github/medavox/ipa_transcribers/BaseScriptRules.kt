package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.Rule

/**common pronunciation rules for scripts shared by multiple languages*/
object BaseScriptRules {
    val devanagariBaseRules:List<Rule> = listOf(

    )

    val latinBaseRules:List<Rule> = listOf(
        Rule("a", "a"),
        Rule("b", "b"),
        Rule("d", "d"),

        Rule("e", "e"),//[a]
        Rule("f", "f"),

        Rule("g", "ɡ"), ///ɟ/[b]

        Rule("h", "h"),
        Rule("i", "i"),
        Rule("k", "k"),//, /c/[b]
        Rule("l", "l"),//, /l/[b]
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
        Rule("z", "z")
    )

    val persoArabicBaseRules:List<Rule> = listOf(

    )
}