package com.github.medavox.ipa_transcribers

import com.github.medavox.AnalysableString
import java.lang.StringBuilder

/**Spanish spelling is largely considered phonetic.
 * I'm not sure how true that is practice
 * (with all the varying dialects), but it does mean that there aren't many IPA transcription
 * engines for spanish out there.
 *
 * So I'll try to write my own.*/
class SpanishIpaRuleBased: IpaTranscriber {
    //the 'transcripcon' problem - does the voicedness of n bleed over onto s AND c?
    //todo: account for voicing assimilation
    /**Maps >=1 characters to 1 IPA character. It's a string because diacritics count as extra characters.

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
    on the final or pentultimate syllable.
    We need to know which syllable of the word we're on, so we know which one to mark for stress in the IPA.

    (having looked at the rules for syllabifiication in Spanish, we don't need the Spanish sonority hierarchy.)

    -------

    7.  LL The pronunciation of ll varies greatly throughout the Spanish-speaking world.

    (a) It is pronounced rather like the y in English yes by the majority of speakers,
    who do not distinguish between the pronunciation of ll and that of y
    (e.g. between haya and halla).
    The sound is pronounced slightly more emphatically when at the beginning of an utterance.

    (b) In some areas, particularly Bolivia, parts of Peru and Castile in Spain,
    the distinction between ll and y has been preserved.
    In these areas ll is pronounced with the tongue against the palate,
    the air escaping through narrow channels on either side.
    (The nearest sound in English would be that of lli in million).

    (c) In the River Plate area ll is pronounced /Ʒ/ (as in English measure),
    with some speakers using a sound which tends toward /ʃ / (as in shop).

    When phonetic transcriptions of Spanish headwords containing ll are given in the dictionary,
    the symbol /J/ is used to represent the range of pronunciations described above.

    10.  R is pronounced /r/ when it occurs between vowels or in syllable-final position (aro /′aro/, horma /′orma/, barco /′barko/, cantar /kan′tar/).
    It is pronounced /rr/ when in initial position (rama /′rrama/, romper /rrom′per/).


    11.  S is pronounced /s/ but it is aspirated in many dialects of Spanish
    when it occurs in syllable-final position (hasta /′ahta/, los cuatro /loh′kwatro/).
    In other dialects it is voiced when followed by a voiced consonant (mismo/′mIzmo/, los dos /loz′ðos/).

    13.  X is pronounced /ks/, although there is a marked tendency to render it as /s/ before consonants,
    especially in less careful speech (extra /′ekstra/, /′estra/, or in some dialects /′ehtra/, see 11 above).

    In some words derived from Nahuatl and other Indian languages it is pronounced /x/ (México /′mexiko/)
    and in others it is pronounced /s/ (Xochlmllco /sotʃi′milko/).

    14.  Y (a) When followed by a vowel within the same syllable y is pronounced rather like the y in English yes
    (slightly more emphatically when at the beginning of an utterance).
    In the River Plate area it is pronounced /Ʒ/ (as in English measure),
    with some speakers using a sound which tends toward /ʃ/ (as in shop).

    When phonetic transcriptions of Spanish headwords containing y are given in the dictionary,
    the symbol /J/ is used to represent both pronunciations described above.
    (b) As the conjunction y and in syllable-final position, y is pronounced /i/.


     */

