package com.github.medavox.ipa_transcribers

interface IpaTranscriber {
    fun transcribeToIpa(nativeText:String):Set<Variant>
}