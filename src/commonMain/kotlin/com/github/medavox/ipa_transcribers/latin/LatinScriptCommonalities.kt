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
            Rule("ph", "f"),//greek loanwords are common

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