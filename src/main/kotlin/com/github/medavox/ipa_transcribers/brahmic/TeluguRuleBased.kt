package com.github.medavox.ipa_transcribers.brahmic

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object TeluguRuleBased:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.INCOMPLETE

    private val rules:List<Rule> = listOf(
        //consonants
        Rule("క", "k"),
        Rule("ఖ", "kʰ"),
        Rule("గ", "ɡ"),
        Rule("ఘ", "ɡʱ"),
        Rule("ఙ", "ŋ"),
        Rule("చ", "tʃ"),
        Rule("ఛ", "tʃʰ"),
        Rule("జ", "dʒ"),
        Rule("ఝ", "dʒʱ"),
        Rule("ఞ", "ɲ"),
        Rule("ట", "ʈ"),
        Rule("ఠ", "ʈʰ"),
        Rule("డ", "ɖ"),
        Rule("ఢ", "ɖʱ"),
        Rule("ణ", "ɳ"),
        Rule("త", "t"),
        Rule("థ", "tʰ"),
        Rule("ద", "d"),
        Rule("ధ", "dʱ"),
        Rule("న", "n"),
        Rule("ప", "p"),
        Rule("ఫ", "pʰ"),
        Rule("బ", "b"),
        Rule("భ", "bʱ"),
        Rule("మ", "m"),
        Rule("య", "j"),
        Rule("ర", "r"),
        Rule("ల", "l"),
        Rule("వ", "ʋ"),
        Rule("ళ", "ɭ"),
        Rule("శ", "ʃ"),
        Rule("ష", "ʂ"),
        Rule("స", "s"),
        Rule("హ", "h"),
        Rule("ఱ", "ɽ"),

        //vowels
        Rule("[అ]", "a"),
        Rule("[ఆా]", "aː"),
        Rule("[ఇి]", "i"),
        Rule("[ఈీ]", "iː"),
        Rule("[ఉు]", "u"),
        Rule("[ఊూ]", "uː"),
        Rule("[ఋృ]", "ru"),
        Rule("[ౠౄ]", "ruː"),
        Rule("[ఌౢ]", "alu"),
        Rule("[ౡౣ]", "alu:"),
        Rule("[ఎె]", "e"),
        Rule("[ఏే]", "eː"),
        Rule("[ఐై]", "aj"),
        Rule("[ఒొ]", "o"),
        Rule("[ఓో]", "oː"),
        Rule("[ఔౌ]", "aw"),

        Rule("","")
    )

    override fun transcribe(nativeText: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}