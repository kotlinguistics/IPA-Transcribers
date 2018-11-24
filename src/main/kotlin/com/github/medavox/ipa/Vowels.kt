package com.github.medavox.ipa

import com.github.medavox.ipa.Backness.*
import com.github.medavox.ipa.Height.*

enum class Height {
    CLOSE,
    NEAR_CLOSE,
    CLOSE_MID,
    MID,
    OPEN_MID,
    NEAR_OPEN,
    OPEN
}

enum class Backness {
    FRONT,
    CENTRAL,
    BACK
}

data class Vowel(
    /**This would be a [Char],
     * but Kotlin considers diacritic marks to be separate characters.
     * So marked vowels like ̞e are considered two characters,
     * meaning they are not a valid Char (in the eyes of kotlin).*/
    val ipa:String,
    val height: Height,
    val backness: Backness,
    val rounded:Boolean=false,
    /**Any other features, marked by diacritics.*/
    val features:Diacritics = Diacritics()
)

fun getQualitiesForIpaVowel(ipa:String): Vowel {
    return when(ipa) {
        //FRONT VOWELS
        "i" -> Vowel(ipa, CLOSE, FRONT)
        "y" -> Vowel(ipa, CLOSE, FRONT, true)

        "ɪ" -> Vowel(ipa, NEAR_CLOSE, FRONT)
        "ʏ" -> Vowel(ipa, NEAR_CLOSE, FRONT, true)

        "e" -> Vowel(ipa, CLOSE_MID, FRONT)
        "ø" -> Vowel(ipa, CLOSE_MID, FRONT, true)

        "̞e", "̝ɛ" -> Vowel(ipa, MID, FRONT)
        "̞ø", "̝œ" -> Vowel(ipa, MID, FRONT, true)

        "ɛ" -> Vowel(ipa, OPEN_MID, FRONT)
        "œ" -> Vowel(ipa, OPEN_MID, FRONT, true)

        "æ", "̝a" -> Vowel(ipa, NEAR_OPEN, FRONT)

        "a", "̟a", "̞æ" -> Vowel(ipa, OPEN, FRONT)
        "ɶ" -> Vowel(ipa, CLOSE_MID, FRONT, true)


        //CENTRAL VOWELS
        "ɨ", "ï", "̈ɯ" -> Vowel(ipa, CLOSE, CENTRAL)
        "ʉ" -> Vowel(ipa, CLOSE, CENTRAL, true)

        "̞ɨ" -> Vowel(ipa, NEAR_CLOSE, CENTRAL)
        "̞ʉ", "ü" -> Vowel(ipa, NEAR_CLOSE, CENTRAL, true)

        "ɘ", "ë", "̈ɤ", "̝ə" -> Vowel(ipa, CLOSE_MID, CENTRAL)
        "ɵ", "ö" -> Vowel(ipa, CLOSE_MID, CENTRAL, true)

        //all hail the immortal schwa!
        "ə" -> Vowel(ipa, MID, CENTRAL, false)

        "ɜ", "̈ɛ", "̞ə", "̝ɐ" -> Vowel(ipa, OPEN_MID, CENTRAL)
        "ɞ", "̈ɔ" -> Vowel(ipa, OPEN_MID, CENTRAL, true)

        "ɐ" -> Vowel(ipa, NEAR_OPEN, CENTRAL)

        "ä","̠a", "̈ɑ", "̞ɐ" -> Vowel(ipa, OPEN, CENTRAL)
        "̈ɒ", "̈ɶ" -> Vowel(ipa, OPEN, CENTRAL, true)


        //BACK VOWELS
        "ɯ" -> Vowel(ipa, CLOSE, BACK)
        "u" -> Vowel(ipa, CLOSE, BACK, true)

        "̞ɯ", "̝ɤ", "̽ɯ" -> Vowel(ipa, NEAR_CLOSE, BACK)
        "ʊ" -> Vowel(ipa, NEAR_CLOSE, BACK, true)

        "ɤ" -> Vowel(ipa, CLOSE_MID, BACK)
        "o" -> Vowel(ipa, CLOSE_MID, BACK, true)

        "̞ɤ", "̝ʌ" -> Vowel(ipa, MID, BACK)
        "̞o", "̝ɔ" -> Vowel(ipa, MID, BACK, true)

        "ʌ" -> Vowel(ipa, OPEN_MID, BACK)
        "ɔ" -> Vowel(ipa, OPEN_MID, BACK, true)

        "ɑ" -> Vowel(ipa, OPEN, BACK)
        "ɒ", "̞ɔ" -> Vowel(ipa, CLOSE, BACK, true)


        else -> Vowel("ə", MID, CENTRAL, false)
    }
}


