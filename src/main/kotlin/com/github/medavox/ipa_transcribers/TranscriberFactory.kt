package com.github.medavox.ipa_transcribers

//import com.github.medavox.ipa_transcribers.english.EnglishIpaCambridge
import com.github.medavox.ipa_transcribers.spanish.PanAmericanSpanishIpaRuleBased
import com.github.medavox.ipa_transcribers.Language.*
import com.github.medavox.ipa_transcribers.french.FrenchJsoupEasyPronunciation
import com.github.medavox.ipa_transcribers.japanese.JapaneseJsoupEasyPronunciation
import com.github.medavox.ipa_transcribers.korean.KoreanRuleBased
import com.github.medavox.ipa_transcribers.malay.MalayRuleBased
import com.github.medavox.ipa_transcribers.portuguese.EuropeanPortugueseJsoupEasyPronunciation
import com.github.medavox.ipa_transcribers.russian.RussianJsoupEasyPronunciation
import com.github.medavox.ipa_transcribers.spanish.PeninsularSpanishRuleBased
import com.github.medavox.ipa_transcribers.turkish.TurkishRuleBased

/**Provides instances that each transcribe a specific language and orthography to IPA.*/
object TranscriberFactory {

    /**Get an [Transcriber] instance for the specified language.
     * @param language the language to get an [Transcriber] instance for.
     * If there is no [Transcriber] implementation available for the specified language,
     * A dummy implementation is returned which only returns empty sets.*/
    fun getTranscriber(language: Language): Transcriber<*> {
      //todo:instead of directly transcribing arabic to IPA, try transcribing the google-romanised text to IPA
        return when(language) {
            //is English -> EnglishIpaCambridge()
            PanAmericanSpanish -> PanAmericanSpanishIpaRuleBased
            PeninsularSpanish -> PeninsularSpanishRuleBased
            Turkish -> TurkishRuleBased
            Korean -> KoreanRuleBased
            IndonesianMalay -> MalayRuleBased
            Japanese -> JapaneseJsoupEasyPronunciation
            Russian -> RussianJsoupEasyPronunciation
            French -> FrenchJsoupEasyPronunciation
            EuropeanPortuguese -> EuropeanPortugueseJsoupEasyPronunciation
            else -> UselessDefaultIpaTranscriber()
        }
    }
    private class UselessDefaultIpaTranscriber: Transcriber<Language> {
        override fun transcribe(nativeText: String): String {
            return ""
        }
    }
}