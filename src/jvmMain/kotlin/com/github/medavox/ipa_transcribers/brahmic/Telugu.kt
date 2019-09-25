package com.github.medavox.ipa_transcribers.brahmic

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

object Telugu:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.INCOMPLETE

    private fun l(it:String):String{
        return if(it.endsWith("a")) it.substring(0, it.length-1) else it
    }

    private val rules:List<Rule> = listOf(
        //consonants
        Rule("క", "ka"),
        Rule("ఖ", "kʰa"),
        Rule("గ", "ɡa"),
        Rule("ఘ", "ɡʱa"),
        Rule("ఙ", "ŋa"),
        Rule("చ", "tʃa"),
        Rule("ఛ", "tʃʰa"),
        Rule("జ", "dʒa"),
        Rule("ఝ", "dʒʱa"),
        Rule("ఞ", "ɲa"),
        Rule("ట", "ʈa"),
        Rule("ఠ", "ʈʰa"),
        Rule("డ", "ɖa"),
        Rule("ఢ", "ɖʱa"),
        Rule("ణ", "ɳa"),
        Rule("త", "ta"),
        Rule("థ", "tʰa"),
        Rule("ద", "da"),
        Rule("ధ", "dʱa"),
        Rule("న", "na"),
        Rule("ప", "pa"),
        Rule("ఫ", "pʰa"),
        Rule("బ", "ba"),
        Rule("భ", "bʱa"),
        Rule("మ", "ma"),
        Rule("య", "ja"),
        Rule("ర", "ra"),
        Rule("ల", "la"),
        Rule("వ", "ʋa"),
        Rule("ళ", "ɭa"),
        Rule("శ", "ʃa"),
        Rule("ష", "ʂa"),
        Rule("స", "sa"),
        Rule("హ", "ha"),
        Rule("ఱ", "ɽa"),

        //vowels
        Rule("[అ]", {l(it)+"a"}),
        Rule("[ఆా]", {l(it)+"aː"}),
        Rule("[ఇి]", {l(it)+"i"}),
        Rule("[ఈీ]", {l(it)+"iː"}),
        Rule("[ఉు]", {l(it)+"u"}),
        Rule("[ఊూ]", {l(it)+"uː"}),
        Rule("[ఋృ]", {l(it)+"ru"}),
        Rule("[ౠౄ]", {l(it)+"ruː"}),
        Rule("[ఌౢ]", {l(it)+"alu"}),
        Rule("[ౡౣ]", {l(it)+"alu:"}),
        Rule("[ఎె]", {l(it)+"e"}),
        Rule("[ఏే]", {l(it)+"eː"}),
        Rule("[ఐై]", {l(it)+"aj"}),
        Rule("[ఒొ]", {l(it)+"o"}),
        Rule("[ఓో]", {l(it)+"oː"}),
        Rule("[ఔౌ]", {l(it)+"aw"}),

        Rule("్", {l(it)}),

        Rule("","")
    )

    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, ::reportOnceAndCopy)
    }
}