package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**This transcriber follows pronunciation in Standard German, as spoken in Germany.*/
object GermanRuleBased: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS

    val vowels = "aeiouäöü"
    val consonants = "bcdfghjklmnpqrstvwxyz"
    val rules:List<Rule> = listOf(

        //vowels, second attempt

        //Vowel Length

        //Even though vowel length is phonemic in German, it is not consistently represented.
        // However, there are different ways of identifying long vowels:

        //A vowel in an open syllable (a free vowel) is long, for instance in ge-ben ('to give'), sa-gen ('to say').
        //It is rare to see a bare i used to indicate a long vowel /iː/.
        //Instead, the digraph ie is used, for instance in Liebe ('love'), hier ('here').
        Rule("ie", "iː"),
        //Occasionally – typically in word-final position – this digraph <ie> represents /iː.ə/
        //as in the plural noun Knie /kniː.ə/ ('knees') (cf. singular Knie /kniː/).
        //In Fraktur, where capital I and J are identical or near-identical J {\displaystyle {\mathfrak {J}}}
        //{\displaystyle {\mathfrak {J}}}, the combinations Ie and Je are confusable;
        //hence the combination Ie is not used at the start of a word, for example Igel ('hedgehog'), Ire ('Irishman').

        //A silent h indicates a long vowel in certain cases. That h derives from an old /x/ in some words,
        //for instance sehen ('to see') zehn ('ten'), but in other words it has no etymological justification,
        //for instance gehen ('to go') or mahlen ('to mill'). Occasionally a digraph can be redundantly followed by h,
        //either due to analogy, such as sieht ('sees', from sehen) or etymology, such as Vieh ('cattle', MHG vihe),
        //rauh ('rough', pre-1996 spelling, now written rau, MHG ruh).

        //The letters a, e, o are doubled in a few words that have long vowels, for instance Saat ('seed'),
        //See ('sea'/'lake'), Moor ('moor').
        Rule("aa", "aː"),
        Rule("ee", "eː"),
        Rule("oo", "oː"),

        //A doubled consonant after a vowel indicates that the vowel is short,
        //while a single consonant often indicates the vowel is long, e.g. Kamm ('comb') has a short vowel /kam/,
        //while kam ('came') has a long vowel /kaːm/. Two consonants are not doubled: k, which is replaced by ck
        // (until the spelling reform of 1996, however, ck was divided across a line break as k-k),
        //and z, which is replaced by tz.
        //In loanwords, kk (which may correspond with cc in the original spelling) and zz can occur.
        //Consonants are sometimes doubled in writing to indicate the preceding vowel is to be pronounced as a short vowel.
        //todo Rule("[$consonants]\\1"),

        //For different consonants and for sounds represented by more than one letter (ch and sch) after a vowel,
        //no clear rule can be given, because they can appear after long vowels,
        // yet are not redoubled if belonging to the same stem, e.g. Mond /moːnt/ 'moon', Hand /hant/ 'hand'.
        Rule(" ", "mond( |$)", "moːnt", 4),
        Rule("( |^)", "hand( |$)", "hant", 4),
        //On a stem boundary, reduplication usually takes place, e.g., nimm-t 'takes';
        // however in fixed, no longer productive derivatives this too can be lost,
        // e.g., Geschäft /ɡəˈʃɛft/ 'business' despite schaffen 'to get something done'.

        //ß indicates that the preceding vowel is long, e.g. Straße 'street' vs. Masse 'amount'.
        //In addition to that, texts written before the 1996 spelling reform also use ß at the ends of words and before
        //consonants, e.g. naß 'wet' and mußte 'had to' (after the reform spelled nass and musste),
        //so vowel length in these positions could not be detected by the ß, cf. Maß 'measure' and fußte 'was based'
        // (after the reform still spelled Maß and fußte).

        //A vowel usually represents a long sound if the vowel in question occurs:
        //    as the final letter (except for e)
        //    followed by a single consonant as in bot "offered"
        //    before a single consonant followed by a vowel as in Wagen "car"

        // Most one-syllable words that end in a single consonant are pronounced with long vowels,
        // but there are some exceptions such as an, das, es, in, mit, and von.
        Rule(" ", "an ", "an", 2),

        // The e in the ending -en is often silent, as in bitten "to ask, request".
        Rule("[^ ]", "en( |$)", "̩n", 2),//the syllabic n is not silent
        // The ending -er is often pronounced [ɐ], but in some regions, people say [ʀ̩] or [r̩].
        Rule("[^ ]", "er( |$)", "ɐ", 2),
        Rule("[^ ]", "e( |$)", "ə"),
        // The e in the ending -el ([əl ~ l̩], e.g. Tunnel, Mörtel "mortar") is pronounced short despite having just a
        // single consonant on the end.
        Rule("[^ ]", "el( |$)", "el", 2),

        //Short Vowels
        //    a: [a] as in Wasser "water"
        //    ä: [ɛ] as in Männer "men"
        //    e: [ɛ] as in Bett "bed"; unstressed [ə] as in Ochse "ox"
        //    i: [ɪ] as in Mittel "means"
        //    o: [ɔ] as in kommen "to come"
        //    ö: [œ] as in Göttin "goddess"
        //    u: [ʊ] as in Mutter "mother"
        //    ü: [ʏ] as in Müller "miller"
        //    y: [ʏ] as in Dystrophie "dystrophy"

        //Long vowels
        //
        //Long vowels are generally pronounced with greater tenseness than short vowels.
        //    a, ah, and aa: [aː]
        //    ä, äh: [ɛː] or [eː]
        //    e, eh, and ee: [eː]
        //    i, ie, ih, and ieh: [iː]
        //    o, oh, and oo: [oː]
        //    ö, öh: [øː]
        //    u and uh: [uː]
        //    ü and üh: [yː]
        //    y: [yː]
        Rule("au", "aʊ"),
        Rule("(eu|äu)", "ɔʏ"),
        Rule("(ei|ai|ey|ay)", "aɪ"),

       //old -- use these to double-check the new vowel rules, when they're done
/*        Rule("wird", "ɪɐ̯"),
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
        */
        //consonants

        Rule("sch", "w", "f"),
        Rule("w", "v"),
        Rule("r[$vowels]", "ʁ", 1),
        Rule("r($| )", "ɐ", 1),
        //todo:Double consonants are pronounced as single consonants, except in compound words.

        //b: at end of syllable: [p]; otherwise: [b] or [b̥]
        Rule("b(^| )", "p", 1),
        //TODO ch: after a, o, and u: [x]; after other vowels or consonants or initially: [ç] or [k] (word-initially in Southern Germany);
            //the suffix -chen always [ç]. In Austro-Bavarian, especially in Austria, [ç] may always be substituted by [x].
        //chs: [ks] within a morpheme (e.g. Dachs [daks] "badger"); [çs] or [xs] across a morpheme boundary (e.g.
        // Dachs [daxs] "roof (genitive)")
        Rule("chs", "ks"),
        Rule("i", "ch", "ç"),
        Rule("ch", "x"),
        //ck: [k], follows short vowels
        Rule("ck", "k"),
        //c: before ä, e, and i: [ts]; otherwise: [k]
        Rule("c[äei]", "ts", 1),
        Rule("c", "k"),
        //d: at end of syllable: [t]; otherwise: [d] or [d̥]
        Rule("d($| )", "t", 1),
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
        Rule("s($| )", "s", 1),
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
        return nativeText.toLowerCase().normaliseUmlauts().processWithRules(rules, ::reportOnceAndCopy)
    }

    /**Converts umlauted vowels in all their possible representations into
     *  the same integrated characters used in all Rules.*/
    private fun String.normaliseUmlauts():String {
        return if(contains("ä") || contains("ö") || contains("ü") ) {
            this
        }else {
            this
                .replace("ä", "ä")//a-thn-umlaut
                .replace("̈a", "ä")//umlaut-then-a
                .replace("ae", "ä")

                .replace("ö", "ö")//o-umlaut
                .replace("̈o", "ö")//umlaut-o
                .replace("oe", "ö")//umlaut-o

                .replace("ü", "ü")//u-umlaut
                .replace("̈u", "ü")//umlaut-u
                .replace("ue", "ü")//umlaut-u
        }
    }
}