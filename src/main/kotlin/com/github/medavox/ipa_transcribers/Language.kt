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

data class VariantRule<T : Language>(
    /**The native text that this rule operates on.*/
    val matcher: Regex,
    /**Define a different string output for each (major) variant of the language.*/
    val variantOutputs: Map<Variant<T>, String>,
    /**the output to use for Variants not defined in [variantOutputs].*/
    val defaultOutput: String? = null,
    val lettersConsumed: Int? = null
) : GenericRule(matcher, lettersConsumed)

data class Rule(
    /**The native text that this rule operates on.*/
    val matcher: Regex,
    /**A lambda which returns the text to append to the output string.
     * Use this constructor if your rule has side effects, such as counting vowels so far.*/
    val outputString: () -> String,
    /**The number of letters of native text that have been 'consumed'.
     * if not specified, defaults to the size of the Regex match.*/
    val lettersConsumed: Int? = null)
        :GenericRule(matcher, lettersConsumed)
{
    constructor(
        /**The native text that this rule operates on.*/
        matcher: Regex,
        /**The text to append to the output string*/
        outputString: String,
        /**The number of letters of native text that have been 'consumed'.
         * if not specified, defaults to the size of the Regex match.*/
        lettersConsumed: Int? = null)
            : this(matcher, { outputString }, lettersConsumed)
}

val gob:GenericRule = VariantRule<English>(Regex("lol"), mapOf(Variant.British to "no"), "yes")