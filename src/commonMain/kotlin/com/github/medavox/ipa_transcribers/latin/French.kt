package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.*

import com.github.medavox.ipa_transcribers.latin.LatinScriptCommonalities.latinBaseRules

object French:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS
    private val silencableConsonants = "sxztdnpg"
    private val vowels = "aâeêiîoôuûéèëàï"
    private val consonants = "bdfghklmnpqstvz"
    //French pronunciation follows strict rules based on spelling, but French spelling is often based more on history than phonology. The rules for pronunciation vary between dialects, but the standard rules are:

    //The final letters f, k, q, and l, however, are normally pronounced.
    //The final c is sometimes pronounced like in bac, sac, roc, avec
    //but can also be silent like in blanc or estomac.
    //The final r is usually silent when it follows an e in a word of two or more syllables,
    //but it is pronounced in some words (hiver, super, cancer etc.).

    //When the following word begins with a vowel, however,
    //a silent consonant may once again be pronounced,
    //to provide a liaison or "link" between the two words.
    //Some liaisons are mandatory, for example the s in les amants or vous avez;
    //some are optional, depending on dialect and register,
    //for example, the first s in deux cents euros or euros irlandais;
    //and some are forbidden, for example, the s in beaucoup d'hommes aiment.
    //The t of et is never pronounced, and the silent final consonant of a noun is only pronounced
    //in the plural and in set phrases like pied-à-terre.

    // Doubling a final n and adding a silent e at the end of a word (e.g., chien → chienne)
    //makes it clearly pronounced.
    //Doubling a final l and adding a silent e (e.g., gentil → gentille) adds a [j] sound if
    //the l is preceded by the letter i.

    //Some monosyllabic function words ending in a or e, such as je and que, drop their final vowel
    //when placed before a word that begins with a vowel sound (thus avoiding a hiatus).
    //The missing vowel is replaced by an apostrophe.
    //(e.g., *je ai is instead pronounced and spelled → j'ai).
    //This gives, for example, the same pronunciation for l'homme qu'il a vu ("the man whom he saw")
    //and l'homme qui l'a vu ("the man who saw him").
    //However, for Belgian French the sentences are pronounced differently;
    //in the first sentence the syllable break is as "qu'il-a",
    //while the second breaks as "qui-l'a".
    //It can also be noted that in Quebec French,
    //the second example (l'homme qui l'a vu) is more emphasized on l'a vu.
    private val rules:List<IRule> = listOf(
        //Rule("ai", "jɛ̃"),
        Rule("à", "a"),
        //The cedilla (la cédille) ç (e.g., garçon—boy) means that the letter ç is pronounced /s/
        // in front of the back vowels a, o and u (c is otherwise /k/ before a back vowel).
        Rule("ç", "s"),

        // C is always pronounced /s/ in front of the front vowels e, i, and y
        Rule("c[iey]", "s", 1),
        Rule("c[^ieyh]", "k", 1),
        Rule("qu", "k"),

        //FRICATIVES
        //----------
        Rule("ch", "ʃ"),
        Rule("g[ieéè]", "ʒ", 1),
        Rule("gn", "ɲ"),
        Rule("j", "ʒ"),
        LookbackRule("[$vowels]","s[$vowels]", "z", 1),
        Rule("(ss)", "s"),
        Rule("ti(on|ence)", "sj", 2),

        //NASAL VOWELS
        //------
        Rule(Regex("([ae][mn])[^$vowels]"), "ɑ̃", 2),
        Rule(Regex("(ean|aon)[^$vowels]"), "ɑ̃", 3),
        Rule("ie[nm][^$vowels]", "jɛ̃", 3),
        Rule("u[nm][^$vowels]", "œ̃", 2),
        Rule("oi", "wa"),
        Rule("oin", "wɛ̃"),

        //the french r
        Rule("r", "ʁ"),
        //-eu in the interior of a word = œ heure
        LookbackRule("(?!\\b)", "eu(?!\\b)", "œ", 2),
        //-eu before [z] = ø creuse
        //-eu as a final sound = ø  peu
        Rule("eu(se)?", "ø", 2),

        //SEMIVOWELS
        //----------
        Rule("(ui|uy)", "ɥ"),
        LookbackRule("[$vowels]", "il(le?)?\\b", "j"),

        //VOWELS
        //------
        //The acute accent (l'accent aigu) é (e.g., école—school) means that the vowel is
        // pronounced /e/ instead of the default /ə/.
        Rule("é", "e"),

        //The grave accent (l'accent grave) è (e.g., élève—pupil) means that the vowel is
        // pronounced /ɛ/ instead of the default /ə/.
        Rule("è", "ɛ"),

        //The circumflex (l'accent circonflexe) ê (e.g. forêt—forest) shows that an e is
        // pronounced /ɛ/
        Rule("ê", "ɛ"),
        Rule("e", "ə"),
        //Final single consonants, in particular s, x, z, t, d, n, p and g, are normally silent.
        //(A consonant is considered "final" when no vowel follows it,
        // even if one or more consonants follow it.)
        //Rule("", ""),
        //The circumflex (l'accent circonflexe) signifies that an ô is pronounced /o/.
        //In standard French, it also signifies a pronunciation of /ɑ/ for the letter â,
        //but this differentiation is disappearing.
        //(In the mid-18th century, the circumflex was used in place of s after a vowel,
        //where that letter s was not pronounced.
        // Thus, forest became forêt, hospital became hôpital, and hostel became hôtel.)
        Rule("ô", "o"),
        Rule("(œ|oe)u?", "œ"),
        Rule("aur", "ɔ", 2),
        Rule("e?au", "o"),
        Rule(Regex("e[$silencableConsonants]+\\b"), "e", 1),
        Rule(Regex("o[$silencableConsonants]+\\b"), "o", 1),

        //SILENT LETTERS
        //--------------
        LookbackRule(Regex("[^ ]"), Regex("[$silencableConsonants]+\\b"), ""),
        Rule("h", ""),
        Rule("['’]", "")
    ) + latinBaseRules.filter {
        with(it.unconsumedMatcher.toString()) {
        this != "e" &&
        this != "y" &&
        this != "h"
    } } + westernPunctuation

    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processGreedily(rules, ::reportOnceAndCopy)
    }
}