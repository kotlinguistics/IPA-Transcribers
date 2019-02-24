package com.github.medavox.ipa_transcribers

/**Specifies one replacement rule, from a Regex matching native text,
 * to the IPA characters corresponding to them.
 * Required features:
[ / ] optionally specify number of letters consumed, if different from match length
[ / ] (per-rule) either a string or lambda. The lambba can access state persisting across whole word
[ / ] lambda on no rule matched
[ / ] support for multiple simultaneous output variants, eg british and american english
[ / ] transcribe() function can return just a String for languages with only one variant
 @constructor primary constructor
 @property consumedMatcher
 */
data class Rule(
    /**If specified, BOTH matchers must match*/
    val consumedMatcher:Regex?,
    /**The native text that this rule operates on.*/
    val unconsumedMatcher: Regex,
    /**A lambda which returns the text to append to the output string.
     * Use this constructor if your rule has side effects, such as counting vowels so far.*/
    val outputString: (soFar:String) -> String,
    /**The number of letters of native/input text that have been 'consumed'.
     * if not specified, defaults to the size of the Regex match.*/
    val lettersConsumed: Int? = null)
{
    /**@param outputString The text to append to the output string*/
    constructor(matcher: Regex, outputString: String, lettersConsumed: Int? = null)
            :this(null, matcher, { it+outputString }, lettersConsumed)

    constructor(match:String, outputString:String, lettersUsed:Int? = null)
            :this(null, Regex(match), {it+outputString}, lettersUsed)

    constructor(match:String, outputString:(soFar:String) -> String, lettersUsed:Int? = null)
            :this(null, Regex(match), outputString, lettersUsed)

    constructor(consumedMatcher:Regex, unconsumedMatcher:Regex, output:String, lettersConsumed:Int?=null )
            :this(consumedMatcher, unconsumedMatcher, {it+output}, lettersConsumed)

    constructor(consumedMatcher:String, unconsumedMatcher:String, output:String, lettersConsumed:Int?=null )
            :this(Regex(consumedMatcher), Regex(unconsumedMatcher), {it+output}, lettersConsumed)
}
//private val anything = Regex("[\\s\\S]*")