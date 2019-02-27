package com.github.medavox.ipa_transcribers.english

import com.github.medavox.ipa_transcribers.Language.AmericanEnglish
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**I'm not hopeful that this will work well enough to use,
 * but Mark Rosenfelder seems fairly confident that he's compiled a list of English spelling rules
 * which get it right ~85% of the time.
 *
 * So here goes.*/
object EnglishRuleBased:RuleBasedTranscriber<AmericanEnglish> {

    fun longPronunciation(vowel:Char):String {
        return "not yet implemented"
    }
    fun shortPronunciation(vowel:Char):String {
        return "not yet implemented"
    }
    const val vowels = "aeiou"
    val rules:List<Rule> = listOf(
        Rule("ch", "tʃ"),
        Rule("sh", "ʃ"),
        Rule("ph", "f"),
        Rule("th", "θ"),
        Rule("qu", "kw"),
        Rule("wr", "r"),
        //Before an o, replace wh with h instead: who, whore, whole.
        Rule("who", "h", 1),
        Rule("wh", "w"),
        //Replace x with ks; but after e and before another vowel, use gz instead.
        // (This is not an allophonic rule: compare the near-minimal pair exist and excite.)
        Rule("e", "xh[$vowels]", "gz", 2),
        Rule("xh", "ks"),
        Rule("e", "x[$vowels]", "gz", 1),
        Rule("x", "ks"),

        Rule("rh", "r"),
        //Ignore apostrophes (can't, cop's, o'clock).
        Rule("'", ""),

        // Hyphens can however be treated as word separators (mother-in-law is pronounced like mother in law).
        Rule("-", " "),
        Rule("", "")
    )+latinBaseRules+westernPunctuation
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, reportAndCopy)
    }
}