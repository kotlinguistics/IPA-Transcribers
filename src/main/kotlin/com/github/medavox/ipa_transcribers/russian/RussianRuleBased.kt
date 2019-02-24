package com.github.medavox.ipa_transcribers.russian

import com.github.medavox.ipa_transcribers.Language.Russian
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object RussianRuleBased:RuleBasedTranscriber<Russian> {
    //features of russian orthography
    //1.hardening and softening of consonants
    //vowel reduction
    //the third one
    private const val softenableConsonants = "бвгдзклмнпрстфх"
    //problem:

    //we need to know the previous consonant to check if it can be softened;
    //but we also need to print out the following vowel so we don't reprocess it again as a word-initial.

    //this means one rule for every pair of softenable consonant + softening vowel,
    //or 5 * 15 = 75 rules.

    //this is bad.

    //so instead we need to be able to 'look back' at previous, consumed letters -- preferably in a Regex-friendly way.
    //so maybe instead of feeding the chopped-off string (with the characters consumed so far removed),
    //we feed in the whole string each time, with a pointer to the current one?

    //maybe we have to match regexes on two strings: the consumed-so-far characters AND the unconsumed characters?

    //like this:

    // para aq | ui

    //this would allow us to use regex to read the end of the last-consumed characters

    //Consonant letters represent both
    // "soft" (palatalized, represented in the IPA with a ⟨ʲ⟩) and
    // "hard" consonant phonemes.
    //
    // If consonant letters are followed by vowel letters,
    // the soft/hard quality of the consonant depends on whether the vowel is meant to follow
    // "hard" consonants ⟨а, о, э, у, ы⟩ or
    // "soft" consonants ⟨я, ё, е, ю, и⟩
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
        return nativeText.toLowerCase().processWithRules(rules, reportAndCopy)
    }
}