package com.github.medavox.ipa_transcribers



object TranscriberFactory {
    fun getTranscriberForLang(language: Language): IpaTranscriber {
        return when(language) {
            Language.English -> EnglishIpaCambridge()
            else -> UselessDefaultIpaTranscriber()
        }
    }
    private class UselessDefaultIpaTranscriber: IpaTranscriber {
        override fun transcribeToIpa(nativeText: String): Set<Variant> {
            return setOf()
        }
    }
}