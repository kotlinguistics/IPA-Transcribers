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

enum class Vowel(
    /**This would be a [Char],
     * but Kotlin considers diacritic marks to be separate characters.
     * So marked vowels like ̞e are considered two characters,
     * meaning they are not a valid Char (in the eyes of kotlin).
     *
     * It's an array because some vowels have multiple symbol variants,
     * from historical changes and nonstandard usage*/
    val symbols:Array<String>,
    val height: Height,
    val backness: Backness,
    val rounded:Boolean=false,
    /**Any other features, marked by diacritics.*/
    val features:Diacritics = Diacritics()
) {
    //FRONT VOWELS
    CLOSE_FRONT_UNROUNDED(arrayOf("i" ), CLOSE, FRONT),
    CLOSE_FRONT_ROUNDED(arrayOf("y" ), CLOSE, FRONT, true),

    NEAR_CLOSE_FRONT_UNROUNDED(arrayOf("ɪ" ), NEAR_CLOSE, FRONT),
    NEAR_CLOSE_FRONT_ROUNDED(arrayOf("ʏ" ), NEAR_CLOSE, FRONT, true),

    CLOSE_MID_FRONT_UNROUNDED(arrayOf("e" ), CLOSE_MID, FRONT),
    CLOSE_MID_FRONT_ROUNDED(arrayOf("ø" ), CLOSE_MID, FRONT, true),

    MID_FRONT_UNROUNDED(arrayOf("̞e", "̝ɛ" ), MID, FRONT),
    MID_FRONT_ROUNDED(arrayOf("̞ø", "̝œ" ), MID, FRONT, true),

    OPEN_MID_FRONT_UNROUNDED(arrayOf("ɛ" ), OPEN_MID, FRONT),
    OPEN_MID_FRONT_ROUNDED(arrayOf("œ" ), OPEN_MID, FRONT, true),

    NEAR_OPEN_FRONT_UNROUNDED(arrayOf("æ", "̝a" ), NEAR_OPEN, FRONT),

    OPEN_FRONT_UNROUNDED(arrayOf("a", "̟a", "̞æ" ), OPEN, FRONT),
    OPEN_FRONT_ROUNDED(arrayOf("ɶ" ), CLOSE_MID, FRONT, true),


    //CENTRAL VOWELS
    CLOSE_CENTRAL_UNROUNDED(arrayOf("ɨ", "ï", "̈ɯ" ), CLOSE, CENTRAL),
    CLOSE_CENTRAL_ROUNDED(arrayOf("ʉ" ), CLOSE, CENTRAL, true),

    NEAR_CLOSE_CENTRAL_UNROUNDED(arrayOf("̞ɨ" ), NEAR_CLOSE, CENTRAL),
    NEAR_CLOSE_CENTRAL_ROUNDED(arrayOf("̞ʉ", "ü" ), NEAR_CLOSE, CENTRAL, true),

    CLOSE_MID_CENTRAL_UNROUNDED(arrayOf("ɘ", "ë", "̈ɤ", "̝ə" ), CLOSE_MID, CENTRAL),
    CLOSE_MID_CENTRAL_ROUNDED(arrayOf("ɵ", "ö" ), CLOSE_MID, CENTRAL, true),

    //all hail the immortal schwa!
    SCHWA(arrayOf("ə"),MID, CENTRAL, false),

    OPEN_MID_CENTRAL_UNROUNDED(arrayOf("ɜ", "̈ɛ", "̞ə", "̝ɐ" ), OPEN_MID, CENTRAL),
    OPEN_MID_CENTRAL_ROUNDED(arrayOf("ɞ", "̈ɔ" ), OPEN_MID, CENTRAL, true),

    NEAR_OPEN_CENTRAL_UNROUNDED(arrayOf("ɐ" ), NEAR_OPEN, CENTRAL),

    OPEN_CENTRAL_UNROUNDED(arrayOf("ä","̠a", "̈ɑ", "̞ɐ" ), OPEN, CENTRAL),
    OPEN_CENTRAL_ROUNDED(arrayOf("̈ɒ", "̈ɶ" ), OPEN, CENTRAL, true),


    //BACK VOWELS
    CLOSE_BACK_UNROUNDED(arrayOf("ɯ" ), CLOSE, BACK),
    CLOSE_BACK_ROUNDED(arrayOf("u" ), CLOSE, BACK, true),

    NEAR_CLOSE_BACK_UNROUNDED(arrayOf("̞ɯ", "̝ɤ", "̽ɯ" ), NEAR_CLOSE, BACK),
    NEAR_CLOSE_BACK_ROUNDED(arrayOf("ʊ" ), NEAR_CLOSE, BACK, true),

    CLOSE_MID_BACK_UNROUNDED(arrayOf("ɤ" ), CLOSE_MID, BACK),
    CLOSE_MID_BACK_ROUNDED(arrayOf("o" ), CLOSE_MID, BACK, true),

    MID_BACK_UNROUNDED(arrayOf("̞ɤ", "̝ʌ" ), MID, BACK),
    MID_BACK_ROUNDED(arrayOf("̞o", "̝ɔ" ), MID, BACK, true),

    OPEN_MID_BACK_UNROUNDED(arrayOf("ʌ" ), OPEN_MID, BACK),
    OPEN_MID_BACK_ROUNDED(arrayOf("ɔ" ), OPEN_MID, BACK, true),

    OPEN_BACK_UNROUNDED(arrayOf("ɑ" ), OPEN, BACK),
    OPEN_BACK_ROUNDED(arrayOf("ɒ", "̞ɔ" ), CLOSE, BACK, true),
}



