package com.github.medavox.ipa_transcribers.arabic

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**Persian, like Modern Standard Arabic, does not write short vowels.
 * This means that any transcription system that relies solely on the orthography (such as this one)
 * *cannot* produce a complete transcription.
 *
 * A lookup dictionary wouldn't even solve this problem. According to Wikipedia:
 *
 * >words distinguished from each other only by short vowels are ambiguous in writing:
 * >Western Persian kerm "worm", karam "generosity", kerem "cream",
 * >and krom "chrome" are all spelled krm (کرم) in Persian
 *
 * "Context" is necessary for first working out which word the vowel-less spelling refers to;
 * and context is no simple thing, requiring tools more complex than regex matching.
 *
 * Even so, this transcriber does the best job possible,
 * given the information that *has* been recorded in the orthography.*/
object PersianRuleBased:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS

    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(persoArabicBaseRules, reportAndCopy)
    }
}