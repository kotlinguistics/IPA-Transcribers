package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.arabic.*
import com.github.medavox.ipa_transcribers.other.*
import com.github.medavox.ipa_transcribers.brahmic.*
import com.github.medavox.ipa_transcribers.latin.*

//UNSTARTED LANGUAGES

//MandarinChinese
//CantoneseChinese
//BritishEnglish --  ineligible for rule-based.
//AmericanEnglish --  ineligible for rule-based.

/*
Arabic --  ineligible for pure rule-based, as orthography usually does not include vowels.
3 possibilities:
1. give up on transcribing the vowels; they vary a lot anyway, by semitic conjugation
2. Transcribe Google Translate's arbitrary arabic pronunciation guide for english speakers,
which likely has dictionary-lookup hints for common words.
3. Contact Dr Claire Brierley of Leeds University and ask for copy of her research group's
 IPA transcription software for Modern Standard Arabic.
*/

//EuropeanPortuguese --  unknown. Probably fairly regular spelling, given a near-creolisation event
//BrazilianPortuguese --  unknown. Probably fairly regular spelling, given a near-creolisation event
//and the relatively large number of uneducated speakers in the language's past.

//ShahmukhiPunjabi --  listed on Ethnologue as Lahnda with related dialects
//GurmukhiPunjabi --  listed on Ethnologue as Lahnda with related dialects

//IndonesianMalay -- according to wikipedia, "Most speakers of Javanese also speak Indonesian".
//Javanese --  Uses the latin script

/*
French
------

  DONE scraper. West European Colonial Language;
 probably eligible for rule-based to a varying degree, depending on cultural factors
1. cultural preference between linguistic conservation and progress:
 strong conservative tradition. L'academie Française does sometimes update spellings  however
2. influence of colonial speakers on the mother language:
 little influence, barring loanwords
3. degree of education of speakers:
 high education, meaning they remember lots of irregularities.
prediction: probably irregular
*/

/*
German: West European Colonial Language
-------
 probably eligible for rule-based to a varying degree, depending on cultural factors:
1. cultural preference between linguistic conservation and progress:
 I'd say fairly progressive? replacement of ß with ss is taking hold, and english loanwords are prevalent
2. influence of colonial speakers on the mother language:
 DACH countries had little influence colonially, so no feedback from the colonies there
3. degree of education of speakers:
 high education, meaning they remember lots of irregularities.
prediction: fairly regular, but known to have lots of variants
*/

//Telugu -- Unique brahmic abugida
//Marathi -- Devanagari (Balbodh)
//Urdu -- Perso-Arabic
//Vietnamese
//tamil -- Unique brahmic abugida

enum class Language(val neim:String, val transcriber: Transcriber) {
    ARABIC("Arabic", Arabic),
    BENGALI("Bengali", Bengali),
    CHINESE_BOPOMOFO("Chinese Bopomofo (Zhuyin)", ChineseBopomofoZhuyin),
    CHINESE_PINYIN("Chinese Pinyin", ChinesePinyin),
    ENGLISH("English", English),
    FILIPINO_TAGALOG("Filipino/Tagalog", FilipinoTagalog),
    FRENCH("French", French),
    GERMAN("German", German),
    GUJARATI("Gujarati", Gujarati),
    HAUSA("Hausa", Hausa),
    HINDI("Hindi", Hindi),
    INDONESIAN_MALAY("Indonesian//Malay", IndonesianMalay),
    ITALIAN("Italian", Italian),
    JAPANESE_LIMITED("Japanese (Katakana & Hiragana Only)", JapaneseOnlyKatakanaHiragana),
    KOREAN("Korean", KoreanHangeul),
    MALAY("Malay", IndonesianMalay),
    MARATHI("Marathi", Marathi),
    PERSIAN("Persian/Farsi/Dari/Tajik", Persian),
    PORTUGUESE_BRAZILIAN("Portuguese (Brazilian)", PortugueseBrazilian),
    PORTUGUESE_EUROPEAN("Portuguese (European)", PortugueseEuropean),
    PUNJABI_GURMUKHI("Punjabi (Gurmukhi)", PunjabiGurmukhi),
    PUNJABI_SHAHMUKHI("Punjabi (Shahmukhi)", PunjabiShahmukhi),
    RUSSIAN("Russian",RussianCyrillic),
    SPANISH_AMERICAN("Spanish (Pan-American)", SpanishPanAmerican),
    SPANISH_EUROPEAN("Spanish (European)", SpanishPeninsular),
    SWAHILI("Swahili", Swahili),
    TAMIL("Tamil", Tamil),
    TELUGU("Telugu", Telugu),
    THAI("Thai", Thai),
    TURKISH("Turkish", Turkish),
    URDU("Urdu", Urdu),
    VIETNAMESE("Vietnamese", Vietnamese)
}