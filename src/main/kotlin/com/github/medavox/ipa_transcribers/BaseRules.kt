package com.github.medavox.ipa_transcribers

interface BaseRules {

    val westernPunctuation:List<Rule> get() = listOf(
        Rule(" ", " "),
        Rule(",", ","),
        Rule(".", ".")
    )

    private fun l(it:String):String{
        return if(it.endsWith("ə")) it.substring(0, it.length-1) else it
    }
    val devanagariBaseRules:List<Rule> get() = listOf(

        //consonants.
        // These have an inherent schwa (which is often romanised as 'a'),
        //if there isn't another vowel attached to that character.
        Rule("क़", "qə"),//2
        Rule("क", "kə"),//1
        Rule("ख़", "xə"),//2
        Rule("ख", "kʰə"),//1
        Rule("ग़", "ɣə"),//2
        Rule("ग", "ɡə"),//1
        Rule("घ", "ɡʱə"),//1
        Rule("ङ", "ŋə"),//1
        Rule("च", "tʃə"),//1
        Rule("छ", "tʃʰə"),//1
        Rule("ज़", "zə"),//2
        Rule("ज", "dʒə"),//1
        Rule("झ़", "ʒə"),//2
        Rule("झ", "dʒʱə"),//1
        Rule("ञ", "ɲə"),//1
        Rule("ट", "ʈə"),//1
        Rule("ठ", "ʈʰə"),//1
        Rule("ड", "ɖə"),//1
        Rule("ढ़", "ɽʱə"),//2
        Rule("ढ", "ɖʱə"),//1
        Rule("ण", "ɳə"),//1
        Rule("त", "tə"),//1
        Rule("थ", "tʰə"),//1
        Rule("द", "də"),//1
        Rule("ध", "dʱə"),//1
        Rule("न", "nə"),//1
        Rule("प", "pə"),//1
        Rule("फ़", "fə"),//2
        Rule("फ", "pʰə"),//1
        Rule("ब", "bə"),//1
        Rule("भ", "bʱə"),//1
        Rule("म", "mə"),//1
        Rule("य", "jə"),//1
        Rule("र", "ɾə"),//1
        Rule("ल", "lə"),//1
        Rule("व", "ʋə"),//1
        Rule("श", "ʃə"),//1
        Rule("ष", "ʂə"),//1
        Rule("स", "sə"),//1
        Rule("ह", "ɦə"),//1


        //Vowels. Each vowel has an independent form, and a form which attaches to the previous consonant.
        //Much kudos to Unicode's Devanagari support;
        // the vowels act like separate characters on a character level,
        // but combine with their previous consonant to form the right character visually.
        //this means we use the minimum number of code points possible to represent Devanagari.
        Rule("[आा]", {l(it)+"aː"}),
        Rule("[एे]", {l(it)+"eː"}),
        Rule("[ऐै]", {l(it)+"ɛː"}),
        Rule("[अ]", {l(it)+"ə"}),
        Rule("[ईी]", {l(it)+"iː"}),
        Rule("[इि]", {l(it)+"ɪ"}),
        Rule("[ओो]", {l(it)+"oː"}),
        Rule("[औौ]", {l(it)+"ɔː"}),
        Rule("[ऊू]", {l(it)+"uː"}),
        Rule("[उु]", {l(it)+"ʊ"}),
        Rule("[ऋृ]", {l(it)+"ɾɪ"}),
        Rule("्", {l(it)}),// ् "virama" is a diacritic which suppresses the inherent vowel
        Rule("ं", {l(it)}),// "anusvara" diacritic nasalises the preceding consonant*
        //or in modern hindi and marathi, sometimes its vowel as well. It's comlicated.

        Rule("ँ", "̃"), //nasalised vowel diacritic. Presumably can go over any (or some) other vowels

        //numbers, for completeness' sake
        Rule("०", "0"),
        Rule("१", "1"),
        Rule("२", "2"),
        Rule("३", "3"),
        Rule("४", "4"),
        Rule("५", "5"),
        Rule("६", "6"),
        Rule("७", "7"),
        Rule("८", "8"),
        Rule("९", "9"),

        //punctuation
        Rule("।", "."),//danda or 'stick'. equivalent to a full stop.
        Rule(" ", " ")

    )

