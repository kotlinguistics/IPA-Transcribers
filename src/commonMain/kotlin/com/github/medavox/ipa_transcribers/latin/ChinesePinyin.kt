package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber
import com.github.medavox.ipa_transcribers.latin.ChinesePinyin.Mode.*

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
    private var mode:Mode = INITIALS
    private enum class Mode {
        INITIALS,
        FINALS_NO_INITIAL,
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

    private val finalRulesNoInitial:List<Rule> = listOf(//an initial is present
        //no medial, no coda
        Rule("i", "ɨ"),
        Rule("e", "ɤ"),
        Rule("a", "a"),

        //no medial, coda = /i/
        Rule("ei", "ei̯"),
        Rule("ai", "ai̯"),

        //no medial, coda = /u/
        Rule("ou", "ou̯"),
        Rule("ao", "au̯"),

        //no medial, coda = /n/
        Rule("en", "ən"),
        Rule("an", "an"),

        //no medial, coda = /ŋ/
        Rule("eng", "əŋ"),
        Rule("ang", "aŋ"),

        //medial = /j/, no coda
        Rule("yi", "i"),
        Rule("ye", "je"),
        Rule("ya", "ja"),

        //medial = /j/, coda = /u/
        Rule("you", "jou̯"),
        Rule("yao", "jau̯"),

        //medial = /j/, coda = /n/
        Rule("yin", "in"),
        Rule("yan", "jɛn"),

        //medial = /j/, coda = /ŋ/
        Rule("yong", "jʊŋ"),
        Rule("ying", "iŋ"),
        Rule("yang", "jaŋ"),

        //medial = /w/, no coda
        Rule("wu", "u"),
        Rule("wo", "wo"),
        Rule("wa", "wa"),

        //medial = /w/, coda = /i/
        Rule("wei", "wei̯"),
        Rule("wai", "wai̯"),

        //medial = /w/, coda = /n/
        Rule("wen", "wən"),
        Rule("wan", "wan"),

        //medial = /w/, coda = /ŋ/
        Rule("weng", "wəŋ"),
        Rule("wang", "waŋ"),

        //medial = /y/, no coda
        Rule("yu", "y"),
        Rule("yue", "ɥe"),

        //medial = /y/, coda = /n/
        Rule("yun", "yn"),
        Rule("yuan", "ɥɛn")
    )

    //only contains rules which differ from the equivalent rule in finalRules.
    private val finalRules:List<Rule> = listOf(
        //no medial, no coda
        Rule("i", "ɨ"),
        Rule("e", "ɤ"),
        Rule("a", "a"),

        //no medial, coda = /i/
        Rule("ei", "ei̯"),
        Rule("ai", "ai̯"),

        //no medial, coda = /u/
        Rule("ou", "ou̯"),
        Rule("ao", "au̯"),

        //no medial, coda = /n/
        Rule("en", "ən"),
        Rule("an", "an"),

        //no medial, coda = /ŋ/
        Rule("ong", "ʊŋ"),//first difference to finalRulesNoInitials
        Rule("eng", "əŋ"),
        Rule("ang", "aŋ"),

        //all rules from here onwards are different -------------------

        //medial = /j/, no coda
        Rule("i", "i"),
        Rule("ie", "je"),
        Rule("ia", "ja"),

        //medial = /j/, coda = /u/
        Rule("iu", "jou̯"),
        Rule("iao", "jau̯"),

        //medial = /j/, coda = /n/
        Rule("in", "in"),
        Rule("ian", "jɛn"),

        //medial = /j/, coda = /ŋ/
        Rule("iong", "jʊŋ"),
        Rule("ing", "iŋ"),
        Rule("iang", "jaŋ"),

        //medial = /w/, no coda
        Rule("u", "u"),
        Rule("uo", "wo"),//todo: 3 uo is written as o after b, p, m, f, or w
        Rule("ua", "wa"),

        //medial = /w/, coda = /i/
        Rule("ui", "wei̯"),
        Rule("uai", "wai̯"),

        //medial = /w/, coda = /n/
        Rule("un", "wən"),
        Rule("uan", "wan"),

        //medial = /w/, coda = /ŋ/
        Rule("wang", "waŋ"),

        //medial = /y/, no coda
        Rule("ü", "y"),//todo: ü is written as u after j, q, or x
        Rule("üe", "ɥe"),//todo: ü is written as u after j, q, or x

        //medial = /y/, coda = /n/
        Rule("ün", "yn"),//todo: ü is written as u after j, q, or x
        Rule("üan", "ɥɛn")//todo: ü is written as u after j, q, or x
    )
    fun String.processPinyin(onNoRuleMatch:(unmatched:String) -> UnmatchedOutput) : String {
        var out:String = ""
        var processingWord:String = this
        var consumed = ""

        //todo: when in Mode.FINALS_NO_INITAL, try the finalRulesNoInitials first,
        // and if nothing matches, try the normal finalRules list.
        // that way, we can omit rules from finalRulesNoInitials whose output is the same as the equivalent finalRules
        loop@ while(processingWord.isNotEmpty()) {
            //uses the first rule which matches -- so rule order matters

            val rules = when(mode) {
                INITIALS -> initialRules
                FINALS -> finalRules
                FINALS_NO_INITIAL -> finalRulesNoInitial
            }
            //get the first rule (if any) where the following conditions are met:
            val rule = rules.firstOrNull{
                //the unconsumed matcher must match at the start, and
                it.unconsumedMatcher.find(processingWord)?.range?.start == 0 &&
                    //the consumed matcher must either be null (unspecified), or
                    (it.consumedMatcher == null ||
                    //it must match at the end of the "already-consumed input" string
                    it.consumedMatcher.findAll(consumed).lastOrNull()?.range?.endInclusive == consumed.length-1)
            }

            if(rule != null) {
                val unconsumedMatch:MatchResult = rule.unconsumedMatcher.find(processingWord)!!
                out = rule.outputString(out, unconsumedMatch.groups)
                //System.out.println("matched rule:$rule")
                //number of letters consumed is the match length, unless explicitly specified
                val actualLettersConsumed = rule.lettersConsumed ?: unconsumedMatch.value.length
                mode = FINALS
                if(actualLettersConsumed > 0) {
                    consumed += processingWord.substring(0, actualLettersConsumed)
                    processingWord = processingWord.substring(actualLettersConsumed)
                    continue@loop
                }
            }else {//no rule matched
                when (mode) {
                    INITIALS -> {
                        //in Mode.INITIALS, that's fine;
                        //it just means there is no initial
                        mode = FINALS_NO_INITIAL
                        continue@loop
                    }
                    FINALS, FINALS_NO_INITIAL -> {
                        //but if we're in Mode.FINALS or Mode.FINALS_NO_INITIAL,
                        // this really does mean no rule matched. So call the lambda!
                        val unmatchedOutput = onNoRuleMatch(processingWord)
                        processingWord = unmatchedOutput.newWorkingInput
                        out = unmatchedOutput.output(out)
                        mode = INITIALS
                        continue@loop
                    }
                }
            }
            //loop
        }
        //System.out.println("consumed: $consumed")
        return out
    }


    override fun transcribe(nativeText: String): String {
        //if we don't match an initial, it's probably because there isn't one.
        //so if no initial matches in INITIALS mode,
        //try to match a final instead before falling back to a proper onNoRuleMatched case
        if(mode == INITIALS) {

        }else {//finals mode

        }
        return nativeText.toLowerCase().processWithRules(initialRules, reportAndSkip)
    }
}