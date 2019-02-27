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
    const val longI = "aɪ"
    //const val longO = "oʊ"//might not actually be what he means by long o
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

        //The notorious gh
        //Before a vowel, gh becomes g: ghost = göst.
        Rule("gh[$vowels]", "g", 1),
        //gh turns a preceding single vowel long: right = rït.
        //[my note: i don't think <aght>, <eght>, <oght> or <ught> occur naturally in english, so this can just be for i ]
        Rule("igh", longI),
        //aught and ought become òt: daughter = dòt@r, sought = sòt.
        Rule("aught", "ɔt"),
        Rule("ought", "ɔt"),
        //Any other ough becomes ö: dough = dö.
        Rule("ough", "oʊ"),
        //Elsewhere, gh is simply dropped: freight = frät.
        Rule("gh", ""),

        //In initial gn, kn, mn, pt, ps, tm, pronounce the second letter only: gnostic = nôstîk, psycho = sïkö, knight = nït.
        Rule("( |^)", "gn", "n"),
        Rule("( |^)", "kn", "n"),
        Rule("( |^)", "mn", "n"),
        Rule("( |^)", "pt", "t"),
        Rule("( |^)", "tm", "m"),

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