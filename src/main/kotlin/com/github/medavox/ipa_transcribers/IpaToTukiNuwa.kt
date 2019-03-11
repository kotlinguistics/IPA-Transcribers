package com.github.medavox.ipa_transcribers


object IpaToTukiNuwa: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.COMPLETE
    /**Essentially an automated repair strategy for Tuki Nuwa.
     * replaces every IPA sound with the nearest legal sound in Tuki Nuwa.

     * For consonant clusters, not sure yet.
     * Maybe a series of prioritised drop rules?
     * (drop this consonant, then this one, then this one, until it's a legal word)
     *
     * with words that have too many syllables
     * AND whose stressed syllable is after the first,
     * drop the unstressed syllable(s) before the stressed one*/
    private val initialRules:List<Rule> = listOf(
        //simplifying consonant clusters
        Rule(Regex("[sʃzʒʂʐɕʑθ]+t[sʃzʒʂʐɕʑθ]+"), "s"),


        Rule(Regex("[aɶäɒɑæɐɛəʌ]+"), "a"),
        Rule(Regex("[hɦχxħçʁʕ]+"), "h"),
        Rule(Regex("[iyɪʏeɨ]+"), "i"),
        Rule(Regex("[jʎʝ]+"), "j"),
        Rule(Regex("[ɣkgqɢɡ]+"), "k"),
        Rule(Regex("[lɫɭr]+"), "l"),
        Rule(Regex("[mɱ]+"), "m"),
        Rule(Regex("[nŋɲɴ]+"), "n"),
        Rule(Regex("[fpbʙɸβ]+"), "p"),
        Rule(Regex("[szʃʒʂʐɕʑθ]+"), "s"),
        Rule(Regex("[tdðʈɖɾ]+"), "t"),
        Rule(Regex("[uʊɯɤoɔø]+"), "u"),
        Rule(Regex("[ʋwvʍɹ]+"), "w")
    ) + westernPunctuation

    private val phonotacticsRules:List<Rule> = listOf(
        //tuki nuwa doesn't allow these combinations.
        Rule(Regex("ji"), "i"),
        Rule(Regex("wu"), "u")
    )

    private val cleanupAfterPhonotacticsRules:List<Rule> = listOf(
        //deduplicate any resulting repeated letters
        Rule("a+", "a"),
        Rule("h+", "h"),
        Rule("i+", "i"),
        Rule("j+", "j"),
        Rule("k+", "k"),
        Rule("l+", "l"),
        Rule("m+", "m"),
        Rule("n+", "n"),
        Rule("p+", "p"),
        Rule("s+", "s"),
        Rule("t+", "t"),
        Rule("u+", "u"),
        Rule("w+", "w")
    )

    private val breakUpConsonantClustersAndDiphthongs:List<Rule> = listOf(
        Rule(Regex("au"), "aju"),
        Rule(Regex("ai"), "awi"),
        Rule(Regex("h[^aiu]"), "hi", 1),
        Rule(Regex("i[au]"), "ij", 1),
        Rule(Regex("j[^aiu]"), "ja", 1),
        Rule(Regex("k[^aiu]"), "ku", 1),
        Rule(Regex("l[^aiu]"), "la", 1),
        Rule(Regex("m[^aiu]"), "mu", 1),
        Rule(Regex("n[hjklmnpstw]"), "na", 1),
        Rule(Regex("p[^aiu]"), "pu", 1),
        Rule(Regex("s[^aiu]"), "sa", 1),
        Rule(Regex("t[^aiu]"), "ta", 1),
        Rule(Regex("u[ai]"), "uw", 1),
        Rule(Regex("w[^aiu]"), "wa", 1)
    )

    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(initialRules, reportAndSkip)
            .processWithRules(phonotacticsRules, copy)
            .processWithRules(cleanupAfterPhonotacticsRules, copy)
            .processWithRules(breakUpConsonantClustersAndDiphthongs, copy)
    }
}