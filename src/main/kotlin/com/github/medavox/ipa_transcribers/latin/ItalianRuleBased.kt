package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**Italian has something called Syntactic gemination, which is a grammar-dependent doubling of a consonant.
 * Therefore, this transcriber cannot achieve perfect results with an only regular expression-based approach.
 * But it can achieve a good enough approximation for our needs.*/
object ItalianRuleBased: RuleBasedTranscriber() {
    val frontVowels = "ie"
    val nonFrontVowels = "aou"
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS
    val rules = listOf<Rule>(
        //c & g rules
        Rule("ch[$frontVowels]", "k", 2),
        Rule("cc[$frontVowels]", "ttʃ", 2),
        Rule("ci[$nonFrontVowels]", "tʃ", 2),
        Rule("c[$frontVowels]", "tʃ", 1),
        Rule("c", "k", 1),
        Rule("q", "k", 1),

        Rule("gh[$frontVowels]", "g", 2),
        Rule("gi[$nonFrontVowels]", "dʒ", 2),
        Rule("g[$frontVowels]", "dʒ", 1),
        //Rule("g", "g"), <g> = /g/ is handled by the latin base rules

        // /sk/ and /ʃ/
        //Before ⟨i e⟩ 	sch 	scherno /ˈskerno/ 	sc 	scerno /ˈʃɛrno/
        //Elsewhere 	sc 	scalo /ˈskalo/ 	sci 	scialo /ˈʃalo/
        Rule("sch[$frontVowels]", "sk", 3),
        Rule("sci[$frontVowels]", "ʃ", 2),
        Rule("sc[$frontVowels]", "ʃ", 2),
        Rule("sc", "sk", 2),

        //liquids
        Rule("r", "r"),//trilled r
        Rule("gl", "ʎ"),// figli, glielo, maglia[3]

        //nasals. quite a few of these rules are the same as in spanish; maybe they could share a definition?
        //Nasals always assimilate their place of articulation to that of the following consonant.
        Rule("gn", "ɲ"),
        Rule("n[fv]", "ɱ", 1),//the nasal in /nf/ or /nv/ is the labiodental [ɱ].
        Rule("[nm][pbm]", "m", 1),// A nasal before /p/, /b/ and /m/ is always the labial [m].
        //fixme: check the /ng/ rule thoroughly
        Rule("n(q|gh[ie]|ch[ie]|c|g)", "ŋ", 1),//The n in /nɡ/~/nk/ is a velar [ŋ]: unghia, anche, dunque[5]

        //h is always silent, or forms part of a digraph
        Rule("ph", "f"),
        Rule("h", "")
        //S and Z

        //⟨s⟩ and ⟨z⟩ are ambiguous to voicing.
        //
        //⟨s⟩ represents a dental sibilant consonant, either /s/ or /z/. However, these two phonemes are in complementary distribution everywhere except between two vowels in the same word and, even with such words, there are very few minimal pairs.
        //
        //    The voiceless /s/ occurs:
        //        At the start of a word before a vowel (e.g. Sara /ˈsara/) or a voiceless consonant (e.g. spuntare /spunˈtare/)
        //        After any consonant (e.g. transitare /transiˈtare/)
        //        Before a voiceless consonant (e.g. raspa /ˈraspa/)
        //        At the start of the second part of a compound word (e.g. affittasi, disotto, girasole, prosegue, risaputo, unisono, preservare, riservare, reggiseno). These words are formed by adding a prefix to a word beginning with /s/
        //    The voiced /z/ occurs before voiced consonants (e.g. sbranare /zbraˈnare/).
        //    It can be either voiceless or voiced (/s/ or /z/) between vowels; in standard Tuscany-based pronunciation some words are pronounced with /s/ between vowels (e.g. casa, cosa, così, mese, naso, peso, cinese, piemontese, goloso); in Northern Italy (and also increasingly in Tuscany) ⟨s⟩ between vowels is always pronounced with /z/ (with some exceptions[example needed]) whereas in Southern Italy ⟨s⟩ between vowels is always pronounced /s/.
        //
        //⟨ss⟩ always represents voiceless /ss/: grosso /ˈɡrɔsso/, successo /sutˈtʃɛsso/, passato /pasˈsato/, etc.


        //⟨z⟩ represents a dental affricate consonant; either /dz/ (zanzara /dzanˈdzara/) or /ts/ (nazione /natˈtsjone/), depending on context, though there are few minimal pairs.

        //It is normally voiceless /ts/:
        //    At the start of a word in which the second syllable starts with a voiceless consonant
        //        (zampa /ˈtsampa/, zoccolo /ˈtsɔkkolo/, zufolo /ˈtsufolo/)
        //        Exceptions (because they are of Greek origin): zaffiro, zefiro, zotico, zeta, zafferano, Zacinto
        //    When followed by an ⟨i⟩ which is followed, in turn, by another vowel (e.g. zio /ˈtsio/, agenzia /adʒenˈtsia/, grazie /ˈɡrattsje/)
        //        Exceptions: azienda /adˈdzjɛnda/, all words derived from words obeying other rules (e.g. romanziere /romanˈdzjɛre/, which is derived from romanzo)
        //    After the letter ⟨l⟩ (e.g. alzare /alˈtsare/)
        //        Exceptions: elzeviro /eldzeˈviro/ and Belzebù /beldzeˈbu/
        //    In the suffixes -anza, -enza and -onzolo (e.g. usanza /uˈzantsa/, credenza /kreˈdɛntsa/, ballonzolo /balˈlontsolo/)

        //It is voiced /dz/:
        //    At the start of a word in which the second syllable starts with a voiced consonant or ⟨z⟩ (or ⟨zz⟩) itself
        //        (e.g. zebra /ˈdzɛbra/, zuzzurellone /dzuddzurelˈlone/)
        //        Exceptions: zanna /ˈtsanna/, zigano /tsiˈɡano/
        //    At the start of a word when followed by two vowels (e.g. zaino /ˈdzaino/)
        //        Exceptions: zio and its derived terms (see above)
        //    If it is single (not doubled) and between two single vowels (e.g. azalea /addzaˈlɛa/)
        //        Exceptions: nazismo /natˈtsizmo/ (from the German pronunciation of ⟨z⟩)

        //⟨zz⟩ is generally voiceless /tts/: pazzo /ˈpattso/, ragazzo /raˈɡattso/, pizza /ˈpittsa/, grandezza /ɡranˈdettsa/, etc.
        // (exceptions: razzo /ˈraddzo/, mezzo /ˈmɛddzo/, azzardo /addzarˈdo/, azzurro /adˈdzurro/, brezza /ˈbreddza/).
        // A major exception is the verbal ending -izzare (from Greek -ίζειν),
        // in which it is always pronounced /ddz/ (e.g. organizzare /ɔrɡanidˈdzare/),
        // and derived words (e.g. analizzo /anaˈliddzo/, a derivative of analizzare).

        //In addition to representing the respective vowels /i/ and /u/,
        // ⟨i⟩ and ⟨u⟩ also typically represent the semivowels /j/ and /w/, respectively,
        // when unstressed and occurring before another vowel.
        // Many exceptions exist (e.g. attuale, deciduo, deviare, dioscuro, fatuo, iato, inebriare, ingenuo, liana, proficuo, riarso, viaggio).
        // Unstressed ⟨i⟩ may represent that a preceding or following ⟨c⟩ or ⟨g⟩ is 'soft' (dolce).

        //j 	ieri, saio, più, Jesi, yacht, news 	you
        //w 	uova, guado, qui, week-end 	wine

        //A, a 	a [ˈa] 	/a/ 	à
        //E, e 	e [ˈe] 	/e/ or /ɛ/ 	è, é
        //I, i 	i [ˈi] 	/i/ or /j/ 	ì, í, [î]
        //O, o 	o [ˈɔ] 	/o/ or /ɔ/ 	ò, ó

        //U, u 	u [ˈu] 	/u/ or /w/ 	ù, ú

        // If consonants are doubled after a vowel, they are geminated: all consonants may be geminated except for /z/.
        // In IPA, gemination is represented by doubling the consonant (fatto [ˈfatto], mezzo [ˈmɛddzo])
        // or by using the length marker ⟨ː⟩.
        // There is also the sandhi of syntactic gemination: va via [ˌva vˈviːa]).

        //[3] /dz/, /ts/, /ʎ/, /ɲ/ and /ʃ/ are always geminated after a vowel.

        //In Tuscany [h], [ɸ], [θ], [ʃ] and [ʒ] are the common allophones of vowel-following single /k/, /p/, /t/, /tʃ/ and /dʒ/.

        //Non-geminate /r/ is generally realised with a single strike, as a monovibrant trill or tap [ɾ],
        // particularly in unstressed syllables.

        ///θ/ is usually pronounced as [t] in English loanwords,
        // and [dz], [ts] (if spelled ⟨z⟩) or [s] (if spelled ⟨c⟩ or ⟨z⟩) in Spanish ones.

        //In Spanish loanwords, /x/ is usually pronounced as [h], [k] or dropped.
        // In German, Arabic and Russian ones, it is usually pronounced [k].

        //Italian contrasts seven monophthongs in stressed syllables.
        // Open-mid vowels /ɛ, ɔ/ can appear only if the syllable is stressed (coperto [koˈpɛrto], quota [ˈkwɔːta]),
        // close-mid vowels /e, o/ are found elsewhere (Boccaccio [bokˈkattʃo], amore [aˈmoːre]).
        // Close and open vowels /i, u, a/ are unchanged in unstressed syllables,
        // but word-final unstressed /i/ may become approximant [j] before vowels,
        // which is known as synalepha (pari età [ˌparj eˈta]).

        //Open-mid [œ] or close-mid [ø] if it is stressed but usually [ø] if it is unstressed.
        // May be replaced by [ɛ] (stressed) or [e] (stressed or unstressed).

        // /y/ is often pronounced as [u] or [ju].

        //Since Italian has no distinction between heavier or lighter vowels
        // (like the English o in conclusion vs o in nomination),
        // a defined secondary stress, even in long words, is extremely rare.

        //Stressed vowels are long in non-final open syllables: fato [ˈfaːto] ~ fatto [ˈfatto].
    ) + latinBaseRules.filter { with(it.unconsumedMatcher) {
            //the letters j, k, w, x and y aren't used in native italian words
            // the latin base rules already don't include j and x
            this != Regex("k") &&
            this != Regex("w") &&
            this != Regex("y")
        } }
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, reportAndSkip)
    }
}