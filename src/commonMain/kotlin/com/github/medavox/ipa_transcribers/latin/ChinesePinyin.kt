/*
IPA Transcribers
Copyright (C) 2018 - 2025  Adam Howard

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

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
    // form the fundamental elements in pinyin
    // (and most other phonetic systems used to describe the Han language).
    // Every Mandarin syllable can be spelled with exactly one initial followed by one final,
    // except for the special syllable er or when a trailing -r is considered part of a syllable.
    // The latter case, though a common practice in some sub-dialects,
    // is rarely used in official publications.
    //
    //Even though most initials contain a consonant, finals are not always simple vowels,
    // especially in compound finals (复韵母; 複韻母; fùyùnmǔ),
    // i.e. when a "medial" is placed in front of the final.
    // For example, the medials [i] and [u] are pronounced with such tight openings at the
    // beginning of a final that some native Chinese speakers (especially when singing)
    // pronounce yī (衣, clothes, officially pronounced /í/) as /jí/ and wéi
    // (围; 圍, to enclose, officially pronounced /uěi/) as /wěi/ or /wuěi/.
    //
    // Often these medials are treated as separate from the finals rather than as part of them;
    // this convention is followed in the chart of finals below.
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
        Rule("yuan", "ɥɛn"),

        //Erhua rules
        //---------------------------------------------------

        //no medial
        Rule("ar", "ɐʵ"),
        Rule("or", "ɔʵ"),
        Rule("e'r", "ɤʵ"),
        Rule("air", "ɐʵ"),
        Rule("eir", "ɚ̯"),
        Rule("aor", "au̯˞"),
        Rule("our", "ou̯˞"),
        Rule("anr", "ɐʵ"),
        Rule("enr", "ɚ̯"),
        Rule("angr","ɑ̃ʵ"),
        Rule("engr","ɤ̃ʵ"),

        //medial = /j/
        Rule("yir","jɚ"),
        Rule("yar","jɐʵ"),
        Rule("yer","jɛʵ"),
        Rule("yaor","jau̯ʵ"),
        Rule("your","jou̯ʵ"),
        Rule("yanr","jɐʵ"),
        Rule("yinr","jɚ"),
        Rule("yangr","jɑ̃ʵ"),
        Rule("yingr","jɤ̃ʵ"),

        //medial = /w/
        Rule("wur", "u˞"),
        Rule("war", "wɐʵ"),
        Rule("wor", "wɔʵ"),
        Rule("wair", "wɐʵ"),
        Rule("weir", "wɚ̯"),
        Rule("wanr", "wɐʵ"),
        Rule("wenr", "wɚ̯"),
        Rule("wangr", "wɑ̃ʵ"),
        Rule("wengr", "wɤ̃ʵ"),//or ʊ̃˞

        //medial = /y/
        Rule("yur", "ɥɚ"),
        Rule("yuer", "ɥœʵ"),
        Rule("yuanr", "ɥɐʵ"),
        Rule("yunr", "ɥɚ"),
        Rule("yongr", "jʊ̃ʵ"),

        Rule("","")
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
        //                                  (and technically y, but that is handled here)
        Rule("üe", "ɥe"),//todo: ü is written as u after j, q, or x

        //medial = /y/, coda = /n/
        Rule("ün", "yn"),//todo: ü is written as u after j, q, or x
        Rule("üan", "ɥɛn"),//todo: ü is written as u after j, q, or x

        //----------------------------------------------------------------------------
        //Erhua rules

        //no medial
        Rule("ir", "ɚ"),
        Rule("or", "ɔʵ"),
        Rule("er", "ɤʵ"),
        Rule("air", "ɐʵ"),
        Rule("eir", "ɚ̯"),
        Rule("aor", "au̯˞"),
        Rule("our", "ou̯˞"),
        Rule("anr", "ɐʵ"),
        Rule("enr", "ɚ̯"),
        Rule("angr", "ɑ̃ʵ"),
        Rule("engr", "ɤ̃ʵ"),

        //medial = /j/
        Rule("ir", "jɚ"),
        Rule("iar", "jɐʵ"),
        Rule("ier", "jɛʵ"),
        Rule("iaor", "jau̯ʵ"),
        Rule("iur", "jou̯ʵ"),
        Rule("ianr", "jɐʵ"),
        Rule("inr", "jɚ"),
        Rule("iangr", "jɑ̃ʵ"),
        Rule("ingr", "jɤ̃ʵ"),


    //fixme: the following finals (which expect a preceding initial) haven't got an <r> on the end,
    // which means there's nothing distinguishing them from their non-erhua counterparts!
    // find out if this an error on Wikipedia, or if there really is no orthographical distinction.
        //[u˞] -u
        //[wɐʵ] -ua
        //[wɔʵ] -uo
        //[wɐʵ] -uai
        //[wɚ̯] -ui
        //[wɐʵ] -uan
        //[wɚ̯] -un
        //[wɑ̃ʵ] -uang
        //medial = /w/
        Rule("ongr", "wɤ̃ʵ"),//or ʊ̃˞

        //medial = /y/
        Rule("ür", "ɥɚ"),
        Rule("üer", "ɥœʵ"),
        Rule("üanr", "ɥɐʵ"),
        Rule("ünr", "ɥɚ"),
        Rule("iongr", "jʊ̃ʵ"),


        Rule("","")//todo: delete after finishing
    )

    //A Finite State Machine which greedily applies the rule that matches the most characters
    fun String.processPinyin(onNoRuleMatch:(unmatched:String) -> UnmatchedOutput) : String {
        var out:String = ""
        var processingWord:String = this
        var consumed = ""

        //when in Mode.FINALS_NO_INITAL, try the finalRulesNoInitials first,
        //and if nothing matches, try the normal finalRules list.
        //that way, we can omit rules from finalRulesNoInitials whose output is the same as
        // the equivalent finalRules
        loop@ while(processingWord.isNotEmpty()) {
            //uses the first rule which matches -- so rule order matters

            val rules = when(mode) {
                INITIALS -> initialRules
                FINALS -> finalRules
                FINALS_NO_INITIAL -> finalRulesNoInitial
            }
            //get the first rule (if any) where the following conditions are met:
            val rule = rules.filter{
                //the unconsumed matcher must match at the start, and
                it.unconsumedMatcher.find(processingWord)?.range?.start == 0 &&
                    //the consumed matcher must either be null (unspecified), or
                    (it.consumedMatcher == null ||
                    //it must match at the end of the "already-consumed input" string
                    it.consumedMatcher.findAll(consumed).lastOrNull()?.range?.
                        endInclusive == consumed.length-1)
            }.maxBy {
                //shouldn't be null,
                it.lettersConsumed ?: it.unconsumedMatcher.find(processingWord)!!.value.length
                //because we've already filtered out the null ones in the above filter{} block
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
                        // this really does mean no rule matched.
                        // So call the passed function for onNoRuleMatch
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