package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object ItalianRuleBased: RuleBasedTranscriber() {
    val frontVowels = "ie"
    val nonFrontVowels = "aou"
    override val completionStatus: CompletionStatus = CompletionStatus.UNSTARTED
    val rules = listOf<Rule>(
        //c & g rules
        Rule("ch[$frontVowels]", "k", 2),
        Rule("cc[$frontVowels]", "ttʃ", 2),
        Rule("ci[$nonFrontVowels]", "tʃ", 2),
        Rule("c[$frontVowels]", "tʃ", 1),
        Rule("c", "k", 1),
        Rule("gh[$frontVowels]", "g", 2),
        Rule("gi[$nonFrontVowels]", "dʒ", 2),
        Rule("g[$frontVowels]", "dʒ", 1),
        Rule("g", "g", 1),

        // /sk/ and /ʃ/
        //Before ⟨i e⟩ 	sch 	scherno /ˈskerno/ 	sc 	scerno /ˈʃɛrno/
        //Elsewhere 	sc 	scalo /ˈskalo/ 	sci 	scialo /ˈʃalo/
        Rule("sch[$frontVowels]", "sk", 3),
        Rule("sci[$frontVowels]", "ʃ", 2),
        Rule("sc[$frontVowels]", "ʃ", 2),
        Rule("sc", "sk", 2),


        //S and Z
        //
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
        //
        //    It is normally voiceless /ts/:
        //        At the start of a word in which the second syllable starts with a voiceless consonant (zampa /ˈtsampa/, zoccolo /ˈtsɔkkolo/, zufolo /ˈtsufolo/)
        //            Exceptions (because they are of Greek origin): zaffiro, zefiro, zotico, zeta, zafferano, Zacinto
        //        When followed by an ⟨i⟩ which is followed, in turn, by another vowel (e.g. zio /ˈtsio/, agenzia /adʒenˈtsia/, grazie /ˈɡrattsje/)
        //            Exceptions: azienda /adˈdzjɛnda/, all words derived from words obeying other rules (e.g. romanziere /romanˈdzjɛre/, which is derived from romanzo)
        //        After the letter ⟨l⟩ (e.g. alzare /alˈtsare/)
        //            Exceptions: elzeviro /eldzeˈviro/ and Belzebù /beldzeˈbu/
        //        In the suffixes -anza, -enza and -onzolo (e.g. usanza /uˈzantsa/, credenza /kreˈdɛntsa/, ballonzolo /balˈlontsolo/)
        //    It is voiced /dz/:
        //        At the start of a word in which the second syllable starts with a voiced consonant or ⟨z⟩ (or ⟨zz⟩) itself (e.g. zebra /ˈdzɛbra/, zuzzurellone /dzuddzurelˈlone/)
        //            Exceptions: zanna /ˈtsanna/, zigano /tsiˈɡano/
        //        At the start of a word when followed by two vowels (e.g. zaino /ˈdzaino/)
        //            Exceptions: zio and its derived terms (see above)
        //        If it is single (not doubled) and between two single vowels (e.g. azalea /addzaˈlɛa/)
        //            Exceptions: nazismo /natˈtsizmo/ (from the German pronunciation of ⟨z⟩)

    //⟨zz⟩ is generally voiceless /tts/: pazzo /ˈpattso/, ragazzo /raˈɡattso/, pizza /ˈpittsa/, grandezza /ɡranˈdettsa/, etc. (exceptions: razzo /ˈraddzo/, mezzo /ˈmɛddzo/, azzardo /addzarˈdo/, azzurro /adˈdzurro/, brezza /ˈbreddza/). A major exception is the verbal ending -izzare (from Greek -ίζειν), in which it is always pronounced /ddz/ (e.g. organizzare /ɔrɡanidˈdzare/), and derived words (e.g. analizzo /anaˈliddzo/, a derivative of analizzare).

    //In addition to representing the respective vowels /i/ and /u/,
        // ⟨i⟩ and ⟨u⟩ also typically represent the semivowels /j/ and /w/, respectively,
        // when unstressed and occurring before another vowel.
        // Many exceptions exist (e.g. attuale, deciduo, deviare, dioscuro, fatuo, iato, inebriare, ingenuo, liana, proficuo, riarso, viaggio).
        // Unstressed ⟨i⟩ may represent that a preceding or following ⟨c⟩ or ⟨g⟩ is 'soft' (dolce).

        //dz 	z
        //dʒ 	gelo, giù, magia, judo, gadget[4] 	job
        //ɡ 	gatto, agro, glifo, ghetto 	again
        //j 	ieri, saio, più, Jesi, yacht, news 	you
        //k 	cosa, acuto, finché, quei, kiwi[4] 	scar
        //l 	lato, tela 	ladder
        //ʎ 	figli, glielo, maglia[3] 	billion
        //m 	mano, amare, input[5] 	mother
        //ɱ 	anfibio, invece[5] 	comfort
        //n 	nano, punto, pensare[5] 	nest
        //ŋ 	unghia, anche, dunque[5] 	sing
        //ɲ 	gnocco, ogni[3] 	canyon
        //p 	primo, ampio, apertura[4] 	spin
        //r 	Roma, quattro, morte[6] 	trilled r
        //s 	sano, scusa, presentire, pasto 	sorry
        //ʃ 	scena, scià, pesci, flash, chic[3][4] 	shoe
        //t 	tranne, mito, altro, thai[4] 	star
        //ts 	zio, sozzo, marzo[2][3] 	cats
        //tʃ 	certo, ciao, farmacia, chip[4] 	check
        //v 	vado, povero, watt 	vent
        //w 	uova, guado, qui, week-end 	wine
        //z 	sbirro, presentare, asma 	zipper
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