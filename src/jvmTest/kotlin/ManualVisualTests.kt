import com.github.medavox.ipa_transcribers.Transcriber
import com.github.medavox.ipa_transcribers.arabic.*
import com.github.medavox.ipa_transcribers.latin.*
import com.github.medavox.ipa_transcribers.brahmic.*
import com.github.medavox.ipa_transcribers.other.*
import org.junit.Test

/**Runs each transcriber against a provided snippet of text in the native orthography,
 * allowing us the manually inspect the IPA output*/
class ManualVisualTests {
    @Test
    fun testItalian() {
        tist("dammi tutte le tue copie", Italian)
    }
    @Test
    fun testPersian() {
        val inp = "نازنین بنیادی\u200E"
        val ipa = Persian.transcribe(inp)
        println("original  = $inp")
        println("rule-based=/$ipa/")
    }
    @Test
    fun testPersian2() {
        val inp = "من به هر کپی شما نیاز دارم"
        val ipa = Persian.transcribe(inp)
        println("original  = $inp")
        println("rule-based=/$ipa/")
    }
    @Test
    fun testBengali() {
        tist("বাংলা লিপি এবং তার অক্ষর-হরফের উৎস বা উৎপত্তি কীভাবে হল, তা এখনো অজানা, " +
                "কিন্তু গবেষণাসহ মনে করা হয় যে বাংলা লিপির ব্যবহার খ্রিস্টাব্দ একাদশ শতক থেকে প্রচলিত।[১] " +
                "বাংলা লিপির ব্যবহার প্রায়ই মধ্যযুগীয় ভারতের পূর্বাঞ্চলে এবং তারপর পাল সাম্রাজ্যের মধ্যে ব্যবহার ছিল। পরে " +
                "বিশেষভাবে বাংলার অঞ্চলে ব্যবহার করা অব্যাহত ছিল। পরে বাংলা লিপিটিকে ব্রিটিশ ইস্ট ইন্ডিয়া কোম্পানির " +
                "রাজত্বের অধীনে ঈশ্বরচন্দ্র বিদ্যাসাগর দ্বারা আধুনিক বাংলা লিপিতে প্রমিত করা হয়েছিল। বর্তমান দিনে বাংলা " +
                "লিপিটি বাংলাদেশ ও ভারতে সরকারী লিপির পদমর্যাদা স্থানে আছে, এবং বাংলার মানুষের দৈনন্দিন জীবনের সঙ্গে যুক্ত আছে।" +
                " . পশ্চাদ্দন্তমূলীয়",
            Bengali)
    }
    @Test
    fun testArabicGoogleRomanised() {
        tist("nas hakim lah sirun qatie wadhu shan eazim maktub ealaa thwb 'akhdur wamughlaf bijald 'azraq",
            ArabicGoogleRomanised)
    }
    //val inp = "यह लेख एक आधार है। जानकारी जोड़कर इसे बढ़ाने में विकिपीडिया की मदद करें।"
    @Test
    fun testRussian() {
        tist("Старославянский язык, будучи языком церкви, испытывал на себе влияние древнерусского языка.",
            RussianCyrillic)
    }
    @Test
    fun testEnglish() {
        tist("at least try to COUGH Into my handkerchief, you dirty little blighter. " +
                "Your games have almost killed me", English)
    }
    //val inp = "shite shit"
    @Test
    fun testSpanishPanAmerican() {
        tist("Cinco de Mayo", SpanishPanAmerican)
    }
    @Test
    fun testHindi() {
        tist("यह लेख एक आधार है। जानकारी जोड़कर इसे बढ़ाने में विकिपीडिया की मदद करें। . " +
                "तियानानमेन चौक विरोध प्रदर्शन, १९८९",
            Hindi)
    }
    @Test
    fun testKorean() {
        tist("동료 시위대에 대한 적개심", KoreanHangeul)
    }
    @Test
    fun testFrench() {
        tist("Wikipédia est un projet d’encyclopédie collective en ligne, universelle, " +
                "multilingue et fonctionnant sur le principe du wiki. " +
                "Ce projet vise à offrir un contenu librement réutilisable, " +
                "objectif et vérifiable, que chacun peut modifier et améliorer. Bonheureusement",
            French)
    }

    @Test
    fun testJapanese() {
        tist("参考になった", JapaneseOnlyKatakanaHiragana)
    }
    @Test
    fun testJapanese2() {
        val inp="荷重"
        val ipa = JapaneseOnlyKatakanaHiragana.transcribe(inp)
        println("original  = $inp")
        println("rule-based=/$ipa/")
    }
    @Test
    fun testTelugu() {
        tist("""లోహశాసనాలకే లౌహికములని మరో పేరు. సంఖ్యాపరంగా చూస్తే శిలాశాసనాల కన్నా ఇవి చాలా తక్కువ
            | సంఖ్యలో ఉన్నాయి. కానీ వీటి చారిత్రిక ప్రాధాన్యత చాలా ఎక్కువ. పల్లవ, కదంబ, గాంగ, 
            | చాళుక్యాది వంశాల చరిత్ర ప్రధానంగా లోహశాలనాలపై ఆధారపడి ఉన్నాయి. ఈ శాసనాలను ప్రజలు ఏవో యంత్రాలను,
            |  మంత్రతంత్రాలకు సంబంధించిన వివరాలేవో వాటిలో వ్రాసి వున్నాయని భావించడంతో చాలా శాసనాలు వెలుగులోకి 
            |  రావట్లేదు. పలువురు వీటిని నిధినిక్షేపాలున్న ప్రదేశాల దారిని చూపే రహస్యమిందులో వ్రాసివుందని భావించి 
            |  ప్రభుత్వానికి ఇవ్వక తమ వద్దే దాచుకునే మూర్ఖత వల్ల ఎంతో చరిత్ర కాలగర్భంలోనే ఉండిపోయింది. 
            |  కొందరు తామ్రశాసనాలను కరిగించి ఇంటికి ఉపయోగించే చెంబులు, తపేలాలు, గుండిగలు వంటివి 
            |  తయారుచేసుకున్నారు. వీటివల్ల ఎంతో విలువైన చారిత్రిక సమాచారం నశించిపోయింది[1]. """.trimMargin(),
            Telugu)
    }
    @Test
    fun testArabic() {
        tist("نص حكيم له سر قاطع وذو شأن عظيم مكتوب على ثوب أخضر ومغلف بجلد أزرق", Arabic)
    }
    @Test
    fun testGerman() {
        tist("das ist super eigentlich vorstellung für mich", German)
    }

    private fun tist(inp:String, transcriber:Transcriber) {
        val ipa = transcriber.transcribe(inp)
        println("original  = $inp")
        println("rule-based=/$ipa/")
    }
}