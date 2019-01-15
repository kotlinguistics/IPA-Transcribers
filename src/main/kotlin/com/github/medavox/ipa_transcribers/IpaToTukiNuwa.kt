package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.Transcriber.Rule

class IpaToTukiNuwa: Transcriber {
    /**Essentially an automated repair strategy for Tuki Nuwa.
     * replaces every IPA sound with the nearest legal sound in Tuki Nuwa.

     * For consonant clusters, not sure yet.
     * Maybe a series of prioritised drop rules?
     * (drop this consonant, then this one, then this one, until it's a legal word)
     *
     * with words that have too many syllables
     * AND whose stressed syllable is after the first,
     * drop the unstressed syllable(s) before the stressed one*/
    private val rules:Array<Rule> = arrayOf(
        Rule(Regex("[aɶäɒɑæɐɛəʌ]+"), "a"),
        Rule(Regex("[hɦχxħçʁʕ]+"), "h"),
        Rule(Regex("[iyɪʏeø]+"), "i"),
        Rule(Regex("[jʎʝ]+"), "j"),
        Rule(Regex("[kgqɢ]+"), "k"),
        Rule(Regex("[lɫɭɹ]+"), "l"),
        Rule(Regex("[mɱ]+"), "m"),
        Rule(Regex("[nŋɲɴ]+"), "n"),
        Rule(Regex("[pbʙɸβ]+"), "p"),
        Rule(Regex("[szʃʒʂʐɕʑθ]+"), "s"),
        Rule(Regex("[tdðʈɖ]+"), "t"),
        Rule(Regex("[uʊɯɤoɔ]+"), "u"),
        Rule(Regex("[ʋwvʍ]+"), "w")
    )
    override fun transcribe(nativeText: String): Set<Variant> {
        return setOf(Variant("tn", processWithRules(nativeText, rules)))
    }
}