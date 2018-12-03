package com.github.medavox.ipa_transcribers

/**Converts text in the native orthography of a language,
 * into a collection of broad IPA transcriptions for important language variants.
 *
 *  The aim here is not to capture the nuances of every dialect/accent of a language;
 *  but rather to provide the pronunciation of a standard or prestige dialect(s)
 *  that every speaker should be able to understand.
 *
 *  For instance, English IPA transcribers should provide American English and British English
 *  transcriptions, but ignore Irish, Scottish, Texan, Indian, African, and International variants.
 *
 *  To get an instance for a particular language,
 *  call [TranscriberFactory.getTranscriberForLang]*/
interface IpaTranscriber {
    fun transcribeToIpa(nativeText:String):Set<Variant>
}