package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**Transcriber for the Brazilian variety of Portuguese*/
object PortugueseBrazilian:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.UNSTARTED

    override fun transcribe(nativeText: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}