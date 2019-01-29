package com.github.medavox.ipa_transcribers

//sealed class PluricentricLanguage(code:String):Language(code) {
import com.github.medavox.ipa_transcribers.PluricentricLanguage.*

sealed class GenericLanguage(val code: String)

/**Languages with only one standard variant internationally.
 * Most languages have plenty of regional and social variants, but I'm not counting them here.*/
sealed class Language(code: String):GenericLanguage(code) {
    object Arabic : Language("ar") //I intend this to mean classical Arabic which, thanks to the Qu'ran,
    // should be understood by most arabic dialect speakers
    object Hindi : Language("hi")
    object Bengali : Language("bn")
    object Portuguese : Language("pt")
    object Russian : Language("ru")
    object Japanese : Language("ja")
    object Punjabi : Language("pa") //listed on Ethnologue as Lahnda with related dialects,
    // but I've excluded them here.
    object Javanese : Language("jw")
    object Turkish : Language("tr")
    object Korean : Language("ko")
    object French : Language("fr")
    object German : Language("de")
    object Telugu : Language("te")
    object Marathi : Language("mr")
    object Urdu : Language("ur")
    object Vietnamese : Language("vi")
    object Tamil : Language("ta")
    object Italian : Language("it")
    object Persian : Language("fa")
    object InternationalPhoneticAlphabet : Language("ipa")
}

/**Languages with multiple internationally-accepted standard versions.*/
sealed class PluricentricLanguage(code:String):GenericLanguage(code) {
    //a PluricentricLanguage implementor has to have a variant object which implements Variant<ThatLanguage>
    //the only implementor of this is a data class with every variant as a required field
    //but how can the RuleProcessor iterate through properties?
    object Spanish : PluricentricLanguage("es")
    object English : PluricentricLanguage("en")
}

sealed class VariantsOutput<T:PluricentricLanguage> {
    data class SpanishVariants(val Peninsular: String, val PanAmerican: String): VariantsOutput<Spanish>()
    data class EnglishVariants(val British: String, val American: String): VariantsOutput<English>()
}