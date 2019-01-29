package com.github.medavox.ipa_transcribers.rulebased

import com.github.medavox.ipa_transcribers.GenericLanguage


/**Specifies one replacement rule, from a Regex matching native text,
 * to the IPA characters corresponding to them.
 * Required features:
[ / ] optionally specify number of letters consumed, if different from match length
[ / ] (per-rule) either a string or lambda. The lambba can access state persisting across whole word
[   ] lambda on no rule matched
[ / ] support for multiple simultaneous output variants, eg british and american english
[   ] transcribe() function can return just a String for languages with only one variant
 */
interface GenericRule<T : GenericLanguage> {
    /**The native text that this rule operates on.*/
    val matcher:Regex
    /**The number of letters of native text that have been 'consumed'.
     * if not specified, defaults to the size of the Regex match.*/
    val lettersConsumed: Int? get() = null
}

data class VariantRule<T : GenericLanguage>(
    override val matcher: Regex,
    /**Define a different string output for each (major) variant of the language.*/
    //val variantOutputs: Map<Variant<T>, String>,
    override val lettersConsumed: Int? = null,
    /**Will be called once for every defined variant for that language.
     * Use a when-statement to guarantee exhaustive condition handling!*/
    val outputForEveryVariant: (T) -> String
) : GenericRule<T>

data class Rule<T : GenericLanguage>(
    override val matcher: Regex,
    /**A lambda which returns the text to append to the output string.
     * Use this constructor if your rule has side effects, such as counting vowels so far.*/
    val outputString: () -> String,
    override val lettersConsumed: Int? = null) :GenericRule<T>
{
    constructor(
        matcher: Regex,
        /**The text to append to the output string*/
        outputString: String,
        lettersConsumed: Int? = null)
            : this(matcher, { outputString }, lettersConsumed)
}