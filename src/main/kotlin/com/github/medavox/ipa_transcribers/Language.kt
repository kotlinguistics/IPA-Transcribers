package com.github.medavox.ipa_transcribers

sealed class Language(code: String) {
    object MandarinChinese:Language("zh")
    object CantoneseChinese:Language("zh")
    object PeninsularSpanish:Language("es")//DONE rule-based
    object PanAmericanSpanish:Language("es")//DONE rule-based

    object BritishEnglish:Language("en")//ineligible for rule-based.
    object AmericanEnglish:Language("en")//ineligible for rule-based.

    //I intend this to mean classical Arabic which, thanks to the Qu'ran,
    // should be understood by most arabic dialect speakers
    object Arabic : Language("ar")//ineligible for pure rule-based, as orthography usually does not include vowels.
    //3 possibilities:
    //1. give up on transcribing the vowels; they vary a lot anyway, by semitic conjugation
    //2. Transcribe Google Translate's arbitrary arabic pronunciation guide for english speakers,
    //which likely has dictionary-lookup hints for common words.
    //3. Contact Dr Claire Brierley of Leeds University and ask for copy of her research group's
    // IPA transcription software for Modern Standard Arabic.


    object Hindi : Language("hi")//rule-based is possible,
    // but apparently the orthography has become out-of-date with pronunciation.
    object Bengali : Language("bn")
    object EuropeanPortuguese : Language("pt")//unknown. Probably fairly regular spelling, given a near-creolisation event
    object BrazilianPortuguese : Language("pt")//unknown. Probably fairly regular spelling, given a near-creolisation event
    //and the relatively large number of uneducated speakers in the language's past.
    object Russian : Language("ru")//DONE scraper. Rule-based eligible,
    // though expect some spelling irregularities, given the long period of Russian linguistic stability.
    object Japanese : Language("ja")//DONE scraper. Ineligible for rule-based:
    // The most common writing system (Kanji) doesn't record pronunciation. Or at least, not directly.
    object Punjabi : Language("pa") //listed on Ethnologue as Lahnda with related dialects,

    //according to wikipedia, "Most speakers of Javanese also speak Indonesian".
    object IndonesianMalay:Language("id")
    // but I've excluded them here.
    object Javanese : Language("jw")//Uses the latin script, presumably imposed on it during colonial times.
    //or the language is a colonial creole of a eurooean and a 'native' language.
    // Either way, high chance of spelling regularity
    object Turkish : Language("tr")//DONE rule-based, needs refinement. very eligible for rule-based;
    //systemically adopted latin characters around 1900.

    object Korean : Language("ko")//IN PROGRESS rule-based. syllable-final consonants need finishing.
    //beautiful regular alphabet. Only issue is text support for hangul syllable-blocks was once bad,
    //so there are some grandfathered irregularities in computer support.

    object French : Language("fr")//DONE scraper. West European Colonial Language;
    // probably eligible for rule-based to a varying degree, depending on cultural factors
    //1. cultural preference between linguistic conservation and progress:
    // strong conservative tradition. L'academie Française does sometimes update spellings  however
    //2. influence of colonial speakers on the mother language:
    // little influence, barring loanwords
    //3. degree of education of speakers:
    // high education, meaning they remember lots of irregularities.
    //verdict: probably irregular

    object German : Language("de")//West European Colonial Language;
    // probably eligible for rule-based to a varying degree, depending on cultural factors:
    //1. cultural preference between linguistic conservation and progress:
    // I'd say fairly progressive? replacement of ß with ss is taking hold, and english loanwords are prevalent
    //2. influence of colonial speakers on the mother language:
    // DACH countries had little influence colonially, so no feedback from the colonies there
    //3. degree of education of speakers:
    // high education, meaning they remember lots of irregularities.
    //verdict: fairly regular, but known to have lots of variants
    object Telugu : Language("te")
    object Marathi : Language("mr")
    object Urdu : Language("ur")
    object Vietnamese : Language("vi")
    object Tamil : Language("ta")

    object Italian : Language("it")

    object Persian : Language("fa")
    object InternationalPhoneticAlphabet : Language("ipa")
}