    val latinBaseRules:List<Rule> get() = listOf(
        Rule("a", "a"),
        Rule("b", "b"),

        Rule("d", "d"),
        Rule("e", "e"),
        Rule("f", "f"),
        Rule("g", "ɡ"),
        Rule("h", "h"),
        Rule("i", "i"),

        Rule("k", "k"),
        Rule("l", "l"),
        Rule("m", "m"),
        Rule("n", "n"),
        Rule("o", "o"),
        Rule("p", "p"),

        Rule("s", "s"),
        Rule("t", "t"),
        Rule("u", "u"),
        Rule("v", "v"),
        Rule("w", "w"),

        Rule("y", "j"),
        Rule("z", "z"),
        Rule(" ", " ")
    )

    /**Although persian letters have different repesentations whether they are initial, medial, or final --
     * all forms are represented by the same unicode character.*/
    val persoArabicBaseRules:List<Rule> get() = listOf(
        Rule("ا", "ɒ"),
        Rule("ب", "b"),
        Rule("پ", "p"),
        Rule("ت", "t"),
        Rule("ث", "s"),
        Rule("ج", "d͡ʒ"),
        Rule("چ", "t͡ʃ"),
        Rule("ح", "h"),
        Rule("خ", "x"),
        Rule("د", "d"),
        Rule("ذ", "z"),
        Rule("ر", "ɾ"),
        Rule("ز", "z"),
        Rule("ژ", "ʒ"),
        Rule("س", "s"),
        Rule("ش", "ʃ"),
        Rule("ص", "s"),
        Rule("ض", "z"),
        Rule("ط", "t"),
        Rule("ظ", "z"),
        Rule("ع", "ʔ"),
        Rule("غ", "ɣ"),
        Rule("ف", "f"),
        Rule("ق", "ɣ"),
        Rule("ک", "k"),
        Rule("گ", "ɡ"),
        Rule("ل", "l"),
        Rule("م", "m"),
        Rule("ن", "n"),
        Rule("و", "ʋ"),// [v] / [uː] / [o] / [ow] / ([w] / [aw] / [oː] in Dari)),
        Rule("ه", "h"),
        Rule("ی", "i"),// / [j] / [ɒː] / ([aj] / [eː] in Dari)),
        Rule(" ", " ")
    )

