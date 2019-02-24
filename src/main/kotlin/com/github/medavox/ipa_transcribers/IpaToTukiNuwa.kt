package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.Language.InternationalPhoneticAlphabet


class IpaToTukiNuwa: RuleBasedTranscriber<InternationalPhoneticAlphabet> {
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
        Rule(Regex("[aɶäɒɑæɐɛəʌ]+"), "a"),
        Rule(Regex("[hɦχxħçʁʕ]+"), "h"),
        Rule(Regex("[iyɪʏeø]+"), "i"),
        Rule(Regex("[jʎʝ]+"), "j"),
        Rule(Regex("[kgqɢɡ]+"), "k"),
        Rule(Regex("[lɫɭɹ]+"), "l"),
        Rule(Regex("[mɱ]+"), "m"),
        Rule(Regex("[nŋɲɴ]+"), "n"),
        Rule(Regex("[pbʙɸβ]+"), "p"),
        Rule(Regex("[szʃʒʂʐɕʑθ]+"), "s"),
        Rule(Regex("[tdðʈɖɾ]+"), "t"),
        Rule(Regex("[uʊɯɤoɔ]+"), "u"),
        Rule(Regex("[ʋwvʍ]+"), "w"),
        Rule(Regex(" "), " ")
    )

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

    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(initialRules, reportAndSkip)
            .processWithRules(phonotacticsRules, reportAndCopy)
            .processWithRules(cleanupAfterPhonotacticsRules, reportAndCopy)
    }
}