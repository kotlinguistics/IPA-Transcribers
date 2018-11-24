package com.github.medavox.ipa_transcribers

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

/**Spanish spelling is largely considered phonetic.
 * I'm not sure how true that is practice
 * (with all the varying dialects), but it does mean that there aren't many IPA transcription
 * engines for spanish out there.
 *
 * So I'll try to write my own.*/
class SpanishIpaRuleBased: IpaTranscriber {
    /**Maps >=1 characters to 1 IPA character. It's a string because diacritics count as extra characters
     *

    3.  D is pronounced /d/ when it occurs at the beginning of an utterance or after n or l (digo /′diƔo/, anda /′anda/, el dueño /el′dweɲo/) and /ð/ in all other contexts (hada /′aða/, arde /′arðe/, los dados /loz′ðaðos/). It is often not pronounced at all at the end of a word (libertad /liβer′ta(ð)/, Madrid /ma′ðri(ð)/).

    6.  J is always pronounced /x/ (jamón /xa′mon/, jefe /′xefe/).

    7.  LL The pronunciation of ll varies greatly throughout the Spanish-speaking world.

    (a) It is pronounced rather like the y in English yes by the majority of speakers, who do not distinguish between the pronunciation of ll and that of y (e.g. between haya and halla). The sound is pronounced slightly more emphatically when at the beginning of an utterance.

    (b) In some areas, particularly Bolivia, parts of Peru and Castile in Spain, the distinction between ll and y has been preserved. In these areas ll is pronounced with the tongue against the palate, the air escaping through narrow channels on either side. (The nearest sound in English would be that of lli in million).

    (c) In the River Plate area ll is pronounced /Ʒ/ (as in English measure), with some speakers using a sound which tends toward /ʃ / (as in shop).

    When phonetic transcriptions of Spanish headwords containing ll are given in the dictionary, the symbol /J/ is used to represent the range of pronunciations described above.

    9.  Q is always followed by ue or ui. It is pronounced /K/, and the u is silent (quema /′kema/, quiso /′kiso/).

    10.  R is pronounced /r/ when it occurs between vowels or in syllable-final position (aro /′aro/, horma /′orma/, barco /′barko/, cantar /kan′tar/). It is pronounced /rr/ when in initial position (rama /′rrama/, romper /rrom′per/). The double consonant rr is always pronounced /rr/.

    11.  S is pronounced /s/ but it is aspirated in many dialects of Spanish when it occurs in syllable-final position (hasta /′ahta/, los cuatro /loh′kwatro/). In other dialects it is voiced when followed by a voiced consonant (mismo/′mIzmo/, los dos /loz′ðos/).

    12.  V see 1 above .

    13.  X is pronounced /ks/, although there is a marked tendency to render it as /s/ before consonants, especially in less careful speech (extra /′ekstra/, /′estra/, or in some dialects /′ehtra/, see 11 above).

    In some words derived from Nahuatl and other Indian languages it is pronounced /x/ (México /′mexiko/) and in others it is pronounced /s/ (Xochlmllco /sotʃi′milko/).

    14.  Y (a) When followed by a vowel within the same syllable y is pronounced rather like the y in English yes (slightly more emphatically when at the beginning of an utterance). In the River Plate area it is pronounced /Ʒ/ (as in English measure), with some speakers using a sound which tends toward /ʃ/ (as in shop).

    When phonetic transcriptions of Spanish headwords containing y are given in the dictionary, the symbol /J/ is used to represent both pronunciations described above. (b) As the conjunction y and in syllable-final position, y is pronounced /i/.

    15.  Z is pronounced /s/ in Latin America and parts of southern Spain and /θ/ in the rest of Spain.*/

    /**Maps the first character of digraphs to all the possible rules it could represent,
     * if it forms a digraph with the next character.
     *  Digraphs are orthographical combos, usually two letters, that together represent one sound.
     *  Eg in English: th sh ch*/
    val digraphs:Map<Char, Map<String, String>> = mapOf()
    override fun transcribeToIpa(nativeText: String): Set<Variant> {
        val output = StringBuilder().append('/')
        val word = nativeText.toLowerCase()
        var i:Int = 0
        while(i < word.length) {
            //System.out.println("i:$i")
            val next:String = when(word[i]) {
                //8. Ñ is always pronounced /ŋ/
                'ñ' -> "ɲ"

                //5.  H is mute in Spanish, (huevo /′ weβo/, almohada /almo′aða/) except in the combination ch, which is pronounced /tʃ/ (chico /′tʃiko/, leche /′letʃe/).
                'h' -> ""

                //1.  B,V The letters b and v are pronounced in exactly the same way:
                //    /b/ when at the beginning of an utterance or after m or n (barco/′barko/, vaca/′baka/, ambos /′ambos/, en vano /em′bano/)
                // and /β/ in all other contexts (rabo /′rraβo/, ave /′aβe/, árbol /′arβol/, Elvira /el′βira/).
                'b', 'v' -> {
                    if(i==0 || word[i-1] == 'm' || word[i-1] == 'n'){
                        "b"
                    }else {
                        "β"
                    }
                }

                'n' -> {
                    //make n into m before b/v
                    if(i < (word.length-1) && word[i+1] == 'c' ) {
                        i++
                        "ŋk"

                    }
                    else if(i < (word.length-1) && word[i+1] == 'b' || word[i+1] == 'v' ) {
                        "m"
                    }else {
                        "n"
                    }
                }

                //2.  C is pronounced /k/ when followed by a consonant other than h or by a, o or u
                // (acto/′akto/, casa/′kasa/, coma /′koma/, cupo /′kupo/).

                // When it is followed by e or i,
                // it is pronounced /s/ in Latin America and parts of southern Spain and /θ/ in the rest of Spain
                // (cero /′sero/, /′θero/; cinco /′siŋko/, /′θiŋko/).
                'c' -> {
                    if(i < (word.length-1) && word[i+1] == 'i' || word[i+1] == 'e') {
                        "s"
                    }else if(i < (word.length-1) && word[i+1] == 'h') {//digraph
                        i++
                        "tʃ"
                    }
                    else {
                        "k"
                    }
                }

                //4.  G is pronounced /x/ when followed by e or i (gitano /xi′tano/, auge /′awxe/).
                // When followed by a, o, u, ue or ui it is pronounced /g/ if at the beginning of an utterance or after n
                // (gato /′gato/, gula/′gula/, tango /′taŋgo/, guiso /′giso/)
                // and /Ɣ/ in all other contexts (hago /′aƔo/, trague /′traƔe/, alga /′alƔa/, águila /′aƔila/).
                //
                // Note that the u is not pronounced in the combinations gue and gui,
                // unless it is written with a diaeresis (paragüero /para′Ɣwero/, agüita /a′Ɣwita/).
                'g' -> {
                    if(i < word.length-1 && word[i+1] == 'e' || word[i+1] == 'i') {
                        "x"
                    }else if(i < word.length-1 ) {
                        
                    }

                }

                //there are no special rules for this native-orthography-letter; it is literally spelled as pronounced.
                //just copy it to the output
                else -> word[i].toString()
            }
            output.append(next)
            i++
        }
        return setOf(Variant("", output.append('/').toString()))
    }
}