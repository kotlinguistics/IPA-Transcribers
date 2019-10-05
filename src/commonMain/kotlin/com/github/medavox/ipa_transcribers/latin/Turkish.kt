package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.*
import com.github.medavox.ipa_transcribers.latin.LatinScriptCommonalities.latinBaseRules

/**Status:COMPLETE
 * barring any major irregularities.
 *
 * Turkish spelling is extremely regular, because it systematically adopted the latin alphabet in 1929.
 * thanks Atatürk!*/
object Turkish: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.COMPLETE
    val frontVowels = "eiöü"
    val backVowels = "aâıouû"
    val allVowels = "aâeiıoöuüû"

    private val rules:List<IRule> = listOf(
        Rule("â", "a"),
        Rule("c", "d͡ʒ"),
        Rule("c[$allVowels]", "d͡ʒʰ", 1),
        Rule("ç", "t͡ʃ"),

        // /e/ is realized as [ɛ]~[æ] before coda /m, n, l, r/. E.g. gelmek [ɡæɫˈmec].
        Rule("e[mnlr]", "æ", 1),
        Rule("e", "e"),//[a]

        //⟨ğ⟩ only occurs after a vowel.
        //-----------------------------
        //a debatable phoneme, called yumuşak g ('soft g').
        //It is sometimes transcribed /ɰ/ or /ɣ/.
        //Before the loss of this sound, Turkish did not allow vowel sequences in native words,
        //and today the letter ⟨ğ⟩ serves largely to indicate vowel length and vowel sequences where /ɰ/ once occurred.

        // Between front vowels, it is either silent or realized as [j] (e.g. düğün 'marriage',
        // where the [j] is even mandatory in fast speech to distinguish it from dün 'yesterday'),
        // depending on the preceding and following vowels.
        LookbackRule("[$frontVowels]", "ğ[$frontVowels]", "j", 1),//, /‿/, /j/   —[c]

        //Between back vowels, it may be silent or sound like a bilabial glide.
        LookbackRule("[$backVowels]", "ğ[$backVowels]", "ɰ̟", 1),//, /‿/, /j/   —[c]

        // (1) Syllable initially: Silent, indicates a syllable break.
        // That is Erdoğan /ˈeɾ.do.an/ (the English equivalent is approximately a W, i.e. "Erdowan")
        // and değil [ˈde.il] (the English equivalent is approximately a Y, i.e. "deyil").
        LookbackRule("[$allVowels]", "ğ[$allVowels]", "", 1),//, /‿/, /j/   —[c]

        // (2) Syllable finally after /e/: [j]. E.g. eğri [ej.ˈɾi].
        LookbackRule("[e]", "ğ[^$allVowels]", "j", 1),//, /‿/, /j/   —[c]

        //Word-finally and preconsonantally, it lengthens the preceding vowel.
        // When not between vowels (that is, word finally and before a consonant),
        // it is generally realized as vowel length, lengthening the preceding vowel,
        // or as a slight [j] if preceded by a front vowel.[4]
        LookbackRule("[$allVowels]", "ğ", "ː"),//, /‿/, /j/   —[c]

        Rule("ı", "ɯ"),
        //The phonemes /ʒ/ and /f/ only occur in loanwords and interjections.
        Rule("j", "ʒ"),

        //In native Turkic words, the velar consonants /k, ɡ/ are palatalized to [c, ɟ] (similar to Russian)
        // when adjacent to the front vowels /e, i, ø, y/.

        // Similarly, the consonant /l/ is realized as a clear or light [l] next to front vowels
        // (including word finally), and as a velarized [ɫ] next to the central and back vowels /a, ɯ, o, u/.

        // These alternations are not indicated orthographically: the same letters ⟨k⟩, ⟨g⟩, and ⟨l⟩ are used for
        // both pronunciations.

        // In foreign borrowings and proper nouns, however, these distinct realizations of /k, ɡ, l/ are contrastive.
        // In particular, [c, ɟ] and clear [l] are sometimes found in conjunction with the vowels [a] and [u].

        // This pronunciation can be indicated by adding a circumflex accent over the vowel: e.g. gâvur ('infidel'),
        // mahkûm ('condemned'), lâzım ('necessary'),
        // although the use of this diacritic has become increasingly archaic.[2]
        // An example of a minimal pair is kar ('snow') vs. kâr (with palatalized [c]) ('profit').
        LookbackRule("[$frontVowels]","k", "c"),
        Rule("k[$frontVowels]", "c", 1),
        Rule("k[âû]", "c", 1),
        //Syllable-initial /p, t, c, k/ are usually aspirated.
        LookbackRule("", "k[$backVowels]", "kʰ"),
        Rule("k", "k"),

        LookbackRule("[$frontVowels]", "g", "ɟ"),
        Rule("g[$frontVowels]", "ɟ", 1),
        Rule("g[âû]", "ɟ", 1),
        Rule("g", "ɡ"),

        LookbackRule("[$frontVowels]", "l", "l"),
        Rule("l[$frontVowels]", "l", 1),
        Rule("l[âû]", "l", 1),
        Rule("l", "ɫ"),

        Rule("ö", "ø̞"),
        Rule("r", "ɾ"),
        Rule("ş", "ʃ"),
        Rule("û", "u"),
        Rule("ü", "y"),

        //Syllable-initial /p, t, c, k/ are usually aspirated.
        Rule("p[$allVowels]", "pʰ"),
        Rule("t[$allVowels]", "tʰ"),

        //Final /h/ may be fronted to a voiceless velar fricative [x].[5]
        // It may be fronted even further after front vowels, then tending towards a voiceless palatal fricative [ç].
        LookbackRule("[$frontVowels]", "h", "ç"),
        ///h/ is realised [x] in most dialects, including standard Turkish Radio & Television speech.
        Rule("h", "x")
    ) + latinBaseRules

    /*Vowel harmony of grammatical suffixes is realized through "a chameleon-like quality",[16]
     meaning that the vowels of suffixes change to harmonize with the vowel of the preceding syllable.
     According to the changeable vowel, there are two patterns:

    * twofold (/e/~/a/):[17] Backness is preserved, that is, /e/ appears following a front vowel and
      /a/ appears following a back vowel.
      For example, the locative suffix is -de after front vowels and -da after back vowels.
      The notation -de2 is shorthand for this pattern.
    * fourfold (/i/~/y/~/ɯ/~/u/): Both backness and rounding are preserved.
      For example, the genitive suffix is -in after unrounded front vowels, -ün after rounded front vowels,
       -ın after unrounded back vowels, and -un after rounded back vowels.
       The notation -in4 can be this pattern's shorthand.*/

    //back vowels (/a, ɯ, o, u/)
    //front vowels (/e, i, œ, y/)
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, reportAndSkip)
    }
}