package com.github.medavox.ipa_transcribers

interface RuleBasedTranscriber<T:Language>:Transcriber<T>, BaseRules {
    data class UnmatchedOutput(val newWorkingInput:String, val output:(soFar:String) -> String) {
        constructor(newWorkingInput: String, output:String):this(newWorkingInput, {it+output})
    }
    val reportAndSkip:(String) -> UnmatchedOutput get() = {
        System.err.println("unknown char '${it[0]}' in $it; skipping...")
        RuleBasedTranscriber.UnmatchedOutput(it.substring(1), "")
    }

    val copyVerbatim:(String) -> UnmatchedOutput get() = {
        System.err.println("copying unknown char '${it[0]}' to output...")
        RuleBasedTranscriber.UnmatchedOutput(it.substring(1), it[0].toString())
    }

    /*Automatically applies the rule which consumes the most characters*/
    /*fun String.greedy(rules: List<Rule>, onNoRuleMatch: (unmatched: String) -> UnmatchedOutput):String {
        var out:String = ""
        var processingWord = this
        loop@ while(processingWord.isNotEmpty()) {
            //val matchResult:MatchResult? = rule.matcher.find(processingWord)
            val rule:Rule? = rules.filter { it.matcher.find(processingWord)?.range?.start == 0 }
                .sortedBy { it.lettersConsumed }.lastOrNull()
            if(rule == null) {
                //no rule matched; call the lambda!
                val unmatchedOutput = onNoRuleMatch(processingWord)
                processingWord = unmatchedOutput.newWorkingInput
                out = unmatchedOutput.output(out)
            }else {
                out = rule.outputString(out)
                System.out.println("matched rule:$rule")
                //number of letters consumed is the match length, unless explicitly specified
                val actualLettersConsumed = rule.lettersConsumed ?: rule.matcher.find(processingWord)?.value?.length ?: 0
                if(actualLettersConsumed > 0) {
                    processingWord = processingWord.substring(actualLettersConsumed)
                    continue@loop
                }//else keep going through the rule list
            }
        }
        return out
    }*/

    fun String.processWithRules(rules:List<Rule>,
                                onNoRuleMatch:(unmatched:String) -> UnmatchedOutput
    ) : String {
        var out:String = ""
        var processingWord = this
        loop@ while(processingWord.isNotEmpty()) {
            for (rule in rules) {
                val matchResult:MatchResult? = rule.matcher.find(processingWord)

                //if the rule matches the start of the remaining string
                if(matchResult?.range?.start == 0) {
                    //System.out.println("rule '${rules[i]}' matches '$processingWord'")
                    out = rule.outputString(out)
                    //System.out.println("matched rule:$rule")
                    //number of letters consumed is the match length, unless explicitly specified
                    val actualLettersConsumed = rule.lettersConsumed ?: matchResult.value.length
                    if(actualLettersConsumed > 0) {
                        processingWord = processingWord.substring(actualLettersConsumed)
                        continue@loop
                    }//else keep going through the rule list
                }
            }
            //no rule matched; call the lambda!
            val unmatchedOutput = onNoRuleMatch(processingWord)
            processingWord = unmatchedOutput.newWorkingInput
            out = unmatchedOutput.output(out)
        }
        return out
    }
}