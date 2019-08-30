package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.arabic.*
import com.github.medavox.ipa_transcribers.asian_unique.*
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
    ARABIC("Arabic", ArabicRuleBased),
    BENGALI("Bengali", BengaliRuleBased),
    ENGLISH("English", EnglishRuleBased),
    GERMAN("German", GermanRuleBased),
    HINDI("Hindi", HindiRuleBased),
    ITALIAN("Italian", ItalianRuleBased),
    JAPANESE_LIMITED("Japanese/Katakana & Hiragana Only", JapaneseRuleBasedKatakanaHiraganaOnly),
    KOREAN("Korean", KoreanRuleBased),
    MARATHI("Marathi", MarathiRuleBased),
    MALAY("Malay", MalayRuleBased),
    PERSIAN("Persian", PersianRuleBased),
    RUSSIAN("Russian",RussianRuleBased),
    SPANISH_EUROPEAN("Spanish/European", SpanishPeninsularRuleBased),
    SPANISH_AMERICAN("Spanish/PanAmerican", SpanishPanAmericanRuleBased),
    SWAHILI("Swahili", SwahiliRuleBased),
    TELUGU("Telugu", TeluguRuleBased),
    TURKISH("Turkish", TurkishRuleBased)
}