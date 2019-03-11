package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object GermanRuleBased: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.INCOMPLETE

    val vowels = "aeiouäöü"
    val rules:List<Rule> = listOf(

        Rule("wird", "ɪɐ̯"),
        Rule("wir", "iːɐ̯"),
        Rule("Würde", "ʏɐ̯"),
        Rule("für", "yːɐ̯"),
        Rule("wurde", "ʊɐ̯"),
        Rule("Urlaub", "uːɐ̯"),
        Rule("Erft", "ɛɐ̯"),
        Rule("är", "ɛːɐ̯"),
        Rule("ehr", "eːɐ̯"),
        Rule("dörrt", "œɐ̯"),
        Rule("hör!", "øːɐ̯"),
        Rule("Norden", "ɔɐ̯"),
        Rule("Tor", "oːɐ̯"),
        Rule("hart", "aɐ̯"),
        Rule("ahr", "aːɐ̯"),
        //vowels
        Rule("eer", "iɐ"),
        Rule("ehe", "eɐ"),
        Rule("ee", "iː"),
        Rule("ei", "a̯ɪ"),
        Rule("or", "ɔː"),
        Rule("ä", "ɛ"),
        Rule("ö", "?????"),
        Rule("ü", "y"),
        Rule("u", "ʊ"),
        Rule("i", "ɪ"),

        //velar fricative
        Rule("i", "ch", "ç"),
        Rule("ch", "x"),

        Rule("d(^| )", "t", 1),
        Rule("t?z", "ts"),

        Rule("er", "ɐ"),
        //sibilants
        Rule("sch", "ʃ"),
        Rule("s[pt][$vowels]", "ʃ", 1),
        Rule("s[ptk]", "s", 1),
        Rule("s(^| )", "s", 1),
        Rule("s", "z"),

        Rule("v", "f"),
        Rule("sch", "w", "f"),
        Rule("w", "v"),
        Rule("ng", "ŋ"),
        Rule("r[$vowels]", "ʁ", 1),
        Rule("r(^| )", "ɐ", 1)


        //Rule("","")
    ) + latinBaseRules + westernPunctuation
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, ::reportOnceAndCopy)
    }
}