package com.github.medavox.ipa_transcribers.brahmic

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber

/**Completion Status: SURFACE-LEVEL COMPLETE
 *
 * meaning that pronunciation rules for single letters and simple digraphs have been implemented,
 * but more complex linguistic rules not directly represented in the orthography are as-yet unimplemented.
 **/
object BengaliRuleBased : RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.SURFACE_LEVEL_COMPLETE

    fun l(it:String):String{
        return if(it.endsWith("ɔ")) it.substring(0, it.length-1) else it
    }

    //bengali's vowel diacritics only APPEAR VISUALLY to come before their consonant:
    //they still combine only with the next consonant in a string!
    // meaning we don't need any complex stack-based parsing; at least not for this.
    //todo: conjunct consonants (consonant cluster letters)
    //todo: inherent vowel dropping
    val rules:List<Rule> = listOf(
        //post-reform consonants -
        //from a character standpoint they are digraphs, using a nuqta ় ,
        //so apply them first
        Rule("ড়", "ɽɔ"),
        Rule("ঢ়", "ɽʱɔ"),
        Rule("য়", "jɔ"),
        //consonants
        Rule("ব", "bɔ"),
        Rule("ভ", "bʱɔ"),
        Rule("দ", "dɔ"),
        Rule("ধ", "dʱɔ"),
        Rule("ড", "ɖɔ"),
        Rule("ঢ", "ɖʱɔ"),
        Rule("[জয]", "dʒɔ"),
        Rule("ঝ", "dʒʱɔ"),
        Rule("গ", "ɡɔ"),
        Rule("ঘ", "ɡʱɔ"),
        Rule("(হ|ঃ)", "ɦɔ"),
        Rule("ক", "kɔ"),
        Rule("খ", "kʰɔ"),
        Rule("ল", "lɔ"),
        Rule("ম", "mɔ"),
        Rule("[নণঞ]", "nɔ"),
        Rule("(ঙ|ং)", "ŋɔ"),
        Rule("প", "pɔ"),
        Rule("ফ", "pʰɔ"),
        Rule("র", "rɔ"),
        Rule("(ড়|ঢ়)", "ɽɔ"),
        Rule("স", "sɔ"),
        Rule("[শষস]", "ʃɔ"),
        Rule("ত", "tɔ"),
        Rule("থ", "tʰɔ"),
        Rule("ট", "ʈɔ"),
        Rule("ঠ", "ʈʰɔ"),
        Rule("চ", "tʃɔ"),
        Rule("ছ", "tʃʰɔ"),

        //special letters
        Rule("ৎ", "̪t"), //final T
        Rule("্", {l(it)}), //suppresses inherent vowel

        //Vowels
        Rule("অ", "ɔ"),

        Rule("[ইঈ]", "i"),
        Rule("(ি|ী)", {l(it)+"i"}),

        Rule("[ঊউ]", "u"),
        Rule("(ু|ূ)", {l(it)+"u"}),

        Rule("ঋ", "ri"),
        Rule("ৃ", {l(it)+"ri"}),


        Rule("আ", "a"),
        Rule("া", {l(it)+"ri"}),

        //complex vowels
        Rule("ঐ", "oi"),
        Rule("ৈ", {l(it)+"oi"}),

        Rule("ঔ", "ou"),
        Rule("ৌ", {l(it)+"ou"}),

        Rule("এ", "e"),
        Rule("ে", {l(it)+"e"}),

        Rule("ও", "ʊ"),
        Rule("ো", {l(it)+"ʊ"}),

        //"deprecated" vowels
        Rule("ঌ", "li"),//supposed to have been removed from the abugida, but you never know...
        Rule("ৢ", {l(it)+"li"}),

        Rule("ৡ", "lːi"),//supposed to have been removed from the abugida, but you never know...
        Rule("ৣ", {l(it)+"lːi"}),

        Rule("ৠ", "rːi"),//supposed to have been removed from the abugida, but you never know...

        //numbers
        Rule("০", "0"),
        Rule("১", "1"),
        Rule("২", "2"),
        Rule("৩", "3"),
        Rule("৪", "4"),
        Rule("৫", "5"),
        Rule("৬", "6"),
        Rule("৭", "7"),
        Rule("৮", "8"),
        Rule("৯", "9"),
        Rule(" ", " "),//space

        //Punctuation
        Rule("।", ".")//devanagari danda 'stick' == full stop.

//Even though the open-mid front unrounded vowel /ɛ/ is one of the seven main vowel sounds in standard Bengali,
// no distinct vowel symbol has been allotted for it in the script since there is no /ɛ/ sound in Sanskrit,
// the primary written language when the script was conceived.

// As a result, the sound is orthographically realised by multiple means in modern Bengali orthography,
// usually using some combination of "এ" e (স্বর এ shôrô e, "vocalic e") /e/, "অ", "আ" a (স্বর আ shôrô a) /a/
// and the যফলা jôfôla (diacritic form of the consonant grapheme য jô).

    )
    override fun transcribe(nativeText: String): String {
        unhandledChars = ""
        return nativeText.processWithRules(rules, ::reportOnceAndCopy)
    }
}