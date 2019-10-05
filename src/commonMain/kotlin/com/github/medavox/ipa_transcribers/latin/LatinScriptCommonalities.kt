package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.Rule
/**Rules for Latin-Script letters whose pronunciation across all languages varies more rarely.*/
object LatinScriptCommonalities {
    val latinBaseRules: List<Rule> get() = listOf(
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
}