package com.github.medavox.ipa_transcribers

/**Specifies one replacement rule, from a Regex matching native text,
 * to the IPA characters corresponding to them.
 * Required features:
[ / ] optionally specify number of letters consumed, if different from match length
[ / ] (per-rule) either a string or lambda. The lambba can access state persisting across whole word
[ / ] lambda on no rule matched
[ / ] support for multiple simultaneous output variants, eg british and american english
[ / ] transcribe() function can return just a String for languages with only one variant

In Russian, we need to know the previous consonant to check if it can be softened;
but we also need to print out the following vowel so we don't reprocess it again as a word-initial.

this would mean one rule for every pair of softenable consonant + softening vowel,
or 5 * 15 = 75 rules.

this is bad, because it doesn't scale for languages with even more combination sounds.

So instead we need to be able to 'look back' at previous, consumed letters -- preferably in a Regex-friendly way.
instead of feeding the chopped-off string (with the characters consumed so far removed) to one regex,
we have to match regexes on two strings: the consumed-so-far characters AND the unconsumed characters.
The regex for the consumed-so-far string is optional.

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

    fun asKotlin():String {
        return "Rule("+
                (if(consumedMatcher==null) "" else "\"$consumedMatcher\", ")+
                "\"$unconsumedMatcher\", "+
                "\""+outputString("")+"\""+
                (if(lettersConsumed==null) "" else ", $lettersConsumed")+
                ")"
    }
}
//private val anything = Regex("[\\s\\S]*")