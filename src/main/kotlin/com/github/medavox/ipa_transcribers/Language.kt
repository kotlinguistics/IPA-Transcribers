package com.github.medavox.ipa_transcribers

enum class Language(val code: String) {
    English ("en"),
    Arabic ("ar"), //I intend this to mean Classical Arabic which, thanks to the Qu'ran,
    // should be understood by most arabic dialect speakers
    Hindi ("hi"),
    Bengali ("bn"),
    Portuguese ("pt"),
    Punjabi ("pa"), //listed on Ethnologue as Lahnda with related dialects,
    // but I've excluded them here.
    Javanese ("jw"),
    Turkish ("tr"),
    Telugu ("te"),
    Marathi ("mr"),
    Urdu ("ur"),
    Tamil ("ta"),
    Persian ("fa"),
}