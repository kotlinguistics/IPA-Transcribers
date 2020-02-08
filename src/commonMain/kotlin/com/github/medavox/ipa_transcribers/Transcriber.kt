package com.github.medavox.ipa_transcribers

/**Converts text in a language's native orthography,
 * into a broad IPA transcription where possible.
 *
 *  The aim here is not to capture the nuances of every dialect/accent of a language;
 *  but rather to provide the pronunciation of a standard or prestige dialect(s)
 *  that every speaker should be able to understand.
 *
 *  For instance, English IPA transcribers should provide American English and British English
 *  transcriptions, but ignore
 *  Irish, Scottish, Texan, Indian, African, Australian, New Zealand, South African and International variants.*/
interface Transcriber {
    fun transcribe(nativeText:String):String
}