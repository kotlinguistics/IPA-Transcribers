@file:Suppress("NonAsciiCharacters")

package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.*
import com.github.medavox.ipa_transcribers.latin.German.Vowels.*
import com.github.medavox.ipa_transcribers.latin.LatinScriptCommonalities.latinBaseRules

/**This transcriber transcribes the pronunciation of Standard German, as spoken in Germany.
 *
 * In terms of accuracy, it's going to be close,
 * but it can never be 100% with the vowels, because the vowel length rules don't always apply consistently.
 *
 * Still to do: rules around final consonant devoicing, and voicing harmonisation
 * (eg when an unvoiced consonant devoices surrounding or following consonants)*/
object German: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.SURFACE_LEVEL_COMPLETE

    val vowels = "aeiouäöü"
    val consonants = "bcdfghjklmnpqrstvwxyz"

    //A doubled consonant after a vowel indicates that the vowel is short,
    //while a single consonant often indicates the vowel is long,
    //e.g. Kamm ('comb') has a short vowel /kam/, while kam ('came') has a long vowel /kaːm/.
    //
    // Two consonants are not doubled: k, which is replaced by ck
    // (until the spelling reform of 1996, however, ck was divided across a line break as k-k),
    //and z, which is replaced by tz.
    //In loanwords, kk (which may correspond with cc in the original spelling) and zz can occur.
    val vowelShorteningConsonantPairs:String = "(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)"
    /**
     * Short Vowels
    a: [a] as in Wasser "water"
    ä: [ɛ] as in Männer "men"
    e: [ɛ] as in Bett "bed"; unstressed [ə] as in Ochse "ox"
    i: [ɪ] as in Mittel "means"
    o: [ɔ] as in kommen "to come"
    ö: [œ] as in Göttin "goddess"
    u: [ʊ] as in Mutter "mother"
    ü: [ʏ] as in Müller "miller"
    y: [ʏ] as in Dystrophie "dystrophy"

    Long vowels

    generally pronounced with greater tenseness than short vowels.
    a, ah, and aa: [aː]
    ä, äh: [ɛː] or [eː]
    e, eh, and ee: [eː]
    i, ie, ih, and ieh: [iː]
    o, oh, and oo: [oː]
    ö, öh: [øː]
    u and uh: [uː]
    ü and üh: [yː]
    y: [yː]
     * */
    private enum class Vowels(val short:String, val long:String) {
        A("a", "aː"),
        Ä("ɛ", "ɛː"),
        E("ɛ", "eː"),
        I("ɪ", "iː"),
        O("ɔ", "oː"),
        Ö("œ", "øː"),
        U("ʊ", "uː"),
        Ü_Y("ʏ", "yː");

        companion object {
            fun from(vowel: String): Vowels = when (vowel) {
                "a" -> A
                "e" -> E
                "i" -> I
                "o" -> O
                "u" -> U
                "ä" -> Ä
                "ö" -> Ö
                "ü", "y" -> Ü_Y
                else -> throw IllegalArgumentException(
                    "only the following Strings of length 1 are valid input to this method:" +
                            "aeiouäöü"
                )
            }
        }
    }
    val rules:List<IRule> = listOf(

        // Most one-syllable words that end in a single consonant are pronounced with long vowels,
        // but there are some exceptions such as an, das, es, in, mit, and von.
        LookbackRule("( |^)", "an ", "an", 2),
        LookbackRule("( |^)", "das ", "das", 3),
        LookbackRule("( |^)", "der ", "dɛɐ", 3),
        LookbackRule("( |^)", "es ", "ɛs", 2),
        LookbackRule("( |^)", "in ", "ɪn", 2),
        LookbackRule("( |^)", "mit ", "mɪt", 3),
        LookbackRule("( |^)", "von ", "fɔn", 3),

        // The e in the ending -en is often silent, as in bitten "to ask, request".
        LookbackRule("[ptk]", "en( |$)", "n̩", 2),//the syllabic n is not silent
        // The ending -er is often pronounced [ɐ], but in some regions, people say [ʀ̩] or [r̩].
        LookbackRule("[^ ]", "er( |$)", "ɐ", 2),
        LookbackRule("[^ ]", "e( |$)", "ə"),
        // The e in the ending -el ([əl ~ l̩], e.g. Tunnel, Mörtel "mortar") is pronounced short,
        // despite having just a single consonant on the end.
        LookbackRule("[^ ]", "el( |$)", "el", 2),

        //other irregular words & elements transcribed manually
        Rule("system", "zʏzteːm"),
        LookbackRule("([^ ]|^)", "net ", "nət", 3),

        //DIPHTHONGS
        //==========
        Rule("au", "aʊ"),
        Rule("(eu|äu)", "ɔʏ"),
        Rule("(ei|ai|ey|ay)", "aɪ"),

        //VOWELS, second attempt
        //=====================

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

        //Even though vowel length is phonemic in German, it is not consistently represented.
        // However, there are different ways of identifying long vowels:

        //It is rare to see a bare i used to indicate a long vowel /iː/.
        //Instead, the digraph ie is used, for instance in Liebe ('love'), hier ('here').
        Rule("ie", "iː"),
        //Occasionally – typically in word-final position – this digraph <ie> represents /iː.ə/
        //as in the plural noun Knie /kniː.ə/ ('knees') (cf. singular Knie /kniː/).
        //In Fraktur, where capital I and J are identical or near-identical,
        // the combinations Ie and Je are confusable; hence the combination Ie is not used at the
        // start of a word, for example Igel ('hedgehog'), Ire ('Irishman').

        //The letters a, e, o are doubled in a few words that have long vowels,
        // for instance Saat ('seed'), See ('sea'/'lake'), Moor ('moor').
        Rule("aa", A.long),
        Rule("ee", E.long),
        Rule("oo", O.long),

        //A doubled consonant after a vowel indicates that the vowel is short,
        //while a single consonant often indicates the vowel is long,
        // e.g. Kamm ('comb') has a short vowel /kam/, while kam ('came') has a long vowel /kaːm/.
        // Two consonants are not doubled: k, which is replaced by ck
        // (until the spelling reform of 1996, however, ck was divided across a line break as k-k),
        //and z, which is replaced by tz.
        //In loanwords, kk (which may correspond with cc in the original spelling) and zz can occur.
        //Consonants are sometimes doubled in writing to indicate the preceding vowel is to be
        // pronounced as a short vowel.
        Rule("a$vowelShorteningConsonantPairs", A.short, 1),
        Rule("ä$vowelShorteningConsonantPairs", Ä.short, 1),
        Rule("e$vowelShorteningConsonantPairs", E.short, 1),
        Rule("i$vowelShorteningConsonantPairs", I.short, 1),
        Rule("o$vowelShorteningConsonantPairs", O.short, 1),
        Rule("ö$vowelShorteningConsonantPairs", Ö.short, 1),
        Rule("u$vowelShorteningConsonantPairs", U.short, 1),
        Rule("ü$vowelShorteningConsonantPairs", Ü_Y.short, 1),
        Rule("y$vowelShorteningConsonantPairs", Ü_Y.short, 1),

        Rule("ä", "Ä"),
        Rule("ö", "Ö"),

        //For different consonants and for sounds represented by more than one letter (ch and sch)
        // after a vowel, no clear rule can be given, because they can appear after long vowels,
        // yet are not redoubled if belonging to the same stem, e.g.
        // Mond /moːnt/ 'moon', Hand /hant/ 'hand'.
        LookbackRule(" ", "mond( |$)", "moːnt", 4),
        LookbackRule("( |^)", "hand( |$)", "hant", 4),
        //On a stem boundary, reduplication usually takes place, e.g., nimm-t 'takes';
        // however in fixed, no longer productive derivatives this too can be lost,
        // e.g., Geschäft /ɡəˈʃɛft/ 'business' despite schaffen 'to get something done'.

        //ß indicates that the preceding vowel is long, e.g. Straße 'street' vs. Masse 'amount'.
        //In addition to that,
        // texts written before the 1996 spelling reform also use ß at the ends of words and before
        //consonants, e.g. naß 'wet' and mußte 'had to' (after the reform spelled nass and musste),
        //so vowel length in these positions could not be detected by the ß,
        // cf. Maß 'measure' and fußte 'was based' (after the reform still spelled Maß and fußte).

        //A vowel usually represents a long sound if the vowel in question occurs:
        //=======================================================================
        //as the final letter (except for e)
        Rule("a($| )", A.long, 1),
        Rule("ä($| )", Ä.long, 1),
        Rule("i($| )", I.long, 1),
        Rule("o($| )", O.long, 1),
        Rule("ö($| )", Ö.long, 1),
        Rule("u($| )", U.long, 1),
        Rule("ü($| )", Ü_Y.long, 1),

        //e at the end of a word is pronounced as a schwa
        Rule("e($| )", "ə", 1),

        //    followed by a single consonant as in bot "offered"
        //    before a single consonant followed by a vowel as in Wagen "car"
        Rule("a[$consonants]{1}($| |[$vowels])", A.long, 1),
        Rule("ä[$consonants]{1}($| |[$vowels])", Ä.long, 1),
        Rule("e[$consonants]{1}($| |[$vowels])", E.long, 1),
        Rule("i[$consonants]{1}($| |[$vowels])", I.long, 1),
        Rule("o[$consonants]{1}($| |[$vowels])", O.long, 1),
        Rule("ö[$consonants]{1}($| |[$vowels])", Ö.long, 1),
        Rule("u[$consonants]{1}($| |[$vowels])", U.long, 1),
        Rule("ü[$consonants]{1}($| |[$vowels])", Ü_Y.long, 1),

        //A silent h indicates a long vowel in certain cases.
        //That h derives from an old /x/ in some words, for instance sehen ('to see') zehn ('ten'),
        // but in other words it has no etymological justification,
        //for instance gehen ('to go') or mahlen ('to mill').
        //Occasionally a digraph can be redundantly followed by h, either due to analogy,
        // such as sieht ('sees', from sehen) or etymology, such as Vieh ('cattle', MHG vihe),
        //rauh ('rough', pre-1996 spelling, now written rau, MHG ruh).
        CapturingRule(Regex("([$vowels])h"),
            {soFar, groups -> soFar+Vowels.from(groups[1]!!.value).long}, 2),

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
        Rule("or", "ɔː"),
        */

        //CONSONANTS
        //==========

        LookbackRule("sch", "w", "f"),
        Rule("w", "v"),
        Rule("r[$vowels]", "ʁ", 1),
        Rule("r($| )", "ɐ", 1),

        //b: at end of syllable: [p]; otherwise: [b] or [b̥]
        Rule("b(^| )", "p", 1),
        //ch: after a, o, and u: [x];
        // after other vowels or consonants or initially: [ç] or [k]
        // (word-initially in Southern Germany);
        //chs: [ks] within a morpheme (e.g. Dachs [daks] "badger"); [çs] or [xs] across a morpheme boundary (e.g.
        // Dachs [daxs] "roof (genitive)")
        Rule("chs", "ks"),
        LookbackRule("i", "ch", "ç"),
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
        //g: when part of word-final -ig: [ç] or [k] (Southern German);
        // at the end of a syllable: [k]; otherwise: [ɡ] or [ɡ̊]
        Rule("ig( |$)", "ɪç"),
        //h: before a vowel: [h]; when lengthening a vowel: silent
        Rule("h[$vowels]", "h", 1),
        //j: [j] in most words; [ʒ] in loanwords from French (as in jardin, French for garden)
        Rule("j", "j"),
        //ng: usually: [ŋ];
        // in compound words where the first element ends in "n" and the second element begins with
        // "g" (-n·g-): [nɡ] or [nɡ̊]
        Rule("ng", "ŋ"),
        //nk: [ŋk]
        Rule("nk", "ŋk"),
        //pf: [pf] in all cases with some speakers;
        Rule("pf", "pf"),
        //with other speakers [f] at the beginning of words
        // (or at the beginning of compound words' elements)
        // and [pf] in all other cases

        //qu: [kv] or [kw] (in a few regions)
        Rule("qu", "kf"),//it's actually going to be devoiced

        //r: the pronunciation of r varies regionally:
        //[ʁ] before vowels, [ɐ] otherwise; or
        Rule("r[$vowels]", "ʁ", 1),
        Rule("r", "ɐ", 1),
        //[ɐ] after long vowels (except [aː]), [ʁ] otherwise;[17] or
        //[r] or [ɾ] before vowels, [ɐ] otherwise (Austro-Bavarian); or
        //[r] in all cases (Swiss Standard German)

        //s: before and between vowels: [z] or [z̥]; before consonants or when final: [s];
        // before p or t at the beginning of a word or syllable: [ʃ]
        LookbackRule("(^| |[^s])", "s[pt][$vowels]", "ʃ", 1),
        Rule("s[ptk]", "s", 1),
        Rule("s($| )", "s", 1),
        LookbackRule("[$vowels]?", "s[$vowels]", "z", 1),

        //the suffix -chen is always [ç].
        // In Austro-Bavarian, especially in Austria, [ç] may always be substituted by [x].
        Rule("chen", "ç", 2),
        //sch: [ʃ]; however, [sç] when part of the -chen diminutive of a word ending on "s",
        // (e.g. Mäuschen "little mouse")
        Rule("sch", "ʃ"),

        //ss, ß: [s]
        Rule("(ss|ß)", "s"),
        //th: [t]
        Rule("th", "t"),
        //ti: in -tion, -tiär, -tial, -tiell: [tsɪ̯]; otherwise: [ti]
        Rule("ti(on|är|al|ell)", "tsɪ̯", 2),
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

    /**Converts umlaut vowels in all their possible representations into
     *  the same integrated characters used in all Rules.
     *
     *  Umlauts in German don't function as accents; they mark entirely different letters.
     *  Therefore, we normalise to treating (a / ä, o / ö, u / ü) as separate letters.*/
    private fun String.normaliseUmlauts():String {
        return if(contains("ä") || contains("ö") || contains("ü") ) {
            this
        }else {
            this
                .replace("ä", "ä")//a-then-umlaut
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