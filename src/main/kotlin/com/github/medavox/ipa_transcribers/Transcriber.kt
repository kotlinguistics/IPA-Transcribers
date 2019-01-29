package com.github.medavox.ipa_transcribers

/**Converts text in the native orthography of a language,
 * into a collection of broad IPA transcriptions for important language variants.
 *
 * This API takes a context-free approach:
 * Regex is matched to the start of the string only,
 * and the output String is not interpreted as Regex.
 *
 * Therefore, there is no state held by the Transcriber;
 * only simple substitutions matched bvy Regular expressions may be used.
 *
 *  The aim here is not to capture the nuances of every dialect/accent of a language;
 *  but rather to provide the pronunciation of a standard or prestige dialect(s)
 *  that every speaker should be able to understand.
 *
 *  For instance, English IPA transcribers should provide American English and British English
 *  transcriptions, but ignore Irish, Scottish, Texan, Indian, African, and International variants.
 *
 *  To get an instance for a particular language,
 *  call [TranscriberFactory.getTranscriber]*/
interface Transcriber<T:Language> {
    fun transcribe(nativeText:String):String//:String
}