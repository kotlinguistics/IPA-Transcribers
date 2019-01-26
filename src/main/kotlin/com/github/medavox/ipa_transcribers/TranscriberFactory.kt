package com.github.medavox.ipa_transcribers

//import com.github.medavox.ipa_transcribers.english.EnglishIpaCambridge
import com.github.medavox.ipa_transcribers.spanish.SpanishIpaRuleBased
import com.github.medavox.ipa_transcribers.Language.*

/**Provides instances that each transcribe a specific language and orthography to IPA.*/
object TranscriberFactory {

    /**Get an [Transcriber] instance for the specified language.
     * @param language the language to get an [Transcriber] instance for.
     * If there is no [Transcriber] implementation available for the specified language,
     * A dummy implementation is returned which only returns empty sets.*/
    fun getTranscriberForLang(language: Class<Language>): Transcriber<*> {
      //todo:instead of directly transcribing arabic to IPA, try transcribing the google-romanised text to IPA
        return when(language) {
            //is English -> EnglishIpaCambridge()
            is Spanish -> SpanishIpaRuleBased()
            else -> UselessDefaultIpaTranscriber()
        }
    }
    private class UselessDefaultIpaTranscriber: Transcriber<Language> {
        override fun transcribe(nativeText: String): Map<Language, String> {
            return mapOf()
        }
    }
}