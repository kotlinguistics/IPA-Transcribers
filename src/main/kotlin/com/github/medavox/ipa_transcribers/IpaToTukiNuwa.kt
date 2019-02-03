package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.Language.InternationalPhoneticAlphabet
import com.github.medavox.ipa_transcribers.rulesystem.Rule
import com.github.medavox.ipa_transcribers.rulesystem.RuleProcessor


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
        Rule(Regex("[tdðʈɖ]+"), "t"),
        Rule(Regex("[uʊɯɤoɔ]+"), "u"),
        Rule(Regex("[ʋwvʍ]+"), "w")
    )

    private val phonotacticsRules:List<Rule> = listOf(
        //tuki nuwa doesn't allow these combinations.
        Rule(Regex("ji"), "i"),
        Rule(Regex("wu"), "u")
    )

    private val cleanupAfterPhonotacticsRules:List<Rule> = listOf(
        //tuki nuwa doesn't allow this combination.
        Rule(Regex("i+"), "i"),
        Rule(Regex("u+"), "u")
    )

    override fun transcribe(nativeText: String): String {
        val noMatchLambda:(unmatched:String) -> RuleProcessor.UnmatchedOutput = {
            //drop unhandled characters
            System.out.println("character ${it[0]} in $it doesn't match any IPA->TN rules. Skipping...")
            RuleProcessor.UnmatchedOutput(it.substring(1), "")
        }
        return nativeText.processWithRules(initialRules, noMatchLambda)
            .processWithRules(phonotacticsRules){RuleProcessor.UnmatchedOutput(it.substring(1), it[0].toString())}
            .processWithRules(cleanupAfterPhonotacticsRules){RuleProcessor.UnmatchedOutput(it.substring(1), it[0].toString())}
    }
}