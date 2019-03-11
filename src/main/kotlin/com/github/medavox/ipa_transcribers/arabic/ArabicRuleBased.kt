package com.github.medavox.ipa_transcribers.arabic

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.Rule
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber


/**Partial transcriber for Modern Standard Arabic.
 * Transcribes the sound recorded in the orthography.
 * However, he Arabic script is an abugida, which means it does not (in normal writing) record all vowels.
 *
 * This means that a simple rule-based approach *cannot* produce a complete representation of a word's pronunciation,
 * given its standard spelling.
 *
 * But we can at least transcribe the information that arabic DOES provide.*/
object ArabicRuleBased : RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS
    val rules:List<Rule> = listOf<Rule>(
        Rule("؀", "№"),//NUMBER SIGN
        //Rule("؁", ""),//SIGN SANAH
        //Rule("؂", ""),//FOOTNOTE MARKER
        //Rule("؃", ""),//SIGN SAFHA
        //Rule("؄", ""),//SIGN SAMVAT
        //Rule("؅", ""),//NUMBER MARK ABOVE
        //Rule("؆", ""),//ARABIC-INDIC CUBE ROOT
        //Rule("؇", ""),//ARABIC-INDIC FOURTH ROOT
        //Rule("؈", ""),//RAY
        Rule("؉", "‰"),//ARABIC-INDIC PER MILLE SIGN
        Rule("؊", "‱"),//ARABIC-INDIC PER TEN THOUSAND SIGN
        //Rule("؋", ""),//AFGHANI SIGN
        Rule("،", ","),//COMMA
        //Rule("؍", ""),//DATE SEPARATOR
        //Rule("؎", ""),//POETIC VERSE SIGN
        //Rule("؏", ""),//SIGN MISRA
        //Rule("ؐ", ""),//SIGN SALLALLAHOU ALAYHE WASSALLAM
        //Rule("ؑ", ""),//SIGN ALAYHE ASSALLAM
        //Rule("ؒ", ""),//SIGN RAHMATULLAH ALAYHE
        //Rule("ؓ", ""),//SIGN RADI ALLAHOU ANHU
        //Rule("ؔ", ""),//SIGN TAKHALLUS
        //Rule("ؕ", ""),//SMALL HIGH TAH
        //Rule("ؖ", ""),//SMALL HIGH LIGATURE ALEF WITH LAM WITH YEH
        //Rule("ؗ", ""),//SMALL HIGH ZAIN
        //Rule("ؘ", ""),//SMALL FATHA
        //Rule("ؙ", ""),//SMALL DAMMA
        //Rule("ؚ", ""),//SMALL KASRA
        Rule("؛", ";"),//SEMICOLON
        //Rule("؜", ""),//LETTER MARK
        ////Rule("؝", ""),//Unknown character   O   Arabic
        Rule("؞", "…"),//TRIPLE DOT PUNCTUATION MARK
        Rule("؟", "?"),//QUESTION MARK
        //Rule("ؠ", ""),//LETTER KASHMIRI YEH
        //Rule("ء", ""),//LETTER HAMZA
        //Rule("آ", ""),//LETTER ALEF WITH MADDA ABOVE
        //Rule("أ", ""),//LETTER ALEF WITH HAMZA ABOVE
        //Rule("ؤ", ""),//LETTER WAW WITH HAMZA ABOVE
        //Rule("إ", ""),//LETTER ALEF WITH HAMZA BELOW
        //Rule("ئ", ""),//LETTER YEH WITH HAMZA ABOVE
        //Rule("ا", ""),//LETTER ALEF
        Rule("ب", "b"),//LETTER BEH
        //Rule("ة", ""),//LETTER TEH MARBUTA
        Rule("ت", "t"),//LETTER TEH
        Rule("ث", "θ"),//LETTER THEH
        Rule("ج", "d͡ʒ"),//LETTER JEEM
        Rule("ح", "ħ"),//LETTER HAH
        Rule("خ", "x"),//LETTER KHAH
        Rule("د", "d"),//LETTER DAL
        Rule("ذ", "ð"),//LETTER THAL
        Rule("ر", "r"),//LETTER REH
        Rule("ز", "z"),//LETTER ZAIN
        Rule("س", "s"),//LETTER SEEN
        Rule("ش", "ʃ"),//LETTER SHEEN
        Rule("ص", "sˤ"),//LETTER SAD
        Rule("ض", "dˤ"),//LETTER DAD
        Rule("ط", "tˤ"),//LETTER TAH
        Rule("ظ", "ðˤ"),//LETTER ZAH
        Rule("ع", "ʕ"),//LETTER AIN
        Rule("غ", "ɣ"),//LETTER GHAIN
        //Rule("ػ", ""),//LETTER KEHEH WITH TWO DOTS ABOVE
        //Rule("ؼ", ""),//LETTER KEHEH WITH THREE DOTS BELOW
        //Rule("ؽ", ""),//LETTER FARSI YEH WITH INVERTED V
        //Rule("ؾ", ""),//LETTER FARSI YEH WITH TWO DOTS ABOVE
        //Rule("ؿ", ""),//LETTER FARSI YEH WITH THREE DOTS ABOVE
        //Rule("ـ", ""),//TATWEEL
        Rule("ف", "f"),//LETTER FEH
        Rule("ق", "q"),//LETTER QAF
        Rule("ك", "k"),//LETTER KAF
        Rule("ل", "l"),//LETTER LAM
        Rule("م", "m"),//LETTER MEEM
        Rule("ن", "n"),//LETTER NOON
        Rule("ه", "h"),//LETTER HEH
        //Rule("و", ""),//LETTER WAW
        //Rule("ى", ""),//LETTER ALEF MAKSURA
        //Rule("ي", ""),//LETTER YEH
        //Rule("ً", ""),//FATHATAN
        //Rule("ٌ", ""),//DAMMATAN
        //Rule("ٍ", ""),//KASRATAN
        //Rule("َ", ""),//FATHA
        //Rule("ُ", ""),//DAMMA
        //Rule("ِ", ""),//KASRA
        //Rule("ّ", ""),//SHADDA
        //Rule("ْ", ""),//SUKUN
        //Rule("ٓ", ""),//MADDAH ABOVE
        //Rule("ٔ", ""),//HAMZA ABOVE
        //Rule("ٕ", ""),//HAMZA BELOW
        //Rule("ٖ", ""),//SUBSCRIPT ALEF
        //Rule("ٗ", ""),//INVERTED DAMMA
        //Rule("٘", ""),//MARK NOON GHUNNA
        //Rule("ٙ", ""),//ZWARAKAY
        //Rule("ٚ", ""),//VOWEL SIGN SMALL V ABOVE
        //Rule("ٛ", ""),//VOWEL SIGN INVERTED SMALL V ABOVE
        //Rule("ٜ", ""),//VOWEL SIGN DOT BELOW
        //Rule("ٝ", ""),//REVERSED DAMMA
        //Rule("ٞ", ""),//FATHA WITH TWO DOTS
        //Rule("ٟ", ""),//WAVY HAMZA BELOW
        Rule("٠", "0"),//ARABIC-INDIC DIGIT ZERO
        Rule("١", "1"),//ARABIC-INDIC DIGIT ONE
        Rule("٢", "2"),//ARABIC-INDIC DIGIT TWO
        Rule("٣", "3"),//ARABIC-INDIC DIGIT THREE
        Rule("٤", "4"),//ARABIC-INDIC DIGIT FOUR
        Rule("٥", "5"),//ARABIC-INDIC DIGIT FIVE
        Rule("٦", "6"),//ARABIC-INDIC DIGIT SIX
        Rule("٧", "7"),//ARABIC-INDIC DIGIT SEVEN
        Rule("٨", "8"),//ARABIC-INDIC DIGIT EIGHT
        Rule("٩", "9"),//ARABIC-INDIC DIGIT NINE
        Rule("٪", "%"),//PERCENT SIGN
        Rule("٫", "."),//DECIMAL SEPARATOR
        Rule("٬", ","),//THOUSANDS SEPARATOR
        Rule("٭", "*"),//FIVE POINTED STAR
        //Rule("ٮ", ""),//LETTER DOTLESS BEH
        //Rule("ٯ", ""),//LETTER DOTLESS QAF
        //Rule("ٰ", ""),//LETTER SUPERSCRIPT ALEF
        //Rule("ٱ", ""),//LETTER ALEF WASLA
        //Rule("ٲ", ""),//LETTER ALEF WITH WAVY HAMZA ABOVE
        //Rule("ٳ", ""),//LETTER ALEF WITH WAVY HAMZA BELOW
        //Rule("ٴ", ""),//LETTER HIGH HAMZA
        //Rule("ٵ", ""),//LETTER HIGH HAMZA ALEF
        //Rule("ٶ", ""),//LETTER HIGH HAMZA WAW
        //Rule("ٷ", ""),//LETTER U WITH HAMZA ABOVE
        //Rule("ٸ", ""),//LETTER HIGH HAMZA YEH
        //Rule("ٹ", ""),//LETTER TTEH
        //Rule("ٺ", ""),//LETTER TTEHEH
        //Rule("ٻ", ""),//LETTER BEEH
        //Rule("ټ", ""),//LETTER TEH WITH RING
        //Rule("ٽ", ""),//LETTER TEH WITH THREE DOTS ABOVE DOWNWARDS
        //Rule("پ", ""),//LETTER PEH
        //Rule("ٿ", ""),//LETTER TEHEH
        //Rule("ڀ", ""),//LETTER BEHEH
        //Rule("ځ", ""),//LETTER HAH WITH HAMZA ABOVE
        //Rule("ڂ", ""),//LETTER HAH WITH TWO DOTS VERTICAL ABOVE
        //Rule("ڃ", ""),//LETTER NYEH
        //Rule("ڄ", ""),//LETTER DYEH
        //Rule("څ", ""),//LETTER HAH WITH THREE DOTS ABOVE
        //Rule("چ", ""),//LETTER TCHEH
        //Rule("ڇ", ""),//LETTER TCHEHEH
        //Rule("ڈ", ""),//LETTER DDAL
        //Rule("ډ", ""),//LETTER DAL WITH RING
        //Rule("ڊ", ""),//LETTER DAL WITH DOT BELOW
        //Rule("ڋ", ""),//LETTER DAL WITH DOT BELOW AND SMALL TAH
        //Rule("ڌ", ""),//LETTER DAHAL
        //Rule("ڍ", ""),//LETTER DDAHAL
        //Rule("ڎ", ""),//LETTER DUL
        //Rule("ڏ", ""),//LETTER DAL WITH THREE DOTS ABOVE DOWNWARDS
        //Rule("ڐ", ""),//LETTER DAL WITH FOUR DOTS ABOVE
        //Rule("ڑ", ""),//LETTER RREH
        //Rule("ڒ", ""),//LETTER REH WITH SMALL V
        //Rule("ړ", ""),//LETTER REH WITH RING
        //Rule("ڔ", ""),//LETTER REH WITH DOT BELOW
        //Rule("ڕ", ""),//LETTER REH WITH SMALL V BELOW
        //Rule("ږ", ""),//LETTER REH WITH DOT BELOW AND DOT ABOVE
        //Rule("ڗ", ""),//LETTER REH WITH TWO DOTS ABOVE
        //Rule("ژ", ""),//LETTER JEH
        //Rule("ڙ", ""),//LETTER REH WITH FOUR DOTS ABOVE
        //Rule("ښ", ""),//LETTER SEEN WITH DOT BELOW AND DOT ABOVE
        //Rule("ڛ", ""),//LETTER SEEN WITH THREE DOTS BELOW
        //Rule("ڜ", ""),//LETTER SEEN WITH THREE DOTS BELOW AND THREE DOTS ABOVE
        //Rule("ڝ", ""),//LETTER SAD WITH TWO DOTS BELOW
        //Rule("ڞ", ""),//LETTER SAD WITH THREE DOTS ABOVE
        //Rule("ڟ", ""),//LETTER TAH WITH THREE DOTS ABOVE
        //Rule("ڠ", ""),//LETTER AIN WITH THREE DOTS ABOVE
        //Rule("ڡ", ""),//LETTER DOTLESS FEH
        //Rule("ڢ", ""),//LETTER FEH WITH DOT MOVED BELOW
        //Rule("ڣ", ""),//LETTER FEH WITH DOT BELOW
        //Rule("ڤ", ""),//LETTER VEH
        //Rule("ڥ", ""),//LETTER FEH WITH THREE DOTS BELOW
        //Rule("ڦ", ""),//LETTER PEHEH
        //Rule("ڧ", ""),//LETTER QAF WITH DOT ABOVE
        //Rule("ڨ", ""),//LETTER QAF WITH THREE DOTS ABOVE
        //Rule("ک", ""),//LETTER KEHEH
        //Rule("ڪ", ""),//LETTER SWASH KAF
        //Rule("ګ", ""),//LETTER KAF WITH RING
        //Rule("ڬ", ""),//LETTER KAF WITH DOT ABOVE
        //Rule("ڭ", ""),//LETTER NG
        //Rule("ڮ", ""),//LETTER KAF WITH THREE DOTS BELOW
        //Rule("گ", ""),//LETTER GAF
        //Rule("ڰ", ""),//LETTER GAF WITH RING
        //Rule("ڱ", ""),//LETTER NGOEH
        //Rule("ڲ", ""),//LETTER GAF WITH TWO DOTS BELOW
        //Rule("ڳ", ""),//LETTER GUEH
        //Rule("ڴ", ""),//LETTER GAF WITH THREE DOTS ABOVE
        //Rule("ڵ", ""),//LETTER LAM WITH SMALL V
        //Rule("ڶ", ""),//LETTER LAM WITH DOT ABOVE
        //Rule("ڷ", ""),//LETTER LAM WITH THREE DOTS ABOVE
        //Rule("ڸ", ""),//LETTER LAM WITH THREE DOTS BELOW
        //Rule("ڹ", ""),//LETTER NOON WITH DOT BELOW
        //Rule("ں", ""),//LETTER NOON GHUNNA
        //Rule("ڻ", ""),//LETTER RNOON
        //Rule("ڼ", ""),//LETTER NOON WITH RING
        //Rule("ڽ", ""),//LETTER NOON WITH THREE DOTS ABOVE
        //Rule("ھ", ""),//LETTER HEH DOACHASHMEE
        //Rule("ڿ", ""),//LETTER TCHEH WITH DOT ABOVE
        //Rule("ۀ", ""),//LETTER HEH WITH YEH ABOVE
        //Rule("ہ", ""),//LETTER HEH GOAL
        //Rule("ۂ", ""),//LETTER HEH GOAL WITH HAMZA ABOVE
        //Rule("ۃ", ""),//LETTER TEH MARBUTA GOAL
        //Rule("ۄ", ""),//LETTER WAW WITH RING
        //Rule("ۅ", ""),//LETTER KIRGHIZ OE
        //Rule("ۆ", ""),//LETTER OE
        //Rule("ۇ", ""),//LETTER U
        //Rule("ۈ", ""),//LETTER YU
        //Rule("ۉ", ""),//LETTER KIRGHIZ YU
        //Rule("ۊ", ""),//LETTER WAW WITH TWO DOTS ABOVE
        //Rule("ۋ", ""),//LETTER VE
        //Rule("ی", ""),//LETTER FARSI YEH
        //Rule("ۍ", ""),//LETTER YEH WITH TAIL
        //Rule("ێ", ""),//LETTER YEH WITH SMALL V
        //Rule("ۏ", ""),//LETTER WAW WITH DOT ABOVE
        //Rule("ې", ""),//LETTER E
        //Rule("ۑ", ""),//LETTER YEH WITH THREE DOTS BELOW
        //Rule("ے", ""),//LETTER YEH BARREE
        //Rule("ۓ", ""),//LETTER YEH BARREE WITH HAMZA ABOVE
        Rule("۔", ".")//FULL STOP
        //Rule("ە", ""),//LETTER AE
        //Rule("ۖ", ""),//SMALL HIGH LIGATURE SAD WITH LAM WITH ALEF MAKSURA
        //Rule("ۗ", ""),//SMALL HIGH LIGATURE QAF WITH LAM WITH ALEF MAKSURA
        //Rule("ۘ", ""),//SMALL HIGH MEEM INITIAL FORM
        //Rule("ۙ", ""),//SMALL HIGH LAM ALEF
        //Rule("ۚ", ""),//SMALL HIGH JEEM
        //Rule("ۛ", ""),//SMALL HIGH THREE DOTS
        //Rule("ۜ", ""),//SMALL HIGH SEEN
        //Rule("۝", ""),//END OF AYAH
        //Rule("۞", ""),//START OF RUB EL HIZB
        //Rule("۟", ""),//SMALL HIGH ROUNDED ZERO
        //Rule("۠", ""),//SMALL HIGH UPRIGHT RECTANGULAR ZERO
        //Rule("ۡ", ""),//SMALL HIGH DOTLESS HEAD OF KHAH
        //Rule("ۢ", ""),//SMALL HIGH MEEM ISOLATED FORM
        //Rule("ۣ", ""),//SMALL LOW SEEN
        //Rule("ۤ", ""),//SMALL HIGH MADDA
        //Rule("ۥ", ""),//SMALL WAW
        //Rule("ۦ", ""),//SMALL YEH
        //Rule("ۧ", ""),//SMALL HIGH YEH
        //Rule("ۨ", ""),//SMALL HIGH NOON
        //Rule("۩", ""),//PLACE OF SAJDAH
        //Rule("۪", ""),//EMPTY CENTRE LOW STOP
        //Rule("۫", ""),//EMPTY CENTRE HIGH STOP
        //Rule("۬", ""),//ROUNDED HIGH STOP WITH FILLED CENTRE
        //Rule("ۭ", ""),//SMALL LOW MEEM
        //Rule("ۮ", ""),//LETTER DAL WITH INVERTED V
        //Rule("ۯ", ""),//LETTER REH WITH INVERTED V
        //Rule("۰", ""),//EXTENDED ARABIC-INDIC DIGIT ZERO
        //Rule("۱", ""),//EXTENDED ARABIC-INDIC DIGIT ONE
        //Rule("۲", ""),//EXTENDED ARABIC-INDIC DIGIT TWO
        //Rule("۳", ""),//EXTENDED ARABIC-INDIC DIGIT THREE
        //Rule("۴", ""),//EXTENDED ARABIC-INDIC DIGIT FOUR
        //Rule("۵", ""),//EXTENDED ARABIC-INDIC DIGIT FIVE
        //Rule("۶", ""),//EXTENDED ARABIC-INDIC DIGIT SIX
        //Rule("۷", ""),//EXTENDED ARABIC-INDIC DIGIT SEVEN
        //Rule("۸", ""),//EXTENDED ARABIC-INDIC DIGIT EIGHT
        //Rule("۹", ""),//EXTENDED ARABIC-INDIC DIGIT NINE
        //Rule("ۺ", ""),//LETTER SHEEN WITH DOT BELOW
        //Rule("ۻ", ""),//LETTER DAD WITH DOT BELOW
        //Rule("ۼ", ""),//LETTER GHAIN WITH DOT BELOW
        //Rule("۽", ""),//SIGN SINDHI AMPERSAND
        //Rule("۾", ""),//SIGN SINDHI POSTPOSITION MEN
        //Rule("ۿ", "")//LETTER HEH WITH INVERTED V   Lo  Arabic
    )//+ comprehensiveArabic
    override fun transcribe(nativeText: String): String {
        return nativeText.processWithRules(rules, reportAndCopy)
    }
}