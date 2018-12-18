package com.github.medavox.ipa_transcribers

import java.lang.StringBuilder

/**Spanish spelling is largely considered phonetic.
 * I'm not sure how true that is practice
 * (with all the varying dialects), but it does mean that there aren't many IPA transcription
 * engines for spanish out there.
 *
 * So I'll try to write my own.
 *
 * Pronunciation Information sourced from:-
 * * [Oxford Dictionary Spanish Pronunciation Guide](https://es.oxforddictionaries.com/grammar/spanish-pronunciation)]
 * * [Wikipedia's IPA for Spanish](https://en.wikipedia.org/wiki/Help:IPA/Spanish)
 * * [Wikipedia:Spanish Orthography](https://en.wikipedia.org/wiki/Spanish_orthography)
 * */
class SpanishIpaRuleBased: IpaTranscriber {
    //the 'transcripcon' problem - does the voicedness of n bleed over onto s AND c?
    //todo: account for voicing assimilation
    /**
     METHODOLOGY
    ============

    all "before" and "after" rules cn be encoded here as digraphs,
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

    10.  R is pronounced /r/ when it occurs between vowels or in syllable-final position
    (aro /′aro/, horma /′orma/, barco /′barko/, cantar /kan′tar/).
    It is pronounced /rr/ when in initial position (rama /′rrama/, romper /rrom′per/).


    11.  S is pronounced /s/ but it is aspirated in many dialects of Spanish
    when it occurs in syllable-final position (hasta /′ahta/, los cuatro /loh′kwatro/).
    In other dialects it is voiced when followed by a voiced consonant (mismo/′mIzmo/, los dos /loz′ðos/).

    14.  Y (a) When followed by a vowel within the same syllable y is pronounced rather like the y in English yes
    (slightly more emphatically when at the beginning of an utterance).
    In the River Plate area it is pronounced /Ʒ/ (as in English measure),
    with some speakers using a sound which tends toward /ʃ/ (as in shop).

    When phonetic transcriptions of Spanish headwords containing y are given in the dictionary,
    the symbol /J/ is used to represent both pronunciations described above.
    (b) As the conjunction y and in syllable-final position, y is pronounced /i/.

     Consonants
     =========

      **b** or **v**
     --------

     word-initial after a pause, or after ⟨m⟩ or ⟨n⟩
     \[b\]
      **b**estia; em**b**uste; **v**aca; en**v**idia

     elsewhere (i.e. after a vowel, even across a word boundary, or after any consonant other than ⟨m⟩ or ⟨n⟩) | \[β\] | be**b**é; o**b**tuso; vi**v**ir; cur**v**a; mi **b**e**b**é; mi **v**aca


⟨c⟩
     before ⟨e⟩ or ⟨i⟩
     \[θ\]
     (central and northern Spain) or
     \[s\]
     (most other regions)
      **c**ereal; en**c**ima

     elsewhere
     \[k\]
      **c**asa; **c**laro; * va**c**a*; * es**c**udo*

     before voiced consonants
     \[ɣ\]
     ané**c**dota


⟨ch⟩
     everywhere^[\[16\]](#cite_note-16)^
     \[tʃ\]
     or \[ʃ\]
     (depending upon the dialect)
     o**ch**o*; **ch**í**ch**aro*

⟨d⟩
     word-initial after a pause, or after ⟨l⟩ or ⟨n⟩
     \[d\]
      ***d**edo*; * cuan**d**o*; * al**d**aba*

     elsewhere
     \[ð\]
     dá**d**iva*; ar**d**er*; a**d**mirar*; mi* **d**e**d**o; ver**d**a**d**

⟨g⟩
     before ⟨e⟩ or ⟨i⟩
     \[x\]
     or \[h\]
      ***g**eneral*
     not before ⟨e⟩ or ⟨i⟩, and either word-initial after a pause, or after
     ⟨n⟩
     \[ɡ\]
      ***g**ato*; ***g**rande*; * ven**g**o*

     not before ⟨e⟩ or ⟨i⟩, and not in the above contexts
     \[ɣ\]
     tri**g**o; amar**g**o*; si**g**no*; mi **g**ato


⟨gu⟩
     before ⟨a⟩ or ⟨o⟩, and either word-initial after a pause, or after ⟨n⟩; but only in some dialects
     \[ɡw\]
      ***gu**ante*; * len**gu**a*

     before ⟨a⟩ or ⟨o⟩, and not in the above contexts
     \[ɣw\]
     a**gu**a; averi**gu**ar

     before ⟨e⟩ or ⟨i⟩, and either word-initial after a pause, or after ⟨n⟩
     \[ɡ\]
      ***gu**erra*

     before ⟨e⟩ or ⟨i⟩, and not in the above contexts
     \[ɣ\]
     si**gu**e

⟨gü⟩
     before ⟨e⟩ or ⟨i⟩, and either word-initial after a pause, or after ⟨n⟩; but only in some dialects
     \[ɡw\]

      ***gü**ero*,
      * pin**gü**ino*

     before ⟨e⟩ or ⟨i⟩, and not in the above contexts
     \[ɣw\]
      * averi**gü**e

⟨h⟩
     everywhere
     (*silent*)
      **h**oy; **h**acer; pro**h**ibir; **h**uevo; **h**ielo

     everywhere; occurs in loanwords and foreign proper names
     \[x\]
     or \[h\]
      **h**ámster, **h**awaiano, **h**achís, yi**h**ad, **h**arakiri, Yoko**h**ama


⟨hi⟩
     before a vowel
     \[j\]
     or \[ʝ\]
      ***hi**erba*; ***hi**elo*

⟨hu⟩
     before a vowel
     \[w\]
      **hu**eso; **hu**evo

⟨j⟩
     everywhere
     \[x\]
     or \[h\]
      **j**amón; e**j**e; relo**j**

⟨k⟩
     rare; only occurs in a few loanwords
     \[k\]
      ***k**ilo*,
      ***k**arate*

⟨l⟩
     everywhere
     \[l\]
      **l**ino; a**l**haja; principa**l**

⟨ll⟩
     everywhere
     \[ʎ\],
     \[ʝ\]
     or \[dʒ\](depending
     upon the dialect)
      ***ll**ave*; * po**ll**o*

⟨m⟩
     everywhere except word-finally
     \[m\]
      **m**adre; co**m**er; ca**m**po

     word-final
     \[n\]
     or \[ŋ\]
     (depending upon the dialect)
      * álbu**m***

⟨n⟩
     si**n***
     everywhere but before other consonants
     \[n\]
      ***n**ido*; * a**n**illo*; * a**n**helo*

     before other consonants
     \[m\]\
     \[ɱ\]\
     \[n\]\
     \[ɲ\]\
     \[ŋ\]\
      * i**n**vierno*\
      * co**n**fite*\
      * mu**n**do*\
      * e**n**yesar*\
      * ci**n**co*

⟨ñ⟩
     everywhere
     \[ɲ\]
      **ñ**andú; caba**ñ**a

⟨qu⟩
     only occurs before ⟨e⟩ or ⟨i⟩
     \[k\]
      ***qu**ise*

⟨r⟩
     word-initial, morpheme-initial,^[\[21\]](#cite_note-21)^\
     or after ⟨l⟩, ⟨n⟩, or ⟨s⟩, or syllable-final (especially before ⟨l⟩,
     ⟨m⟩, ⟨n⟩, or ⟨s⟩) and word-final positions (before pause or
     consonant-initial words only)
     \[r\]
      ***r**umbo*; * hon**r**a*; * Is**r**ael*; * sub**r**ayar*; invie**r**no; pe**r**sona; ve**r**de; * ca**r**ta*; amo**r** puro

     elsewhere (sometimes word-initial (after a pause or consonant-ending
     words only), morpheme-initial (when preceded by prefixes ending in
     consonants), or after ⟨l⟩, ⟨n⟩, or ⟨s⟩, or syllable-final positions, and
     word-final positions before vowel-initial words only)
     \[ɾ\]
     ca**r**o; cab**r**a; b**r**avo; **r**umbo; hon**r**a; Is**r**ael; sub**r**ayar; invie**r**no; pe**r**sona; ve**r**de; ca**r**ta; amo**r** puro; amo**r** eterno

⟨rr⟩
     only occurs between vowels
     \[r\]
      * ca**rr**o*
     trilled or rolled ⟨r⟩

⟨s⟩
     before a voiced consonant (e.g. ⟨l⟩, ⟨m⟩, ⟨d⟩)
     \[z\]
     i**s**la; mi**s**mo; de**s**de; de**s**huesar

     everywhere else
     \[s\]
      **s**aco; ca**s**a; de**s**hora; e**s**pita
     same as the typical English ⟨s⟩; ***s**a**ss***; in central and northern
     Spain, Paisa region of Colombia, and Andes, this
     sound is made with the tip of the tongue rather than the blade, with a
     sound quality intermediate between the alveolar \[s\]
     of English ***s**ea* and the palato-alveolar \[ʃ\]
     of ***s**he*

⟨sh⟩
     Not considered to be a Spanish digraph (hence words like *sherpa, show,
     flash* are considered *extranjerismos crudos*), but used in proper names
     from other languages, some of them being accentuated in the Spanish
     manner (names from Native American languages or from languages using
     non-Latin writing systems)
     \[ʃ\]
     or \[tʃ\]
     (sometimes \[s\])
     Ánca**sh**; **Sh**anghái; **sh**iitake,
      ***sh**ah*,
     Wa**sh**ington

⟨t⟩
     everywhere
     \[t\]
      ***t**amiz*; * á**t**omo*

     before voiced consonants
     \[ð\]
      * a**t**mósfera*

⟨tl⟩
     rare; mostly in loanwords from Nahuatl
     \[tl\]
     or \[tɬ\]
      ***tl**apalería*; * cenzon**tl**e*; * Popocatépe**tl***

⟨tx⟩
     rare; from loanwords
     \[tʃ\]
      * pin**tx**o*

⟨tz⟩
     rare; from loanwords
     \[ts\]
      * que**tz**al*; * Pá**tz**cuaro*

⟨w⟩
     rare; in loanwords from English
     \[w\]
      ***w**aterpolo*
      **w**hen (sometimes turns to /gw/ or /bw/)
     rare; in loanwords from German and in Visigothic names
     \[b\]
      ***w**olframio*; ***W**amba*

⟨x⟩
     between vowels and word-finally
     \[ks\]
      * e**x**acto*; * ta**x**i*; * rela**x***

     word-initially
     \[s\]
      ***x**enofobia*

     before a consonant
     \[ks\]
     or \[s\]
     e**x**tremo

     in some words borrowed from Nahuatl, mostly place names, and in some
     Spanish proper names conserving archaic spelling
     \[x\]
     or \[h\]
     Mé**x**ico*; Oa**x**aca*; **x**iote; Te**x**as; La A**x**arquía; **X**imena; **X**iménez; Me**x**ía

     in some words from indigenous American languages, mostly place names
     \[ʃ\]
     or \[tʃ\]
     (sometimes \[s\])
      **X**ela; **x**ocoyote

⟨y⟩
     as a semivowel (almost always in a
     diphthong)
     \[i\]
     or \[j\]
     ha**y**,
     so**y**

     as a consonant
     \[j\],
     \[ʝ\],
     or \[dʒ\]
      **y**a; **y**elmo; a**y**uno

⟨z⟩
     usually does not occur before ⟨e⟩ or ⟨i⟩
     \[θ\]
     (central and northern Spain) or\
     \[s\]
     (most other regions)
      ***z**orro*; * pa**z***; * ca**z**a*

     before voiced consonants
     \[ð\]
     (central and northern Spain) or \[z\]
     (most other regions)^[\[15\]](#cite_note-seseo-15)^
      * ja**z**mín*,
      * ju**z**gado*,
     A**z**nar
     */

