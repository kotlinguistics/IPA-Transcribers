package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**Transcriber for the European variety of Portuguese,
 * spoken in Portugal (and arguably Galicia)*/
object PortugueseEuropean: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.UNSTARTED

    override fun transcribe(nativeText: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}