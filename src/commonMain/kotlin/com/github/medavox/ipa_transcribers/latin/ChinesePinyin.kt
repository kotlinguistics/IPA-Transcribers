package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**Transcriber for the Hanyu Pinyin Chinese romanisation system to IPA.*/
object ChinesePinyin: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS

    //Unlike European languages,
    // clusters of letters — initials (声母; 聲母; shēngmǔ) and finals (韵母; 韻母; yùnmǔ) —
    // and not consonant and vowel letters,
    // form the fundamental elements in pinyin (and most other phonetic systems used to describe the Han language).
    // Every Mandarin syllable can be spelled with exactly one initial followed by one final,
    // except for the special syllable er or when a trailing -r is considered part of a syllable.
    // The latter case, though a common practice in some sub-dialects, is rarely used in official publications.
    //
    //Even though most initials contain a consonant, finals are not always simple vowels, especially in compound finals (复韵母; 複韻母; fùyùnmǔ), i.e. when a "medial" is placed in front of the final. For example, the medials [i] and [u] are pronounced with such tight openings at the beginning of a final that some native Chinese speakers (especially when singing) pronounce yī (衣, clothes, officially pronounced /í/) as /jí/ and wéi (围; 圍, to enclose, officially pronounced /uěi/) as /wěi/ or /wuěi/. Often these medials are treated as separate from the finals rather than as part of them; this convention is followed in the chart of finals below.
    private val mode:Mode = Mode.INITIALS
    private enum class Mode {
        INITIALS,
        FINALS
    }

    private val initialRules:List<Rule> = listOf(
        //initials
        Rule("b", "p"),
        Rule("p", "pʰ"),
        Rule("m", "m"),
        Rule("f", "f"),
        Rule("d", "t"),
        Rule("t", "tʰ"),
        Rule("n", "n"),
        Rule("l", "l"),
        Rule("g", "k"),
        Rule("k", "kʰ"),
        Rule("h", "x"),
        Rule("j", "tɕ"),
        Rule("q", "tɕʰ"),
        Rule("x", "ɕ"),
        Rule("zh", "ʈʂ"),
        Rule("ch", "ʈʂʰ"),
        Rule("sh", "ʂ"),
        Rule("r", "ɻ~ʐ"),
        Rule("z", "ts"),
        Rule("c", "tsʰ"),
        Rule("s", "s")
    )
    override fun transcribe(nativeText: String): String {
        //if we don't match an initial, it's probably because there isn't one.
        //so if no initial matches in INITIALS mode,
        //try to match a final instead before falling back to a proper onNoRuleMatched case
        if(mode == Mode.INITIALS) {

        }else {//finals mode

        }
        return nativeText.toLowerCase().processWithRules(initialRules, reportAndSkip)
    }
}