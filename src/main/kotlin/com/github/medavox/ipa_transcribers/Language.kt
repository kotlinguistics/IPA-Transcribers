package com.github.medavox.ipa_transcribers

//todo:re-evaluate language speakers to include L2 speakers
//indo-aryan languages and their scripts:
//hindi     Devanagari
//urdu      Perso-Arabic
//bengali   Unique brahmic abugida (unstandardised)
//punjabi   Shahmukhi=Perso-Arabic (punjabi muslims), Gurmukhi = Unique Brahmic abugida (punjabi Hindus & Sikhs)
//telugu    Unique brahmic abugida (brahmi-derived)
//marathi   Devanagari (Balbodh)
//tamil     Unique brahmic abugida
//Persian/Farsi/Dari/Tajiki Perso-Arabic
sealed class Language {
    object MandarinChinese:Language()
    object CantoneseChinese:Language()
    object PeninsularSpanish:Language()//DONE rule-based
    object PanAmericanSpanish:Language()//DONE rule-based

    object BritishEnglish:Language()//ineligible for rule-based.
    object AmericanEnglish:Language()//ineligible for rule-based.

    //I intend this to mean classical Arabic which, thanks to the Qu'ran,
    // should be understood by most arabic dialect speakers
    object Arabic : Language()//ineligible for pure rule-based, as orthography usually does not include vowels.
    //3 possibilities:
    //1. give up on transcribing the vowels; they vary a lot anyway, by semitic conjugation
    //2. Transcribe Google Translate's arbitrary arabic pronunciation guide for english speakers,
    //which likely has dictionary-lookup hints for common words.
    //3. Contact Dr Claire Brierley of Leeds University and ask for copy of her research group's
    // IPA transcription software for Modern Standard Arabic.


    object Hindi : Language()//rule-based is possible,
    // but apparently the orthography has become out-of-date with pronunciation.
    object Bengali : Language()
    object EuropeanPortuguese : Language()//unknown. Probably fairly regular spelling, given a near-creolisation event
    object BrazilianPortuguese : Language()//unknown. Probably fairly regular spelling, given a near-creolisation event
    //and the relatively large number of uneducated speakers in the language's past.
    object Russian : Language()//DONE scraper. Rule-based eligible,
    // though expect some spelling irregularities, given the long period of Russian linguistic stability.
    object Japanese : Language()//DONE scraper. Ineligible for rule-based:
    // The most common writing system (Kanji) doesn't record pronunciation. Or at least, not directly.
    object Punjabi : Language() //listed on Ethnologue as Lahnda with related dialects

    object Swahili:Language()

    //according to wikipedia, "Most speakers of Javanese also speak Indonesian".
    object IndonesianMalay:Language()
    // but I've excluded them here.
    object Javanese : Language()//Uses the latin script, presumably imposed on it during colonial times.
    //or the language is a colonial creole of a eurooean and a 'native' language.
    // Either way, high chance of spelling regularity
    object Turkish : Language()//DONE rule-based, needs refinement. very eligible for rule-based;
    //systemically adopted latin characters around 1900.

    object Korean : Language()//IN PROGRESS rule-based. syllable-final consonants need finishing.
    //beautiful regular alphabet. Only issue is text support for hangul syllable-blocks was once bad,
    //so there are some grandfathered irregularities in computer support.

    object French : Language()//DONE scraper. West European Colonial Language;
    // probably eligible for rule-based to a varying degree, depending on cultural factors
    //1. cultural preference between linguistic conservation and progress:
    // strong conservative tradition. L'academie Française does sometimes update spellings  however
    //2. influence of colonial speakers on the mother language:
    // little influence, barring loanwords
    //3. degree of education of speakers:
    // high education, meaning they remember lots of irregularities.
    //verdict: probably irregular

    object German : Language()//West European Colonial Language;
    // probably eligible for rule-based to a varying degree, depending on cultural factors:
    //1. cultural preference between linguistic conservation and progress:
    // I'd say fairly progressive? replacement of ß with ss is taking hold, and english loanwords are prevalent
    //2. influence of colonial speakers on the mother language:
    // DACH countries had little influence colonially, so no feedback from the colonies there
    //3. degree of education of speakers:
    // high education, meaning they remember lots of irregularities.
    //verdict: fairly regular, but known to have lots of variants
    object Telugu : Language()
    object Marathi : Language()
    object Urdu : Language()
    object Vietnamese : Language()
    object Tamil : Language()

    object Italian : Language()

    object Persian : Language()
    object InternationalPhoneticAlphabet : Language()
}
