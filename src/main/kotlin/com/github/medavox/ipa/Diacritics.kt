package com.github.medavox.ipa

interface DiacriticFeature {
    val diacritics:Array<Char>
}

enum class PhonationDiacritics(override val diacritics:Array<Char>):DiacriticFeature {
    VOICELESS(arrayOf('̥', '̊')),
    VOICED(arrayOf('̬')),
    BREATHY_VOICED(arrayOf('̤')),
    CREAKY_VOICED(arrayOf('̰'))
}

enum class ArticulationDiacritics(override val diacritics: Array<Char>):DiacriticFeature {
    DENTAL(arrayOf('̪', '͆')),
    LINGUOLABIAL(arrayOf('̼')),
    APICAL(arrayOf('̺')),
    LAMINAL(arrayOf('̻')),
    ADVANCED(arrayOf('̟', '˖')),
    RETRACTED(arrayOf('̠', '˗')),
    CENTRALIZED(arrayOf('̈')),
    MID_CENTRALIZED(arrayOf('̽')),
    RAISED(arrayOf('̝', '˔')),
    LOWERED(arrayOf('̞', '˕'))
}

enum class CoarticulationDiacritics(override val diacritics:Array<Char>):DiacriticFeature {
    //todo: these super-weird ones
//    MORE_ROUNDED(arrayOf('')),
//    LESS_ROUNDED(arrayOf('')),
    LABIALIZED(arrayOf('ʷ')),
    PALATALIZED(arrayOf('ʲ')),
    VELARIZED(arrayOf('ˠ')),
//    PHARYNGEALIZED(arrayOf('')),
//    VERALIZED_OR_PHARYNGEALIZED(arrayOf('')),
//    ADVANCED_TONGUE_ROOT(arrayOf('')),
//    RETRACTED_TONGUE_ROOT(arrayOf('')),
    NASALIZED(arrayOf('̃')),
    RHOTICITY(arrayOf('˞')),
    ;
}
enum class ConsonantReleaseDiacritics(override val diacritics: Array<Char>):DiacriticFeature {
    //todo:these weird ones
    ASPIRATED(arrayOf('ʰ')),
//    NO_AUDIBLE_RELEASE(),
//    NASAL_RELEASE(),
//    LATERAL_RELEASE(),
//    VOICELESS_DENTAL_FRICATIVE_RELEASE(),
//    VOICELESS_VELAR_FRICATIVE_RELEASE(),
    MID_CENTRAL_VOWEL_RELEASE(arrayOf('ᵊ')),//from the accent of other kids in my childhood: "dowunt-uh!"
}

enum class SyllabicityDiacritics(override val diacritics: Array<Char>):DiacriticFeature {
    SYLLABIC(arrayOf('̩', '̍')),
    NON_SYLLABIC(arrayOf('̯', '̑'))
}

data class Diacritics(val consonantReleaseDiacritics: ConsonantReleaseDiacritics?=null,
                      val syllabicityDiacritics: SyllabicityDiacritics?=null,
                      val coarticulationDiacritics: CoarticulationDiacritics?=null,
                      val phonationDiacritics: PhonationDiacritics?=null,
                      val articulationDiacritics: ArticulationDiacritics?=null)