    /**Maps the first character of digraphs to all the possible rules it could represent,
     * if it forms a digraph with the next character.
     *  Digraphs are orthographical combos, usually two letters, that together represent one sound.
     *  Eg in English: th sh ch.
     *  */
    override fun transcribeToIpa(input: String): Set<Variant> {
        val american = StringBuilder().append('/')
        val european = StringBuilder().append('/')

        //NOTE:rule order matters!
        data class Rule(val matcher:Regex, val outputString:String, val lettersConsumed:Int=1 )
        val rules:Array<Rule> = arrayOf(
            //8. Ñ is always pronounced /ŋ/
            Rule(Regex("ñ"), "ɲ"),
            //5.  H is mute in Spanish, (huevo /′ weβo/, almohada /almo′aða/)
            Rule(Regex("h"), ""),
            Rule(Regex("(mb|mv|nb|nv)"), "mb", 2),
            Rule(Regex("^[bv]"), "b"),
            //1.  B,V The letters b and v are pronounced in exactly the same way:
            //    /b/ when at the beginning of an utterance or after m or n (barco/′barko/, vaca/′baka/, ambos /′ambos/, en vano /em′bano/)
            // and /β/ in all other contexts (rabo /′rraβo/, ave /′aβe/, árbol /′arβol/, Elvira /el′βira/).

            Rule(Regex("[bv]"), "β"),
            Rule(Regex("ng"), "ŋg", 2),
            Rule(Regex("(nk|nc)"), "ŋ"),

            //the combination 'ch' is pronounced /tʃ/ (chico /′tʃiko/, leche /′letʃe/).
            Rule(Regex("ch"), "tʃ", 2),
            // When c is followed by e or i,
            // it is pronounced /s/ in Latin America and parts of southern Spain and /θ/ in the rest of Spain
            // (cero /′sero/, /′θero/; cinco /′siŋko/, /′θiŋko/).
            Rule(Regex("c[ie]"), "θ|s"),
            //2.  C is pronounced /k/ when followed by a consonant other than h or by a, o or u
            Rule(Regex("c"), "k"),

            //15.  Z is pronounced /s/ in Latin America and parts of southern Spain and /θ/ in the rest of Spain.
            Rule(Regex("z"), "θ|s"),

            //9.  Q is always followed by ue or ui.
            // It is pronounced /K/, and the u is silent (quema /′kema/, quiso /′kiso/).
            Rule(Regex("que"), "ke", 3),
            Rule(Regex("qui"), "ki", 3),

            //3.  D is pronounced /d/ when it occurs at the beginning of an utterance
            //or after n or l (digo /′diƔo/, anda /′anda/, el dueño /el′dweɲo/)
            //and /ð/ in all other contexts (hada /′aða/, arde /′arðe/, los dados /loz′ðaðos/).
            //It is often not pronounced at all at the end of a word (libertad /liβer′ta(ð)/,
            //Madrid /ma′ðri(ð)/).
            Rule(Regex("^d"), "d"),
            //todo: match this rule across word boundaries
            Rule(Regex("ld"), "ld", 2),
            Rule(Regex("nd"), "nd", 2),
            Rule(Regex("d"), "ð"),

            //6.  J is always pronounced /x/ (jamón /xa′mon/, jefe /′xefe/).
            Rule(Regex("j"), "x"),

            //4.  G is pronounced /x/ when followed by e or i (gitano /xi′tano/, auge /′awxe/).
            Rule(Regex("g[ie]"), "x"),
            // Note that the u is not pronounced in the combinations gue and gui,
            // When followed by a, o, u, ue or ui it is pronounced /g/ if at the beginning of an utterance or after n
            // (gato /′gato/, gula/′gula/, tango /′taŋgo/, guiso /′giso/)
            Rule(Regex("^gui"), "gi", 3),
            Rule(Regex("^gue"), "ge", 3),
            Rule(Regex("^g[aou]"), "g"),
            // and /Ɣ/ in all other contexts (hago /′aƔo/, trague /′traƔe/, alga /′alƔa/, águila /′aƔila/).
            Rule(Regex("g"), "Ɣ"),
            // unless it is written with a diaeresis (paragüero /para′Ɣwero/, agüita /a′Ɣwita/).
            Rule(Regex("güi"), "Ɣwi", 3),
            Rule(Regex("güe"), "Ɣwe", 3),

            //The double consonant rr is always pronounced /rr/.
            //the letter /r/ represents the trilled r in IPA
            Rule(Regex("rr"), "r", 2),

            //13.  X is pronounced /ks/, although there is a marked tendency to render it as /s/ before consonants,
            //especially in less careful speech (extra /′ekstra/, /′estra/, or in some dialects /′ehtra/, see 11 above).
            //In some words derived from Nahuatl and other Indian languages it is pronounced /x/ (México /′mexiko/)
            //and in others it is pronounced /s/ (Xochlmllco /sotʃi′milko/).
            Rule(Regex("x"), "ks"),

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
            Rule(Regex("ll"), "ʎ|ʝ", 2),


            //Spanish has both strong vowels (a, e, o) and weak vowels (i, u).
            //Here are some rules on how the combinations of these vowels are divided into syllables.

            //Two weak vowels together form a diphthong and are not separated into different syllables.
            ///wa/ 	cuadro 	picture
            ///we/ 	fuego 	fire
            ///wi/[62] 	buitre 	vulture
            ///wo/ 	cuota 	quota
            Rule(Regex("u[aeio]"), "w"),
            ///ja/ 	hacia 	towards
            ///je/ 	tierra 	earth
            ///ju/ 	viuda 	widow
            ///jo/ 	radio 	radio
            Rule(Regex("i[aeou]"), "j"),

            //A weak vowel and a strong vowel together form a diphthong and are not separated into different syllables.
            //Two strong vowels together form a hiatus and are separated into different syllables. Example: Leo

            //Falling
            ///ai/ 	aire 	air
            ///au/ 	pausa 	pause
            ///ei/ 	rey 	king
            Rule(Regex("ey"), "ei", 2),
            ///eu/ 	neutro 	neutral
            ///oi/ 	hoy 	today
            Rule(Regex("oy"), "oi", 2)
            ///ou/[61] 	bou 	seine fishing


//syllables:
        //we either need to be able to produce
        //1. the number of syllables in a word, the number of the current syllable we're in,
        //and the position in the current syllable (onset, nucleus, coda). Or
        //2. A list of ranges, that correspond to the start and end of each syllable,
        //and something to tell whether a letter is eg syllable-final or not
        )
        var processingWord = input.normalise()
        loop@ while(processingWord.isNotEmpty()) {
            for (i in 0 until rules.size) {
                //if the rule matches the start of the remaining string
                if(rules[i].matcher.find(processingWord)?.range?.start == 0) {
                    //System.out.println("rule '${rules[i]}' matches '$processingWord'")
                    if(rules[i].outputString.contains("|")) {
                        //there's a difference in pronunciation between european and american spanish
                        //european on the left, american on the right of the pipe
                        val variants = rules[i].outputString.split("|")
                        european.append(variants[0])
                        american.append(variants[1])
                    }
                    else{//otherwise, they're the same
                        american.append(rules[i].outputString)
                        european.append(rules[i].outputString)
                    }

                    processingWord = processingWord.substring(rules[i].lettersConsumed)
                    continue@loop
                }
            }
            //no rule matched; the spanish orthography matches the IPA.
            //just copy it to the output
            american.append(processingWord[0])
            european.append(processingWord[0])
            processingWord = processingWord.substring(1)
        }

        american.append('/')
        european.append('/')
    return setOf(
        Variant("American", american.toString()),
        Variant("Peninsular", european.toString())    )
    }

    /**Makes consistent the representation of spanish accented letters.
     * That is, replaces letters with combined diacritic marks with single-character equivalents.*/
    private fun String.normalise():String {
        return this
        .toLowerCase()
            .replace(Regex("(ñ|̃n)"), "ñ")
            .replace(Regex("(á|́a)"), "á")
            .replace(Regex("(é|́e)"), "é")
            .replace(Regex("(í|́i)"), "í")
            .replace(Regex("(ó|́o)"), "ó")
            .replace(Regex("(ú|́u)"), "ú")
    }
}
