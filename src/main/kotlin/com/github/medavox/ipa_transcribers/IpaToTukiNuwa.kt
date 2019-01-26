package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.Language.InternationalPhoneticAlphabet
import com.github.medavox.ipa_transcribers.rulebased.Rule
import com.github.medavox.ipa_transcribers.rulebased.RuleProcessor


class IpaToTukiNuwa: RuleProcessor<InternationalPhoneticAlphabet>, Transcriber<InternationalPhoneticAlphabet> {
    /**Essentially an automated repair strategy for Tuki Nuwa.
     * replaces every IPA sound with the nearest legal sound in Tuki Nuwa.

     * For consonant clusters, not sure yet.
     * Maybe a series of prioritised drop rules?
     * (drop this consonant, then this one, then this one, until it's a legal word)
     *
     * with words that have too many syllables
     * AND whose stressed syllable is after the first,
     * drop the unstressed syllable(s) before the stressed one*/
    private val rules:Array<Rule<InternationalPhoneticAlphabet>> = arrayOf(
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
        Rule(Regex("[tdðʈɖ]+"), "t"),
        Rule(Regex("[uʊɯɤoɔ]+"), "u"),
        Rule(Regex("[ʋwvʍ]+"), "w")
    )

    override fun transcribe(nativeText: String): Map<InternationalPhoneticAlphabet, String> {
        return processWithRules(nativeText, rules, mapOf(InternationalPhoneticAlphabet to StringBuilder())){
            //drop unhandled characters
            System.out.println("character ${it[0]} in $it doesn't match any IPA->TN rules. Skipping...")
            RuleProcessor.UnmatchedOutput(it.substring(1), "")
        }
    }
}