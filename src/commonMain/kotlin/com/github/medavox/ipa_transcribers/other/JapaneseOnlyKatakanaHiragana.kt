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

package com.github.medavox.ipa_transcribers.other

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**We can't process Japanese's primary writing system, Kanji, with a rule-based transcriber.
 * But we can process its more regular supplementary syllabaries, Katakana and Hiragana.
 *
 * Completion status: all purely sound-based characters have been added;
 * however, there are a small number of 'functional' Hiragana & Katakana, which require more complex rules,
 * that are yet to be done.*/
object JapaneseOnlyKatakanaHiragana:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.INCOMPLETE
    private val rules:List<Rule> = listOf(
        //katakana
        Rule("ア", "a"),
        Rule("イ", "i"),
        Rule("ウ", "ɯ"),
        Rule("エ", "e"),
        Rule("オ", "o"),
        Rule("カ", "ka"),
        Rule("キ", "ki"),
        Rule("ク", "kɯ"),
        Rule("ケ", "ke"),
        Rule("コ", "ko"),
        Rule("キャ", "kʲa"),
        Rule("キュ", "kʲɯ"),
        Rule("キョ", "kʲo"),
        Rule("サ", "sa"),
        Rule("シ", "ɕi"),
        Rule("ス", "sɯ"),
        Rule("セ", "se"),
        Rule("ソ", "so"),
        Rule("シャ", "ɕa"),
        Rule("シュ", "ɕɯ"),
        Rule("ショ", "ɕo"),
        Rule("タ", "ta"),
        Rule("チ", "t͡ɕi"),
        Rule("ツ", "t͡sɯ"),
        Rule("テ", "te"),
        Rule("ト", "to"),
        Rule("チャ", "t͡ɕa"),
        Rule("チュ", "t͡ɕɯ"),
        Rule("チョ", "t͡ɕo"),
        Rule("ナ", "na"),
        Rule("ニ", "ɲi"),
        Rule("ヌ", "nɯ"),
        Rule("ネ", "ne"),
        Rule("ノ", "no"),
        Rule("ニャ", "ɲa"),
        Rule("ニュ", "ɲɯ"),
        Rule("ニョ", "ɲo"),
        Rule("ハ", "ha"),
        Rule("ヒ", "çi"),
        Rule("フ", "ɸɯ"),
        Rule("ヘ", "he"),
        Rule("ホ", "ho"),
        Rule("ヒャ", "ça"),
        Rule("ヒュ", "çɯ"),
        Rule("ヒョ", "ço"),
        Rule("マ", "ma"),
        Rule("ミ", "mi"),
        Rule("ム", "mɯ"),
        Rule("メ", "me"),
        Rule("モ", "mo"),
        Rule("ミャ", "mʲa"),
        Rule("ミュ", "mʲɯ"),
        Rule("ミョ", "mʲo"),
        Rule("ヤ", "ja"),
        Rule("ユ", "jɯ"),
        Rule("ヨ", "jo"),
        Rule("ラ", "ɾa"),
        Rule("リ", "ɾi"),
        Rule("ル", "ɾɯ"),
        Rule("レ", "ɾe"),
        Rule("ロ", "ɾo"),
        Rule("リャ", "ɾʲa"),
        Rule("リュ", "ɾʲɯ"),
        Rule("リョ", "ɾʲo"),
        Rule("ワ", "ɰa"),
        Rule("ヰ", "i"),
        Rule("ヱ", "e"),
        Rule("ヲ", "o"),

        //katakana with diacritics
        Rule("ギ", "ɡi"),
        Rule("グ", "ɡɯ"),
        Rule("ゲ", "ɡe"),
        Rule("ゴ", "ɡo"),
        Rule("ギャ", "ɡʲa"),
        Rule("ギュ", "ɡʲɯ"),
        Rule("ギョ", "ɡʲo"),
        Rule("ジ", "(d)ʑi"),
        Rule("ズ", "(d)zɯ"),
        Rule("ゼ", "ze"),
        Rule("ゾ", "zo"),
        Rule("ジャ", "(d)ʑa"),
        Rule("ジュ", "(d)ʑɯ"),
        Rule("ジョ", "(d)ʑo"),
        Rule("ヂ", "(d)ʑi"),
        Rule("ヅ", "(d)zɯ"),
        Rule("デ", "de"),
        Rule("ド", "do"),
        Rule("ヂャ", "(d)ʑa"),
        Rule("ヂュ", "(d)ʑɯ"),
        Rule("ヂョ", "(d)ʑo"),
        Rule("ビ", "bi"),
        Rule("ブ", "bɯ"),
        Rule("ベ", "be"),
        Rule("ボ", "bo"),
        Rule("ビャ", "bʲa"),
        Rule("ビュ", "bʲɯ"),
        Rule("ビョ", "bʲo"),
        Rule("ピ", "pi"),
        Rule("プ", "pɯ"),
        Rule("ペ", "pe"),
        Rule("ポ", "po"),
        Rule("ピャ", "pʲa"),
        Rule("ピュ", "pʲɯ"),
        Rule("ピョ", "pʲo"),

        //todo: functional katakana
        //ン n [n m ŋ] before stop consonants; [ɴ ɰ̃] elsewhere
        //ッ (before geminate consonant)
        //ー (after long vowel)
        //ヽ (reduplicates and unvoices syllable)
        //ヾ (reduplicates and voices syllable)


        //hiragana
        Rule("あ", "a"),
        Rule("い", "i"),
        Rule("う", "ɯ"),
        Rule("え", "e"),
        Rule("お", "o"),
        Rule("か", "ka"),
        Rule("き", "ki"),
        Rule("く", "kɯ"),
        Rule("け", "ke"),
        Rule("こ", "ko"),
        Rule("きゃ", "kʲa"),
        Rule("きゅ", "kʲɯ"),
        Rule("きょ", "kʲo"),
        Rule("さ", "sa"),
        Rule("し", "ɕi"),
        Rule("す", "sɯ"),
        Rule("せ", "se"),
        Rule("そ", "so"),
        Rule("しゃ", "ɕa"),
        Rule("しゅ", "ɕɯ"),
        Rule("しょ", "ɕo"),
        Rule("た", "ta"),
        Rule("ち", "tɕi"),
        Rule("つ", "tsɯ"),
        Rule("て", "te"),
        Rule("と", "to"),
        Rule("ちゃ", "tɕa"),
        Rule("ちゅ", "tɕɯ"),
        Rule("ちょ", "tɕo"),
        Rule("な", "na"),
        Rule("に", "ɲi"),
        Rule("ぬ", "nɯ"),
        Rule("ね", "ne"),
        Rule("の", "no"),
        Rule("にゃ", "ɲa"),
        Rule("にゅ", "ɲɯ"),
        Rule("にょ", "ɲo"),
        Rule("は", "ha"), //([ɰa] as particle)
        Rule(" ひ", "çi"),
        Rule("ふ", "ɸɯ"),
        Rule("へ", "he"), //([e] as particle)
        Rule(" ほ", "ho"),
        Rule("ひゃ", "ça"),
        Rule("ひゅ", "çɯ"),
        Rule("ひょ", "ço"),
        Rule("ま", "ma"),
        Rule("み", "mi"),
        Rule("む", "mɯ"),
        Rule("め", "me"),
        Rule("も", "mo"),
        Rule("みゃ", "mʲa"),
        Rule("みゅ", "mʲɯ"),
        Rule("みょ", "mʲo"),
        Rule("や", "ja"),
        Rule("ゆ", "jɯ"),
        Rule("よ", "jo"),
        Rule("ら", "ɾa"),
        Rule("り", "ɾi"),
        Rule("る", "ɾɯ"),
        Rule("れ", "ɾe"),
        Rule("ろ", "ɾo"),
        Rule("りゃ", "ɾʲa"),
        Rule("りゅ", "ɾʲɯ"),
        Rule("りょ", "ɾʲo"),
        Rule("わ", "ɰa"),
        Rule("ゐ", "i"),//wi
        Rule("ゑ", "e"),//we
        Rule("を", "o"),//wo

        //hiaragana with diacritics
        Rule("が", "ɡa"),
        Rule("ぎ", "ɡi"),
        Rule("ぐ", "ɡɯ"),
        Rule("げ", "ɡe"),
        Rule("ご", "ɡo"),
        Rule("ぎゃ", "ɡʲa"),
        Rule("ぎゅ", "ɡʲɯ"),
        Rule("ぎょ", "ɡʲo"),
        Rule("ざ", "(d)za"),
        Rule("じ", "(d)ʑi"),
        Rule("ず", "(d)zɯ"),
        Rule("ぜ", "(d)ze"),
        Rule("ぞ", "(d)zo"),
        Rule("じゃ", "(d)ʑa"),
        Rule("じゅ", "(d)ʑɯ"),
        Rule("じょ", "(d)ʑo"),
        Rule("だ", "da"),
        Rule("ぢ", "(d)ʑi"),
        Rule("づ", "(d)zɯ"),
        Rule("で", "de"),
        Rule("ど", "do"),
        Rule("ぢゃ", "(d)ʑa"),
        Rule("ぢゅ", "(d)ʑɯ"),
        Rule("ぢょ", "(d)ʑo"),
        Rule("ば", "ba"),
        Rule("び", "bi"),
        Rule("ぶ", "bɯ"),
        Rule("べ", "be"),
        Rule("ぼ", "bo"),
        Rule("びゃ", "bʲa"),
        Rule("びゅ", "bʲɯ"),
        Rule("びょ", "bʲo"),
        Rule("ぱ", "pa"),
        Rule("ぴ", "pi"),
        Rule("ぷ", "pɯ"),
        Rule("ぺ", "pe"),
        Rule("ぽ", "po"),
        Rule("ぴゃ", "pʲa"),
        Rule("ぴゅ", "pʲɯ"),
        Rule("ぴょ", "pʲo")


        //todo: functional hiragana
        //ん n [ɴ m n ɲ ŋ ɰ̃]
        //っ (indicates a geminate consonant)
        //ゝ(reduplicates and unvoices syllable)
        //ゞ (reduplicates and voices syllable)

    )
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}