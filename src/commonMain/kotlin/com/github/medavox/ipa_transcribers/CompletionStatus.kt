package com.github.medavox.ipa_transcribers

enum class CompletionStatus {

    /**There is no transcriber for this language/orthography.*/
    UNSTARTED,

    /**This transcriber is not complete, and is not currently being worked on.*/
    INCOMPLETE,

    /**This transcriber is not yet complete, and is currently under construction.
     * Some letters may not yet be handled etc.*/
    IN_PROGRESS,

    /**Pronunciation rules for single letters and simple digraphs have been implemented:
     * There is at least one rule for every character in the orthography.
     * However, more complex linguistic rules not directly represented in the orthography are as-yet
     * unimplemented.*/
    SURFACE_LEVEL_COMPLETE,

    /**The transcriber transliterates all information available in the native orthography.
     * However this is not a complete rendering of how the word is pronounced,
     * due to the nature of the orthography (eg Arabic without extended diacritics does not record
     * short vowels).
     * */
    COMPLETE_PARTIAL,
    /**The transcriber is considered complete,
     * and should produce IPA transliterations that are accurate.*/
    COMPLETE

}