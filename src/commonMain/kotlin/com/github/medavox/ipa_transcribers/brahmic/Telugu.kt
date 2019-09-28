package com.github.medavox.ipa_transcribers.brahmic

import com.github.medavox.ipa_transcribers.*

object Telugu:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.INCOMPLETE

    private fun l(it:String):String{
        return if(it.endsWith("a")) it.substring(0, it.length-1) else it
    }

    private val rules:List<IRule> = listOf(
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
        RevisingRule("[అ]", {l(it)+"a"}),
        RevisingRule("[ఆా]", {l(it)+"aː"}),
        RevisingRule("[ఇి]", {l(it)+"i"}),
        RevisingRule("[ఈీ]", {l(it)+"iː"}),
        RevisingRule("[ఉు]", {l(it)+"u"}),
        RevisingRule("[ఊూ]", {l(it)+"uː"}),
        RevisingRule("[ఋృ]", {l(it)+"ru"}),
        RevisingRule("[ౠౄ]", {l(it)+"ruː"}),
        RevisingRule("[ఌౢ]", {l(it)+"alu"}),
        RevisingRule("[ౡౣ]", {l(it)+"alu:"}),
        RevisingRule("[ఎె]", {l(it)+"e"}),
        RevisingRule("[ఏే]", {l(it)+"eː"}),
        RevisingRule("[ఐై]", {l(it)+"aj"}),
        RevisingRule("[ఒొ]", {l(it)+"o"}),
        RevisingRule("[ఓో]", {l(it)+"oː"}),
        RevisingRule("[ఔౌ]", {l(it)+"aw"}),

        RevisingRule("్", {l(it)}),

        Rule("","")
    )

    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, ::reportOnceAndCopy)
    }
}