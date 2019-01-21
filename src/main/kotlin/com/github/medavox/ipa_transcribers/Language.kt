package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.Language.*

sealed class Language(val code: String) {
    class Spanish : Language("es")
    class English : Language("en")
    class Arabic : Language("ar") //I intend this to mean Classical Arabic which, thanks to the Qu'ran,
    // should be understood by most arabic dialect speakers
    class Hindi : Language("hi")
    class Bengali : Language("bn")
    class Portuguese : Language("pt")
    class Russian : Language("ru")
    class Japanese : Language("ja")
    class Punjabi : Language("pa") //listed on Ethnologue as Lahnda with related dialects,
    // but I've excluded them here.
    class Javanese : Language("jw")
    class Turkish : Language("tr")
    class Korean : Language("ko")
    class French : Language("fr")
    class German : Language("de")
    class Telugu : Language("te")
    class Marathi : Language("mr")
    class Urdu : Language("ur")
    class Vietnamese : Language("vi")
    class Tamil : Language("ta")
    class Italian : Language("it")
    class Persian : Language("fa")
}

sealed class Variant<Language> {
    object All : Variant<Language>()

    object British : Variant<English>()
    object American : Variant<English>()

    object Peninsular : Variant<Spanish>()
    object PanAmerican : Variant<Spanish>()
}

sealed class GenericRule(matcher:Regex, lettersConsumed: Int?)

class  VariantRule<T:Language>(val matcher:Regex,
                               vararg val variantOutputs:Map.Entry<Variant<T>, String>,
                               lettersConsumed: Int?=null):GenericRule(matcher, lettersConsumed)

data class Rool(val matcher:Regex, val outputString:() -> String, val lettersConsumed:Int?=null ):GenericRule(matcher, lettersConsumed) {
    constructor(matcher:Regex, outputString: String, lettersConsumed:Int?=null)
            :this(matcher, {outputString}, lettersConsumed)
}
