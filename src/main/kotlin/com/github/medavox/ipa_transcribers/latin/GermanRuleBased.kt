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
        Rule("art", "aɐ̯"),
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

        Rule("eer", "iɐ"),
        Rule("er", "ɐ"),
        //consonants

        Rule("sch", "w", "f"),
        Rule("w", "v"),
        Rule("r[$vowels]", "ʁ", 1),
        Rule("r(^| )", "ɐ", 1),
        //todo:Double consonants are pronounced as single consonants, except in compound words.

        //b: at end of syllable: [p]; otherwise: [b] or [b̥]
        Rule("b(^| )", "p", 1),
        //c: before ä, e, and i: [ts]; otherwise: [k]
        Rule("c[äei]", "ts", 1),
        Rule("c", "k"),
        //TODO ch: after a, o, and u: [x]; after other vowels or consonants or initially: [ç] or [k] (word-initially in Southern Germany);
            //the suffix -chen always [ç]. In Austro-Bavarian, especially in Austria, [ç] may always be substituted by [x].
        Rule("i", "ch", "ç"),
        Rule("ch", "x"),
        //chs: [ks] within a morpheme (e.g. Dachs [daks] "badger"); [çs] or [xs] across a morpheme boundary (e.g.
        // Dachs [daxs] "roof (genitive)")
        Rule("chs", "ks"),
        //ck: [k], follows short vowels
        Rule("ck", "k"),
        //d: at end of syllable: [t]; otherwise: [d] or [d̥]
        Rule("d(^| )", "t", 1),
        //dsch: [dʒ] or [d̥ʒ̊], used in loanwords and transliterations only.
            //Words borrowed from English can alternatively retain the original ⟨j⟩.
            //Many speakers pronounce ⟨dsch⟩ as [t͡ʃ] (= ⟨tsch⟩), because [dʒ] is not native to German.
        //dt: [t]
        Rule("dt", "t"),
        //g: when part of word-final -ig: [ç] or [k] (Southern German); at the end of a syllable: [k]; otherwise: [ɡ] or [ɡ̊]
        Rule("ig( |$)", "ɪç"),
        //h: before a vowel: [h]; when lengthening a vowel: silent
        Rule("h[$vowels]", "h", 1),
        //j: [j] in most words; [ʒ] in loanwords from French (as in jardin, French for garden)
        Rule("j", "j"),
        //ng: usually: [ŋ]; in compound words where the first element ends in "n" and the second element begins with "g" (-n·g-): [nɡ] or [nɡ̊]
        Rule("ng", "ŋ"),
        //nk: [ŋk]
        Rule("nk", "ŋk"),
        //pf: [pf] in all cases with some speakers;
        Rule("pf", "pf"),
            //with other speakers [f] at the beginning of words (or at the beginning of compound words' elements)
            // and [pf] in all other cases

        //ph: [f]
        Rule("ph", "f"),
        //qu: [kv] or [kw] (in a few regions)
        Rule("qu", "kv"),

        //r: the pronunciation of r varies regionally:
        //[ʁ] before vowels, [ɐ] otherwise; or
        Rule("r[$vowels]", "ʁ", 1),
        Rule("r", "ɐ", 1),
        //[ɐ] after long vowels (except [aː]), [ʁ] otherwise;[17] or
        //[r] or [ɾ] before vowels, [ɐ] otherwise (Austro-Bavarian); or
        //[r] in all cases (Swiss Standard German)

        //s: before and between vowels: [z] or [z̥]; before consonants or when final: [s];
        // before p or t at the beginning of a word or syllable: [ʃ]
        Rule("s[pt][$vowels]", "ʃ", 1),
        Rule("s[ptk]", "s", 1),
        Rule("s(^| )", "s", 1),
        Rule("[$vowels]?", "s[$vowels]", "z", 1),

        //sch: [ʃ]; however, [sç] when part of the -chen diminutive of a word ending on "s", (e.g. Mäuschen "little mouse")
        Rule("chen", "ç", 2),
        Rule("sch", "ʃ"),

        //ss, ß: [s]
        Rule("(ss|ß)", "s"),
        //th: [t]
        Rule("th", "t"),
        //ti: in -tion, -tiär, -tial, -tiell: [tsɪ̯]; otherwise: [ti]
        //tsch: [tʃ]
        //tzsch: [tʃ]
        Rule("tz?sch", "tʃ"),
        //tz: [ts], follows short vowels. also //z: [ts]
        Rule("t?z", "ts"),

        //v: in foreign borrowings not at the end of a word: [v]; otherwise: [f]
        Rule("v", "f"),
        //x: [ks]
        Rule("x", "ks"),

        //zsch: [tʃ]
        Rule("zsch", "tʃ"),
        Rule("","")
    ) + westernPunctuation + latinBaseRules.filter { with(it.unconsumedMatcher) {
        //german handles these letters differently than the base latin rules
            this != Regex("s") &&
            this != Regex("v") &&
            this != Regex("w") &&
            this != Regex("y") &&
            this != Regex("z")
        } }
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, ::reportOnceAndCopy)
    }
}