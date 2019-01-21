package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.english.EnglishIpaCambridge
import com.github.medavox.ipa_transcribers.spanish.SpanishIpaRuleBased

/**Provides instances that each transcribe a specific language and orthography to IPA.*/
object TranscriberFactory {

    /**Get an [Transcriber] instance for the specified language.
     * @param language the language to get an [Transcriber] instance for.
     * If there is no [Transcriber] implementation available for the specified language,
     * A dummy implementation is returned which only returns empty sets.*/
    fun getTranscriberForLang(language: Language): Transcriber {
      //todo:instead of directly transcribing arabic to IPA, try transcribing the google-romanised text to IPA
        return when(language) {
            Language.English -> EnglishIpaCambridge()
            Language.Spanish -> SpanishIpaRuleBased()
            else -> UselessDefaultIpaTranscriber()
        }
    }
    private class UselessDefaultIpaTranscriber: Transcriber {
        override fun transcribe(nativeText: String): Set<Variant> {
            return setOf()
        }
    }
}