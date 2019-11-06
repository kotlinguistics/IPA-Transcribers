package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.*

/**Spanish spelling is largely considered phonetic.
 * I'm not sure how true that is in practice
 * (with all the varying dialects), but it does mean that there aren't many IPA transcription
 * engines for spanish out there.
 *
 * So I'll try to write my own.
 *
 * Pronunciation information sourced from:-
 * * [Oxford Dictionary Spanish Pronunciation Guide](https://es.oxforddictionaries.com/grammar/spanish-pronunciation)]
 * * [Wikipedia's IPA for Spanish](https://en.wikipedia.org/wiki/Help:IPA/Spanish)
 * * [Wikipedia:Spanish Orthography](https://en.wikipedia.org/wiki/Spanish_orthography)
 * * [Wikipedia phonology of spanish](https://en.wikipedia.org/wiki/Spanish_language#Phonology)
 * */
object SpanishPanAmerican: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.COMPLETE
    //the 'transcripcon' problem - does the voicedness of n bleed over onto s AND c?
    //todo: account for voicing assimilation
    /**
     METHODOLOGY
    ============

    all "before" and "after" rules can be encoded here as digraphs,
    even if this produces a lot of rules (eg, before a voiced consonant).

    It's still simpler than creating an entire IPA-structure in code,
    to look back at the voicedness of the last (or next) letter.

    Digraphs require less code, but more rules.

    We do however need to be able to distinguish Spanish syllable boundaries,
    for two reasons:

    1. Some rules are encoded as syllable-final or syllable-initial.
     We need to know what part of the current syllable we're at.

    2. Barring words that have specific accent-markers, Spanish word stress has rules along the lines of falling
    on the final or penultimate syllable.
    We need to know which syllable of the word we're on, so we know which one to mark for stress in the IPA.

    (having looked at the rules for syllabification in Spanish, we don't need the Spanish sonority hierarchy.)

    -------


⟨sh⟩
     Not considered to be a Spanish digraph (hence words like *sherpa, show,
     flash* are considered *extranjerismos crudos*), but used in proper names
     from other languages, some of them being accentuated in the Spanish
     manner (names from Native American languages or from languages using
     non-Latin writing systems)
     [ʃ]
     or [tʃ]
     (sometimes [s])
     Ánca**sh**; **Sh**anghái; **sh**iitake,
      ***sh**ah*,
     Wa**sh**ington
     */

    /*//CAN'T TRANSCRIBE THESE IRREGULAR RULES:
⟨x⟩     in some words borrowed from Nahuatl, mostly place names, and in some
        Spanish proper names conserving archaic spelling
        [x] or [h]
        Mé**x**ico*; Oa**x**aca*; **x**iote; Te**x**as; La A**x**arquía; **X**imena; **X**iménez; Me**x**ía

        in some words from indigenous American languages, mostly place names
        [ʃ] or [tʃ] (sometimes [s])
           **X**ela; **x**ocoyote

⟨tl⟩
     rare; mostly in loanwords from Nahuatl
     [tl]
     or [tɬ]
      ***tl**apalería*; * cenzon**tl**e*; * Popocatépe**tl***

⟨w⟩
     rare; in loanwords from English
     [w]
      **w**aterpolo
      **w**hen (sometimes turns to /gw/ or /bw/)
     rare; in loanwords from German and in Visigothic names
     [b]
      **w**olframio; **W**amba
*/
    //NOTE:rule order matters!
    internal val voicedConsonants = "([bdglmnñvwy]|hu|hi)"
    internal val rules:List<IRule> = listOf(
        //⟨ñ⟩ = [ɲ] (ñandú; cabaña)
        Rule(Regex("ñ"), "ɲ"),

        //⟨hu⟩ before a vowel = [w]
        //      **hu**eso; **hu**evo
        Rule(Regex("hu[aeio]"), "w", 2),
        //⟨hi⟩ before a vowel = [j] or [ʝ]
        //      **hi**erba; **hi**elo
        Rule(Regex("hi[aeio]"), "ʝ", 2),
        //⟨h⟩ everywhere = silent (hoy; hacer; prohibir; huevo; hielo)
        //(huevo /′ weβo/, almohada /almo′aða/)
        //     in loanwords and foreign proper names = [x] or [h]
        //      (hámster, hawaiano, hachís, yihad, harakiri, Yokohama)
        Rule(Regex("h"), ""),

        //⟨b⟩ or ⟨v⟩ word-initial after a pause, or after ⟨m⟩ or ⟨n⟩ = [b] (bestia; embuste; vaca; envidia)
        //⟨n⟩  i**n**vierno = [m]
        //(barco/′barko/, vaca/′baka/, ambos /′ambos/, en vano /em′bano/)
        Rule(Regex("[nm][bv]"), "mb"),
        LookbackRule(Regex("^$"), Regex("[bv]"), "b"),
        //⟨b⟩ or ⟨v⟩ elsewhere (i.e. after a vowel, even across a word boundary,
        // or after any consonant other than ⟨m⟩ or ⟨n⟩) = [β]
        //(rabo /′rraβo/, ave /′aβe/, árbol /′arβol/, Elvira /el′βira/)
        Rule(Regex("[bv]"), "β"),

        //⟨n⟩  ci_n_co = [ŋ]
        Rule(Regex("(nk|nc)"), "ŋ", 1),
        //⟨n⟩  co_n_fite = [ɱ]
        Rule(Regex("nf"), "ɱ", 1),
        //⟨n⟩  e_n_yesar = [ɲ]
        Rule(Regex("ny"), "ɲʝ"),
        //⟨n⟩ si**n*** everywhere but before other consonants = [n]
        //      _n_ido; a_n_illo; a_n_helo
        //     mu**n**do = [n]
        //(verbatim transcription needs no rule)

        //⟨ch⟩ = [tʃ] or [ʃ] (depending upon the dialect) (ocho; chícharo)
        //(chico /′tʃiko/, leche /′letʃe/).
        Rule(Regex("ch"), "tʃ"),

        //⟨tx⟩ (rare; from loanwords) = [tʃ] (pin_tx_o)
        Rule(Regex("tx"), "tʃ"),

        //⟨c⟩ before ⟨e⟩ or ⟨i⟩ = [θ] (central and northern Spain) or [s] (most other regions)
        // (cero /′sero/, /′θero/; cinco /′siŋko/, /′θiŋko/).
        //      **c**ereal; en**c**ima
        Rule(Regex("c[ie]"), "s", 1),
        //2.  C is pronounced /k/ when followed by a consonant other than h or by a, o or u
        //     elsewhere = [k]
        //      **c**asa; **c**laro; * va**c**a*; * es**c**udo*
        //     before voiced consonants = [ɣ]
        //     ané**c**dota
        Rule(Regex("c$voicedConsonants"), "ɣ", 1),
        Rule(Regex("c"), "k"),

        //15.  Z is pronounced /s/ in Latin America and parts of southern Spain and /θ/ in the rest of Spain.
        //⟨z⟩ = [θ] (central and northern Spain) or [s] (most other regions)
        //     before voiced consonants = [ð] (central and northern Spain) or [z] (most other regions)
        Rule(Regex("z$voicedConsonants"), "z", 1),
        Rule(Regex("z"), "s"),

        //⟨qu⟩ only occurs before ⟨e⟩ or ⟨i⟩ = [k] (quema /′kema/, quiso /′kiso/)
        Rule(Regex("que"), "ke"),
        Rule(Regex("qui"), "ki"),

        //⟨d⟩ word-initial after a pause, or after ⟨l⟩ or ⟨n⟩ = [d]
        //(digo /′diƔo/, anda /′anda/, el dueño /el′dweɲo/)
        //     dá_d_iva; ar_d_er; a_d_mirar; mi _d_e_d_o; ver_d_a_d_
        LookbackRule(Regex("^$"), Regex("d"), "d"),
        Rule(Regex("ld"), "ld"),
        Rule(Regex("nd"), "nd"),
        //todo: match this rule across word boundaries
        //⟨d⟩  elsewhere = [ð] (hada /′aða/, arde /′arðe/, los dados /loz′ðaðos/)
        Rule(Regex("d"), "ð"),
        //⟨d⟩ is often not pronounced at all at the end of a word
        // (libertad /liβer′ta(ð)/, Madrid /ma′ðri(ð)/)
        //maybe implement this rule?

        //⟨j⟩ everywhere = [x] or [h]  (jamón; eje; reloj) (jamón /xa′mon/, jefe /′xefe/)
        Rule(Regex("j"), "x"),

        //⟨gu⟩ before ⟨a⟩ or ⟨o⟩, and either word-initial after a pause, or after ⟨n⟩; but only in some dialects
        //      = [ɡw]
        //      ***gu**ante*; * len**gu**a*
        LookbackRule(Regex("^$"), Regex("gu[ao]"), "gw", 2),
        LookbackRule(Regex("^$"), Regex("ngu[ao]"), "ŋgw", 3),
        //⟨gu⟩ before ⟨a⟩ or ⟨o⟩, and not in the above contexts = [ɣw]
        //     a**gu**a; averi**gu**ar
        Rule(Regex("gu[ao]"), "ɣw", 2),
        //⟨gu⟩ before ⟨e⟩ or ⟨i⟩, and either word-initial after a pause, or after ⟨n⟩ = [ɡ]
        //      ***gu**erra*
        LookbackRule(Regex("^$"), Regex("gu[ie]"), "g", 2),
        //⟨gu⟩ before ⟨e⟩ or ⟨i⟩, and not in the above contexts = [ɣ]
        //     si**gu**e
        Rule(Regex("gu[ie]"), "ɣ", 2),

        //⟨g⟩ before ⟨e⟩ or ⟨i⟩ = [x] or [h]
        //(gitano /xi′tano/, auge /′awxe/).
        Rule(Regex("g[ie]"), "x", 1),
        //⟨g⟩ not before ⟨e⟩ or ⟨i⟩, and either word-initial after a pause, or after ⟨n⟩ = [ɡ]
        //      ***g**ato*; ***g**rande*; * ven**g**o*
        Rule(Regex("ng[^ie]"), "ŋg", 2),
        LookbackRule(Regex("^$"), Regex("g[^ie]"), "g", 1),
        //⟨g⟩  not before ⟨e⟩ or ⟨i⟩, and not in the above contexts = [ɣ]
        //     tri**g**o; amar**g**o*; si**g**no*; mi **g**ato
        //(hago /′aƔo/, trague /′traƔe/, alga /′alƔa/, águila /′aƔila/).
        Rule(Regex("g"), "Ɣ"),
        // unless it is written with a diaeresis
        //⟨gü⟩ before ⟨e⟩ or ⟨i⟩, and either word-initial after a pause, or after ⟨n⟩; but only in some dialects
        //    = [ɡw]
        //      **gü**ero, pin**gü**ino
        //(paragüero /para′Ɣwero/, agüita /a′Ɣwita/).
        //     before ⟨e⟩ or ⟨i⟩, and not in the above contexts = [ɣw]
        //      averi**gü**e
        //fixme:because we work on the chopped string, it's ALWAYS at the beginning
        LookbackRule(Regex("^$"), Regex("güi"), "gwi"),
        Rule(Regex("güi"), "Ɣwi"),
        LookbackRule(Regex("^$"), Regex("güe"), "gwe"),
        Rule(Regex("güe"), "Ɣwe"),

        //⟨rr⟩ only occurs between vowels = [r]
        //(the letter /r/ represents the trilled r in IPA)
        //      * ca**rr**o*
        Rule(Regex("rr"), "r"),

        //13.  X is pronounced /ks/, although there is a marked tendency to render it as /s/ before consonants,
        //especially in less careful speech (extra /′ekstra/, /′estra/, or in some dialects /′ehtra/, see 11 above).
        //In some words derived from Nahuatl and other Indian languages it is pronounced /x/ (México /′mexiko/)
        //and in others it is pronounced /s/ (Xochlmllco /sotʃi′milko/).
        //⟨x⟩  before a consonant = [ks] or [s]
        //     e**x**tremo
        Rule(Regex("x"), "ks"),
        //⟨x⟩ between vowels and word-finally = [ks]
        //      * e**x**acto*; * ta**x**i*; * rela**x***
        Rule(Regex("x$"), "ks"),

        LookbackRule("[aeiou]", "x[aeiou]", "ks", 1),//FIXED? broken rule. Look-backs are prohibited!
        //⟨x⟩  word-initially = [s]
        //      ***x**enofobia*
        LookbackRule(Regex("^$"), Regex("x"), "s"),

        //7. The pronunciation of ll varies greatly throughout the Spanish-speaking world.

        //(a) LL is pronounced rather like the y in English yes by the majority of speakers,
        //who do not distinguish between the pronunciation of ll and that of y
        //(e.g. between haya and halla).
        //The sound is pronounced slightly more emphatically when at the beginning of an utterance.

        //(b) In some areas, particularly Bolivia, parts of Peru and Castile in Spain,
        //the distinction between ll and y has been preserved.
        //In these areas ll is pronounced with the tongue against the palate,
        //the air escaping through narrow channels on either side.
        //(The nearest sound in English would be that of lli in million).

        //(c) In the River Plate area ll is pronounced /Ʒ/ (as in English measure),
        //with some speakers using a sound which tends toward /ʃ / (as in shop).

        //When phonetic transcriptions of Spanish headwords containing ll are given in the dictionary,
        //the symbol /J/ is used to represent the range of pronunciations described above.
        //⟨ll⟩ everywhere = [ʎ], [ʝ] or [dʒ] (depending upon the dialect)
        //      ***ll**ave*; * po**ll**o*
        Rule(Regex("ll"), "ʎ|ʝ"),

        //⟨t⟩ everywhere = [t]
        //    before voiced consonants = [ð]
        Rule(Regex("t$voicedConsonants"), "ð", 1),

        //    11.  S is pronounced /s/ but it is aspirated in many dialects of Spanish
        //    when it occurs in syllable-final position (hasta /′ahta/, los cuatro /loh′kwatro/).
        //    In other dialects it is voiced when followed by a voiced consonant (mismo/′mIzmo/, los dos /loz′ðos/).
        //⟨s⟩ before a voiced consonant (e.g. ⟨l⟩, ⟨m⟩, ⟨d⟩) = [z]
        //     i**s**la; mi**s**mo; de**s**de; de**s**huesar
        //    everywhere else = [s]
        //      **s**aco; ca**s**a; de**s**hora; e**s**pita
        //     same as the typical English ⟨s⟩; ***s**a**ss***; in central and northern
        //     Spain, Paisa region of Colombia, and Andes, this
        //     sound is made with the tip of the tongue rather than the blade, with a
        //     sound quality intermediate between the alveolar [s]
        //     of English **s**ea and the palato-alveolar [ʃ]
        //     of ***s**he*
        Rule(Regex("s$voicedConsonants"), "z", 1),

        //⟨tz⟩ rare; from loanwords = [ts]
        //      * que**tz**al*; * Pá**tz**cuaro*
        Rule(Regex("tz"), "ts"),

        //⟨m⟩  word-final = [n] or [ŋ] (depending upon the dialect)
        //      * álbu**m***
        Rule(Regex("m$"), "n"),
        //⟨m⟩ everywhere except word-finally = [m]
        //      **m**adre; co**m**er; ca**m**po
        //(no rule is necessary to transcribe letters verbatim)

        //⟨y⟩ as a semivowel (almost always in a diphthong) = [i] or [j]
        //     ha**y**, so**y**
        //14.  Y (a) When followed by a vowel within the same syllable y is pronounced rather like the y in English yes
        //    (slightly more emphatically when at the beginning of an utterance).
        //    In the River Plate area it is pronounced /Ʒ/ (as in English measure),
        //    with some speakers using a sound which tends toward /ʃ/ (as in shop).
        //    When phonetic transcriptions of Spanish headwords containing y are given in the dictionary,
        //    the symbol /J/ is used to represent both pronunciations described above.
        //    (b) As the conjunction y and in syllable-final position, y is pronounced /i/.
        //⟨y⟩  as a consonant = [j], [ʝ], or [dʒ]
        //      **y**a; **y**elmo; a**y**uno
        Rule(Regex("y[^aeiou]"), "i", 1),
        Rule(Regex("y$"), "i"),
        Rule(Regex("y"), "ʝ"),

        // --------- Vowels -------------------

        //Spanish has both strong vowels (a, e, o) and weak vowels (i, u).
        //Here are some rules on how the combinations of these vowels are divided into syllables.

        //Two weak vowels together form a diphthong and are not separated into different syllables.

        //A weak vowel and a strong vowel together form a diphthong and are not separated into different syllables.
        ///wa/ 	cuadro 	picture
        ///we/ 	fuego 	fire
        ///wi/[62] 	buitre 	vulture
        ///wo/ 	cuota 	quota
        Rule(Regex("u[aeio]"), "w", 1),
        ///ja/ 	hacia 	towards
        ///je/ 	tierra 	earth
        ///ju/ 	viuda 	widow
        ///jo/ 	radio 	radio
        Rule(Regex("i[aeou]"), "j", 1),

        //Two strong vowels together form a hiatus and are separated into different syllables. Example: Leo

        //Falling
        ///ai/ 	aire 	air
        ///au/ 	pausa 	pause
        ///ei/ 	rey 	king
        Rule(Regex("ey"), "ei"),
        ///eu/ 	neutro 	neutral
        ///oi/ 	hoy 	today
        Rule(Regex("oy"), "oi")
        ///ou/[61] 	bou 	seine fishing
    )

    /**Maps the first character of digraphs to all the possible rules it could represent,
     * if it forms a digraph with the next character.
     *  Digraphs are orthographical combos, usually two letters, that together represent one sound.
     *  Eg in English: th sh ch.
     *  */
    override fun transcribe(nativeText: String):String {
        return nativeText.toLowerCase().normaliseAccents().removeStressAccents().processWithRules(rules, reportAndCopy)
        //return nativeText.toLowerCase().normaliseAccents().removeStressAccents().greedy(rules, reportAndCopy)
    }

    /**Removes the stress accents from vowels,
     * which aren't needed for our IPA orthography-to-sound transcription,
     * and in fact get in the way ("o" != "ó")*/
    //todo:the acute accent in spanish does two things, mark irregular stress and split up diphthongs
    fun String.removeStressAccents():String {
        return this
            .replace("á", "a")
            .replace("é", "e")
            .replace("í", "i")
            .replace("ó", "o")
            .replace("ú", "u")
    }

    /**Makes consistent the representation of spanish accented letters.
     * That is, replaces letters with combined diacritic marks with single-character equivalents.*/
    fun String.normaliseAccents():String {
        return this
            .replace(Regex("(ñ|̃n)"), "ñ")
            .replace(Regex("(á|́a)"), "á")
            .replace(Regex("(é|́e)"), "é")
            .replace(Regex("(í|́i)"), "í")
            .replace(Regex("(ó|́o)"), "ó")
            .replace(Regex("(ú|́u)"), "ú")
    }
}
