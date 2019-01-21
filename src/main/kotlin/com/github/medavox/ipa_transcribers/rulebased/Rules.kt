package com.github.medavox.ipa_transcribers.rulebased

import com.github.medavox.ipa_transcribers.Language
import com.github.medavox.ipa_transcribers.Variant


/**Specifies one replacement rule, from a Regex matching native text,
 * to the IPA characters corresponding to them.
 * Required features:
[ / ] optionally specify number of letters consumed, if different from match length
[ / ] (per-rule) either a string or lambda. The lambba can access state persisting across whole word
[   ] lambda on no rule matched
[ / ] support for multiple simultaneous output variants, eg british and american english*/
interface GenericRule {
    val matcher:Regex
    val lettersConsumed: Int?
}

data class VariantRule<T : Language>(
    /**The native text that this rule operates on.*/
    override val matcher: Regex,
    /**Define a different string output for each (major) variant of the language.*/
    val variantOutputs: Map<Variant<T>, String>,
    /**(Optional) the output to use for Variants not defined in [variantOutputs].
     * consider this like an if-statement,
     * when a rule has a default that applies to varieties other than those listed in [variantOutputs]*/
    val defaultOutput: String? = null,
    override val lettersConsumed: Int? = null
) : GenericRule

data class Rule(
    /**The native text that this rule operates on.*/
    override val matcher: Regex,
    /**A lambda which returns the text to append to the output string.
     * Use this constructor if your rule has side effects, such as counting vowels so far.*/
    val outputString: () -> String,
    /**The number of letters of native text that have been 'consumed'.
     * if not specified, defaults to the size of the Regex match.*/
    override val lettersConsumed: Int? = null) :GenericRule
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