package com.github.medavox.ipa_transcribers.malay

import com.github.medavox.ipa_transcribers.Language.IndonesianMalay
import com.github.medavox.ipa_transcribers.Transcriber
import com.github.medavox.ipa_transcribers.baserules.BaseScriptRules
import com.github.medavox.ipa_transcribers.rulesystem.Rule
import com.github.medavox.ipa_transcribers.rulesystem.RuleProcessor

object MalayRuleBased:Transcriber<IndonesianMalay>, RuleProcessor<IndonesianMalay> {
    val rules:List<Rule> = listOf(
        Rule("c", "t͡ʃ"),
        Rule("j", "d͡ʒ"),
        Rule("ai", "ai̯"),
        Rule("au", "au̯"),
        Rule("oi", "oi̯̯"),//or ʊi
        Rule("gh", "ɣ"),// or x
        Rule("kh", "x"),
        Rule("ng", "ŋ"),
        Rule("ny", "ɲ"),
        Rule("sy", "ʃ")
    ) + BaseScriptRules.latinBaseRules
    override fun transcribe(nativeText: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}