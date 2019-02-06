package com.github.medavox.ipa_transcribers.turkish

import com.github.medavox.ipa_transcribers.Language.Turkish
import com.github.medavox.ipa_transcribers.Transcriber
import com.github.medavox.ipa_transcribers.rulesystem.Rule
import com.github.medavox.ipa_transcribers.rulesystem.RuleProcessor

object TurkishRuleBased: Transcriber<Turkish>, RuleProcessor<Turkish> {
    private val rules:List<Rule> = listOf(
        Rule("a", "a"),
        Rule("b", "b"),
        Rule("c",   "d͡ʒ"),
        Rule("ç",   "t͡ʃ"),
        Rule("d", "d"),

        // /e/ is realized as [ɛ]~[æ] before coda /m, n, l, r/. E.g. gelmek [ɡæɫˈmec].
        Rule("e", "e"),//[a]
        Rule("f", "f"),

        Rule("g", "ɡ"), ///ɟ/[b]

        //^c (1) Syllable initially: Silent, indicates a syllable break.
        // That is Erdoğan /ˈeɾ.do.an/ (the English equivalent is approximately a W, i.e. "Erdowan")
        // and değil [ˈde.il] (the English equivalent is approximately a Y, i.e. "deyil").
        // (2) Syllable finally after /e/: [j]. E.g. eğri [ej.ˈɾi].
        // (3) In other cases: Lengthening of the preceding vowel. E.g. bağ [ˈbaː].
        // (4) There is also a rare, dialectal occurrence of [ɰ], in Eastern and lower Ankara dialects.
        Rule("ğ", "ː"),//, /‿/, /j/   —[c]
        Rule("h", "h"),
        Rule("ı", "ɯ"),
        Rule("i", "i"),
        Rule("j", "ʒ"),
        Rule("k", "k"),//, /c/[b]
        Rule("l", "ɫ"),//, /l/[b]
        Rule("m", "m"),
        Rule("n", "n"),
        Rule("o", "o"),
        Rule("ö", "ø"),
        Rule("p", "p"),

        //^d The alveolar tap /ɾ/ doesn't exist as a separate phoneme in English,
        // though a similar sound appears in words like butter in a number of dialects.
        Rule("r", "ɾ"),
        Rule("s", "s"),
        Rule("ş", "ʃ"),
        Rule("t", "t"),
        Rule("u", "u"),
        Rule("ü", "y"),
        Rule("v", "v"),
        Rule("y", "j"),
        Rule("z", "z")
    )

    //^b In native Turkic words, the velar consonants /k, ɡ/ are palatalized to [c, ɟ]
    // when adjacent to the front vowels /e, i, ø, y/.
    //
    // Similarly, the consonant /l/ is realized as a clear or light [l] next to front vowels (including word finally),
    // and as a velarized [ɫ] next to the central and back vowels /a, ɯ, o, u/.
    //
    // These alternations are not indicated orthographically:
    // the same letters ⟨k⟩, ⟨g⟩, and ⟨l⟩ are used for both pronunciations.
    //
    // In foreign borrowings and proper nouns, however, these distinct realizations of /k, ɡ, l/ are contrastive.
    //
    // In particular, [c, ɟ] and clear [l] are sometimes found in conjunction with the vowels [a] and [u].

    // This pronunciation can be indicated by adding a circumflex accent over the vowel:
    // e.g. gâvur ('infidel'), mahkûm ('condemned'), lâzım ('necessary'),
    // although this diacritic's usage has been increasingly archaic.
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules) {
            System.err.println("unknown char ${it[0]} in $it; skipping...")
            RuleProcessor.UnmatchedOutput(it.substring(1), "")
        }
    }
}