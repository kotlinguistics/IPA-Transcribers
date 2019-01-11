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
        Rule(Regex("[a]"), "a"),
        Rule(Regex("[h]"), "h"),
        Rule(Regex("[i]"), "i"),
        Rule(Regex("[j]"), "j"),
        Rule(Regex("[kg]"), "k"),
        Rule(Regex("[l]"), "l"),
        Rule(Regex("[m]"), "m"),
        Rule(Regex("[n]"), "n"),
        Rule(Regex("[pb]"), "p"),
        Rule(Regex("[sz]"), "s"),
        Rule(Regex("[td]"), "t"),
        Rule(Regex("[u]"), "u"),
        Rule(Regex("[wv]"), "w")
    )
    override fun transcribe(nativeText: String): Set<Variant> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}