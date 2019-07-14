package com.github.medavox.ipa_transcribers

/**Specifies one replacement rule, from a Regex matching native text,
 * to the IPA characters corresponding to them.
 *
 *  Features:
 - optionally specify number of letters consumed, if different from match length
 - (per-rule) either a string or lambda. The lambba can access state persisting across whole word
 - lambda on no rule matched
 - support for multiple simultaneous output variants, eg british and american english
 - transcribe() function can return just a String for languages with only one variant

In Russian, we need to know the previous consonant to check if it can be softened;
but we also need to print out the following vowel so we don't reprocess it again as a word-initial.

this would mean one rule for every pair of softenable consonant + softening vowel,
or 5 * 15 = 75 rules.

this is bad, because it doesn't scale for languages with even more combination sounds.

So instead we need to be able to 'look back' at previous, consumed letters -- preferably in a Regex-friendly way.
instead of feeding the chopped-off string (with the characters consumed so far removed) to one regex,
we have to match regexes on two strings: the consumed-so-far characters AND the unconsumed characters.
The regex for the consumed-so-far string is optional.

@Constructor
primary constructor
 @property consumedMatcher
 */
data class Rule(
    /**Matches the already-consumed part of the input string,
     * starting from the most recently consumed character - the end of the used-up input-string.
     * If not null, BOTH matchers must match.*/
    val consumedMatcher:Regex?,
    /**The incoming native text that this rule operates on.*/
    val unconsumedMatcher: Regex,
    /**A lambda which returns the new output string, __replacing the whole of the old output string.__
     * Use this constructor if your rule has side effects, such as counting vowels so far.*/
    val outputString: (soFar:String) -> String,
    /**The number of letters of native/input text that have been 'consumed' by this rule.
     * if not specified, defaults to the size of the Regex match.*/
    val lettersConsumed: Int? = null)
{//todo: turn the myriad constructors into companion functions with helpful names
    companion object {
        /**@param outputString The text to append to the output string*/
        fun simple(matcher:Regex, outputString: String, lettersConsumed: Int? = null):Rule {
            return Rule(null, matcher, { it + outputString }, lettersConsumed)
        }

        fun simple(matcherRegex:String, outputString:String, lettersConsumed:Int? = null):Rule {
            return Rule(null, Regex(matcherRegex), { it + outputString }, lettersConsumed)
        }

        fun complex(matcherRegex:String, outputString:(soFar:String) -> String, lettersConsumed:Int? = null):Rule {
            return Rule(null, Regex(matcherRegex), outputString, lettersConsumed)
        }

        fun complex(consumedRegex:String, unconsumedRegex:String, output:String, lettersConsumed:Int?=null ):Rule {
            return Rule(Regex(consumedRegex), Regex(unconsumedRegex), { it + output }, lettersConsumed)
        }
    }

    class Builder(private val unconsumedRegex:Regex,
                  private val output:(soFar:String) -> String,
                  private val lettersConsumed:Int?=null) {
        private var consumedMatcher:Regex? = null

        constructor(unconsumedRegex:String, output:(soFar:String) -> String, lettersConsumed:Int?=null)
                :this(Regex(unconsumedRegex), output, lettersConsumed)

        constructor(unconsumedRegex:String, output:String, lettersConsumed:Int?=null)
                :this(Regex(unconsumedRegex), {it+output}, lettersConsumed)

        fun consumedMatcher(matcherRegex:String) {
            consumedMatcher = Regex(matcherRegex)
        }

        fun consumedMatcher(matcherRegex:Regex) {
            consumedMatcher = matcherRegex
        }

        fun build(): Rule{
            return Rule(consumedMatcher, unconsumedRegex, output, lettersConsumed)
        }
    }
    fun asKotlin():String {
        return "Rule("+
                (if(consumedMatcher==null) "" else "\"$consumedMatcher\", ")+
                "\"$unconsumedMatcher\", "+
                "\""+outputString("")+"\""+
                (if(lettersConsumed==null) "" else ", $lettersConsumed")+
                ")"
    }
}
