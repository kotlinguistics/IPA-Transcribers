package com.github.medavox.ipa_transcribers.bengali

import com.github.medavox.ipa_transcribers.Language.Bengali
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber


object BengaliRuleBased : RuleBasedTranscriber<Bengali> {
    //todo:write rules for vowels,
    //todo:modify RuleTranscriber so we can handle those vowel diacritics that come BEFORE their consonant
    val rules:List<Rule> = listOf(
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
        Rule("[তৎ]", "tɔ"),
        Rule("থ", "tʰɔ"),
        Rule("ট", "ʈɔ"),
        Rule("ঠ", "ʈʰɔ"),
        Rule("চ", "tʃɔ"),
        Rule("ছ ", "tʃʰɔ"),

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
        Rule("৯", "9")



        )
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}