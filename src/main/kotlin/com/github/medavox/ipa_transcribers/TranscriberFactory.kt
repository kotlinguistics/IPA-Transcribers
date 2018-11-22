package com.github.medavox.ipa_transcribers



object TranscriberFactory {
    fun getTranscriberForLang(language: Language): IpaTranscriber {
        return when(language) {
            else -> UselessDefaultIpaTranscriber()
        }
    }
    private class UselessDefaultIpaTranscriber: IpaTranscriber {
        override fun transcribeToIpa(nativeText: String): String {
            return nativeText
        }
    }
}