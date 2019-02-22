package com.github.medavox.ipa_transcribers.russian

import com.github.medavox.ipa_transcribers.Language.Russian
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object RussianRuleBased:RuleBasedTranscriber<Russian> {
    val rules:List<Rule> = listOf(
        Rule("а", "a"),
        Rule("б", "b"), //  or /bʲ/
        Rule("в", "v"), //  or /vʲ/
        Rule("г", "ɡ"), //  or /gʲ/
        Rule("д", "d"), //  or /dʲ/
        Rule("е", "je"), // , / ʲe/ or /e/
        Rule("ё", "jo"), //  or / ʲo/
        Rule("ж", "ʐ"), //
        Rule("з", "z"), //  or /zʲ/
        Rule("и", "i"), // , / ʲi/, or /ɨ/
        Rule("й", "j"),
        Rule("к", "k"), //  or /kʲ/
        Rule("л", "ɫ"), //  or /lʲ/
        Rule("м", "m"), //  or /mʲ/
        Rule("н", "n"), //  or /nʲ/
        Rule("о", "o"),
        Rule("п", "p"), //  or /pʲ/
        Rule("р", "r"), //  or /rʲ/
        Rule("с", "s"), //  or /sʲ/
        Rule("т", "t"), //  or /tʲ/
        Rule("у", "u"),
        Rule("ф", "f"), //  or /fʲ/
        Rule("х", "x"), //  or /xʲ/
        Rule("ц", "ts"),
        Rule("ч", "tɕ"),
        Rule("ш", "ʂ"),
        Rule("щ", "ɕɕ"),
        //ъ
        //        ы  [ɨ]
        Rule("ь", " ʲ"), //
        Rule("э", "e"), //
        Rule("ю", "ju"), //  or / ʲu/
        Rule("я", "ja") //  or / ʲa/
    )
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, copyVerbatim)
    }
}