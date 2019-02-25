package com.github.medavox.ipa_transcribers.turkish

import com.github.medavox.ipa_transcribers.Language.Turkish
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object TurkishRuleBased: RuleBasedTranscriber<Turkish> {

    val frontVowels = "eiöü"

    //    The phonemes /ʒ/ and /f/ only occur in loanwords and interjections.
    //    /h/ is realised [x] in most dialects, including standard TRT speech.
    private val rules:List<Rule> = listOf(
        Rule("â", "a"),
        Rule("c", "d͡ʒ"),
        Rule("ç", "t͡ʃ"),

        // /e/ is realized as [ɛ]~[æ] before coda /m, n, l, r/. E.g. gelmek [ɡæɫˈmec].
        Rule("e", "e"),//[a]

        //⟨ğ⟩     Word-finally and preconsonantally, it lengthens the preceding vowel.[5]
        //        Between front vowels it is an approximant, either front-velar [ɰ̟] or palatal [j].[5]
        //        Otherwise, intervocalic /ɣ/ is phonetically zero (deleted).[5] Before the loss of this sound,
        // Turkish did not allow vowel sequences in native words, and today the letter ⟨ğ⟩ serves largely to
        // indicate vowel length and vowel sequences where /ɰ/ once occurred.[6]
        // (1) Syllable initially: Silent, indicates a syllable break.
        // That is Erdoğan /ˈeɾ.do.an/ (the English equivalent is approximately a W, i.e. "Erdowan")
        // and değil [ˈde.il] (the English equivalent is approximately a Y, i.e. "deyil").
        // (2) Syllable finally after /e/: [j]. E.g. eğri [ej.ˈɾi].
        // (3) In other cases: Lengthening of the preceding vowel. E.g. bağ [ˈbaː].
        // (4) There is also a rare, dialectal occurrence of [ɰ], in Eastern and lower Ankara dialects.

        //there is a debatable phoneme, called yumuşak g ('soft g') and written ⟨ğ⟩, which only occurs after a vowel.
        //It is sometimes transcribed /ɰ/ or /ɣ/. Between back vowels, it may be silent or sound like a bilabial glide.
        // Between front vowels, it is either silent or realized as [j] (e.g. düğün 'marriage',
        // where the [j] is even mandatory in fast speech to distinguish it from dün 'yesterday'),
        // depending on the preceding and following vowels.
        // When not between vowels (that is, word finally and before a consonant),
        // it is generally realized as vowel length, lengthening the preceding vowel,
        // or as a slight [j] if preceded by a front vowel.[4]
        // According to Zimmer & Orgun (1999), who transcribe this sound as /ɣ/:
            //Word-finally and preconsonantally, it lengthens the preceding vowel.[5]
            //Between front vowels it is an approximant, either front-velar [ɰ̟] or palatal [j].[5]
            //Otherwise, intervocalic /ɣ/ is phonetically zero (deleted).[5] Before the loss of this sound,
            //Turkish did not allow vowel sequences in native words,
            // and today the letter ⟨ğ⟩ serves largely to indicate vowel length and vowel sequences where /ɰ/ once occurred.[6]

        Rule("ğ", "ː"),//, /‿/, /j/   —[c]
        Rule("ı", "ɯ"),
        Rule("j", "ʒ"),

        //In native Turkic words, the velar consonants /k, ɡ/ are palatalized to [c, ɟ] (similar to Russian)
        // when adjacent to the front vowels /e, i, ø, y/.

        // Similarly, the consonant /l/ is realized as a clear or light [l] next to front vowels
        // (including word finally), and as a velarized [ɫ] next to the central and back vowels /a, ɯ, o, u/.

        // These alternations are not indicated orthographically: the same letters ⟨k⟩, ⟨g⟩, and ⟨l⟩ are used for
        // both pronunciations.
        //
        // In foreign borrowings and proper nouns, however, these distinct realizations of /k, ɡ, l/ are contrastive.

        // In particular, [c, ɟ] and clear [l] are sometimes found in conjunction with the vowels [a] and [u].

        // This pronunciation can be indicated by adding a circumflex accent over the vowel: e.g. gâvur ('infidel'),
        // mahkûm ('condemned'), lâzım ('necessary'),
        // although the use of this diacritic has become increasingly archaic.[2]
        // An example of a minimal pair is kar ('snow') vs. kâr (with palatalized [c]) ('profit').

        Rule("[$frontVowels]","k", "c"),
        Rule("k[$frontVowels]", "c", 1),
        Rule("k[âû]", "c", 1),
        Rule("k", "k"),

        Rule("[$frontVowels]", "g", "ɟ"),
        Rule("g[$frontVowels]", "ɟ", 1),
        Rule("g[âû]", "ɟ", 1),
        Rule("g", "ɡ"),

        Rule("[$frontVowels]", "l", "l"),
        Rule("l[$frontVowels]", "l", 1),
        Rule("l[âû]", "l", 1),
        Rule("l", "ɫ"),

        Rule("ö", "ø̞"),
        Rule("r", "ɾ"),
        Rule("ş", "ʃ"),
        Rule("û", "u"),
        Rule("ü", "y"),

        //Final /h/ may be fronted to a voiceless velar fricative [x].[5]
        // It may be fronted even further after front vowels, then tending towards a voiceless palatal fricative [ç].
        Rule("[$frontVowels]", "h", "ç"),
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
    //= e, i, ö, ü

    //Syllable-initial /p, t, c, k/ are usually aspirated.[5]




    ///b, d, d͡ʒ, ɡ, ɟ/ are devoiced to [p, t, t͡ʃ, k, c] word- and morpheme-finally,
    // as well as before a consonant: /edˈmeɟ/ ('to do, to make') is pronounced [etˈmec].
    // (This is reflected in the orthography, so that it is spelled ⟨etmek⟩).
    // When a vowel is added to nouns ending with postvocalic /ɡ/, it is lenited to ⟨ğ⟩ (see below);
    // this is also reflected in the orthography.[11]
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, reportAndSkip)
    }
}