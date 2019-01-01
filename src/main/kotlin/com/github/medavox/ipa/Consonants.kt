package com.github.medavox.ipa

import com.github.medavox.ipa.Manner.*
import com.github.medavox.ipa.Place.*

enum class Manner {
    STOP_PLOSIVE,
    NASAL,
    FRICATIVE,
    APPROXIMANT,
    TAP_OR_FLAP,
    TRILL,
    LATERAL_FRICATIVE,
    LATERAL_APPROXIMANT,
    LATERAL_TAP_FLAP,


}

enum class Place {
    //labial
    BILABIAL,
    LABIO_DENTAL,
    LINGUO_LABIAL,

    //coronal
    DENTAL,
    ALVEOLAR,
    POST_ALVEOLAR,
    RETROFLEX,

    //dorsal
    PALATAL,
    VELAR,
    UVULAR,

    //laryngeal
    PHARYNGEAL_EPIGLOTTAL,
    GLOTTAL
}

enum class PulmonicConsonants(ipaSymbol:String,
                              placeOfArticulation:Place,
                              mannerOfArticulation:Manner,
                              voiced:Boolean) {
    ubs("p", BILABIAL, STOP_PLOSIVE, false),
    vbs("b", BILABIAL, STOP_PLOSIVE, true),


}