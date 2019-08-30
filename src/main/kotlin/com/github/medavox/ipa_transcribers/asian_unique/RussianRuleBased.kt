package com.github.medavox.ipa_transcribers.asian_unique

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**Completion state: vowel reduction in unstressed syllables not handled yet.
 * However, these require stress info, and by all accounts,
 * the stresses of Russian words follow no pattern, and can only be memorised
 *
 * So this may be as far as we can get for Russian.
 *
 * Also a static list of any exceptions.*/
object RussianRuleBased:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS
    //todo: implement vowel reduction in unstressed vowels
    //TODO:voicing assimilation, and devoicing at end of word
    private const val softenableConsonants = "бвгдзклмнпрстфх"
    //Consonant letters represent both
    // "soft" (palatalized, represented in the IPA with a ⟨ʲ⟩) and
    // "hard" consonant phonemes.
    //
    // If consonant letters are followed by vowel letters,
    // the soft/hard quality of the consonant depends on whether the vowel is meant to follow
    // "hard" consonants ⟨а, о, э, у, ы⟩ or
    // "soft" consonants ⟨я, ё, е, ю, и⟩

    //for when you want to write fake cyrillic, but aren't Russian
    private val fakeLatinCyrillic:List<Rule> = listOf(
        Rule("A", "а"),
        Rule("B", "в"),
        Rule("E", "е"),
        Rule("S", "ѕ"),
        Rule("I", "і"),
        Rule("J", "ј"),
        Rule("K", "к"),
        Rule("M", "м"),
        Rule("H", "н"),
        Rule("O", "о"),
        Rule("P", "р"),
        Rule("C", "с"),
        Rule("T", "т"),
        Rule("Y", "у"),
        Rule("X", "х")
    )
    val rules:List<Rule> = listOf(
        Rule("а", "a"),
        Rule("б", "b"), //  or /bʲ/
        Rule("в", "v"), //  or /vʲ/
        Rule("г", "ɡ"), //  or /gʲ/
        Rule("д", "d"), //  or /dʲ/
        Rule("[$softenableConsonants]", "е", "ʲe"), //, / ʲe/ or /e/
        Rule("е", "je"), //, / ʲe/ or /e/
        Rule("[$softenableConsonants]", "ё", "ʲo"),
        Rule("ё", "jo"),
        Rule("ж", "ʐ"),
        Rule("з", "z"), // or /zʲ/
        Rule("[$softenableConsonants]", "и", "ʲi"), //, / ʲi/, or /ɨ/
        Rule("и", "i"), //, / ʲi/, or /ɨ/
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
        Rule("ъ", ""), //"hard sign" silent, prevents palatalization of the preceding consonant
        Rule("ы", "ɨ"),
        Rule("[$softenableConsonants]", "ь", "ʲ"),//"soft sign" silent, palatalizes the preceding consonant
        Rule("э", "e"), //
        Rule("[$softenableConsonants]", "ю", "ʲu"), //  or / ʲu/
        Rule("ю", "ju"), //  or / ʲu/
        Rule("[$softenableConsonants]", "я", "ʲa"), // ja or / ʲa/
        Rule("я", "ja") // ja or / ʲa/
    )+westernPunctuation
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(fakeLatinCyrillic, copy).toLowerCase().processWithRules(rules, reportAndCopy)
    }
}