    /**Maps the first character of digraphs to all the possible rules it could represent,
     * if it forms a digraph with the next character.
     *  Digraphs are orthographical combos, usually two letters, that together represent one sound.
     *  Eg in English: th sh ch.
     *  */
    val digraphs:Map<Char, Map<String, String>> = mapOf()
    override fun transcribeToIpa(nativeText: String): Set<Variant> {
        val american = StringBuilder().append('/')
        val european = StringBuilder().append('/')
        val word = AnalysableString(nativeText.toLowerCase(), 0)

        //NOTE:rule order matters!
        data class RuleOutput(val outputString:String, val lettersConsumed:Int=1)
        data class Rule(val matcher:Regex, val replacement: () -> RuleOutput )
        val rules:Array<Rule> = arrayOf(
            //8. Ñ is always pronounced /ŋ/
            Rule(Regex("ñ")) {RuleOutput("ɲ")},
            //5.  H is mute in Spanish, (huevo /′ weβo/, almohada /almo′aða/)
            Rule(Regex("h")) {RuleOutput("")},
            Rule(Regex("(mb|mv|nb|nv)")) {RuleOutput("mb", 2)},
            Rule(Regex("^(b|v)")) {RuleOutput("b")},
            //1.  B,V The letters b and v are pronounced in exactly the same way:
            //    /b/ when at the beginning of an utterance or after m or n (barco/′barko/, vaca/′baka/, ambos /′ambos/, en vano /em′bano/)
            // and /β/ in all other contexts (rabo /′rraβo/, ave /′aβe/, árbol /′arβol/, Elvira /el′βira/).

            Rule(Regex("(b|v)")) {RuleOutput("β")},
            Rule(Regex("(ng|nk)")) {RuleOutput("ŋ")},

            //the combination 'ch' is pronounced /tʃ/ (chico /′tʃiko/, leche /′letʃe/).
            Rule(Regex("ch")) {RuleOutput("tʃ", 2)},
            // When c is followed by e or i,
            // it is pronounced /s/ in Latin America and parts of southern Spain and /θ/ in the rest of Spain
            // (cero /′sero/, /′θero/; cinco /′siŋko/, /′θiŋko/).
            Rule(Regex("c(i|e)")) {RuleOutput("θ|s")},
            //2.  C is pronounced /k/ when followed by a consonant other than h or by a, o or u
            Rule(Regex("c")) {RuleOutput("k")},

            //15.  Z is pronounced /s/ in Latin America and parts of southern Spain and /θ/ in the rest of Spain.
            Rule(Regex("z")) {RuleOutput("θ|s")},

            //9.  Q is always followed by ue or ui.
            // It is pronounced /K/, and the u is silent (quema /′kema/, quiso /′kiso/).
            Rule(Regex("que")) {RuleOutput("ke", 3)},
            Rule(Regex("qui")) {RuleOutput("ki", 3)},

            //3.  D is pronounced /d/ when it occurs at the beginning of an utterance
            //or after n or l (digo /′diƔo/, anda /′anda/, el dueño /el′dweɲo/)
            //and /ð/ in all other contexts (hada /′aða/, arde /′arðe/, los dados /loz′ðaðos/).
            //It is often not pronounced at all at the end of a word (libertad /liβer′ta(ð)/,
            //Madrid /ma′ðri(ð)/).
            Rule(Regex("^d")) {RuleOutput("d")},
            //todo: match this rule across word boundaries
            Rule(Regex("ld")) {RuleOutput("ld", 2)},
            Rule(Regex("nd")) {RuleOutput("nd", 2)},
            Rule(Regex("d")) {RuleOutput("ð")},

            //6.  J is always pronounced /x/ (jamón /xa′mon/, jefe /′xefe/).
            Rule(Regex("j")) {RuleOutput("x")},

            //4.  G is pronounced /x/ when followed by e or i (gitano /xi′tano/, auge /′awxe/).
            Rule(Regex("g[ie]")) {RuleOutput("x")},
            // Note that the u is not pronounced in the combinations gue and gui,
            Rule(Regex("(^|n)gui")) {RuleOutput("gi", 3)},
            Rule(Regex("(^|n)gue")) {RuleOutput("ge", 3)},
            // When followed by a, o, u, ue or ui it is pronounced /g/ if at the beginning of an utterance or after n
            // (gato /′gato/, gula/′gula/, tango /′taŋgo/, guiso /′giso/)
            Rule(Regex("(^|n)g[aou]")) {RuleOutput("g")},
            // and /Ɣ/ in all other contexts (hago /′aƔo/, trague /′traƔe/, alga /′alƔa/, águila /′aƔila/).
            Rule(Regex("g")) {RuleOutput("Ɣ")},
            // unless it is written with a diaeresis (paragüero /para′Ɣwero/, agüita /a′Ɣwita/).
            Rule(Regex("güi")) {RuleOutput("Ɣwi", 3)},
            Rule(Regex("güe")) {RuleOutput("Ɣwe", 3)},

            //The double consonant rr is always pronounced /rr/.
            //the letter /r/ represents the trilled r in IPA
            Rule(Regex("rr")) {RuleOutput("r", 2)},

        )

        var processingWord = nativeText
        loop@ while(processingWord.isNotEmpty()) {
            for (i in 0 until rules.size) {
                if(rules[i].matcher.matches(processingWord)) {
                    val result = rules[i].replacement()
                    if(result.outputString.contains("|")) {
                        //there's a difference in pronunciation between european and american spanish
                        //european on the left, american on the right of the pipe
                        val variants = result.outputString.split("|")
                        european.append(variants[0])
                        american.append(variants[1])
                    }
                    else{//otherwise, they're the same
                        american.append(result.outputString)
                        european.append(result.outputString)
                    }

                    processingWord = processingWord.substring(result.lettersConsumed)
                    continue@loop
                }
                //no rule matched; the spanish orthography matches the IPA.
                //just copy it to the output
                american.append(processingWord[0])
                european.append(processingWord[0])
                processingWord = processingWord.substring(1)
            }
        }

        american.append('/')
        european.append('/')
    return setOf(
        Variant("American", american.toString()),
        Variant("Peninsular", european.toString())    )
    }
}