    //transcription for the entire arabic unicode block.
    val comprehensiveArabic:List<Rule> get() = listOf(
        Rule("؀", "№"),//NUMBER SIGN
        Rule("؁", ""),//SIGN SANAH
        Rule("؂", ""),//FOOTNOTE MARKER
        Rule("؃", ""),//SIGN SAFHA
        Rule("؄", ""),//SIGN SAMVAT
        Rule("؅", ""),//NUMBER MARK ABOVE
        Rule("؆", ""),//ARABIC-INDIC CUBE ROOT
        Rule("؇", ""),//ARABIC-INDIC FOURTH ROOT
        Rule("؈", ""),//RAY
        Rule("؉", "‰"),//ARABIC-INDIC PER MILLE SIGN
        Rule("؊", "‱"),//ARABIC-INDIC PER TEN THOUSAND SIGN
        Rule("؋", ""),//AFGHANI SIGN
        Rule("،", ","),//COMMA
        Rule("؍", ""),//DATE SEPARATOR
        Rule("؎", ""),//POETIC VERSE SIGN
        Rule("؏", ""),//SIGN MISRA
        Rule("ؐ", ""),//SIGN SALLALLAHOU ALAYHE WASSALLAM
        Rule("ؑ", ""),//SIGN ALAYHE ASSALLAM
        Rule("ؒ", ""),//SIGN RAHMATULLAH ALAYHE
        Rule("ؓ", ""),//SIGN RADI ALLAHOU ANHU
        Rule("ؔ", ""),//SIGN TAKHALLUS
        Rule("ؕ", ""),//SMALL HIGH TAH
        Rule("ؖ", ""),//SMALL HIGH LIGATURE ALEF WITH LAM WITH YEH
        Rule("ؗ", ""),//SMALL HIGH ZAIN
        Rule("ؘ", ""),//SMALL FATHA
        Rule("ؙ", ""),//SMALL DAMMA
        Rule("ؚ", ""),//SMALL KASRA
        Rule("؛", ";"),//SEMICOLON
        Rule("؜", ""),//LETTER MARK
        //Rule("؝", ""),//Unknown character   O   Arabic
        Rule("؞", "…"),//TRIPLE DOT PUNCTUATION MARK
        Rule("؟", "?"),//QUESTION MARK
        Rule("ؠ", ""),//LETTER KASHMIRI YEH
        Rule("ء", ""),//LETTER HAMZA
        Rule("آ", ""),//LETTER ALEF WITH MADDA ABOVE
        Rule("أ", ""),//LETTER ALEF WITH HAMZA ABOVE
        Rule("ؤ", ""),//LETTER WAW WITH HAMZA ABOVE
        Rule("إ", ""),//LETTER ALEF WITH HAMZA BELOW
        Rule("ئ", ""),//LETTER YEH WITH HAMZA ABOVE
        Rule("ا", ""),//LETTER ALEF
        Rule("ب", ""),//LETTER BEH
        Rule("ة", ""),//LETTER TEH MARBUTA
        Rule("ت", ""),//LETTER TEH
        Rule("ث", ""),//LETTER THEH
        Rule("ج", ""),//LETTER JEEM
        Rule("ح", ""),//LETTER HAH
        Rule("خ", ""),//LETTER KHAH
        Rule("د", ""),//LETTER DAL
        Rule("ذ", ""),//LETTER THAL
        Rule("ر", ""),//LETTER REH
        Rule("ز", ""),//LETTER ZAIN
        Rule("س", ""),//LETTER SEEN
        Rule("ش", ""),//LETTER SHEEN
        Rule("ص", ""),//LETTER SAD
        Rule("ض", ""),//LETTER DAD
        Rule("ط", ""),//LETTER TAH
        Rule("ظ", ""),//LETTER ZAH
        Rule("ع", ""),//LETTER AIN
        Rule("غ", ""),//LETTER GHAIN
        Rule("ػ", ""),//LETTER KEHEH WITH TWO DOTS ABOVE
        Rule("ؼ", ""),//LETTER KEHEH WITH THREE DOTS BELOW
        Rule("ؽ", ""),//LETTER FARSI YEH WITH INVERTED V
        Rule("ؾ", ""),//LETTER FARSI YEH WITH TWO DOTS ABOVE
        Rule("ؿ", ""),//LETTER FARSI YEH WITH THREE DOTS ABOVE
        Rule("ـ", ""),//TATWEEL
        Rule("ف", ""),//LETTER FEH
        Rule("ق", ""),//LETTER QAF
        Rule("ك", ""),//LETTER KAF
        Rule("ل", ""),//LETTER LAM
        Rule("م", ""),//LETTER MEEM
        Rule("ن", ""),//LETTER NOON
        Rule("ه", ""),//LETTER HEH
        Rule("و", ""),//LETTER WAW
        Rule("ى", ""),//LETTER ALEF MAKSURA
        Rule("ي", ""),//LETTER YEH
        Rule("ً", ""),//FATHATAN
        Rule("ٌ", ""),//DAMMATAN
        Rule("ٍ", ""),//KASRATAN
        Rule("َ", ""),//FATHA
        Rule("ُ", ""),//DAMMA
        Rule("ِ", ""),//KASRA
        Rule("ّ", ""),//SHADDA
        Rule("ْ", ""),//SUKUN
        Rule("ٓ", ""),//MADDAH ABOVE
        Rule("ٔ", ""),//HAMZA ABOVE
        Rule("ٕ", ""),//HAMZA BELOW
        Rule("ٖ", ""),//SUBSCRIPT ALEF
        Rule("ٗ", ""),//INVERTED DAMMA
        Rule("٘", ""),//MARK NOON GHUNNA
        Rule("ٙ", ""),//ZWARAKAY
        Rule("ٚ", ""),//VOWEL SIGN SMALL V ABOVE
        Rule("ٛ", ""),//VOWEL SIGN INVERTED SMALL V ABOVE
        Rule("ٜ", ""),//VOWEL SIGN DOT BELOW
        Rule("ٝ", ""),//REVERSED DAMMA
        Rule("ٞ", ""),//FATHA WITH TWO DOTS
        Rule("ٟ", ""),//WAVY HAMZA BELOW
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
        Rule("ٮ", ""),//LETTER DOTLESS BEH
        Rule("ٯ", ""),//LETTER DOTLESS QAF
        Rule("ٰ", ""),//LETTER SUPERSCRIPT ALEF
        Rule("ٱ", ""),//LETTER ALEF WASLA
        Rule("ٲ", ""),//LETTER ALEF WITH WAVY HAMZA ABOVE
        Rule("ٳ", ""),//LETTER ALEF WITH WAVY HAMZA BELOW
        Rule("ٴ", ""),//LETTER HIGH HAMZA
        Rule("ٵ", ""),//LETTER HIGH HAMZA ALEF
        Rule("ٶ", ""),//LETTER HIGH HAMZA WAW
        Rule("ٷ", ""),//LETTER U WITH HAMZA ABOVE
        Rule("ٸ", ""),//LETTER HIGH HAMZA YEH
        Rule("ٹ", ""),//LETTER TTEH
        Rule("ٺ", ""),//LETTER TTEHEH
        Rule("ٻ", ""),//LETTER BEEH
        Rule("ټ", ""),//LETTER TEH WITH RING
        Rule("ٽ", ""),//LETTER TEH WITH THREE DOTS ABOVE DOWNWARDS
        Rule("پ", ""),//LETTER PEH
        Rule("ٿ", ""),//LETTER TEHEH
        Rule("ڀ", ""),//LETTER BEHEH
        Rule("ځ", ""),//LETTER HAH WITH HAMZA ABOVE
        Rule("ڂ", ""),//LETTER HAH WITH TWO DOTS VERTICAL ABOVE
        Rule("ڃ", ""),//LETTER NYEH
        Rule("ڄ", ""),//LETTER DYEH
        Rule("څ", ""),//LETTER HAH WITH THREE DOTS ABOVE
        Rule("چ", ""),//LETTER TCHEH
        Rule("ڇ", ""),//LETTER TCHEHEH
        Rule("ڈ", ""),//LETTER DDAL
        Rule("ډ", ""),//LETTER DAL WITH RING
        Rule("ڊ", ""),//LETTER DAL WITH DOT BELOW
        Rule("ڋ", ""),//LETTER DAL WITH DOT BELOW AND SMALL TAH
        Rule("ڌ", ""),//LETTER DAHAL
        Rule("ڍ", ""),//LETTER DDAHAL
        Rule("ڎ", ""),//LETTER DUL
        Rule("ڏ", ""),//LETTER DAL WITH THREE DOTS ABOVE DOWNWARDS
        Rule("ڐ", ""),//LETTER DAL WITH FOUR DOTS ABOVE
        Rule("ڑ", ""),//LETTER RREH
        Rule("ڒ", ""),//LETTER REH WITH SMALL V
        Rule("ړ", ""),//LETTER REH WITH RING
        Rule("ڔ", ""),//LETTER REH WITH DOT BELOW
        Rule("ڕ", ""),//LETTER REH WITH SMALL V BELOW
        Rule("ږ", ""),//LETTER REH WITH DOT BELOW AND DOT ABOVE
        Rule("ڗ", ""),//LETTER REH WITH TWO DOTS ABOVE
        Rule("ژ", ""),//LETTER JEH
        Rule("ڙ", ""),//LETTER REH WITH FOUR DOTS ABOVE
        Rule("ښ", ""),//LETTER SEEN WITH DOT BELOW AND DOT ABOVE
        Rule("ڛ", ""),//LETTER SEEN WITH THREE DOTS BELOW
        Rule("ڜ", ""),//LETTER SEEN WITH THREE DOTS BELOW AND THREE DOTS ABOVE
        Rule("ڝ", ""),//LETTER SAD WITH TWO DOTS BELOW
        Rule("ڞ", ""),//LETTER SAD WITH THREE DOTS ABOVE
        Rule("ڟ", ""),//LETTER TAH WITH THREE DOTS ABOVE
        Rule("ڠ", ""),//LETTER AIN WITH THREE DOTS ABOVE
        Rule("ڡ", ""),//LETTER DOTLESS FEH
        Rule("ڢ", ""),//LETTER FEH WITH DOT MOVED BELOW
        Rule("ڣ", ""),//LETTER FEH WITH DOT BELOW
        Rule("ڤ", ""),//LETTER VEH
        Rule("ڥ", ""),//LETTER FEH WITH THREE DOTS BELOW
        Rule("ڦ", ""),//LETTER PEHEH
        Rule("ڧ", ""),//LETTER QAF WITH DOT ABOVE
        Rule("ڨ", ""),//LETTER QAF WITH THREE DOTS ABOVE
        Rule("ک", ""),//LETTER KEHEH
        Rule("ڪ", ""),//LETTER SWASH KAF
        Rule("ګ", ""),//LETTER KAF WITH RING
        Rule("ڬ", ""),//LETTER KAF WITH DOT ABOVE
        Rule("ڭ", ""),//LETTER NG
        Rule("ڮ", ""),//LETTER KAF WITH THREE DOTS BELOW
        Rule("گ", ""),//LETTER GAF
        Rule("ڰ", ""),//LETTER GAF WITH RING
        Rule("ڱ", ""),//LETTER NGOEH
        Rule("ڲ", ""),//LETTER GAF WITH TWO DOTS BELOW
        Rule("ڳ", ""),//LETTER GUEH
        Rule("ڴ", ""),//LETTER GAF WITH THREE DOTS ABOVE
        Rule("ڵ", ""),//LETTER LAM WITH SMALL V
        Rule("ڶ", ""),//LETTER LAM WITH DOT ABOVE
        Rule("ڷ", ""),//LETTER LAM WITH THREE DOTS ABOVE
        Rule("ڸ", ""),//LETTER LAM WITH THREE DOTS BELOW
        Rule("ڹ", ""),//LETTER NOON WITH DOT BELOW
        Rule("ں", ""),//LETTER NOON GHUNNA
        Rule("ڻ", ""),//LETTER RNOON
        Rule("ڼ", ""),//LETTER NOON WITH RING
        Rule("ڽ", ""),//LETTER NOON WITH THREE DOTS ABOVE
        Rule("ھ", ""),//LETTER HEH DOACHASHMEE
        Rule("ڿ", ""),//LETTER TCHEH WITH DOT ABOVE
        Rule("ۀ", ""),//LETTER HEH WITH YEH ABOVE
        Rule("ہ", ""),//LETTER HEH GOAL
        Rule("ۂ", ""),//LETTER HEH GOAL WITH HAMZA ABOVE
        Rule("ۃ", ""),//LETTER TEH MARBUTA GOAL
        Rule("ۄ", ""),//LETTER WAW WITH RING
        Rule("ۅ", ""),//LETTER KIRGHIZ OE
        Rule("ۆ", ""),//LETTER OE
        Rule("ۇ", ""),//LETTER U
        Rule("ۈ", ""),//LETTER YU
        Rule("ۉ", ""),//LETTER KIRGHIZ YU
        Rule("ۊ", ""),//LETTER WAW WITH TWO DOTS ABOVE
        Rule("ۋ", ""),//LETTER VE
        Rule("ی", ""),//LETTER FARSI YEH
        Rule("ۍ", ""),//LETTER YEH WITH TAIL
        Rule("ێ", ""),//LETTER YEH WITH SMALL V
        Rule("ۏ", ""),//LETTER WAW WITH DOT ABOVE
        Rule("ې", ""),//LETTER E
        Rule("ۑ", ""),//LETTER YEH WITH THREE DOTS BELOW
        Rule("ے", ""),//LETTER YEH BARREE
        Rule("ۓ", ""),//LETTER YEH BARREE WITH HAMZA ABOVE
        Rule("۔", "."),//FULL STOP
        Rule("ە", ""),//LETTER AE
        Rule("ۖ", ""),//SMALL HIGH LIGATURE SAD WITH LAM WITH ALEF MAKSURA
        Rule("ۗ", ""),//SMALL HIGH LIGATURE QAF WITH LAM WITH ALEF MAKSURA
        Rule("ۘ", ""),//SMALL HIGH MEEM INITIAL FORM
        Rule("ۙ", ""),//SMALL HIGH LAM ALEF
        Rule("ۚ", ""),//SMALL HIGH JEEM
        Rule("ۛ", ""),//SMALL HIGH THREE DOTS
        Rule("ۜ", ""),//SMALL HIGH SEEN
        Rule("۝", ""),//END OF AYAH
        Rule("۞", ""),//START OF RUB EL HIZB
        Rule("۟", ""),//SMALL HIGH ROUNDED ZERO
        Rule("۠", ""),//SMALL HIGH UPRIGHT RECTANGULAR ZERO
        Rule("ۡ", ""),//SMALL HIGH DOTLESS HEAD OF KHAH
        Rule("ۢ", ""),//SMALL HIGH MEEM ISOLATED FORM
        Rule("ۣ", ""),//SMALL LOW SEEN
        Rule("ۤ", ""),//SMALL HIGH MADDA
        Rule("ۥ", ""),//SMALL WAW
        Rule("ۦ", ""),//SMALL YEH
        Rule("ۧ", ""),//SMALL HIGH YEH
        Rule("ۨ", ""),//SMALL HIGH NOON
        Rule("۩", ""),//PLACE OF SAJDAH
        Rule("۪", ""),//EMPTY CENTRE LOW STOP
        Rule("۫", ""),//EMPTY CENTRE HIGH STOP
        Rule("۬", ""),//ROUNDED HIGH STOP WITH FILLED CENTRE
        Rule("ۭ", ""),//SMALL LOW MEEM
        Rule("ۮ", ""),//LETTER DAL WITH INVERTED V
        Rule("ۯ", ""),//LETTER REH WITH INVERTED V
        Rule("۰", ""),//EXTENDED ARABIC-INDIC DIGIT ZERO
        Rule("۱", ""),//EXTENDED ARABIC-INDIC DIGIT ONE
        Rule("۲", ""),//EXTENDED ARABIC-INDIC DIGIT TWO
        Rule("۳", ""),//EXTENDED ARABIC-INDIC DIGIT THREE
        Rule("۴", ""),//EXTENDED ARABIC-INDIC DIGIT FOUR
        Rule("۵", ""),//EXTENDED ARABIC-INDIC DIGIT FIVE
        Rule("۶", ""),//EXTENDED ARABIC-INDIC DIGIT SIX
        Rule("۷", ""),//EXTENDED ARABIC-INDIC DIGIT SEVEN
        Rule("۸", ""),//EXTENDED ARABIC-INDIC DIGIT EIGHT
        Rule("۹", ""),//EXTENDED ARABIC-INDIC DIGIT NINE
        Rule("ۺ", ""),//LETTER SHEEN WITH DOT BELOW
        Rule("ۻ", ""),//LETTER DAD WITH DOT BELOW
        Rule("ۼ", ""),//LETTER GHAIN WITH DOT BELOW
        Rule("۽", ""),//SIGN SINDHI AMPERSAND
        Rule("۾", ""),//SIGN SINDHI POSTPOSITION MEN
        Rule("ۿ", "")//LETTER HEH WITH INVERTED V   Lo  Arabic
    )

}