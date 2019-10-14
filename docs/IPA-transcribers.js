(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'IPA-transcribers'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'IPA-transcribers'.");
    }
    root['IPA-transcribers'] = factory(typeof this['IPA-transcribers'] === 'undefined' ? {} : this['IPA-transcribers'], kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var Regex_init = Kotlin.kotlin.text.Regex_init_61zpoe$;
  var listOf = Kotlin.kotlin.collections.listOf_i5x0yv$;
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var Enum = Kotlin.kotlin.Enum;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var throwISE = Kotlin.throwISE;
  var plus = Kotlin.kotlin.collections.plus_mydzjv$;
  var throwCCE = Kotlin.throwCCE;
  var equals = Kotlin.equals;
  var hashCode = Kotlin.hashCode;
  var toString = Kotlin.toString;
  var emptyList = Kotlin.kotlin.collections.emptyList_287e2$;
  var contains = Kotlin.kotlin.text.contains_sgbm27$;
  var lastOrNull = Kotlin.kotlin.sequences.lastOrNull_veqyi0$;
  var Triple = Kotlin.kotlin.Triple;
  var ensureNotNull = Kotlin.ensureNotNull;
  var collectionSizeOrDefault = Kotlin.kotlin.collections.collectionSizeOrDefault_ba2ldo$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_ww73n8$;
  var ArrayList_init_0 = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var getCallableRef = Kotlin.getCallableRef;
  var NotImplementedError_init = Kotlin.kotlin.NotImplementedError;
  var endsWith = Kotlin.kotlin.text.endsWith_7epoxm$;
  var IllegalArgumentException_init = Kotlin.kotlin.IllegalArgumentException_init_pdl1vj$;
  var contains_0 = Kotlin.kotlin.text.contains_li3zpu$;
  var replace = Kotlin.kotlin.text.replace_680rmw$;
  var Unit = Kotlin.kotlin.Unit;
  CompletionStatus.prototype = Object.create(Enum.prototype);
  CompletionStatus.prototype.constructor = CompletionStatus;
  Language.prototype = Object.create(Enum.prototype);
  Language.prototype.constructor = Language;
  Rule.prototype = Object.create(IRule.prototype);
  Rule.prototype.constructor = Rule;
  EverythingRule.prototype = Object.create(IRule.prototype);
  EverythingRule.prototype.constructor = EverythingRule;
  RevisingRule.prototype = Object.create(IRule.prototype);
  RevisingRule.prototype.constructor = RevisingRule;
  CapturingRule.prototype = Object.create(IRule.prototype);
  CapturingRule.prototype.constructor = CapturingRule;
  LookbackRule.prototype = Object.create(IRule.prototype);
  LookbackRule.prototype.constructor = LookbackRule;
  Arabic.prototype = Object.create(RuleBasedTranscriber.prototype);
  Arabic.prototype.constructor = Arabic;
  Persian.prototype = Object.create(RuleBasedTranscriber.prototype);
  Persian.prototype.constructor = Persian;
  PunjabiShahmukhi.prototype = Object.create(RuleBasedTranscriber.prototype);
  PunjabiShahmukhi.prototype.constructor = PunjabiShahmukhi;
  Urdu.prototype = Object.create(RuleBasedTranscriber.prototype);
  Urdu.prototype.constructor = Urdu;
  Bengali.prototype = Object.create(RuleBasedTranscriber.prototype);
  Bengali.prototype.constructor = Bengali;
  Gujarati.prototype = Object.create(RuleBasedTranscriber.prototype);
  Gujarati.prototype.constructor = Gujarati;
  Hindi.prototype = Object.create(RuleBasedTranscriber.prototype);
  Hindi.prototype.constructor = Hindi;
  Marathi.prototype = Object.create(RuleBasedTranscriber.prototype);
  Marathi.prototype.constructor = Marathi;
  PunjabiGurmukhi.prototype = Object.create(RuleBasedTranscriber.prototype);
  PunjabiGurmukhi.prototype.constructor = PunjabiGurmukhi;
  Tamil.prototype = Object.create(RuleBasedTranscriber.prototype);
  Tamil.prototype.constructor = Tamil;
  Telugu.prototype = Object.create(RuleBasedTranscriber.prototype);
  Telugu.prototype.constructor = Telugu;
  ChinesePinyin$Mode.prototype = Object.create(Enum.prototype);
  ChinesePinyin$Mode.prototype.constructor = ChinesePinyin$Mode;
  ChinesePinyin.prototype = Object.create(RuleBasedTranscriber.prototype);
  ChinesePinyin.prototype.constructor = ChinesePinyin;
  English.prototype = Object.create(RuleBasedTranscriber.prototype);
  English.prototype.constructor = English;
  FilipinoTagalog.prototype = Object.create(RuleBasedTranscriber.prototype);
  FilipinoTagalog.prototype.constructor = FilipinoTagalog;
  French.prototype = Object.create(RuleBasedTranscriber.prototype);
  French.prototype.constructor = French;
  German$Vowels.prototype = Object.create(Enum.prototype);
  German$Vowels.prototype.constructor = German$Vowels;
  German.prototype = Object.create(RuleBasedTranscriber.prototype);
  German.prototype.constructor = German;
  Hausa.prototype = Object.create(RuleBasedTranscriber.prototype);
  Hausa.prototype.constructor = Hausa;
  IndonesianMalay.prototype = Object.create(RuleBasedTranscriber.prototype);
  IndonesianMalay.prototype.constructor = IndonesianMalay;
  Italian.prototype = Object.create(RuleBasedTranscriber.prototype);
  Italian.prototype.constructor = Italian;
  PortugueseBrazilian.prototype = Object.create(RuleBasedTranscriber.prototype);
  PortugueseBrazilian.prototype.constructor = PortugueseBrazilian;
  PortugueseEuropean.prototype = Object.create(RuleBasedTranscriber.prototype);
  PortugueseEuropean.prototype.constructor = PortugueseEuropean;
  SpanishPanAmerican.prototype = Object.create(RuleBasedTranscriber.prototype);
  SpanishPanAmerican.prototype.constructor = SpanishPanAmerican;
  SpanishPeninsular.prototype = Object.create(RuleBasedTranscriber.prototype);
  SpanishPeninsular.prototype.constructor = SpanishPeninsular;
  Swahili.prototype = Object.create(RuleBasedTranscriber.prototype);
  Swahili.prototype.constructor = Swahili;
  Turkish.prototype = Object.create(RuleBasedTranscriber.prototype);
  Turkish.prototype.constructor = Turkish;
  Vietnamese.prototype = Object.create(RuleBasedTranscriber.prototype);
  Vietnamese.prototype.constructor = Vietnamese;
  ChineseBopomofoZhuyin.prototype = Object.create(RuleBasedTranscriber.prototype);
  ChineseBopomofoZhuyin.prototype.constructor = ChineseBopomofoZhuyin;
  JapaneseOnlyKatakanaHiragana.prototype = Object.create(RuleBasedTranscriber.prototype);
  JapaneseOnlyKatakanaHiragana.prototype.constructor = JapaneseOnlyKatakanaHiragana;
  KoreanHangeul.prototype = Object.create(RuleBasedTranscriber.prototype);
  KoreanHangeul.prototype.constructor = KoreanHangeul;
  RussianCyrillic.prototype = Object.create(RuleBasedTranscriber.prototype);
  RussianCyrillic.prototype.constructor = RussianCyrillic;
  Thai.prototype = Object.create(RuleBasedTranscriber.prototype);
  Thai.prototype.constructor = Thai;
  function UiStrings() {
    UiStrings_instance = this;
    this.errorsHint = 'errors appear here';
    this.outputHint = 'transliteration appears here';
    this.inputHint = 'enter native text';
  }
  UiStrings.$metadata$ = {kind: Kind_OBJECT, simpleName: 'UiStrings', interfaces: []};
  var UiStrings_instance = null;
  function UiStrings_getInstance() {
    if (UiStrings_instance === null) {
      new UiStrings();
    }
    return UiStrings_instance;
  }
  function BaseRules() {
  }
  Object.defineProperty(BaseRules.prototype, 'westernPunctuation', {get: function () {
    return listOf([Rule_init(' ', ' '), Rule_init(',', ','), new Rule(Regex_init('\\.'), '.')]);
  }});
  Object.defineProperty(BaseRules.prototype, 'comprehensiveArabic', {get: function () {
    return listOf([Rule_init('\u0600', '\u2116'), Rule_init('\u0601', ''), Rule_init('\u0602', ''), Rule_init('\u0603', ''), Rule_init('\u0604', ''), Rule_init('\u0605', ''), Rule_init('\u0606', ''), Rule_init('\u0607', ''), Rule_init('\u0608', ''), Rule_init('\u0609', '\u2030'), Rule_init('\u060A', '\u2031'), Rule_init('\u060B', ''), Rule_init('\u060C', ','), Rule_init('\u060D', ''), Rule_init('\u060E', ''), Rule_init('\u060F', ''), Rule_init('\u0610', ''), Rule_init('\u0611', ''), Rule_init('\u0612', ''), Rule_init('\u0613', ''), Rule_init('\u0614', ''), Rule_init('\u0615', ''), Rule_init('\u0616', ''), Rule_init('\u0617', ''), Rule_init('\u0618', ''), Rule_init('\u0619', ''), Rule_init('\u061A', ''), Rule_init('\u061B', ';'), Rule_init('\u061C', ''), Rule_init('\u061E', '\u2026'), Rule_init('\u061F', '?'), Rule_init('\u0620', ''), Rule_init('\u0621', ''), Rule_init('\u0622', ''), Rule_init('\u0623', ''), Rule_init('\u0624', ''), Rule_init('\u0625', ''), Rule_init('\u0626', ''), Rule_init('\u0627', ''), Rule_init('\u0628', 'b'), Rule_init('\u0629', ''), Rule_init('\u062A', 't'), Rule_init('\u062B', '\u03B8'), Rule_init('\u062C', 'd\u0361\u0292'), Rule_init('\u062D', '\u0127'), Rule_init('\u062E', 'x'), Rule_init('\u062F', 'd'), Rule_init('\u0630', '\xF0'), Rule_init('\u0631', 'r'), Rule_init('\u0632', 'z'), Rule_init('\u0633', 's'), Rule_init('\u0634', '\u0283'), Rule_init('\u0635', 's\u02E4'), Rule_init('\u0636', 'd\u02E4'), Rule_init('\u0637', 't\u02E4'), Rule_init('\u0638', '\xF0\u02E4'), Rule_init('\u0639', '\u0295'), Rule_init('\u063A', '\u0263'), Rule_init('\u063B', ''), Rule_init('\u063C', ''), Rule_init('\u063D', ''), Rule_init('\u063E', ''), Rule_init('\u063F', ''), Rule_init('\u0640', ''), Rule_init('\u0641', 'f'), Rule_init('\u0642', 'q'), Rule_init('\u0643', 'k'), Rule_init('\u0644', 'l'), Rule_init('\u0645', 'm'), Rule_init('\u0646', 'n'), Rule_init('\u0647', 'h'), Rule_init('\u0648', ''), Rule_init('\u0649', ''), Rule_init('\u064A', ''), Rule_init('\u064B', ''), Rule_init('\u064C', ''), Rule_init('\u064D', ''), Rule_init('\u064E', ''), Rule_init('\u064F', ''), Rule_init('\u0650', ''), Rule_init('\u0651', ''), Rule_init('\u0652', ''), Rule_init('\u0653', ''), Rule_init('\u0654', ''), Rule_init('\u0655', ''), Rule_init('\u0656', ''), Rule_init('\u0657', ''), Rule_init('\u0658', ''), Rule_init('\u0659', ''), Rule_init('\u065A', ''), Rule_init('\u065B', ''), Rule_init('\u065C', ''), Rule_init('\u065D', ''), Rule_init('\u065E', ''), Rule_init('\u065F', ''), Rule_init('\u0660', '0'), Rule_init('\u0661', '1'), Rule_init('\u0662', '2'), Rule_init('\u0663', '3'), Rule_init('\u0664', '4'), Rule_init('\u0665', '5'), Rule_init('\u0666', '6'), Rule_init('\u0667', '7'), Rule_init('\u0668', '8'), Rule_init('\u0669', '9'), Rule_init('\u066A', '%'), Rule_init('\u066B', '.'), Rule_init('\u066C', ','), Rule_init('\u066D', '*'), Rule_init('\u066E', ''), Rule_init('\u066F', ''), Rule_init('\u0670', ''), Rule_init('\u0671', ''), Rule_init('\u0672', ''), Rule_init('\u0673', ''), Rule_init('\u0674', ''), Rule_init('\u0675', ''), Rule_init('\u0676', ''), Rule_init('\u0677', ''), Rule_init('\u0678', ''), Rule_init('\u0679', ''), Rule_init('\u067A', ''), Rule_init('\u067B', ''), Rule_init('\u067C', ''), Rule_init('\u067D', ''), Rule_init('\u067E', ''), Rule_init('\u067F', ''), Rule_init('\u0680', ''), Rule_init('\u0681', ''), Rule_init('\u0682', ''), Rule_init('\u0683', ''), Rule_init('\u0684', ''), Rule_init('\u0685', ''), Rule_init('\u0686', ''), Rule_init('\u0687', ''), Rule_init('\u0688', ''), Rule_init('\u0689', ''), Rule_init('\u068A', ''), Rule_init('\u068B', ''), Rule_init('\u068C', ''), Rule_init('\u068D', ''), Rule_init('\u068E', ''), Rule_init('\u068F', ''), Rule_init('\u0690', ''), Rule_init('\u0691', ''), Rule_init('\u0692', ''), Rule_init('\u0693', ''), Rule_init('\u0694', ''), Rule_init('\u0695', ''), Rule_init('\u0696', ''), Rule_init('\u0697', ''), Rule_init('\u0698', ''), Rule_init('\u0699', ''), Rule_init('\u069A', ''), Rule_init('\u069B', ''), Rule_init('\u069C', ''), Rule_init('\u069D', ''), Rule_init('\u069E', ''), Rule_init('\u069F', ''), Rule_init('\u06A0', ''), Rule_init('\u06A1', ''), Rule_init('\u06A2', ''), Rule_init('\u06A3', ''), Rule_init('\u06A4', ''), Rule_init('\u06A5', ''), Rule_init('\u06A6', ''), Rule_init('\u06A7', ''), Rule_init('\u06A8', ''), Rule_init('\u06A9', ''), Rule_init('\u06AA', ''), Rule_init('\u06AB', ''), Rule_init('\u06AC', ''), Rule_init('\u06AD', ''), Rule_init('\u06AE', ''), Rule_init('\u06AF', ''), Rule_init('\u06B0', ''), Rule_init('\u06B1', ''), Rule_init('\u06B2', ''), Rule_init('\u06B3', ''), Rule_init('\u06B4', ''), Rule_init('\u06B5', ''), Rule_init('\u06B6', ''), Rule_init('\u06B7', ''), Rule_init('\u06B8', ''), Rule_init('\u06B9', ''), Rule_init('\u06BA', ''), Rule_init('\u06BB', ''), Rule_init('\u06BC', ''), Rule_init('\u06BD', ''), Rule_init('\u06BE', ''), Rule_init('\u06BF', ''), Rule_init('\u06C0', ''), Rule_init('\u06C1', ''), Rule_init('\u06C2', ''), Rule_init('\u06C3', ''), Rule_init('\u06C4', ''), Rule_init('\u06C5', ''), Rule_init('\u06C6', ''), Rule_init('\u06C7', ''), Rule_init('\u06C8', ''), Rule_init('\u06C9', ''), Rule_init('\u06CA', ''), Rule_init('\u06CB', ''), Rule_init('\u06CC', ''), Rule_init('\u06CD', ''), Rule_init('\u06CE', ''), Rule_init('\u06CF', ''), Rule_init('\u06D0', ''), Rule_init('\u06D1', ''), Rule_init('\u06D2', ''), Rule_init('\u06D3', ''), Rule_init('\u06D4', '.'), Rule_init('\u06D5', ''), Rule_init('\u06D6', ''), Rule_init('\u06D7', ''), Rule_init('\u06D8', ''), Rule_init('\u06D9', ''), Rule_init('\u06DA', ''), Rule_init('\u06DB', ''), Rule_init('\u06DC', ''), Rule_init('\u06DD', ''), Rule_init('\u06DE', ''), Rule_init('\u06DF', ''), Rule_init('\u06E0', ''), Rule_init('\u06E1', ''), Rule_init('\u06E2', ''), Rule_init('\u06E3', ''), Rule_init('\u06E4', ''), Rule_init('\u06E5', ''), Rule_init('\u06E6', ''), Rule_init('\u06E7', ''), Rule_init('\u06E8', ''), Rule_init('\u06E9', ''), Rule_init('\u06EA', ''), Rule_init('\u06EB', ''), Rule_init('\u06EC', ''), Rule_init('\u06ED', ''), Rule_init('\u06EE', ''), Rule_init('\u06EF', ''), Rule_init('\u06F0', ''), Rule_init('\u06F1', ''), Rule_init('\u06F2', ''), Rule_init('\u06F3', ''), Rule_init('\u06F4', ''), Rule_init('\u06F5', ''), Rule_init('\u06F6', ''), Rule_init('\u06F7', ''), Rule_init('\u06F8', ''), Rule_init('\u06F9', ''), Rule_init('\u06FA', ''), Rule_init('\u06FB', ''), Rule_init('\u06FC', ''), Rule_init('\u06FD', ''), Rule_init('\u06FE', ''), Rule_init('\u06FF', '')]);
  }});
  BaseRules.$metadata$ = {kind: Kind_INTERFACE, simpleName: 'BaseRules', interfaces: []};
  function CompletionStatus(name, ordinal) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function CompletionStatus_initFields() {
    CompletionStatus_initFields = function () {
    };
    CompletionStatus$UNSTARTED_instance = new CompletionStatus('UNSTARTED', 0);
    CompletionStatus$INCOMPLETE_instance = new CompletionStatus('INCOMPLETE', 1);
    CompletionStatus$IN_PROGRESS_instance = new CompletionStatus('IN_PROGRESS', 2);
    CompletionStatus$SURFACE_LEVEL_COMPLETE_instance = new CompletionStatus('SURFACE_LEVEL_COMPLETE', 3);
    CompletionStatus$COMPLETE_PARTIAL_instance = new CompletionStatus('COMPLETE_PARTIAL', 4);
    CompletionStatus$COMPLETE_instance = new CompletionStatus('COMPLETE', 5);
  }
  var CompletionStatus$UNSTARTED_instance;
  function CompletionStatus$UNSTARTED_getInstance() {
    CompletionStatus_initFields();
    return CompletionStatus$UNSTARTED_instance;
  }
  var CompletionStatus$INCOMPLETE_instance;
  function CompletionStatus$INCOMPLETE_getInstance() {
    CompletionStatus_initFields();
    return CompletionStatus$INCOMPLETE_instance;
  }
  var CompletionStatus$IN_PROGRESS_instance;
  function CompletionStatus$IN_PROGRESS_getInstance() {
    CompletionStatus_initFields();
    return CompletionStatus$IN_PROGRESS_instance;
  }
  var CompletionStatus$SURFACE_LEVEL_COMPLETE_instance;
  function CompletionStatus$SURFACE_LEVEL_COMPLETE_getInstance() {
    CompletionStatus_initFields();
    return CompletionStatus$SURFACE_LEVEL_COMPLETE_instance;
  }
  var CompletionStatus$COMPLETE_PARTIAL_instance;
  function CompletionStatus$COMPLETE_PARTIAL_getInstance() {
    CompletionStatus_initFields();
    return CompletionStatus$COMPLETE_PARTIAL_instance;
  }
  var CompletionStatus$COMPLETE_instance;
  function CompletionStatus$COMPLETE_getInstance() {
    CompletionStatus_initFields();
    return CompletionStatus$COMPLETE_instance;
  }
  CompletionStatus.$metadata$ = {kind: Kind_CLASS, simpleName: 'CompletionStatus', interfaces: [Enum]};
  function CompletionStatus$values() {
    return [CompletionStatus$UNSTARTED_getInstance(), CompletionStatus$INCOMPLETE_getInstance(), CompletionStatus$IN_PROGRESS_getInstance(), CompletionStatus$SURFACE_LEVEL_COMPLETE_getInstance(), CompletionStatus$COMPLETE_PARTIAL_getInstance(), CompletionStatus$COMPLETE_getInstance()];
  }
  CompletionStatus.values = CompletionStatus$values;
  function CompletionStatus$valueOf(name) {
    switch (name) {
      case 'UNSTARTED':
        return CompletionStatus$UNSTARTED_getInstance();
      case 'INCOMPLETE':
        return CompletionStatus$INCOMPLETE_getInstance();
      case 'IN_PROGRESS':
        return CompletionStatus$IN_PROGRESS_getInstance();
      case 'SURFACE_LEVEL_COMPLETE':
        return CompletionStatus$SURFACE_LEVEL_COMPLETE_getInstance();
      case 'COMPLETE_PARTIAL':
        return CompletionStatus$COMPLETE_PARTIAL_getInstance();
      case 'COMPLETE':
        return CompletionStatus$COMPLETE_getInstance();
      default:throwISE('No enum constant com.github.medavox.ipa_transcribers.CompletionStatus.' + name);
    }
  }
  CompletionStatus.valueOf_61zpoe$ = CompletionStatus$valueOf;
  var IpaToTukiNuwa_instance = null;
  function Language(name, ordinal, neim, transcriber) {
    Enum.call(this);
    this.neim = neim;
    this.transcriber = transcriber;
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function Language_initFields() {
    Language_initFields = function () {
    };
    Language$ARABIC_instance = new Language('ARABIC', 0, 'Arabic', Arabic_getInstance());
    Language$BENGALI_instance = new Language('BENGALI', 1, 'Bengali', Bengali_getInstance());
    Language$CHINESE_BOPOMOFO_instance = new Language('CHINESE_BOPOMOFO', 2, 'Chinese Bopomofo (Zhuyin)', ChineseBopomofoZhuyin_getInstance());
    Language$CHINESE_PINYIN_instance = new Language('CHINESE_PINYIN', 3, 'Chinese Pinyin', ChinesePinyin_getInstance());
    Language$ENGLISH_instance = new Language('ENGLISH', 4, 'English', English_getInstance());
    Language$FILIPINO_TAGALOG_instance = new Language('FILIPINO_TAGALOG', 5, 'Filipino/Tagalog', FilipinoTagalog_getInstance());
    Language$FRENCH_instance = new Language('FRENCH', 6, 'French', French_getInstance());
    Language$GERMAN_instance = new Language('GERMAN', 7, 'German', German_getInstance());
    Language$GUJARATI_instance = new Language('GUJARATI', 8, 'Gujarati', Gujarati_getInstance());
    Language$HAUSA_instance = new Language('HAUSA', 9, 'Hausa', Hausa_getInstance());
    Language$HINDI_instance = new Language('HINDI', 10, 'Hindi', Hindi_getInstance());
    Language$INDONESIAN_MALAY_instance = new Language('INDONESIAN_MALAY', 11, 'Indonesian//Malay', IndonesianMalay_getInstance());
    Language$ITALIAN_instance = new Language('ITALIAN', 12, 'Italian', Italian_getInstance());
    Language$JAPANESE_LIMITED_instance = new Language('JAPANESE_LIMITED', 13, 'Japanese (Katakana & Hiragana Only)', JapaneseOnlyKatakanaHiragana_getInstance());
    Language$KOREAN_instance = new Language('KOREAN', 14, 'Korean', KoreanHangeul_getInstance());
    Language$MALAY_instance = new Language('MALAY', 15, 'Malay', IndonesianMalay_getInstance());
    Language$MARATHI_instance = new Language('MARATHI', 16, 'Marathi', Marathi_getInstance());
    Language$PERSIAN_instance = new Language('PERSIAN', 17, 'Persian/Farsi/Dari/Tajik', Persian_getInstance());
    Language$PORTUGUESE_BRAZILIAN_instance = new Language('PORTUGUESE_BRAZILIAN', 18, 'Portuguese (Brazilian)', PortugueseBrazilian_getInstance());
    Language$PORTUGUESE_EUROPEAN_instance = new Language('PORTUGUESE_EUROPEAN', 19, 'Portuguese (European)', PortugueseEuropean_getInstance());
    Language$PUNJABI_GURMUKHI_instance = new Language('PUNJABI_GURMUKHI', 20, 'Punjabi (Gurmukhi)', PunjabiGurmukhi_getInstance());
    Language$PUNJABI_SHAHMUKHI_instance = new Language('PUNJABI_SHAHMUKHI', 21, 'Punjabi (Shahmukhi)', PunjabiShahmukhi_getInstance());
    Language$RUSSIAN_instance = new Language('RUSSIAN', 22, 'Russian', RussianCyrillic_getInstance());
    Language$SPANISH_AMERICAN_instance = new Language('SPANISH_AMERICAN', 23, 'Spanish (Pan-American)', SpanishPanAmerican_getInstance());
    Language$SPANISH_EUROPEAN_instance = new Language('SPANISH_EUROPEAN', 24, 'Spanish (European)', SpanishPeninsular_getInstance());
    Language$SWAHILI_instance = new Language('SWAHILI', 25, 'Swahili', Swahili_getInstance());
    Language$TAMIL_instance = new Language('TAMIL', 26, 'Tamil', Tamil_getInstance());
    Language$TELUGU_instance = new Language('TELUGU', 27, 'Telugu', Telugu_getInstance());
    Language$THAI_instance = new Language('THAI', 28, 'Thai', Thai_getInstance());
    Language$TURKISH_instance = new Language('TURKISH', 29, 'Turkish', Turkish_getInstance());
    Language$URDU_instance = new Language('URDU', 30, 'Urdu', Urdu_getInstance());
    Language$VIETNAMESE_instance = new Language('VIETNAMESE', 31, 'Vietnamese', Vietnamese_getInstance());
  }
  var Language$ARABIC_instance;
  function Language$ARABIC_getInstance() {
    Language_initFields();
    return Language$ARABIC_instance;
  }
  var Language$BENGALI_instance;
  function Language$BENGALI_getInstance() {
    Language_initFields();
    return Language$BENGALI_instance;
  }
  var Language$CHINESE_BOPOMOFO_instance;
  function Language$CHINESE_BOPOMOFO_getInstance() {
    Language_initFields();
    return Language$CHINESE_BOPOMOFO_instance;
  }
  var Language$CHINESE_PINYIN_instance;
  function Language$CHINESE_PINYIN_getInstance() {
    Language_initFields();
    return Language$CHINESE_PINYIN_instance;
  }
  var Language$ENGLISH_instance;
  function Language$ENGLISH_getInstance() {
    Language_initFields();
    return Language$ENGLISH_instance;
  }
  var Language$FILIPINO_TAGALOG_instance;
  function Language$FILIPINO_TAGALOG_getInstance() {
    Language_initFields();
    return Language$FILIPINO_TAGALOG_instance;
  }
  var Language$FRENCH_instance;
  function Language$FRENCH_getInstance() {
    Language_initFields();
    return Language$FRENCH_instance;
  }
  var Language$GERMAN_instance;
  function Language$GERMAN_getInstance() {
    Language_initFields();
    return Language$GERMAN_instance;
  }
  var Language$GUJARATI_instance;
  function Language$GUJARATI_getInstance() {
    Language_initFields();
    return Language$GUJARATI_instance;
  }
  var Language$HAUSA_instance;
  function Language$HAUSA_getInstance() {
    Language_initFields();
    return Language$HAUSA_instance;
  }
  var Language$HINDI_instance;
  function Language$HINDI_getInstance() {
    Language_initFields();
    return Language$HINDI_instance;
  }
  var Language$INDONESIAN_MALAY_instance;
  function Language$INDONESIAN_MALAY_getInstance() {
    Language_initFields();
    return Language$INDONESIAN_MALAY_instance;
  }
  var Language$ITALIAN_instance;
  function Language$ITALIAN_getInstance() {
    Language_initFields();
    return Language$ITALIAN_instance;
  }
  var Language$JAPANESE_LIMITED_instance;
  function Language$JAPANESE_LIMITED_getInstance() {
    Language_initFields();
    return Language$JAPANESE_LIMITED_instance;
  }
  var Language$KOREAN_instance;
  function Language$KOREAN_getInstance() {
    Language_initFields();
    return Language$KOREAN_instance;
  }
  var Language$MALAY_instance;
  function Language$MALAY_getInstance() {
    Language_initFields();
    return Language$MALAY_instance;
  }
  var Language$MARATHI_instance;
  function Language$MARATHI_getInstance() {
    Language_initFields();
    return Language$MARATHI_instance;
  }
  var Language$PERSIAN_instance;
  function Language$PERSIAN_getInstance() {
    Language_initFields();
    return Language$PERSIAN_instance;
  }
  var Language$PORTUGUESE_BRAZILIAN_instance;
  function Language$PORTUGUESE_BRAZILIAN_getInstance() {
    Language_initFields();
    return Language$PORTUGUESE_BRAZILIAN_instance;
  }
  var Language$PORTUGUESE_EUROPEAN_instance;
  function Language$PORTUGUESE_EUROPEAN_getInstance() {
    Language_initFields();
    return Language$PORTUGUESE_EUROPEAN_instance;
  }
  var Language$PUNJABI_GURMUKHI_instance;
  function Language$PUNJABI_GURMUKHI_getInstance() {
    Language_initFields();
    return Language$PUNJABI_GURMUKHI_instance;
  }
  var Language$PUNJABI_SHAHMUKHI_instance;
  function Language$PUNJABI_SHAHMUKHI_getInstance() {
    Language_initFields();
    return Language$PUNJABI_SHAHMUKHI_instance;
  }
  var Language$RUSSIAN_instance;
  function Language$RUSSIAN_getInstance() {
    Language_initFields();
    return Language$RUSSIAN_instance;
  }
  var Language$SPANISH_AMERICAN_instance;
  function Language$SPANISH_AMERICAN_getInstance() {
    Language_initFields();
    return Language$SPANISH_AMERICAN_instance;
  }
  var Language$SPANISH_EUROPEAN_instance;
  function Language$SPANISH_EUROPEAN_getInstance() {
    Language_initFields();
    return Language$SPANISH_EUROPEAN_instance;
  }
  var Language$SWAHILI_instance;
  function Language$SWAHILI_getInstance() {
    Language_initFields();
    return Language$SWAHILI_instance;
  }
  var Language$TAMIL_instance;
  function Language$TAMIL_getInstance() {
    Language_initFields();
    return Language$TAMIL_instance;
  }
  var Language$TELUGU_instance;
  function Language$TELUGU_getInstance() {
    Language_initFields();
    return Language$TELUGU_instance;
  }
  var Language$THAI_instance;
  function Language$THAI_getInstance() {
    Language_initFields();
    return Language$THAI_instance;
  }
  var Language$TURKISH_instance;
  function Language$TURKISH_getInstance() {
    Language_initFields();
    return Language$TURKISH_instance;
  }
  var Language$URDU_instance;
  function Language$URDU_getInstance() {
    Language_initFields();
    return Language$URDU_instance;
  }
  var Language$VIETNAMESE_instance;
  function Language$VIETNAMESE_getInstance() {
    Language_initFields();
    return Language$VIETNAMESE_instance;
  }
  Language.$metadata$ = {kind: Kind_CLASS, simpleName: 'Language', interfaces: [Enum]};
  function Language$values() {
    return [Language$ARABIC_getInstance(), Language$BENGALI_getInstance(), Language$CHINESE_BOPOMOFO_getInstance(), Language$CHINESE_PINYIN_getInstance(), Language$ENGLISH_getInstance(), Language$FILIPINO_TAGALOG_getInstance(), Language$FRENCH_getInstance(), Language$GERMAN_getInstance(), Language$GUJARATI_getInstance(), Language$HAUSA_getInstance(), Language$HINDI_getInstance(), Language$INDONESIAN_MALAY_getInstance(), Language$ITALIAN_getInstance(), Language$JAPANESE_LIMITED_getInstance(), Language$KOREAN_getInstance(), Language$MALAY_getInstance(), Language$MARATHI_getInstance(), Language$PERSIAN_getInstance(), Language$PORTUGUESE_BRAZILIAN_getInstance(), Language$PORTUGUESE_EUROPEAN_getInstance(), Language$PUNJABI_GURMUKHI_getInstance(), Language$PUNJABI_SHAHMUKHI_getInstance(), Language$RUSSIAN_getInstance(), Language$SPANISH_AMERICAN_getInstance(), Language$SPANISH_EUROPEAN_getInstance(), Language$SWAHILI_getInstance(), Language$TAMIL_getInstance(), Language$TELUGU_getInstance(), Language$THAI_getInstance(), Language$TURKISH_getInstance(), Language$URDU_getInstance(), Language$VIETNAMESE_getInstance()];
  }
  Language.values = Language$values;
  function Language$valueOf(name) {
    switch (name) {
      case 'ARABIC':
        return Language$ARABIC_getInstance();
      case 'BENGALI':
        return Language$BENGALI_getInstance();
      case 'CHINESE_BOPOMOFO':
        return Language$CHINESE_BOPOMOFO_getInstance();
      case 'CHINESE_PINYIN':
        return Language$CHINESE_PINYIN_getInstance();
      case 'ENGLISH':
        return Language$ENGLISH_getInstance();
      case 'FILIPINO_TAGALOG':
        return Language$FILIPINO_TAGALOG_getInstance();
      case 'FRENCH':
        return Language$FRENCH_getInstance();
      case 'GERMAN':
        return Language$GERMAN_getInstance();
      case 'GUJARATI':
        return Language$GUJARATI_getInstance();
      case 'HAUSA':
        return Language$HAUSA_getInstance();
      case 'HINDI':
        return Language$HINDI_getInstance();
      case 'INDONESIAN_MALAY':
        return Language$INDONESIAN_MALAY_getInstance();
      case 'ITALIAN':
        return Language$ITALIAN_getInstance();
      case 'JAPANESE_LIMITED':
        return Language$JAPANESE_LIMITED_getInstance();
      case 'KOREAN':
        return Language$KOREAN_getInstance();
      case 'MALAY':
        return Language$MALAY_getInstance();
      case 'MARATHI':
        return Language$MARATHI_getInstance();
      case 'PERSIAN':
        return Language$PERSIAN_getInstance();
      case 'PORTUGUESE_BRAZILIAN':
        return Language$PORTUGUESE_BRAZILIAN_getInstance();
      case 'PORTUGUESE_EUROPEAN':
        return Language$PORTUGUESE_EUROPEAN_getInstance();
      case 'PUNJABI_GURMUKHI':
        return Language$PUNJABI_GURMUKHI_getInstance();
      case 'PUNJABI_SHAHMUKHI':
        return Language$PUNJABI_SHAHMUKHI_getInstance();
      case 'RUSSIAN':
        return Language$RUSSIAN_getInstance();
      case 'SPANISH_AMERICAN':
        return Language$SPANISH_AMERICAN_getInstance();
      case 'SPANISH_EUROPEAN':
        return Language$SPANISH_EUROPEAN_getInstance();
      case 'SWAHILI':
        return Language$SWAHILI_getInstance();
      case 'TAMIL':
        return Language$TAMIL_getInstance();
      case 'TELUGU':
        return Language$TELUGU_getInstance();
      case 'THAI':
        return Language$THAI_getInstance();
      case 'TURKISH':
        return Language$TURKISH_getInstance();
      case 'URDU':
        return Language$URDU_getInstance();
      case 'VIETNAMESE':
        return Language$VIETNAMESE_getInstance();
      default:throwISE('No enum constant com.github.medavox.ipa_transcribers.Language.' + name);
    }
  }
  Language.valueOf_61zpoe$ = Language$valueOf;
  function IRule(consumedMatcher, unconsumedMatcher, outputString, lettersConsumed) {
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    this.consumedMatcher = consumedMatcher;
    this.unconsumedMatcher = unconsumedMatcher;
    this.outputString = outputString;
    this.lettersConsumed = lettersConsumed;
  }
  IRule.prototype.copy_me0brw$ = function (consumedMatcher, unconsumedMatcher, outputString, lettersConsumed) {
    if (consumedMatcher === void 0)
      consumedMatcher = null;
    if (unconsumedMatcher === void 0)
      unconsumedMatcher = null;
    if (outputString === void 0)
      outputString = null;
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    return new EverythingRule(consumedMatcher != null ? consumedMatcher : this.consumedMatcher, unconsumedMatcher != null ? unconsumedMatcher : this.unconsumedMatcher, outputString != null ? outputString : this.outputString, lettersConsumed != null ? lettersConsumed : this.lettersConsumed);
  };
  function IRule$copy$lambda(closure$outputString) {
    return function (s, f) {
      return closure$outputString(s);
    };
  }
  IRule.prototype.copy_jubfao$ = function (consumedMatcher, unconsumedMatcher, outputString, lettersConsumed) {
    if (consumedMatcher === void 0)
      consumedMatcher = null;
    if (unconsumedMatcher === void 0)
      unconsumedMatcher = null;
    if (outputString === void 0)
      outputString = null;
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    return this.copy_me0brw$(consumedMatcher != null ? consumedMatcher : this.consumedMatcher, unconsumedMatcher != null ? unconsumedMatcher : this.unconsumedMatcher, outputString != null ? IRule$copy$lambda(outputString) : this.outputString, lettersConsumed != null ? lettersConsumed : this.lettersConsumed);
  };
  IRule.prototype.equals = function (other) {
    var tmp$, tmp$_0;
    if (this === other)
      return true;
    if (other == null || !((tmp$ = Kotlin.getKClassFromExpression(this)) != null ? tmp$.equals(Kotlin.getKClassFromExpression(other)) : null))
      return false;
    Kotlin.isType(tmp$_0 = other, IRule) ? tmp$_0 : throwCCE();
    if (!equals(this.consumedMatcher, other.consumedMatcher))
      return false;
    if (!equals(this.unconsumedMatcher, other.unconsumedMatcher))
      return false;
    if (!equals(this.outputString, other.outputString))
      return false;
    if (this.lettersConsumed != other.lettersConsumed)
      return false;
    return true;
  };
  IRule.prototype.hashCode = function () {
    var tmp$, tmp$_0, tmp$_1;
    var result = (tmp$_0 = (tmp$ = this.consumedMatcher) != null ? hashCode(tmp$) : null) != null ? tmp$_0 : 0;
    result = (31 * result | 0) + hashCode(this.unconsumedMatcher) | 0;
    result = (31 * result | 0) + hashCode(this.outputString) | 0;
    result = (31 * result | 0) + ((tmp$_1 = this.lettersConsumed) != null ? tmp$_1 : 0) | 0;
    return result;
  };
  IRule.prototype.toString = function () {
    return 'IRule(consumedMatcher=' + toString(this.consumedMatcher) + ', unconsumedMatcher=' + this.unconsumedMatcher + ', ' + ('outputString=' + this.outputString + ', lettersConsumed=' + toString(this.lettersConsumed) + ')');
  };
  IRule.$metadata$ = {kind: Kind_CLASS, simpleName: 'IRule', interfaces: []};
  function Rule(matcher, outputString, lettersConsumed) {
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    IRule.call(this, null, matcher, Rule_init$lambda(outputString), lettersConsumed);
  }
  function Rule_init$lambda(closure$outputString) {
    return function (s, f) {
      return s + closure$outputString;
    };
  }
  Rule.$metadata$ = {kind: Kind_CLASS, simpleName: 'Rule', interfaces: [IRule]};
  function Rule_init(match, outputString, lettersConsumed, $this) {
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    $this = $this || Object.create(Rule.prototype);
    Rule.call($this, Regex_init(match), outputString, lettersConsumed);
    return $this;
  }
  function EverythingRule(consumedMatcher, unconsumedMatcher, outputString, lettersConsumed) {
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    IRule.call(this, consumedMatcher, unconsumedMatcher, outputString, lettersConsumed);
  }
  EverythingRule.$metadata$ = {kind: Kind_CLASS, simpleName: 'EverythingRule', interfaces: [IRule]};
  function RevisingRule(match, outputString, lettersUsed) {
    if (lettersUsed === void 0)
      lettersUsed = null;
    IRule.call(this, null, match, RevisingRule_init$lambda(outputString), lettersUsed);
  }
  function RevisingRule_init$lambda(closure$outputString) {
    return function (s, f) {
      return closure$outputString(s);
    };
  }
  RevisingRule.$metadata$ = {kind: Kind_CLASS, simpleName: 'RevisingRule', interfaces: [IRule]};
  function RevisingRule_init(match, outputString, lettersUsed, $this) {
    if (lettersUsed === void 0)
      lettersUsed = null;
    $this = $this || Object.create(RevisingRule.prototype);
    RevisingRule.call($this, Regex_init(match), outputString, lettersUsed);
    return $this;
  }
  function CapturingRule(match, outputString, lettersConsumed) {
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    IRule.call(this, null, match, outputString, lettersConsumed);
  }
  CapturingRule.$metadata$ = {kind: Kind_CLASS, simpleName: 'CapturingRule', interfaces: [IRule]};
  function LookbackRule(consumedMatcher, unconsumedMatcher, output, lettersConsumed) {
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    IRule.call(this, consumedMatcher, unconsumedMatcher, LookbackRule_init$lambda(output), lettersConsumed);
  }
  function LookbackRule_init$lambda(closure$output) {
    return function (s, f) {
      return s + closure$output;
    };
  }
  LookbackRule.$metadata$ = {kind: Kind_CLASS, simpleName: 'LookbackRule', interfaces: [IRule]};
  function LookbackRule_init(consumedMatcher, unconsumedMatcher, output, lettersConsumed, $this) {
    if (lettersConsumed === void 0)
      lettersConsumed = null;
    $this = $this || Object.create(LookbackRule.prototype);
    LookbackRule.call($this, Regex_init(consumedMatcher), Regex_init(unconsumedMatcher), output, lettersConsumed);
    return $this;
  }
  var RuleBasedTemplate_instance = null;
  function RuleBasedTranscriber() {
    this.reportedChars_dk12tj$_0 = '';
  }
  function RuleBasedTranscriber$UnmatchedOutput(newWorkingInput, output) {
    this.newWorkingInput = newWorkingInput;
    this.output = output;
  }
  RuleBasedTranscriber$UnmatchedOutput.$metadata$ = {kind: Kind_CLASS, simpleName: 'UnmatchedOutput', interfaces: []};
  function RuleBasedTranscriber$RuleBasedTranscriber$UnmatchedOutput_init(newWorkingInput, output, $this) {
    $this = $this || Object.create(RuleBasedTranscriber$UnmatchedOutput.prototype);
    RuleBasedTranscriber$UnmatchedOutput.call($this, newWorkingInput, RuleBasedTranscriber$RuleBasedTranscriber$UnmatchedOutput_init$lambda(output));
    return $this;
  }
  RuleBasedTranscriber$UnmatchedOutput.prototype.component1 = function () {
    return this.newWorkingInput;
  };
  RuleBasedTranscriber$UnmatchedOutput.prototype.component2 = function () {
    return this.output;
  };
  RuleBasedTranscriber$UnmatchedOutput.prototype.copy_x84c5q$ = function (newWorkingInput, output) {
    return new RuleBasedTranscriber$UnmatchedOutput(newWorkingInput === void 0 ? this.newWorkingInput : newWorkingInput, output === void 0 ? this.output : output);
  };
  RuleBasedTranscriber$UnmatchedOutput.prototype.toString = function () {
    return 'UnmatchedOutput(newWorkingInput=' + Kotlin.toString(this.newWorkingInput) + (', output=' + Kotlin.toString(this.output)) + ')';
  };
  RuleBasedTranscriber$UnmatchedOutput.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.newWorkingInput) | 0;
    result = result * 31 + Kotlin.hashCode(this.output) | 0;
    return result;
  };
  RuleBasedTranscriber$UnmatchedOutput.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.newWorkingInput, other.newWorkingInput) && Kotlin.equals(this.output, other.output)))));
  };
  function RuleBasedTranscriber$RuleBasedTranscriber$UnmatchedOutput_init$lambda(closure$output) {
    return function (it) {
      return it + closure$output;
    };
  }
  RuleBasedTranscriber.prototype.reportOnceAndCopy_61zpoe$ = function (it) {
    if (!contains(this.reportedChars_dk12tj$_0, it.charCodeAt(0))) {
      err_getInstance().println_61zpoe$("copying unknown char '" + String.fromCharCode(it.charCodeAt(0)) + "'/'" + get_unicodeName(it.charCodeAt(0) | 0) + "' to output...");
      this.reportedChars_dk12tj$_0 += String.fromCharCode(it.charCodeAt(0));
    }
    return RuleBasedTranscriber$RuleBasedTranscriber$UnmatchedOutput_init(it.substring(1), String.fromCharCode(it.charCodeAt(0)));
  };
  function RuleBasedTranscriber$get_RuleBasedTranscriber$reportAndSkip$lambda(it) {
    err_getInstance().println_61zpoe$("unknown char '" + String.fromCharCode(it.charCodeAt(0)) + "'; skipping...");
    return RuleBasedTranscriber$RuleBasedTranscriber$UnmatchedOutput_init(it.substring(1), '');
  }
  Object.defineProperty(RuleBasedTranscriber.prototype, 'reportAndSkip', {get: function () {
    return RuleBasedTranscriber$get_RuleBasedTranscriber$reportAndSkip$lambda;
  }});
  function RuleBasedTranscriber$get_RuleBasedTranscriber$reportAndCopy$lambda(it) {
    err_getInstance().println_61zpoe$("copying unknown char '" + String.fromCharCode(it.charCodeAt(0)) + "' to output...");
    return RuleBasedTranscriber$RuleBasedTranscriber$UnmatchedOutput_init(it.substring(1), String.fromCharCode(it.charCodeAt(0)));
  }
  Object.defineProperty(RuleBasedTranscriber.prototype, 'reportAndCopy', {get: function () {
    return RuleBasedTranscriber$get_RuleBasedTranscriber$reportAndCopy$lambda;
  }});
  function RuleBasedTranscriber$get_RuleBasedTranscriber$copy$lambda(it) {
    return RuleBasedTranscriber$RuleBasedTranscriber$UnmatchedOutput_init(it.substring(1), String.fromCharCode(it.charCodeAt(0)));
  }
  Object.defineProperty(RuleBasedTranscriber.prototype, 'copy', {get: function () {
    return RuleBasedTranscriber$get_RuleBasedTranscriber$copy$lambda;
  }});
  RuleBasedTranscriber.prototype.processGreedily_lyv0qx$ = function ($receiver, rules, onNoRuleMatch) {
    var tmp$;
    var out = '';
    var processingWord = {v: $receiver};
    var consumed = {v: ''};
    loop: while (true) {
      if (!(processingWord.v.length > 0))
        break loop;
      var destination = ArrayList_init(collectionSizeOrDefault(rules, 10));
      var tmp$_0;
      tmp$_0 = rules.iterator();
      while (tmp$_0.hasNext()) {
        var item = tmp$_0.next();
        var tmp$_1, tmp$_2;
        destination.add_11rb$(new Triple(item, item.unconsumedMatcher.find_905azu$(processingWord.v), (tmp$_2 = (tmp$_1 = item.consumedMatcher) != null ? tmp$_1.findAll_905azu$(consumed.v) : null) != null ? lastOrNull(tmp$_2) : null));
      }
      var destination_0 = ArrayList_init_0();
      var tmp$_3;
      tmp$_3 = destination.iterator();
      while (tmp$_3.hasNext()) {
        var element = tmp$_3.next();
        var unconsumed = element.component2(), consumedMatch = element.component3();
        var tmp$_4;
        if (((tmp$_4 = unconsumed != null ? unconsumed.range : null) != null ? tmp$_4.start : null) === 0 && (consumedMatch == null || consumedMatch.range.endInclusive === (consumed.v.length - 1 | 0)))
          destination_0.add_11rb$(element);
      }
      var destination_1 = ArrayList_init(collectionSizeOrDefault(destination_0, 10));
      var tmp$_5;
      tmp$_5 = destination_0.iterator();
      while (tmp$_5.hasNext()) {
        var item_0 = tmp$_5.next();
        var tmp$_6 = destination_1.add_11rb$;
        var rule = item_0.component1(), uncon = item_0.component2(), con = item_0.component3();
        tmp$_6.call(destination_1, new Triple(rule, ensureNotNull(uncon), con));
      }
      var candidateRules = destination_1;
      if (candidateRules.isEmpty()) {
        var unmatchedOutput = onNoRuleMatch(processingWord.v);
        processingWord.v = unmatchedOutput.newWorkingInput;
        out = unmatchedOutput.output(out);
      }
       else {
        var maxBy$result;
        maxBy$break: do {
          var iterator = candidateRules.iterator();
          if (!iterator.hasNext()) {
            maxBy$result = null;
            break maxBy$break;
          }
          var maxElem = iterator.next();
          if (!iterator.hasNext()) {
            maxBy$result = maxElem;
            break maxBy$break;
          }
          var f = maxElem;
          var uncon_0 = f.component2(), con_0 = f.component3();
          var tmp$_7, tmp$_8;
          var maxValue = uncon_0.value.length + ((tmp$_8 = (tmp$_7 = con_0 != null ? con_0.value : null) != null ? tmp$_7.length : null) != null ? tmp$_8 : 0) | 0;
          do {
            var e = iterator.next();
            var uncon_1 = e.component2(), con_1 = e.component3();
            var tmp$_9, tmp$_10;
            var v = uncon_1.value.length + ((tmp$_10 = (tmp$_9 = con_1 != null ? con_1.value : null) != null ? tmp$_9.length : null) != null ? tmp$_10 : 0) | 0;
            if (Kotlin.compareTo(maxValue, v) < 0) {
              maxElem = e;
              maxValue = v;
            }
          }
           while (iterator.hasNext());
          maxBy$result = maxElem;
        }
         while (false);
        var tmp$_11 = ensureNotNull(maxBy$result);
        var rule_0 = tmp$_11.component1(), unconsumedMatch = tmp$_11.component2();
        out = rule_0.outputString(out, unconsumedMatch.groups);
        var actualLettersConsumed = (tmp$ = rule_0.lettersConsumed) != null ? tmp$ : unconsumedMatch.value.length;
        if (actualLettersConsumed > 0) {
          consumed.v += processingWord.v.substring(0, actualLettersConsumed);
          processingWord.v = processingWord.v.substring(actualLettersConsumed);
          continue loop;
        }
      }
    }
    return out;
  };
  RuleBasedTranscriber.prototype.processWithRules_lyv0qx$ = function ($receiver, rules, onNoRuleMatch) {
    var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3;
    var out = '';
    var processingWord = $receiver;
    var consumed = '';
    loop: while (true) {
      if (!(processingWord.length > 0))
        break;
      tmp$ = rules.iterator();
      while (tmp$.hasNext()) {
        var rule = tmp$.next();
        var unconsumedMatch = rule.unconsumedMatcher.find_905azu$(processingWord);
        var consumedMatches = rule.consumedMatcher == null || ((tmp$_1 = (tmp$_0 = lastOrNull(rule.consumedMatcher.findAll_905azu$(consumed))) != null ? tmp$_0.range : null) != null ? tmp$_1.endInclusive : null) === (consumed.length - 1 | 0);
        if (consumedMatches && ((tmp$_2 = unconsumedMatch != null ? unconsumedMatch.range : null) != null ? tmp$_2.start : null) === 0) {
          out = rule.outputString(out, unconsumedMatch.groups);
          var actualLettersConsumed = (tmp$_3 = rule.lettersConsumed) != null ? tmp$_3 : unconsumedMatch.value.length;
          if (actualLettersConsumed > 0) {
            consumed += processingWord.substring(0, actualLettersConsumed);
            processingWord = processingWord.substring(actualLettersConsumed);
            continue loop;
          }
        }
      }
      var unmatchedOutput = onNoRuleMatch(processingWord);
      processingWord = unmatchedOutput.newWorkingInput;
      out = unmatchedOutput.output(out);
    }
    return out;
  };
  RuleBasedTranscriber.$metadata$ = {kind: Kind_CLASS, simpleName: 'RuleBasedTranscriber', interfaces: [BaseRules, Transcriber]};
  function Transcriber() {
  }
  Transcriber.$metadata$ = {kind: Kind_INTERFACE, simpleName: 'Transcriber', interfaces: []};
  function Arabic() {
    Arabic_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_cr9tn$_0 = CompletionStatus$IN_PROGRESS_getInstance();
    this.rules = listOf([Rule_init('\u0600', '\u2116'), Rule_init('\u0609', '\u2030'), Rule_init('\u060A', '\u2031'), Rule_init('\u060C', ','), Rule_init('\u061B', ';'), Rule_init('\u061E', '\u2026'), Rule_init('\u061F', '?'), Rule_init('\u0628', 'b'), Rule_init('\u062A', 't'), Rule_init('\u062B', '\u03B8'), Rule_init('\u062C', 'd\u0361\u0292'), Rule_init('\u062D', '\u0127'), Rule_init('\u062E', 'x'), Rule_init('\u062F', 'd'), Rule_init('\u0630', '\xF0'), Rule_init('\u0631', 'r'), Rule_init('\u0632', 'z'), Rule_init('\u0633', 's'), Rule_init('\u0634', '\u0283'), Rule_init('\u0635', 's\u02E4'), Rule_init('\u0636', 'd\u02E4'), Rule_init('\u0637', 't\u02E4'), Rule_init('\u0638', '\xF0\u02E4'), Rule_init('\u0639', '\u0295'), Rule_init('\u063A', '\u0263'), Rule_init('\u0641', 'f'), Rule_init('\u0642', 'q'), Rule_init('\u0643', 'k'), Rule_init('\u0644', 'l'), Rule_init('\u0645', 'm'), Rule_init('\u0646', 'n'), Rule_init('\u0647', 'h'), Rule_init('\u0660', '0'), Rule_init('\u0661', '1'), Rule_init('\u0662', '2'), Rule_init('\u0663', '3'), Rule_init('\u0664', '4'), Rule_init('\u0665', '5'), Rule_init('\u0666', '6'), Rule_init('\u0667', '7'), Rule_init('\u0668', '8'), Rule_init('\u0669', '9'), Rule_init('\u066A', '%'), Rule_init('\u066B', '.'), Rule_init('\u066C', ','), Rule_init('\u066D', '*'), Rule_init('\u06D4', '.')]);
  }
  Object.defineProperty(Arabic.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_cr9tn$_0;
  }});
  Arabic.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, this.rules, getCallableRef('reportOnceAndCopy', function ($receiver, it) {
      return $receiver.reportOnceAndCopy_61zpoe$(it);
    }.bind(null, this)));
  };
  Arabic.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Arabic', interfaces: [RuleBasedTranscriber]};
  var Arabic_instance = null;
  function Arabic_getInstance() {
    if (Arabic_instance === null) {
      new Arabic();
    }
    return Arabic_instance;
  }
  function Persian() {
    Persian_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_66n8pf$_0 = CompletionStatus$IN_PROGRESS_getInstance();
  }
  Object.defineProperty(Persian.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_66n8pf$_0;
  }});
  Object.defineProperty(Persian.prototype, 'persoArabicBaseRules', {get: function () {
    return listOf([Rule_init('\u0627', '\u0252'), Rule_init('\u0628', 'b'), Rule_init('\u067E', 'p'), Rule_init('\u062A', 't'), Rule_init('\u062B', 's'), Rule_init('\u062C', 'd\u0361\u0292'), Rule_init('\u0686', 't\u0361\u0283'), Rule_init('\u062D', 'h'), Rule_init('\u062E', 'x'), Rule_init('\u062F', 'd'), Rule_init('\u0630', 'z'), Rule_init('\u0631', '\u027E'), Rule_init('\u0632', 'z'), Rule_init('\u0698', '\u0292'), Rule_init('\u0633', 's'), Rule_init('\u0634', '\u0283'), Rule_init('\u0635', 's'), Rule_init('\u0636', 'z'), Rule_init('\u0637', 't'), Rule_init('\u0638', 'z'), Rule_init('\u0639', '\u0294'), Rule_init('\u063A', '\u0263'), Rule_init('\u0641', 'f'), Rule_init('\u0642', '\u0263'), Rule_init('\u06A9', 'k'), Rule_init('\u06AF', '\u0261'), Rule_init('\u0644', 'l'), Rule_init('\u0645', 'm'), Rule_init('\u0646', 'n'), Rule_init('\u0648', '\u028B'), Rule_init('\u0647', 'h'), Rule_init('\u06CC', 'i'), Rule_init(' ', ' ')]);
  }});
  Persian.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, this.persoArabicBaseRules, this.reportAndCopy);
  };
  Persian.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Persian', interfaces: [RuleBasedTranscriber]};
  var Persian_instance = null;
  function Persian_getInstance() {
    if (Persian_instance === null) {
      new Persian();
    }
    return Persian_instance;
  }
  function PunjabiShahmukhi() {
    PunjabiShahmukhi_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_909434$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(PunjabiShahmukhi.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_909434$_0;
  }});
  PunjabiShahmukhi.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  PunjabiShahmukhi.$metadata$ = {kind: Kind_OBJECT, simpleName: 'PunjabiShahmukhi', interfaces: [RuleBasedTranscriber]};
  var PunjabiShahmukhi_instance = null;
  function PunjabiShahmukhi_getInstance() {
    if (PunjabiShahmukhi_instance === null) {
      new PunjabiShahmukhi();
    }
    return PunjabiShahmukhi_instance;
  }
  function Urdu() {
    Urdu_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_w3igzh$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(Urdu.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_w3igzh$_0;
  }});
  Urdu.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  Urdu.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Urdu', interfaces: [RuleBasedTranscriber]};
  var Urdu_instance = null;
  function Urdu_getInstance() {
    if (Urdu_instance === null) {
      new Urdu();
    }
    return Urdu_instance;
  }
  function Bengali() {
    Bengali_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_k0mkoh$_0 = CompletionStatus$SURFACE_LEVEL_COMPLETE_getInstance();
    this.rules = listOf([Rule_init('\u09A1\u09BC', '\u027D\u0254'), Rule_init('\u09A2\u09BC', '\u027D\u02B1\u0254'), Rule_init('\u09AF\u09BC', 'j\u0254'), Rule_init('\u09AC', 'b\u0254'), Rule_init('\u09AD', 'b\u02B1\u0254'), Rule_init('\u09A6', 'd\u0254'), Rule_init('\u09A7', 'd\u02B1\u0254'), Rule_init('\u09A1', '\u0256\u0254'), Rule_init('\u09A2', '\u0256\u02B1\u0254'), Rule_init('[\u099C\u09AF]', 'd\u0292\u0254'), Rule_init('\u099D', 'd\u0292\u02B1\u0254'), Rule_init('\u0997', '\u0261\u0254'), Rule_init('\u0998', '\u0261\u02B1\u0254'), Rule_init('(\u09B9|\u0983)', '\u0266\u0254'), Rule_init('\u0995', 'k\u0254'), Rule_init('\u0996', 'k\u02B0\u0254'), Rule_init('\u09B2', 'l\u0254'), Rule_init('\u09AE', 'm\u0254'), Rule_init('[\u09A8\u09A3\u099E]', 'n\u0254'), Rule_init('(\u0999|\u0982)', '\u014B\u0254'), Rule_init('\u09AA', 'p\u0254'), Rule_init('\u09AB', 'p\u02B0\u0254'), Rule_init('\u09B0', 'r\u0254'), Rule_init('(\u09A1\u09BC|\u09A2\u09BC)', '\u027D\u0254'), Rule_init('\u09B8', 's\u0254'), Rule_init('[\u09B6\u09B7\u09B8]', '\u0283\u0254'), Rule_init('\u09A4', 't\u0254'), Rule_init('\u09A5', 't\u02B0\u0254'), Rule_init('\u099F', '\u0288\u0254'), Rule_init('\u09A0', '\u0288\u02B0\u0254'), Rule_init('\u099A', 't\u0283\u0254'), Rule_init('\u099B', 't\u0283\u02B0\u0254'), Rule_init('\u09CE', '\u032At'), RevisingRule_init('\u09CD', Bengali$rules$lambda(this)), Rule_init('\u0985', '\u0254'), Rule_init('[\u0987\u0988]', 'i'), RevisingRule_init('(\u09BF|\u09C0)', Bengali$rules$lambda_0(this)), Rule_init('[\u098A\u0989]', 'u'), RevisingRule_init('(\u09C1|\u09C2)', Bengali$rules$lambda_1(this)), Rule_init('\u098B', 'ri'), RevisingRule_init('\u09C3', Bengali$rules$lambda_2(this)), Rule_init('\u0986', 'a'), RevisingRule_init('\u09BE', Bengali$rules$lambda_3(this)), Rule_init('\u0990', 'oi'), RevisingRule_init('\u09C8', Bengali$rules$lambda_4(this)), Rule_init('\u0994', 'ou'), RevisingRule_init('\u09CC', Bengali$rules$lambda_5(this)), Rule_init('\u098F', 'e'), RevisingRule_init('\u09C7', Bengali$rules$lambda_6(this)), Rule_init('\u0993', '\u028A'), RevisingRule_init('\u09CB', Bengali$rules$lambda_7(this)), Rule_init('\u098C', 'li'), RevisingRule_init('\u09E2', Bengali$rules$lambda_8(this)), Rule_init('\u09E1', 'l\u02D0i'), RevisingRule_init('\u09E3', Bengali$rules$lambda_9(this)), Rule_init('\u09E0', 'r\u02D0i'), Rule_init('\u09E6', '0'), Rule_init('\u09E7', '1'), Rule_init('\u09E8', '2'), Rule_init('\u09E9', '3'), Rule_init('\u09EA', '4'), Rule_init('\u09EB', '5'), Rule_init('\u09EC', '6'), Rule_init('\u09ED', '7'), Rule_init('\u09EE', '8'), Rule_init('\u09EF', '9'), Rule_init(' ', ' '), Rule_init('\u0964', '.')]);
  }
  Object.defineProperty(Bengali.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_k0mkoh$_0;
  }});
  Bengali.prototype.l_61zpoe$ = function (it) {
    var tmp$;
    if (endsWith(it, '\u0254')) {
      var endIndex = it.length - 1 | 0;
      tmp$ = it.substring(0, endIndex);
    }
     else
      tmp$ = it;
    return tmp$;
  };
  Bengali.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, this.rules, getCallableRef('reportOnceAndCopy', function ($receiver, it) {
      return $receiver.reportOnceAndCopy_61zpoe$(it);
    }.bind(null, this)));
  };
  function Bengali$rules$lambda(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it);
    };
  }
  function Bengali$rules$lambda_0(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'i';
    };
  }
  function Bengali$rules$lambda_1(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'u';
    };
  }
  function Bengali$rules$lambda_2(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'ri';
    };
  }
  function Bengali$rules$lambda_3(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'ri';
    };
  }
  function Bengali$rules$lambda_4(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'oi';
    };
  }
  function Bengali$rules$lambda_5(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'ou';
    };
  }
  function Bengali$rules$lambda_6(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'e';
    };
  }
  function Bengali$rules$lambda_7(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + '\u028A';
    };
  }
  function Bengali$rules$lambda_8(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'li';
    };
  }
  function Bengali$rules$lambda_9(this$Bengali) {
    return function (it) {
      return this$Bengali.l_61zpoe$(it) + 'l\u02D0i';
    };
  }
  Bengali.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Bengali', interfaces: [RuleBasedTranscriber]};
  var Bengali_instance = null;
  function Bengali_getInstance() {
    if (Bengali_instance === null) {
      new Bengali();
    }
    return Bengali_instance;
  }
  function DevanagariBaseRules() {
    DevanagariBaseRules_instance = this;
  }
  DevanagariBaseRules.prototype.l_0 = function (it) {
    var tmp$;
    if (endsWith(it, '\u0259')) {
      var endIndex = it.length - 1 | 0;
      tmp$ = it.substring(0, endIndex);
    }
     else
      tmp$ = it;
    return tmp$;
  };
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + 'a\u02D0';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_0(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + 'e\u02D0';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_1(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + '\u025B\u02D0';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_2(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + '\u0259';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_3(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + 'i\u02D0';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_4(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + '\u026A';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_5(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + 'o\u02D0';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_6(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + '\u0254\u02D0';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_7(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + 'u\u02D0';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_8(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + '\u028A';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_9(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it) + '\u027E\u026A';
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_10(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it);
    };
  }
  function DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_11(this$DevanagariBaseRules) {
    return function (it) {
      return this$DevanagariBaseRules.l_0(it);
    };
  }
  Object.defineProperty(DevanagariBaseRules.prototype, 'devanagariBaseRules', {get: function () {
    return listOf([Rule_init('\u0915\u093C', 'q\u0259'), Rule_init('\u0915', 'k\u0259'), Rule_init('\u0916\u093C', 'x\u0259'), Rule_init('\u0916', 'k\u02B0\u0259'), Rule_init('\u0917\u093C', '\u0263\u0259'), Rule_init('\u0917', '\u0261\u0259'), Rule_init('\u0918', '\u0261\u02B1\u0259'), Rule_init('\u0919', '\u014B\u0259'), Rule_init('\u091A', 't\u0283\u0259'), Rule_init('\u091B', 't\u0283\u02B0\u0259'), Rule_init('\u091C\u093C', 'z\u0259'), Rule_init('\u091C', 'd\u0292\u0259'), Rule_init('\u091D\u093C', '\u0292\u0259'), Rule_init('\u091D', 'd\u0292\u02B1\u0259'), Rule_init('\u091E', '\u0272\u0259'), Rule_init('\u091F', '\u0288\u0259'), Rule_init('\u0920', '\u0288\u02B0\u0259'), Rule_init('\u0921', '\u0256\u0259'), Rule_init('\u0922\u093C', '\u027D\u02B1\u0259'), Rule_init('\u0922', '\u0256\u02B1\u0259'), Rule_init('\u0923', '\u0273\u0259'), Rule_init('\u0924', 't\u0259'), Rule_init('\u0925', 't\u02B0\u0259'), Rule_init('\u0926', 'd\u0259'), Rule_init('\u0927', 'd\u02B1\u0259'), Rule_init('\u0928', 'n\u0259'), Rule_init('\u092A', 'p\u0259'), Rule_init('\u092B\u093C', 'f\u0259'), Rule_init('\u092B', 'p\u02B0\u0259'), Rule_init('\u092C', 'b\u0259'), Rule_init('\u092D', 'b\u02B1\u0259'), Rule_init('\u092E', 'm\u0259'), Rule_init('\u092F', 'j\u0259'), Rule_init('\u0930', '\u027E\u0259'), Rule_init('\u0932', 'l\u0259'), Rule_init('\u0935', '\u028B\u0259'), Rule_init('\u0936', '\u0283\u0259'), Rule_init('\u0937', '\u0282\u0259'), Rule_init('\u0938', 's\u0259'), Rule_init('\u0939', '\u0266\u0259'), RevisingRule_init('[\u0906\u093E]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda(this)), RevisingRule_init('[\u090F\u0947]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_0(this)), RevisingRule_init('[\u0910\u0948]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_1(this)), RevisingRule_init('[\u0905]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_2(this)), RevisingRule_init('[\u0908\u0940]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_3(this)), RevisingRule_init('[\u0907\u093F]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_4(this)), RevisingRule_init('[\u0913\u094B]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_5(this)), RevisingRule_init('[\u0914\u094C]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_6(this)), RevisingRule_init('[\u090A\u0942]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_7(this)), RevisingRule_init('[\u0909\u0941]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_8(this)), RevisingRule_init('[\u090B\u0943]', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_9(this)), RevisingRule_init('\u094D', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_10(this)), RevisingRule_init('\u0902', DevanagariBaseRules$get_DevanagariBaseRules$devanagariBaseRules$lambda_11(this)), Rule_init('\u0901', '\u0303'), Rule_init('\u0966', '0'), Rule_init('\u0967', '1'), Rule_init('\u0968', '2'), Rule_init('\u0969', '3'), Rule_init('\u096A', '4'), Rule_init('\u096B', '5'), Rule_init('\u096C', '6'), Rule_init('\u096D', '7'), Rule_init('\u096E', '8'), Rule_init('\u096F', '9'), Rule_init('\u0964', '.'), Rule_init(' ', ' ')]);
  }});
  DevanagariBaseRules.$metadata$ = {kind: Kind_OBJECT, simpleName: 'DevanagariBaseRules', interfaces: []};
  var DevanagariBaseRules_instance = null;
  function DevanagariBaseRules_getInstance() {
    if (DevanagariBaseRules_instance === null) {
      new DevanagariBaseRules();
    }
    return DevanagariBaseRules_instance;
  }
  function Gujarati() {
    Gujarati_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_vm1t92$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(Gujarati.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_vm1t92$_0;
  }});
  Gujarati.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  Gujarati.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Gujarati', interfaces: [RuleBasedTranscriber]};
  var Gujarati_instance = null;
  function Gujarati_getInstance() {
    if (Gujarati_instance === null) {
      new Gujarati();
    }
    return Gujarati_instance;
  }
  function Hindi() {
    Hindi_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_hv0j8h$_0 = CompletionStatus$SURFACE_LEVEL_COMPLETE_getInstance();
    this.consonants_0 = '\u092C\u092D\u0926\u0927\u091C\u091D\u0921\u0922\u092B\u093C\u0917\u0918\u0917\u093C\u0939\u092F\u0915\u0916\u0932\u092E\u0928\u0923\u091E\u0919\u092A\u092B\u0915\u093C\u0930\u0922\u093C\u0938\u0937\u0936\u0924\u0925\u091A\u091B\u091F\u0920\u0935\u0916\u093C\u091C\u093C\u091D\u093C';
    this.lastWasConsonant_0 = false;
    this.rules = DevanagariBaseRules_getInstance().devanagariBaseRules;
  }
  Object.defineProperty(Hindi.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_hv0j8h$_0;
  }});
  Hindi.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, this.rules, this.reportAndCopy);
  };
  Hindi.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Hindi', interfaces: [RuleBasedTranscriber]};
  var Hindi_instance = null;
  function Hindi_getInstance() {
    if (Hindi_instance === null) {
      new Hindi();
    }
    return Hindi_instance;
  }
  function Marathi() {
    Marathi_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_ollg69$_0 = CompletionStatus$INCOMPLETE_getInstance();
  }
  Object.defineProperty(Marathi.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_ollg69$_0;
  }});
  Marathi.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, DevanagariBaseRules_getInstance().devanagariBaseRules, this.reportAndCopy);
  };
  Marathi.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Marathi', interfaces: [RuleBasedTranscriber]};
  var Marathi_instance = null;
  function Marathi_getInstance() {
    if (Marathi_instance === null) {
      new Marathi();
    }
    return Marathi_instance;
  }
  function PunjabiGurmukhi() {
    PunjabiGurmukhi_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_6j3ccq$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(PunjabiGurmukhi.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_6j3ccq$_0;
  }});
  PunjabiGurmukhi.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  PunjabiGurmukhi.$metadata$ = {kind: Kind_OBJECT, simpleName: 'PunjabiGurmukhi', interfaces: [RuleBasedTranscriber]};
  var PunjabiGurmukhi_instance = null;
  function PunjabiGurmukhi_getInstance() {
    if (PunjabiGurmukhi_instance === null) {
      new PunjabiGurmukhi();
    }
    return PunjabiGurmukhi_instance;
  }
  function Tamil() {
    Tamil_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_t5m5g2$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(Tamil.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_t5m5g2$_0;
  }});
  Tamil.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  Tamil.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Tamil', interfaces: [RuleBasedTranscriber]};
  var Tamil_instance = null;
  function Tamil_getInstance() {
    if (Tamil_instance === null) {
      new Tamil();
    }
    return Tamil_instance;
  }
  function Telugu() {
    Telugu_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_dmv05n$_0 = CompletionStatus$INCOMPLETE_getInstance();
    this.rules_0 = listOf([Rule_init('\u0C15', 'ka'), Rule_init('\u0C16', 'k\u02B0a'), Rule_init('\u0C17', '\u0261a'), Rule_init('\u0C18', '\u0261\u02B1a'), Rule_init('\u0C19', '\u014Ba'), Rule_init('\u0C1A', 't\u0283a'), Rule_init('\u0C1B', 't\u0283\u02B0a'), Rule_init('\u0C1C', 'd\u0292a'), Rule_init('\u0C1D', 'd\u0292\u02B1a'), Rule_init('\u0C1E', '\u0272a'), Rule_init('\u0C1F', '\u0288a'), Rule_init('\u0C20', '\u0288\u02B0a'), Rule_init('\u0C21', '\u0256a'), Rule_init('\u0C22', '\u0256\u02B1a'), Rule_init('\u0C23', '\u0273a'), Rule_init('\u0C24', 'ta'), Rule_init('\u0C25', 't\u02B0a'), Rule_init('\u0C26', 'da'), Rule_init('\u0C27', 'd\u02B1a'), Rule_init('\u0C28', 'na'), Rule_init('\u0C2A', 'pa'), Rule_init('\u0C2B', 'p\u02B0a'), Rule_init('\u0C2C', 'ba'), Rule_init('\u0C2D', 'b\u02B1a'), Rule_init('\u0C2E', 'ma'), Rule_init('\u0C2F', 'ja'), Rule_init('\u0C30', 'ra'), Rule_init('\u0C32', 'la'), Rule_init('\u0C35', '\u028Ba'), Rule_init('\u0C33', '\u026Da'), Rule_init('\u0C36', '\u0283a'), Rule_init('\u0C37', '\u0282a'), Rule_init('\u0C38', 'sa'), Rule_init('\u0C39', 'ha'), Rule_init('\u0C31', '\u027Da'), RevisingRule_init('[\u0C05]', Telugu$rules$lambda(this)), RevisingRule_init('[\u0C06\u0C3E]', Telugu$rules$lambda_0(this)), RevisingRule_init('[\u0C07\u0C3F]', Telugu$rules$lambda_1(this)), RevisingRule_init('[\u0C08\u0C40]', Telugu$rules$lambda_2(this)), RevisingRule_init('[\u0C09\u0C41]', Telugu$rules$lambda_3(this)), RevisingRule_init('[\u0C0A\u0C42]', Telugu$rules$lambda_4(this)), RevisingRule_init('[\u0C0B\u0C43]', Telugu$rules$lambda_5(this)), RevisingRule_init('[\u0C60\u0C44]', Telugu$rules$lambda_6(this)), RevisingRule_init('[\u0C0C\u0C62]', Telugu$rules$lambda_7(this)), RevisingRule_init('[\u0C61\u0C63]', Telugu$rules$lambda_8(this)), RevisingRule_init('[\u0C0E\u0C46]', Telugu$rules$lambda_9(this)), RevisingRule_init('[\u0C0F\u0C47]', Telugu$rules$lambda_10(this)), RevisingRule_init('[\u0C10\u0C48]', Telugu$rules$lambda_11(this)), RevisingRule_init('[\u0C12\u0C4A]', Telugu$rules$lambda_12(this)), RevisingRule_init('[\u0C13\u0C4B]', Telugu$rules$lambda_13(this)), RevisingRule_init('[\u0C14\u0C4C]', Telugu$rules$lambda_14(this)), RevisingRule_init('\u0C4D', Telugu$rules$lambda_15(this)), Rule_init('', '')]);
  }
  Object.defineProperty(Telugu.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_dmv05n$_0;
  }});
  Telugu.prototype.l_0 = function (it) {
    var tmp$;
    if (endsWith(it, 'a')) {
      var endIndex = it.length - 1 | 0;
      tmp$ = it.substring(0, endIndex);
    }
     else
      tmp$ = it;
    return tmp$;
  };
  Telugu.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, this.rules_0, getCallableRef('reportOnceAndCopy', function ($receiver, it) {
      return $receiver.reportOnceAndCopy_61zpoe$(it);
    }.bind(null, this)));
  };
  function Telugu$rules$lambda(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'a';
    };
  }
  function Telugu$rules$lambda_0(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'a\u02D0';
    };
  }
  function Telugu$rules$lambda_1(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'i';
    };
  }
  function Telugu$rules$lambda_2(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'i\u02D0';
    };
  }
  function Telugu$rules$lambda_3(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'u';
    };
  }
  function Telugu$rules$lambda_4(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'u\u02D0';
    };
  }
  function Telugu$rules$lambda_5(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'ru';
    };
  }
  function Telugu$rules$lambda_6(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'ru\u02D0';
    };
  }
  function Telugu$rules$lambda_7(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'alu';
    };
  }
  function Telugu$rules$lambda_8(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'alu:';
    };
  }
  function Telugu$rules$lambda_9(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'e';
    };
  }
  function Telugu$rules$lambda_10(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'e\u02D0';
    };
  }
  function Telugu$rules$lambda_11(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'aj';
    };
  }
  function Telugu$rules$lambda_12(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'o';
    };
  }
  function Telugu$rules$lambda_13(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'o\u02D0';
    };
  }
  function Telugu$rules$lambda_14(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it) + 'aw';
    };
  }
  function Telugu$rules$lambda_15(this$Telugu) {
    return function (it) {
      return this$Telugu.l_0(it);
    };
  }
  Telugu.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Telugu', interfaces: [RuleBasedTranscriber]};
  var Telugu_instance = null;
  function Telugu_getInstance() {
    if (Telugu_instance === null) {
      new Telugu();
    }
    return Telugu_instance;
  }
  var ArabicGoogleRomanised_instance = null;
  function ChinesePinyin() {
    ChinesePinyin_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_npqkex$_0 = CompletionStatus$IN_PROGRESS_getInstance();
    this.mode_0 = ChinesePinyin$Mode$INITIALS_getInstance();
    this.initialRules_0 = listOf([Rule_init('b', 'p'), Rule_init('p', 'p\u02B0'), Rule_init('m', 'm'), Rule_init('f', 'f'), Rule_init('d', 't'), Rule_init('t', 't\u02B0'), Rule_init('n', 'n'), Rule_init('l', 'l'), Rule_init('g', 'k'), Rule_init('k', 'k\u02B0'), Rule_init('h', 'x'), Rule_init('j', 't\u0255'), Rule_init('q', 't\u0255\u02B0'), Rule_init('x', '\u0255'), Rule_init('zh', '\u0288\u0282'), Rule_init('ch', '\u0288\u0282\u02B0'), Rule_init('sh', '\u0282'), Rule_init('r', '\u027B~\u0290'), Rule_init('z', 'ts'), Rule_init('c', 'ts\u02B0'), Rule_init('s', 's')]);
    this.finalRulesNoInitial_0 = listOf([Rule_init('i', '\u0268'), Rule_init('e', '\u0264'), Rule_init('a', 'a'), Rule_init('ei', 'ei\u032F'), Rule_init('ai', 'ai\u032F'), Rule_init('ou', 'ou\u032F'), Rule_init('ao', 'au\u032F'), Rule_init('en', '\u0259n'), Rule_init('an', 'an'), Rule_init('eng', '\u0259\u014B'), Rule_init('ang', 'a\u014B'), Rule_init('yi', 'i'), Rule_init('ye', 'je'), Rule_init('ya', 'ja'), Rule_init('you', 'jou\u032F'), Rule_init('yao', 'jau\u032F'), Rule_init('yin', 'in'), Rule_init('yan', 'j\u025Bn'), Rule_init('yong', 'j\u028A\u014B'), Rule_init('ying', 'i\u014B'), Rule_init('yang', 'ja\u014B'), Rule_init('wu', 'u'), Rule_init('wo', 'wo'), Rule_init('wa', 'wa'), Rule_init('wei', 'wei\u032F'), Rule_init('wai', 'wai\u032F'), Rule_init('wen', 'w\u0259n'), Rule_init('wan', 'wan'), Rule_init('weng', 'w\u0259\u014B'), Rule_init('wang', 'wa\u014B'), Rule_init('yu', 'y'), Rule_init('yue', '\u0265e'), Rule_init('yun', 'yn'), Rule_init('yuan', '\u0265\u025Bn'), Rule_init('ar', '\u0250\u02B5'), Rule_init('or', '\u0254\u02B5'), Rule_init("e'r", '\u0264\u02B5'), Rule_init('air', '\u0250\u02B5'), Rule_init('eir', '\u025A\u032F'), Rule_init('aor', 'au\u032F\u02DE'), Rule_init('our', 'ou\u032F\u02DE'), Rule_init('anr', '\u0250\u02B5'), Rule_init('enr', '\u025A\u032F'), Rule_init('angr', '\u0251\u0303\u02B5'), Rule_init('engr', '\u0264\u0303\u02B5'), Rule_init('yir', 'j\u025A'), Rule_init('yar', 'j\u0250\u02B5'), Rule_init('yer', 'j\u025B\u02B5'), Rule_init('yaor', 'jau\u032F\u02B5'), Rule_init('your', 'jou\u032F\u02B5'), Rule_init('yanr', 'j\u0250\u02B5'), Rule_init('yinr', 'j\u025A'), Rule_init('yangr', 'j\u0251\u0303\u02B5'), Rule_init('yingr', 'j\u0264\u0303\u02B5'), Rule_init('wur', 'u\u02DE'), Rule_init('war', 'w\u0250\u02B5'), Rule_init('wor', 'w\u0254\u02B5'), Rule_init('wair', 'w\u0250\u02B5'), Rule_init('weir', 'w\u025A\u032F'), Rule_init('wanr', 'w\u0250\u02B5'), Rule_init('wenr', 'w\u025A\u032F'), Rule_init('wangr', 'w\u0251\u0303\u02B5'), Rule_init('wengr', 'w\u0264\u0303\u02B5'), Rule_init('yur', '\u0265\u025A'), Rule_init('yuer', '\u0265\u0153\u02B5'), Rule_init('yuanr', '\u0265\u0250\u02B5'), Rule_init('yunr', '\u0265\u025A'), Rule_init('yongr', 'j\u028A\u0303\u02B5'), Rule_init('', '')]);
    this.finalRules_0 = listOf([Rule_init('i', '\u0268'), Rule_init('e', '\u0264'), Rule_init('a', 'a'), Rule_init('ei', 'ei\u032F'), Rule_init('ai', 'ai\u032F'), Rule_init('ou', 'ou\u032F'), Rule_init('ao', 'au\u032F'), Rule_init('en', '\u0259n'), Rule_init('an', 'an'), Rule_init('ong', '\u028A\u014B'), Rule_init('eng', '\u0259\u014B'), Rule_init('ang', 'a\u014B'), Rule_init('i', 'i'), Rule_init('ie', 'je'), Rule_init('ia', 'ja'), Rule_init('iu', 'jou\u032F'), Rule_init('iao', 'jau\u032F'), Rule_init('in', 'in'), Rule_init('ian', 'j\u025Bn'), Rule_init('iong', 'j\u028A\u014B'), Rule_init('ing', 'i\u014B'), Rule_init('iang', 'ja\u014B'), Rule_init('u', 'u'), Rule_init('uo', 'wo'), Rule_init('ua', 'wa'), Rule_init('ui', 'wei\u032F'), Rule_init('uai', 'wai\u032F'), Rule_init('un', 'w\u0259n'), Rule_init('uan', 'wan'), Rule_init('wang', 'wa\u014B'), Rule_init('\xFC', 'y'), Rule_init('\xFCe', '\u0265e'), Rule_init('\xFCn', 'yn'), Rule_init('\xFCan', '\u0265\u025Bn'), Rule_init('ir', '\u025A'), Rule_init('or', '\u0254\u02B5'), Rule_init('er', '\u0264\u02B5'), Rule_init('air', '\u0250\u02B5'), Rule_init('eir', '\u025A\u032F'), Rule_init('aor', 'au\u032F\u02DE'), Rule_init('our', 'ou\u032F\u02DE'), Rule_init('anr', '\u0250\u02B5'), Rule_init('enr', '\u025A\u032F'), Rule_init('angr', '\u0251\u0303\u02B5'), Rule_init('engr', '\u0264\u0303\u02B5'), Rule_init('ir', 'j\u025A'), Rule_init('iar', 'j\u0250\u02B5'), Rule_init('ier', 'j\u025B\u02B5'), Rule_init('iaor', 'jau\u032F\u02B5'), Rule_init('iur', 'jou\u032F\u02B5'), Rule_init('ianr', 'j\u0250\u02B5'), Rule_init('inr', 'j\u025A'), Rule_init('iangr', 'j\u0251\u0303\u02B5'), Rule_init('ingr', 'j\u0264\u0303\u02B5'), Rule_init('ongr', 'w\u0264\u0303\u02B5'), Rule_init('\xFCr', '\u0265\u025A'), Rule_init('\xFCer', '\u0265\u0153\u02B5'), Rule_init('\xFCanr', '\u0265\u0250\u02B5'), Rule_init('\xFCnr', '\u0265\u025A'), Rule_init('iongr', 'j\u028A\u0303\u02B5'), Rule_init('', '')]);
  }
  Object.defineProperty(ChinesePinyin.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_npqkex$_0;
  }});
  function ChinesePinyin$Mode(name, ordinal) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function ChinesePinyin$Mode_initFields() {
    ChinesePinyin$Mode_initFields = function () {
    };
    ChinesePinyin$Mode$INITIALS_instance = new ChinesePinyin$Mode('INITIALS', 0);
    ChinesePinyin$Mode$FINALS_NO_INITIAL_instance = new ChinesePinyin$Mode('FINALS_NO_INITIAL', 1);
    ChinesePinyin$Mode$FINALS_instance = new ChinesePinyin$Mode('FINALS', 2);
  }
  var ChinesePinyin$Mode$INITIALS_instance;
  function ChinesePinyin$Mode$INITIALS_getInstance() {
    ChinesePinyin$Mode_initFields();
    return ChinesePinyin$Mode$INITIALS_instance;
  }
  var ChinesePinyin$Mode$FINALS_NO_INITIAL_instance;
  function ChinesePinyin$Mode$FINALS_NO_INITIAL_getInstance() {
    ChinesePinyin$Mode_initFields();
    return ChinesePinyin$Mode$FINALS_NO_INITIAL_instance;
  }
  var ChinesePinyin$Mode$FINALS_instance;
  function ChinesePinyin$Mode$FINALS_getInstance() {
    ChinesePinyin$Mode_initFields();
    return ChinesePinyin$Mode$FINALS_instance;
  }
  ChinesePinyin$Mode.$metadata$ = {kind: Kind_CLASS, simpleName: 'Mode', interfaces: [Enum]};
  function ChinesePinyin$Mode$values() {
    return [ChinesePinyin$Mode$INITIALS_getInstance(), ChinesePinyin$Mode$FINALS_NO_INITIAL_getInstance(), ChinesePinyin$Mode$FINALS_getInstance()];
  }
  ChinesePinyin$Mode.values = ChinesePinyin$Mode$values;
  function ChinesePinyin$Mode$valueOf(name) {
    switch (name) {
      case 'INITIALS':
        return ChinesePinyin$Mode$INITIALS_getInstance();
      case 'FINALS_NO_INITIAL':
        return ChinesePinyin$Mode$FINALS_NO_INITIAL_getInstance();
      case 'FINALS':
        return ChinesePinyin$Mode$FINALS_getInstance();
      default:throwISE('No enum constant com.github.medavox.ipa_transcribers.latin.ChinesePinyin.Mode.' + name);
    }
  }
  ChinesePinyin$Mode.valueOf_61zpoe$ = ChinesePinyin$Mode$valueOf;
  ChinesePinyin.prototype.processPinyin_xe8hom$ = function ($receiver, onNoRuleMatch) {
    var tmp$, tmp$_0;
    var out = '';
    var processingWord = {v: $receiver};
    var consumed = {v: ''};
    loop: while (true) {
      if (!(processingWord.v.length > 0))
        break loop;
      switch (this.mode_0.name) {
        case 'INITIALS':
          tmp$ = this.initialRules_0;
          break;
        case 'FINALS':
          tmp$ = this.finalRules_0;
          break;
        case 'FINALS_NO_INITIAL':
          tmp$ = this.finalRulesNoInitial_0;
          break;
        default:tmp$ = Kotlin.noWhenBranchMatched();
          break;
      }
      var rules = tmp$;
      var destination = ArrayList_init_0();
      var tmp$_1;
      tmp$_1 = rules.iterator();
      while (tmp$_1.hasNext()) {
        var element = tmp$_1.next();
        var tmp$_2, tmp$_3, tmp$_4, tmp$_5;
        if (((tmp$_3 = (tmp$_2 = element.unconsumedMatcher.find_905azu$(processingWord.v)) != null ? tmp$_2.range : null) != null ? tmp$_3.start : null) === 0 && (element.consumedMatcher == null || ((tmp$_5 = (tmp$_4 = lastOrNull(element.consumedMatcher.findAll_905azu$(consumed.v))) != null ? tmp$_4.range : null) != null ? tmp$_5.endInclusive : null) === (consumed.v.length - 1 | 0)))
          destination.add_11rb$(element);
      }
      var maxBy$result;
      maxBy$break: do {
        var iterator = destination.iterator();
        if (!iterator.hasNext()) {
          maxBy$result = null;
          break maxBy$break;
        }
        var maxElem = iterator.next();
        if (!iterator.hasNext()) {
          maxBy$result = maxElem;
          break maxBy$break;
        }
        var it = maxElem;
        var tmp$_6;
        var maxValue = (tmp$_6 = it.lettersConsumed) != null ? tmp$_6 : ensureNotNull(it.unconsumedMatcher.find_905azu$(processingWord.v)).value.length;
        do {
          var e = iterator.next();
          var tmp$_7;
          var v = (tmp$_7 = e.lettersConsumed) != null ? tmp$_7 : ensureNotNull(e.unconsumedMatcher.find_905azu$(processingWord.v)).value.length;
          if (Kotlin.compareTo(maxValue, v) < 0) {
            maxElem = e;
            maxValue = v;
          }
        }
         while (iterator.hasNext());
        maxBy$result = maxElem;
      }
       while (false);
      var rule = maxBy$result;
      if (rule != null) {
        var unconsumedMatch = ensureNotNull(rule.unconsumedMatcher.find_905azu$(processingWord.v));
        out = rule.outputString(out, unconsumedMatch.groups);
        var actualLettersConsumed = (tmp$_0 = rule.lettersConsumed) != null ? tmp$_0 : unconsumedMatch.value.length;
        this.mode_0 = ChinesePinyin$Mode$FINALS_getInstance();
        if (actualLettersConsumed > 0) {
          consumed.v += processingWord.v.substring(0, actualLettersConsumed);
          processingWord.v = processingWord.v.substring(actualLettersConsumed);
          continue loop;
        }
      }
       else {
        switch (this.mode_0.name) {
          case 'INITIALS':
            this.mode_0 = ChinesePinyin$Mode$FINALS_NO_INITIAL_getInstance();
            continue loop;
          case 'FINALS':
          case 'FINALS_NO_INITIAL':
            var unmatchedOutput = onNoRuleMatch(processingWord.v);
            processingWord.v = unmatchedOutput.newWorkingInput;
            out = unmatchedOutput.output(out);
            this.mode_0 = ChinesePinyin$Mode$INITIALS_getInstance();
            continue loop;
          default:Kotlin.noWhenBranchMatched();
            break;
        }
      }
    }
    return out;
  };
  ChinesePinyin.prototype.transcribe_61zpoe$ = function (nativeText) {
    this.mode_0;
    ChinesePinyin$Mode$INITIALS_getInstance();
    return this.processWithRules_lyv0qx$(nativeText.toLowerCase(), this.initialRules_0, this.reportAndSkip);
  };
  ChinesePinyin.$metadata$ = {kind: Kind_OBJECT, simpleName: 'ChinesePinyin', interfaces: [RuleBasedTranscriber]};
  var ChinesePinyin_instance = null;
  function ChinesePinyin_getInstance() {
    if (ChinesePinyin_instance === null) {
      new ChinesePinyin();
    }
    return ChinesePinyin_instance;
  }
  function English() {
    English_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_tzvcsz$_0 = CompletionStatus$IN_PROGRESS_getInstance();
    this.vowels = 'aeiou';
    this.consonants = 'bcdfghjklmnpqrstvwxz';
    this.longI = 'a\u026A';
    this.rules = plus(plus(listOf([Rule_init('t?ch', 't\u0283'), Rule_init('sc?h', '\u0283'), Rule_init('th', '\u03B8'), Rule_init('qu', 'kw'), Rule_init('wr', 'r'), Rule_init('who', 'h', 1), Rule_init('wh', 'w'), LookbackRule_init('e', 'xh[aeiou]', 'gz', 2), Rule_init('xh', 'ks'), LookbackRule_init('e', 'x[aeiou]', 'gz', 1), Rule_init('x', 'ks'), Rule_init('rh', 'r'), Rule_init('gh[aeiou]', 'g', 2), Rule_init('igh', this.longI), Rule_init('aught', '\u0254t'), Rule_init('ought', '\u0254t'), Rule_init('rough', 'r\u028Cf'), Rule_init(' cough', ' k\u0252f'), Rule_init(' through ', ' \u03B8ru '), Rule_init('ough', 'o\u028A'), Rule_init('gh', ''), LookbackRule_init('( |^)', 'gn', 'n'), LookbackRule_init('( |^)', 'kn', 'n'), LookbackRule_init('( |^)', 'mn', 'n'), LookbackRule_init('( |^)', 'pt', 't'), LookbackRule_init('( |^)', 'tm', 'm'), LookbackRule_init('(^|\\s)[^aeiou]+', 'y(\\s|$)', 'a\u026A', 1), Rule_init('ey', 'i'), Rule_init('ay', 'e\u026A'), Rule_init('oy', 'oj'), new Rule(Regex_init('(ti|ci)[aeiou]'), '\u0283', 2), new Rule(Regex_init('al([lrsmtd]|th)'), '\u0254\u026B', 2), LookbackRule_init('[^\\s]', 'alk', '\u0254k'), Rule_init('c[iey]', 's', 1), Rule_init('c', 'k'), Rule_init('ge[oa]', 'd\u0292', 2), Rule_init('g[iey]', 'd\u0292', 1), Rule_init('g', 'g'), LookbackRule_init('(^$|\\s)', 'gu', 'g'), Rule_init('gue($|\\s)', 'g'), Rule_init('gu', 'gw'), LookbackRule_init('[bcdfghjklmnpqrstvwxz]', 'le(\\s|$)', '\u0259\u026B', 2), LookbackRule_init('[bcdfghjklmnpqrstvwxz]', 're(\\s|$)', '\u0259r', 2), new Rule(Regex_init('a[bcdfghjklmnpqrstvwxz][aeiou]'), 'e\u026A', 1), new Rule(Regex_init('e[bcdfghjklmnpqrstvwxz][aeiou]'), 'i\u02D0', 1), new Rule(Regex_init('i[bcdfghjklmnpqrstvwxz][aeiou]'), 'a\u026A', 1), new Rule(Regex_init('o[bcdfghjklmnpqrstvwxz][aeiou]'), 'o\u028A', 1), new Rule(Regex_init('u[bcdfghjklmnpqrstvwxz][aeiou]'), 'ju', 1), new Rule(Regex_init('a[bcdfghjklmnpqrstvwxz]([bcdfghjklmnpqrstvwxz]|\\s|$)'), '\xE6', 1), new Rule(Regex_init('e[bcdfghjklmnpqrstvwxz]([bcdfghjklmnpqrstvwxz]|\\s|$)'), '\u025B', 1), new Rule(Regex_init('i[bcdfghjklmnpqrstvwxz]([bcdfghjklmnpqrstvwxz]|\\s|$)'), '\u026A', 1), new Rule(Regex_init('o[bcdfghjklmnpqrstvwxz]([bcdfghjklmnpqrstvwxz]|\\s|$)'), '\u0252', 1), new Rule(Regex_init('u[bcdfghjklmnpqrstvwxz]([bcdfghjklmnpqrstvwxz]|\\s|$)'), '\u028C', 1), Rule_init('ous', '\u0259s'), LookbackRule_init('[aeiou][bcdfghjklmnpqrstvwxz]{1,2}', 'e', ''), LookbackRule_init('(^|\\s)[^aeiou]+', '[iy][aeiou]', 'aj\u0259'), Rule_init('[aeiou]l', '\u0259\u026B'), Rule_init("'", ''), Rule_init('-', ' '), Rule_init('', '')]), LatinScriptCommonalities_getInstance().latinBaseRules), this.westernPunctuation);
  }
  Object.defineProperty(English.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_tzvcsz$_0;
  }});
  English.prototype.longPronunciation_s8itvh$ = function (vowel) {
    return 'not yet implemented';
  };
  English.prototype.shortPronunciation_s8itvh$ = function (vowel) {
    return 'not yet implemented';
  };
  English.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText.toLowerCase(), this.rules, this.reportAndCopy);
  };
  English.$metadata$ = {kind: Kind_OBJECT, simpleName: 'English', interfaces: [RuleBasedTranscriber]};
  var English_instance = null;
  function English_getInstance() {
    if (English_instance === null) {
      new English();
    }
    return English_instance;
  }
  function FilipinoTagalog() {
    FilipinoTagalog_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_8m28di$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(FilipinoTagalog.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_8m28di$_0;
  }});
  FilipinoTagalog.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  FilipinoTagalog.$metadata$ = {kind: Kind_OBJECT, simpleName: 'FilipinoTagalog', interfaces: [RuleBasedTranscriber]};
  var FilipinoTagalog_instance = null;
  function FilipinoTagalog_getInstance() {
    if (FilipinoTagalog_instance === null) {
      new FilipinoTagalog();
    }
    return FilipinoTagalog_instance;
  }
  function French() {
    French_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_hyp2lp$_0 = CompletionStatus$IN_PROGRESS_getInstance();
    this.silencableConsonants_0 = 'sxztdnpg';
    this.vowels_0 = 'a\xE2e\xEAi\xEEo\xF4u\xFB\xE9\xE8\xEB\xE0\xEF';
    this.consonants_0 = 'bdfghklmnpqstvz';
    var tmp$ = listOf([Rule_init('\xE0', 'a'), Rule_init('\xE7', 's'), Rule_init('c[iey]', 's', 1), Rule_init('c[^ieyh]', 'k', 1), Rule_init('qu', 'k'), Rule_init('ch', '\u0283'), Rule_init('g[ie\xE9\xE8]', '\u0292', 1), Rule_init('gn', '\u0272'), Rule_init('j', '\u0292'), LookbackRule_init('[a\xE2e\xEAi\xEEo\xF4u\xFB\xE9\xE8\xEB\xE0\xEF]', 's[a\xE2e\xEAi\xEEo\xF4u\xFB\xE9\xE8\xEB\xE0\xEF]', 'z', 1), Rule_init('(ss)', 's'), Rule_init('ti(on|ence)', 'sj', 2), new Rule(Regex_init('([ae][mn])[^a\xE2e\xEAi\xEEo\xF4u\xFB\xE9\xE8\xEB\xE0\xEF]'), '\u0251\u0303', 2), new Rule(Regex_init('(ean|aon)[^a\xE2e\xEAi\xEEo\xF4u\xFB\xE9\xE8\xEB\xE0\xEF]'), '\u0251\u0303', 3), Rule_init('ie[nm][^a\xE2e\xEAi\xEEo\xF4u\xFB\xE9\xE8\xEB\xE0\xEF]', 'j\u025B\u0303', 3), Rule_init('u[nm][^a\xE2e\xEAi\xEEo\xF4u\xFB\xE9\xE8\xEB\xE0\xEF]', '\u0153\u0303', 2), Rule_init('oi', 'wa'), Rule_init('oin', 'w\u025B\u0303'), Rule_init('r', '\u0281'), LookbackRule_init('(?!\\b)', 'eu(?!\\b)', '\u0153', 2), Rule_init('eu(se)?', '\xF8', 2), Rule_init('(ui|uy)', '\u0265'), LookbackRule_init('[a\xE2e\xEAi\xEEo\xF4u\xFB\xE9\xE8\xEB\xE0\xEF]', 'il(le?)?\\b', 'j'), Rule_init('\xE9', 'e'), Rule_init('\xE8', '\u025B'), Rule_init('\xEA', '\u025B'), Rule_init('e', '\u0259'), Rule_init('\xF4', 'o'), Rule_init('(\u0153|oe)u?', '\u0153'), Rule_init('aur', '\u0254', 2), Rule_init('e?au', 'o'), new Rule(Regex_init('e[sxztdnpg]+\\b'), 'e', 1), new Rule(Regex_init('o[sxztdnpg]+\\b'), 'o', 1), new LookbackRule(Regex_init('[^ ]'), Regex_init('[sxztdnpg]+\\b'), ''), Rule_init('h', ''), Rule_init("['\u2019]", '')]);
    var $receiver = LatinScriptCommonalities_getInstance().latinBaseRules;
    var destination = ArrayList_init_0();
    var tmp$_0;
    tmp$_0 = $receiver.iterator();
    while (tmp$_0.hasNext()) {
      var element = tmp$_0.next();
      var $receiver_0 = element.unconsumedMatcher.toString();
      if (!equals($receiver_0, 'e') && !equals($receiver_0, 'y') && !equals($receiver_0, 'h'))
        destination.add_11rb$(element);
    }
    this.rules_0 = plus(plus(tmp$, destination), this.westernPunctuation);
  }
  Object.defineProperty(French.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_hyp2lp$_0;
  }});
  French.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processGreedily_lyv0qx$(nativeText.toLowerCase(), this.rules_0, getCallableRef('reportOnceAndCopy', function ($receiver, it) {
      return $receiver.reportOnceAndCopy_61zpoe$(it);
    }.bind(null, this)));
  };
  French.$metadata$ = {kind: Kind_OBJECT, simpleName: 'French', interfaces: [RuleBasedTranscriber]};
  var French_instance = null;
  function French_getInstance() {
    if (French_instance === null) {
      new French();
    }
    return French_instance;
  }
  function German() {
    German_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_hamirl$_0 = CompletionStatus$SURFACE_LEVEL_COMPLETE_getInstance();
    this.vowels = 'aeiou\xE4\xF6\xFC';
    this.consonants = 'bcdfghjklmnpqrstvwxyz';
    this.vowelShorteningConsonantPairs = '(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)';
    var tmp$ = plus(listOf([LookbackRule_init('( |^)', 'an ', 'an', 2), LookbackRule_init('( |^)', 'das ', 'das', 3), LookbackRule_init('( |^)', 'der ', 'd\u025B\u0250', 3), LookbackRule_init('( |^)', 'es ', '\u025Bs', 2), LookbackRule_init('( |^)', 'in ', '\u026An', 2), LookbackRule_init('( |^)', 'mit ', 'm\u026At', 3), LookbackRule_init('( |^)', 'von ', 'f\u0254n', 3), LookbackRule_init('[ptk]', 'en( |$)', 'n\u0329', 2), LookbackRule_init('[^ ]', 'er( |$)', '\u0250', 2), LookbackRule_init('[^ ]', 'e( |$)', '\u0259'), LookbackRule_init('[^ ]', 'el( |$)', 'el', 2), Rule_init('system', 'z\u028Fzte\u02D0m'), LookbackRule_init('([^ ]|^)', 'net ', 'n\u0259t', 3), Rule_init('au', 'a\u028A'), Rule_init('(eu|\xE4u)', '\u0254\u028F'), Rule_init('(ei|ai|ey|ay)', 'a\u026A'), Rule_init('ie', 'i\u02D0'), Rule_init('aa', German$Vowels$A_getInstance().long), Rule_init('ee', German$Vowels$E_getInstance().long), Rule_init('oo', German$Vowels$O_getInstance().long), Rule_init('a(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$A_getInstance().short, 1), Rule_init('\xE4(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$Ä_getInstance().short, 1), Rule_init('e(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$E_getInstance().short, 1), Rule_init('i(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$I_getInstance().short, 1), Rule_init('o(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$O_getInstance().short, 1), Rule_init('\xF6(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$Ö_getInstance().short, 1), Rule_init('u(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$U_getInstance().short, 1), Rule_init('\xFC(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$Ü_Y_getInstance().short, 1), Rule_init('y(ck|ff|ll|mm|nn|pp|rr|ss|tt|tz)', German$Vowels$Ü_Y_getInstance().short, 1), Rule_init('\xE4', '\xC4'), Rule_init('\xF6', '\xD6'), LookbackRule_init(' ', 'mond( |$)', 'mo\u02D0nt', 4), LookbackRule_init('( |^)', 'hand( |$)', 'hant', 4), Rule_init('a($| )', German$Vowels$A_getInstance().long, 1), Rule_init('\xE4($| )', German$Vowels$Ä_getInstance().long, 1), Rule_init('i($| )', German$Vowels$I_getInstance().long, 1), Rule_init('o($| )', German$Vowels$O_getInstance().long, 1), Rule_init('\xF6($| )', German$Vowels$Ö_getInstance().long, 1), Rule_init('u($| )', German$Vowels$U_getInstance().long, 1), Rule_init('\xFC($| )', German$Vowels$Ü_Y_getInstance().long, 1), Rule_init('e($| )', '\u0259', 1), Rule_init('a[bcdfghjklmnpqrstvwxyz]{1}($| |[aeiou\xE4\xF6\xFC])', German$Vowels$A_getInstance().long, 1), Rule_init('\xE4[bcdfghjklmnpqrstvwxyz]{1}($| |[aeiou\xE4\xF6\xFC])', German$Vowels$Ä_getInstance().long, 1), Rule_init('e[bcdfghjklmnpqrstvwxyz]{1}($| |[aeiou\xE4\xF6\xFC])', German$Vowels$E_getInstance().long, 1), Rule_init('i[bcdfghjklmnpqrstvwxyz]{1}($| |[aeiou\xE4\xF6\xFC])', German$Vowels$I_getInstance().long, 1), Rule_init('o[bcdfghjklmnpqrstvwxyz]{1}($| |[aeiou\xE4\xF6\xFC])', German$Vowels$O_getInstance().long, 1), Rule_init('\xF6[bcdfghjklmnpqrstvwxyz]{1}($| |[aeiou\xE4\xF6\xFC])', German$Vowels$Ö_getInstance().long, 1), Rule_init('u[bcdfghjklmnpqrstvwxyz]{1}($| |[aeiou\xE4\xF6\xFC])', German$Vowels$U_getInstance().long, 1), Rule_init('\xFC[bcdfghjklmnpqrstvwxyz]{1}($| |[aeiou\xE4\xF6\xFC])', German$Vowels$Ü_Y_getInstance().long, 1), new CapturingRule(Regex_init('([aeiou\xE4\xF6\xFC])h'), German$rules$lambda, 2), LookbackRule_init('sch', 'w', 'f'), Rule_init('w', 'v'), Rule_init('r[aeiou\xE4\xF6\xFC]', '\u0281', 1), Rule_init('r($| )', '\u0250', 1), Rule_init('b(^| )', 'p', 1), Rule_init('chs', 'ks'), LookbackRule_init('i', 'ch', '\xE7'), Rule_init('ch', 'x'), Rule_init('ck', 'k'), Rule_init('c[\xE4ei]', 'ts', 1), Rule_init('c', 'k'), Rule_init('d($| )', 't', 1), Rule_init('dt', 't'), Rule_init('ig( |$)', '\u026A\xE7'), Rule_init('h[aeiou\xE4\xF6\xFC]', 'h', 1), Rule_init('j', 'j'), Rule_init('ng', '\u014B'), Rule_init('nk', '\u014Bk'), Rule_init('pf', 'pf'), Rule_init('qu', 'kf'), Rule_init('r[aeiou\xE4\xF6\xFC]', '\u0281', 1), Rule_init('r', '\u0250', 1), LookbackRule_init('(^| |[^s])', 's[pt][aeiou\xE4\xF6\xFC]', '\u0283', 1), Rule_init('s[ptk]', 's', 1), Rule_init('s($| )', 's', 1), LookbackRule_init('[aeiou\xE4\xF6\xFC]?', 's[aeiou\xE4\xF6\xFC]', 'z', 1), Rule_init('chen', '\xE7', 2), Rule_init('sch', '\u0283'), Rule_init('(ss|\xDF)', 's'), Rule_init('th', 't'), Rule_init('ti(on|\xE4r|al|ell)', 'ts\u026A\u032F', 2), Rule_init('tz?sch', 't\u0283'), Rule_init('t?z', 'ts'), Rule_init('v', 'f'), Rule_init('x', 'ks'), Rule_init('zsch', 't\u0283'), Rule_init('', '')]), this.westernPunctuation);
    var $receiver = LatinScriptCommonalities_getInstance().latinBaseRules;
    var destination = ArrayList_init_0();
    var tmp$_0;
    tmp$_0 = $receiver.iterator();
    while (tmp$_0.hasNext()) {
      var element = tmp$_0.next();
      var $receiver_0 = element.unconsumedMatcher;
      if (!equals($receiver_0, Regex_init('s')) && !equals($receiver_0, Regex_init('v')) && !equals($receiver_0, Regex_init('w')) && !equals($receiver_0, Regex_init('y')) && !equals($receiver_0, Regex_init('z')))
        destination.add_11rb$(element);
    }
    this.rules = plus(tmp$, destination);
  }
  Object.defineProperty(German.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_hamirl$_0;
  }});
  function German$Vowels(name, ordinal, short, long) {
    Enum.call(this);
    this.short = short;
    this.long = long;
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function German$Vowels_initFields() {
    German$Vowels_initFields = function () {
    };
    German$Vowels$A_instance = new German$Vowels('A', 0, 'a', 'a\u02D0');
    German$Vowels$Ä_instance = new German$Vowels('\xC4', 1, '\u025B', '\u025B\u02D0');
    German$Vowels$E_instance = new German$Vowels('E', 2, '\u025B', 'e\u02D0');
    German$Vowels$I_instance = new German$Vowels('I', 3, '\u026A', 'i\u02D0');
    German$Vowels$O_instance = new German$Vowels('O', 4, '\u0254', 'o\u02D0');
    German$Vowels$Ö_instance = new German$Vowels('\xD6', 5, '\u0153', '\xF8\u02D0');
    German$Vowels$U_instance = new German$Vowels('U', 6, '\u028A', 'u\u02D0');
    German$Vowels$Ü_Y_instance = new German$Vowels('\xDC_Y', 7, '\u028F', 'y\u02D0');
    German$Vowels$Companion_getInstance();
  }
  var German$Vowels$A_instance;
  function German$Vowels$A_getInstance() {
    German$Vowels_initFields();
    return German$Vowels$A_instance;
  }
  var German$Vowels$Ä_instance;
  function German$Vowels$Ä_getInstance() {
    German$Vowels_initFields();
    return German$Vowels$Ä_instance;
  }
  var German$Vowels$E_instance;
  function German$Vowels$E_getInstance() {
    German$Vowels_initFields();
    return German$Vowels$E_instance;
  }
  var German$Vowels$I_instance;
  function German$Vowels$I_getInstance() {
    German$Vowels_initFields();
    return German$Vowels$I_instance;
  }
  var German$Vowels$O_instance;
  function German$Vowels$O_getInstance() {
    German$Vowels_initFields();
    return German$Vowels$O_instance;
  }
  var German$Vowels$Ö_instance;
  function German$Vowels$Ö_getInstance() {
    German$Vowels_initFields();
    return German$Vowels$Ö_instance;
  }
  var German$Vowels$U_instance;
  function German$Vowels$U_getInstance() {
    German$Vowels_initFields();
    return German$Vowels$U_instance;
  }
  var German$Vowels$Ü_Y_instance;
  function German$Vowels$Ü_Y_getInstance() {
    German$Vowels_initFields();
    return German$Vowels$Ü_Y_instance;
  }
  function German$Vowels$Companion() {
    German$Vowels$Companion_instance = this;
  }
  German$Vowels$Companion.prototype.from_61zpoe$ = function (vowel) {
    switch (vowel) {
      case 'a':
        return German$Vowels$A_getInstance();
      case 'e':
        return German$Vowels$E_getInstance();
      case 'i':
        return German$Vowels$I_getInstance();
      case 'o':
        return German$Vowels$O_getInstance();
      case 'u':
        return German$Vowels$U_getInstance();
      case '\xE4':
        return German$Vowels$Ä_getInstance();
      case '\xF6':
        return German$Vowels$Ö_getInstance();
      case '\xFC':
      case 'y':
        return German$Vowels$Ü_Y_getInstance();
      default:throw IllegalArgumentException_init('only the following Strings of length 1 are valid input to this method:' + 'aeiou\xE4\xF6\xFC');
    }
  };
  German$Vowels$Companion.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Companion', interfaces: []};
  var German$Vowels$Companion_instance = null;
  function German$Vowels$Companion_getInstance() {
    German$Vowels_initFields();
    if (German$Vowels$Companion_instance === null) {
      new German$Vowels$Companion();
    }
    return German$Vowels$Companion_instance;
  }
  German$Vowels.$metadata$ = {kind: Kind_CLASS, simpleName: 'Vowels', interfaces: [Enum]};
  function German$Vowels$values() {
    return [German$Vowels$A_getInstance(), German$Vowels$Ä_getInstance(), German$Vowels$E_getInstance(), German$Vowels$I_getInstance(), German$Vowels$O_getInstance(), German$Vowels$Ö_getInstance(), German$Vowels$U_getInstance(), German$Vowels$Ü_Y_getInstance()];
  }
  German$Vowels.values = German$Vowels$values;
  function German$Vowels$valueOf(name) {
    switch (name) {
      case 'A':
        return German$Vowels$A_getInstance();
      case '\xC4':
        return German$Vowels$Ä_getInstance();
      case 'E':
        return German$Vowels$E_getInstance();
      case 'I':
        return German$Vowels$I_getInstance();
      case 'O':
        return German$Vowels$O_getInstance();
      case '\xD6':
        return German$Vowels$Ö_getInstance();
      case 'U':
        return German$Vowels$U_getInstance();
      case '\xDC_Y':
        return German$Vowels$Ü_Y_getInstance();
      default:throwISE('No enum constant com.github.medavox.ipa_transcribers.latin.German.Vowels.' + name);
    }
  }
  German$Vowels.valueOf_61zpoe$ = German$Vowels$valueOf;
  German.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(this.normaliseUmlauts_0(nativeText.toLowerCase()), this.rules, getCallableRef('reportOnceAndCopy', function ($receiver, it) {
      return $receiver.reportOnceAndCopy_61zpoe$(it);
    }.bind(null, this)));
  };
  German.prototype.normaliseUmlauts_0 = function ($receiver) {
    var tmp$;
    if (contains_0($receiver, '\xE4') || contains_0($receiver, '\xF6') || contains_0($receiver, '\xFC')) {
      tmp$ = $receiver;
    }
     else {
      tmp$ = replace(replace(replace(replace(replace(replace(replace(replace(replace($receiver, 'a\u0308', '\xE4'), '\u0308a', '\xE4'), 'ae', '\xE4'), 'o\u0308', '\xF6'), '\u0308o', '\xF6'), 'oe', '\xF6'), 'u\u0308', '\xFC'), '\u0308u', '\xFC'), 'ue', '\xFC');
    }
    return tmp$;
  };
  function German$rules$lambda(soFar, groups) {
    return soFar + German$Vowels$Companion_getInstance().from_61zpoe$(ensureNotNull(groups.get_za3lpa$(1)).value).long;
  }
  German.$metadata$ = {kind: Kind_OBJECT, simpleName: 'German', interfaces: [RuleBasedTranscriber]};
  var German_instance = null;
  function German_getInstance() {
    if (German_instance === null) {
      new German();
    }
    return German_instance;
  }
  function Hausa() {
    Hausa_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_vdk7gt$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(Hausa.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_vdk7gt$_0;
  }});
  Hausa.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  Hausa.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Hausa', interfaces: [RuleBasedTranscriber]};
  var Hausa_instance = null;
  function Hausa_getInstance() {
    if (Hausa_instance === null) {
      new Hausa();
    }
    return Hausa_instance;
  }
  function IndonesianMalay() {
    IndonesianMalay_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_qrzmax$_0 = CompletionStatus$IN_PROGRESS_getInstance();
    this.rules = plus(listOf([Rule_init('c', 't\u0361\u0283'), Rule_init('j', 'd\u0361\u0292'), Rule_init('ai', 'ai\u032F'), Rule_init('au', 'au\u032F'), Rule_init('oi', 'oi\u032F\u032F'), Rule_init('gh', '\u0263'), Rule_init('kh', 'x'), Rule_init('ng', '\u014B'), Rule_init('ny', '\u0272'), Rule_init('sy', '\u0283')]), LatinScriptCommonalities_getInstance().latinBaseRules);
  }
  Object.defineProperty(IndonesianMalay.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_qrzmax$_0;
  }});
  IndonesianMalay.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, this.rules, this.reportAndSkip);
  };
  IndonesianMalay.$metadata$ = {kind: Kind_OBJECT, simpleName: 'IndonesianMalay', interfaces: [RuleBasedTranscriber]};
  var IndonesianMalay_instance = null;
  function IndonesianMalay_getInstance() {
    if (IndonesianMalay_instance === null) {
      new IndonesianMalay();
    }
    return IndonesianMalay_instance;
  }
  function Italian() {
    Italian_instance = this;
    RuleBasedTranscriber.call(this);
    this.alphabet = 'abcdefghilmnopqrstuvz';
    this.vowels = 'aeiou';
    this.voicedConsonants = 'bdglmnrvz';
    this.unvoicedConsonants = 'cfhpqst';
    this.consonants = this.voicedConsonants + this.unvoicedConsonants;
    this.frontVowels = 'ie';
    this.nonFrontVowels = 'aou';
    this.completionStatus_dez21v$_0 = CompletionStatus$IN_PROGRESS_getInstance();
    var tmp$ = listOf([Rule_init('ch[ie]', 'k', 2), Rule_init('cc[ie]', 'tt\u0283', 2), Rule_init('ci[aou]', 't\u0283', 2), Rule_init('c[ie]', 't\u0283', 1), Rule_init('c', 'k', 1), Rule_init('q', 'k', 1), Rule_init('gh[ie]', 'g', 2), Rule_init('gi[aou]', 'd\u0292', 2), Rule_init('g[ie]', 'd\u0292', 1), Rule_init('sch[ie]', 'sk', 3), Rule_init('sci[ie]', '\u0283', 2), Rule_init('sc[ie]', '\u0283', 2), Rule_init('sc', 'sk', 2), Rule_init('rr', 'r'), Rule_init('r', '\u027E'), Rule_init('gl', '\u028E'), Rule_init('gn', '\u0272'), Rule_init('n[fv]', '\u0271', 1), Rule_init('[nm][pbm]', 'm', 1), Rule_init('n(q|gh[ie]|ch[ie]|c|g)', '\u014B', 1), new Rule(Regex_init('u[aeio]'), 'w', 1), new Rule(Regex_init('i[aeou]'), 'j', 1), LookbackRule_init('(| )', 's([aeiou]|cfhpqst)', 's', 1), LookbackRule_init('[bdglmnrvzcfhpqst]', 's', 's'), Rule_init('s[cfhpqst]', 's', 1), Rule_init('s[bdglmnrvz]', 'z', 1), LookbackRule_init('[aeiou]', 's[aeiou]', 'z', 1), new Rule(Regex_init('ss'), 'ss'), Rule_init('(| )', 'z[aeiou]+'), Rule_init('zi[aeiou]', 'ts', 1), LookbackRule_init('l', 'z', 'ts'), Rule_init('anza', 'antsa'), Rule_init('enza', '\u025Bntsa'), Rule_init('onzolo', 'ontsolo'), Rule_init('h', '')]);
    var $receiver = LatinScriptCommonalities_getInstance().latinBaseRules;
    var destination = ArrayList_init_0();
    var tmp$_0;
    tmp$_0 = $receiver.iterator();
    while (tmp$_0.hasNext()) {
      var element = tmp$_0.next();
      var $receiver_0 = element.unconsumedMatcher;
      if (!equals($receiver_0, Regex_init('k')) && !equals($receiver_0, Regex_init('w')) && !equals($receiver_0, Regex_init('y')) && !equals($receiver_0, Regex_init('z')))
        destination.add_11rb$(element);
    }
    this.rules = plus(tmp$, destination);
  }
  Object.defineProperty(Italian.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_dez21v$_0;
  }});
  Italian.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText.toLowerCase(), this.rules, this.reportAndSkip);
  };
  Italian.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Italian', interfaces: [RuleBasedTranscriber]};
  var Italian_instance = null;
  function Italian_getInstance() {
    if (Italian_instance === null) {
      new Italian();
    }
    return Italian_instance;
  }
  function LatinScriptCommonalities() {
    LatinScriptCommonalities_instance = this;
  }
  Object.defineProperty(LatinScriptCommonalities.prototype, 'latinBaseRules', {get: function () {
    return listOf([Rule_init('a', 'a'), Rule_init('b', 'b'), Rule_init('d', 'd'), Rule_init('e', 'e'), Rule_init('f', 'f'), Rule_init('g', '\u0261'), Rule_init('h', 'h'), Rule_init('i', 'i'), Rule_init('k', 'k'), Rule_init('l', 'l'), Rule_init('m', 'm'), Rule_init('n', 'n'), Rule_init('o', 'o'), Rule_init('p', 'p'), Rule_init('ph', 'f'), Rule_init('s', 's'), Rule_init('t', 't'), Rule_init('u', 'u'), Rule_init('v', 'v'), Rule_init('w', 'w'), Rule_init('y', 'j'), Rule_init('z', 'z'), Rule_init(' ', ' ')]);
  }});
  LatinScriptCommonalities.$metadata$ = {kind: Kind_OBJECT, simpleName: 'LatinScriptCommonalities', interfaces: []};
  var LatinScriptCommonalities_instance = null;
  function LatinScriptCommonalities_getInstance() {
    if (LatinScriptCommonalities_instance === null) {
      new LatinScriptCommonalities();
    }
    return LatinScriptCommonalities_instance;
  }
  function PortugueseBrazilian() {
    PortugueseBrazilian_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_topzq0$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(PortugueseBrazilian.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_topzq0$_0;
  }});
  PortugueseBrazilian.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  PortugueseBrazilian.$metadata$ = {kind: Kind_OBJECT, simpleName: 'PortugueseBrazilian', interfaces: [RuleBasedTranscriber]};
  var PortugueseBrazilian_instance = null;
  function PortugueseBrazilian_getInstance() {
    if (PortugueseBrazilian_instance === null) {
      new PortugueseBrazilian();
    }
    return PortugueseBrazilian_instance;
  }
  function PortugueseEuropean() {
    PortugueseEuropean_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_beq4wz$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(PortugueseEuropean.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_beq4wz$_0;
  }});
  PortugueseEuropean.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  PortugueseEuropean.$metadata$ = {kind: Kind_OBJECT, simpleName: 'PortugueseEuropean', interfaces: [RuleBasedTranscriber]};
  var PortugueseEuropean_instance = null;
  function PortugueseEuropean_getInstance() {
    if (PortugueseEuropean_instance === null) {
      new PortugueseEuropean();
    }
    return PortugueseEuropean_instance;
  }
  function SpanishPanAmerican() {
    SpanishPanAmerican_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_yo9oe$_0 = CompletionStatus$COMPLETE_getInstance();
    this.voicedConsonants_8be2vx$ = '([bdglmn\xF1vwy]|hu|hi)';
    this.rules_8be2vx$ = listOf([new Rule(Regex_init('\xF1'), '\u0272'), new Rule(Regex_init('hu[aeio]'), 'w', 2), new Rule(Regex_init('hi[aeio]'), '\u029D', 2), new Rule(Regex_init('h'), ''), new Rule(Regex_init('[nm][bv]'), 'mb'), new LookbackRule(Regex_init('^$'), Regex_init('[bv]'), 'b'), new Rule(Regex_init('[bv]'), '\u03B2'), new Rule(Regex_init('(nk|nc)'), '\u014B', 1), new Rule(Regex_init('nf'), '\u0271', 1), new Rule(Regex_init('ny'), '\u0272\u029D'), new Rule(Regex_init('ch'), 't\u0283'), new Rule(Regex_init('tx'), 't\u0283'), new Rule(Regex_init('c[ie]'), 's', 1), new Rule(Regex_init('c([bdglmn\xF1vwy]|hu|hi)'), '\u0263', 1), new Rule(Regex_init('c'), 'k'), new Rule(Regex_init('z([bdglmn\xF1vwy]|hu|hi)'), 'z', 1), new Rule(Regex_init('z'), 's'), new Rule(Regex_init('que'), 'ke'), new Rule(Regex_init('qui'), 'ki'), new LookbackRule(Regex_init('^$'), Regex_init('d'), 'd'), new Rule(Regex_init('ld'), 'ld'), new Rule(Regex_init('nd'), 'nd'), new Rule(Regex_init('d'), '\xF0'), new Rule(Regex_init('j'), 'x'), new LookbackRule(Regex_init('^$'), Regex_init('gu[ao]'), 'gw', 2), new LookbackRule(Regex_init('^$'), Regex_init('ngu[ao]'), '\u014Bgw', 3), new Rule(Regex_init('gu[ao]'), '\u0263w', 2), new LookbackRule(Regex_init('^$'), Regex_init('gu[ie]'), 'g', 2), new Rule(Regex_init('gu[ie]'), '\u0263', 2), new Rule(Regex_init('g[ie]'), 'x', 1), new Rule(Regex_init('ng[^ie]'), '\u014Bg', 2), new LookbackRule(Regex_init('^$'), Regex_init('g[^ie]'), 'g', 1), new Rule(Regex_init('g'), '\u0194'), new LookbackRule(Regex_init('^$'), Regex_init('g\xFCi'), 'gwi'), new Rule(Regex_init('g\xFCi'), '\u0194wi'), new LookbackRule(Regex_init('^$'), Regex_init('g\xFCe'), 'gwe'), new Rule(Regex_init('g\xFCe'), '\u0194we'), new Rule(Regex_init('rr'), 'r'), new Rule(Regex_init('x'), 'ks'), new Rule(Regex_init('x$'), 'ks'), LookbackRule_init('[aeiou]', 'x[aeiou]', 'ks', 1), new LookbackRule(Regex_init('^$'), Regex_init('x'), 's'), new Rule(Regex_init('ll'), '\u028E|\u029D'), new Rule(Regex_init('t([bdglmn\xF1vwy]|hu|hi)'), '\xF0', 1), new Rule(Regex_init('s([bdglmn\xF1vwy]|hu|hi)'), 'z', 1), new Rule(Regex_init('tz'), 'ts'), new Rule(Regex_init('m$'), 'n'), new Rule(Regex_init('y[^aeiou]'), 'i', 1), new Rule(Regex_init('y$'), 'i'), new Rule(Regex_init('y'), '\u029D'), new Rule(Regex_init('u[aeio]'), 'w', 1), new Rule(Regex_init('i[aeou]'), 'j', 1), new Rule(Regex_init('ey'), 'ei'), new Rule(Regex_init('oy'), 'oi')]);
  }
  Object.defineProperty(SpanishPanAmerican.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_yo9oe$_0;
  }});
  SpanishPanAmerican.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(this.removeStressAccents_pdl1vz$(this.normaliseAccents_pdl1vz$(nativeText.toLowerCase())), this.rules_8be2vx$, this.reportAndCopy);
  };
  SpanishPanAmerican.prototype.removeStressAccents_pdl1vz$ = function ($receiver) {
    return replace(replace(replace(replace(replace($receiver, '\xE1', 'a'), '\xE9', 'e'), '\xED', 'i'), '\xF3', 'o'), '\xFA', 'u');
  };
  SpanishPanAmerican.prototype.normaliseAccents_pdl1vz$ = function ($receiver) {
    var $receiver_0 = Regex_init('(n\u0303|\u0303n)').replace_x2uqeu$($receiver, '\xF1');
    var $receiver_1 = Regex_init('(a\u0301|\u0301a)').replace_x2uqeu$($receiver_0, '\xE1');
    var $receiver_2 = Regex_init('(e\u0301|\u0301e)').replace_x2uqeu$($receiver_1, '\xE9');
    var $receiver_3 = Regex_init('(i\u0301|\u0301i)').replace_x2uqeu$($receiver_2, '\xED');
    var $receiver_4 = Regex_init('(o\u0301|\u0301o)').replace_x2uqeu$($receiver_3, '\xF3');
    return Regex_init('(u\u0301|\u0301u)').replace_x2uqeu$($receiver_4, '\xFA');
  };
  SpanishPanAmerican.$metadata$ = {kind: Kind_OBJECT, simpleName: 'SpanishPanAmerican', interfaces: [RuleBasedTranscriber]};
  var SpanishPanAmerican_instance = null;
  function SpanishPanAmerican_getInstance() {
    if (SpanishPanAmerican_instance === null) {
      new SpanishPanAmerican();
    }
    return SpanishPanAmerican_instance;
  }
  function SpanishPeninsular() {
    SpanishPeninsular_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_668qks$_0 = CompletionStatus$COMPLETE_getInstance();
    var $receiver = SpanishPanAmerican_getInstance().rules_8be2vx$;
    var destination = ArrayList_init(collectionSizeOrDefault($receiver, 10));
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var item = tmp$.next();
      var tmp$_0 = destination.add_11rb$;
      var transform$result;
      var tmp$_1;
      tmp$_1 = item.unconsumedMatcher;
      if (equals(tmp$_1, Regex_init('c[ie]'))) {
        transform$result = item.copy_jubfao$(void 0, void 0, SpanishPeninsular$rules$lambda$lambda);
      }
       else if (equals(tmp$_1, Regex_init('z([bdglmn\xF1vwy]|hu|hi)'))) {
        transform$result = item.copy_jubfao$(void 0, void 0, SpanishPeninsular$rules$lambda$lambda_0);
      }
       else if (equals(tmp$_1, Regex_init('z'))) {
        transform$result = item.copy_jubfao$(void 0, void 0, SpanishPeninsular$rules$lambda$lambda_1);
      }
       else {
        transform$result = item;
      }
      tmp$_0.call(destination, transform$result);
    }
    this.rules = destination;
  }
  Object.defineProperty(SpanishPeninsular.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_668qks$_0;
  }});
  SpanishPeninsular.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(SpanishPanAmerican_getInstance().removeStressAccents_pdl1vz$(SpanishPanAmerican_getInstance().normaliseAccents_pdl1vz$(nativeText.toLowerCase())), this.rules, this.reportAndCopy);
  };
  function SpanishPeninsular$rules$lambda$lambda(f) {
    return '\u03B8';
  }
  function SpanishPeninsular$rules$lambda$lambda_0(f) {
    return '\xF0';
  }
  function SpanishPeninsular$rules$lambda$lambda_1(f) {
    return '\u03B8';
  }
  SpanishPeninsular.$metadata$ = {kind: Kind_OBJECT, simpleName: 'SpanishPeninsular', interfaces: [RuleBasedTranscriber]};
  var SpanishPeninsular_instance = null;
  function SpanishPeninsular_getInstance() {
    if (SpanishPeninsular_instance === null) {
      new SpanishPeninsular();
    }
    return SpanishPeninsular_instance;
  }
  function Swahili() {
    Swahili_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_9xj5pa$_0 = CompletionStatus$SURFACE_LEVEL_COMPLETE_getInstance();
    this.rules = listOf([Rule_init('b', '\u0253'), Rule_init('dh', '\xF0'), Rule_init('d', '\u0257'), Rule_init('d\u0292', 'j'), Rule_init('f', 'f'), Rule_init('gh', '\u0263'), Rule_init('g', '\u0260'), Rule_init('y', 'j'), Rule_init('h', 'h'), Rule_init('l', 'l'), Rule_init('kh', 'x'), Rule_init('k', 'k'), Rule_init('mt', 'm\u0329t'), Rule_init('mb', '\u1D50b'), Rule_init('mv', '\u1DACv'), Rule_init('m', 'm'), Rule_init('nch', 'n\u0329'), Rule_init('nd', '\u207Fd'), Rule_init('ng', '\u1D51\u0261'), Rule_init('nj', '\u207Fd\u0292'), Rule_init('nz', '\u207Fz'), Rule_init('ny', '\u0272'), Rule_init('ng', '\u014B'), Rule_init('n', 'n'), Rule_init('p', 'p'), Rule_init('r', '\u027E'), Rule_init('sh', '\u0283'), Rule_init('th', '\u03B8'), Rule_init('t', 't'), Rule_init('s', 's'), Rule_init('ch', 't\u0283'), Rule_init('v', 'v'), Rule_init('w', 'w'), Rule_init('z', 'z'), Rule_init('a', '\u0251'), Rule_init('e', '\u025B'), Rule_init('i', 'i'), Rule_init('o', '\u0254'), Rule_init('u', 'u')]);
  }
  Object.defineProperty(Swahili.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_9xj5pa$_0;
  }});
  Swahili.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText.toLowerCase(), this.rules, this.reportAndCopy);
  };
  Swahili.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Swahili', interfaces: [RuleBasedTranscriber]};
  var Swahili_instance = null;
  function Swahili_getInstance() {
    if (Swahili_instance === null) {
      new Swahili();
    }
    return Swahili_instance;
  }
  function Turkish() {
    Turkish_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_jtaec9$_0 = CompletionStatus$COMPLETE_getInstance();
    this.frontVowels = 'ei\xF6\xFC';
    this.backVowels = 'a\xE2\u0131ou\xFB';
    this.allVowels = 'a\xE2ei\u0131o\xF6u\xFC\xFB';
    this.rules_0 = plus(listOf([Rule_init('\xE2', 'a'), Rule_init('c', 'd\u0361\u0292'), Rule_init('c[a\xE2ei\u0131o\xF6u\xFC\xFB]', 'd\u0361\u0292\u02B0', 1), Rule_init('\xE7', 't\u0361\u0283'), Rule_init('e[mnlr]', '\xE6', 1), Rule_init('e', 'e'), LookbackRule_init('[ei\xF6\xFC]', '\u011F[ei\xF6\xFC]', 'j', 1), LookbackRule_init('[a\xE2\u0131ou\xFB]', '\u011F[a\xE2\u0131ou\xFB]', '\u0270\u031F', 1), LookbackRule_init('[a\xE2ei\u0131o\xF6u\xFC\xFB]', '\u011F[a\xE2ei\u0131o\xF6u\xFC\xFB]', '', 1), LookbackRule_init('[e]', '\u011F[^a\xE2ei\u0131o\xF6u\xFC\xFB]', 'j', 1), LookbackRule_init('[a\xE2ei\u0131o\xF6u\xFC\xFB]', '\u011F', '\u02D0'), Rule_init('\u0131', '\u026F'), Rule_init('j', '\u0292'), LookbackRule_init('[ei\xF6\xFC]', 'k', 'c'), Rule_init('k[ei\xF6\xFC]', 'c', 1), Rule_init('k[\xE2\xFB]', 'c', 1), LookbackRule_init('', 'k[a\xE2\u0131ou\xFB]', 'k\u02B0'), Rule_init('k', 'k'), LookbackRule_init('[ei\xF6\xFC]', 'g', '\u025F'), Rule_init('g[ei\xF6\xFC]', '\u025F', 1), Rule_init('g[\xE2\xFB]', '\u025F', 1), Rule_init('g', '\u0261'), LookbackRule_init('[ei\xF6\xFC]', 'l', 'l'), Rule_init('l[ei\xF6\xFC]', 'l', 1), Rule_init('l[\xE2\xFB]', 'l', 1), Rule_init('l', '\u026B'), Rule_init('\xF6', '\xF8\u031E'), Rule_init('r', '\u027E'), Rule_init('\u015F', '\u0283'), Rule_init('\xFB', 'u'), Rule_init('\xFC', 'y'), Rule_init('p[a\xE2ei\u0131o\xF6u\xFC\xFB]', 'p\u02B0'), Rule_init('t[a\xE2ei\u0131o\xF6u\xFC\xFB]', 't\u02B0'), LookbackRule_init('[ei\xF6\xFC]', 'h', '\xE7'), Rule_init('h', 'x')]), LatinScriptCommonalities_getInstance().latinBaseRules);
  }
  Object.defineProperty(Turkish.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_jtaec9$_0;
  }});
  Turkish.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText.toLowerCase(), this.rules_0, this.reportAndSkip);
  };
  Turkish.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Turkish', interfaces: [RuleBasedTranscriber]};
  var Turkish_instance = null;
  function Turkish_getInstance() {
    if (Turkish_instance === null) {
      new Turkish();
    }
    return Turkish_instance;
  }
  function Vietnamese() {
    Vietnamese_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_fdxk6w$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(Vietnamese.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_fdxk6w$_0;
  }});
  Vietnamese.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  Vietnamese.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Vietnamese', interfaces: [RuleBasedTranscriber]};
  var Vietnamese_instance = null;
  function Vietnamese_getInstance() {
    if (Vietnamese_instance === null) {
      new Vietnamese();
    }
    return Vietnamese_instance;
  }
  function ChineseBopomofoZhuyin() {
    ChineseBopomofoZhuyin_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_6yq0ui$_0 = CompletionStatus$UNSTARTED_getInstance();
    this.rules = listOf([Rule_init('\u3105', 'p'), Rule_init('\u3106', 'p\u02B0'), Rule_init('\u3107', 'm'), Rule_init('\u3108', 'f'), Rule_init('\u3109', 't'), Rule_init('\u310A', 't\u02B0'), Rule_init('\u310B', 'n'), Rule_init('\u310C', 'l'), Rule_init('\u310D', 'k'), Rule_init('\u310E', 'k\u02B0'), Rule_init('\u310F', 'x'), Rule_init('\u3110', 't\u0255'), Rule_init('\u3111', 't\u0255\u02B0'), Rule_init('\u3112', '\u0255'), Rule_init('\u3113', '\u0288\u0282'), Rule_init('\u3114', '\u0288\u0282\u02B0'), Rule_init('\u3115', '\u0282'), Rule_init('\u3116', '\u027B~\u0290'), Rule_init('\u3117', 'ts'), Rule_init('\u3118', 'ts\u02B0'), Rule_init('\u3119', 's'), Rule_init('\u311A', 'a'), Rule_init('\u311B', 'o'), Rule_init('\u311C', '\u0264'), Rule_init('\u311D', 'e'), Rule_init('\u311E', 'ai'), Rule_init('\u311F', 'ei'), Rule_init('\u3120', 'au'), Rule_init('\u3121', 'ou'), Rule_init('\u3122', 'an'), Rule_init('\u3123', '\u0259n'), Rule_init('\u3124', 'a\u014B'), Rule_init('\u3125', '\u0259\u014B'), Rule_init('\u3126', 'a\u025A'), Rule_init('\u3127', 'i'), Rule_init('\u3128', 'u'), Rule_init('\u3129', 'y'), Rule_init('\u3129', 'y'), Rule_init(' ', ' ')]);
  }
  Object.defineProperty(ChineseBopomofoZhuyin.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_6yq0ui$_0;
  }});
  ChineseBopomofoZhuyin.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, this.rules, getCallableRef('reportOnceAndCopy', function ($receiver, it) {
      return $receiver.reportOnceAndCopy_61zpoe$(it);
    }.bind(null, this)));
  };
  ChineseBopomofoZhuyin.$metadata$ = {kind: Kind_OBJECT, simpleName: 'ChineseBopomofoZhuyin', interfaces: [RuleBasedTranscriber]};
  var ChineseBopomofoZhuyin_instance = null;
  function ChineseBopomofoZhuyin_getInstance() {
    if (ChineseBopomofoZhuyin_instance === null) {
      new ChineseBopomofoZhuyin();
    }
    return ChineseBopomofoZhuyin_instance;
  }
  function JapaneseOnlyKatakanaHiragana() {
    JapaneseOnlyKatakanaHiragana_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_wmdxv7$_0 = CompletionStatus$INCOMPLETE_getInstance();
    this.rules_0 = listOf([Rule_init('\u30A2', 'a'), Rule_init('\u30A4', 'i'), Rule_init('\u30A6', '\u026F'), Rule_init('\u30A8', 'e'), Rule_init('\u30AA', 'o'), Rule_init('\u30AB', 'ka'), Rule_init('\u30AD', 'ki'), Rule_init('\u30AF', 'k\u026F'), Rule_init('\u30B1', 'ke'), Rule_init('\u30B3', 'ko'), Rule_init('\u30AD\u30E3', 'k\u02B2a'), Rule_init('\u30AD\u30E5', 'k\u02B2\u026F'), Rule_init('\u30AD\u30E7', 'k\u02B2o'), Rule_init('\u30B5', 'sa'), Rule_init('\u30B7', '\u0255i'), Rule_init('\u30B9', 's\u026F'), Rule_init('\u30BB', 'se'), Rule_init('\u30BD', 'so'), Rule_init('\u30B7\u30E3', '\u0255a'), Rule_init('\u30B7\u30E5', '\u0255\u026F'), Rule_init('\u30B7\u30E7', '\u0255o'), Rule_init('\u30BF', 'ta'), Rule_init('\u30C1', 't\u0361\u0255i'), Rule_init('\u30C4', 't\u0361s\u026F'), Rule_init('\u30C6', 'te'), Rule_init('\u30C8', 'to'), Rule_init('\u30C1\u30E3', 't\u0361\u0255a'), Rule_init('\u30C1\u30E5', 't\u0361\u0255\u026F'), Rule_init('\u30C1\u30E7', 't\u0361\u0255o'), Rule_init('\u30CA', 'na'), Rule_init('\u30CB', '\u0272i'), Rule_init('\u30CC', 'n\u026F'), Rule_init('\u30CD', 'ne'), Rule_init('\u30CE', 'no'), Rule_init('\u30CB\u30E3', '\u0272a'), Rule_init('\u30CB\u30E5', '\u0272\u026F'), Rule_init('\u30CB\u30E7', '\u0272o'), Rule_init('\u30CF', 'ha'), Rule_init('\u30D2', '\xE7i'), Rule_init('\u30D5', '\u0278\u026F'), Rule_init('\u30D8', 'he'), Rule_init('\u30DB', 'ho'), Rule_init('\u30D2\u30E3', '\xE7a'), Rule_init('\u30D2\u30E5', '\xE7\u026F'), Rule_init('\u30D2\u30E7', '\xE7o'), Rule_init('\u30DE', 'ma'), Rule_init('\u30DF', 'mi'), Rule_init('\u30E0', 'm\u026F'), Rule_init('\u30E1', 'me'), Rule_init('\u30E2', 'mo'), Rule_init('\u30DF\u30E3', 'm\u02B2a'), Rule_init('\u30DF\u30E5', 'm\u02B2\u026F'), Rule_init('\u30DF\u30E7', 'm\u02B2o'), Rule_init('\u30E4', 'ja'), Rule_init('\u30E6', 'j\u026F'), Rule_init('\u30E8', 'jo'), Rule_init('\u30E9', '\u027Ea'), Rule_init('\u30EA', '\u027Ei'), Rule_init('\u30EB', '\u027E\u026F'), Rule_init('\u30EC', '\u027Ee'), Rule_init('\u30ED', '\u027Eo'), Rule_init('\u30EA\u30E3', '\u027E\u02B2a'), Rule_init('\u30EA\u30E5', '\u027E\u02B2\u026F'), Rule_init('\u30EA\u30E7', '\u027E\u02B2o'), Rule_init('\u30EF', '\u0270a'), Rule_init('\u30F0', 'i'), Rule_init('\u30F1', 'e'), Rule_init('\u30F2', 'o'), Rule_init('\u30AE', '\u0261i'), Rule_init('\u30B0', '\u0261\u026F'), Rule_init('\u30B2', '\u0261e'), Rule_init('\u30B4', '\u0261o'), Rule_init('\u30AE\u30E3', '\u0261\u02B2a'), Rule_init('\u30AE\u30E5', '\u0261\u02B2\u026F'), Rule_init('\u30AE\u30E7', '\u0261\u02B2o'), Rule_init('\u30B8', '(d)\u0291i'), Rule_init('\u30BA', '(d)z\u026F'), Rule_init('\u30BC', 'ze'), Rule_init('\u30BE', 'zo'), Rule_init('\u30B8\u30E3', '(d)\u0291a'), Rule_init('\u30B8\u30E5', '(d)\u0291\u026F'), Rule_init('\u30B8\u30E7', '(d)\u0291o'), Rule_init('\u30C2', '(d)\u0291i'), Rule_init('\u30C5', '(d)z\u026F'), Rule_init('\u30C7', 'de'), Rule_init('\u30C9', 'do'), Rule_init('\u30C2\u30E3', '(d)\u0291a'), Rule_init('\u30C2\u30E5', '(d)\u0291\u026F'), Rule_init('\u30C2\u30E7', '(d)\u0291o'), Rule_init('\u30D3', 'bi'), Rule_init('\u30D6', 'b\u026F'), Rule_init('\u30D9', 'be'), Rule_init('\u30DC', 'bo'), Rule_init('\u30D3\u30E3', 'b\u02B2a'), Rule_init('\u30D3\u30E5', 'b\u02B2\u026F'), Rule_init('\u30D3\u30E7', 'b\u02B2o'), Rule_init('\u30D4', 'pi'), Rule_init('\u30D7', 'p\u026F'), Rule_init('\u30DA', 'pe'), Rule_init('\u30DD', 'po'), Rule_init('\u30D4\u30E3', 'p\u02B2a'), Rule_init('\u30D4\u30E5', 'p\u02B2\u026F'), Rule_init('\u30D4\u30E7', 'p\u02B2o'), Rule_init('\u3042', 'a'), Rule_init('\u3044', 'i'), Rule_init('\u3046', '\u026F'), Rule_init('\u3048', 'e'), Rule_init('\u304A', 'o'), Rule_init('\u304B', 'ka'), Rule_init('\u304D', 'ki'), Rule_init('\u304F', 'k\u026F'), Rule_init('\u3051', 'ke'), Rule_init('\u3053', 'ko'), Rule_init('\u304D\u3083', 'k\u02B2a'), Rule_init('\u304D\u3085', 'k\u02B2\u026F'), Rule_init('\u304D\u3087', 'k\u02B2o'), Rule_init('\u3055', 'sa'), Rule_init('\u3057', '\u0255i'), Rule_init('\u3059', 's\u026F'), Rule_init('\u305B', 'se'), Rule_init('\u305D', 'so'), Rule_init('\u3057\u3083', '\u0255a'), Rule_init('\u3057\u3085', '\u0255\u026F'), Rule_init('\u3057\u3087', '\u0255o'), Rule_init('\u305F', 'ta'), Rule_init('\u3061', 't\u0255i'), Rule_init('\u3064', 'ts\u026F'), Rule_init('\u3066', 'te'), Rule_init('\u3068', 'to'), Rule_init('\u3061\u3083', 't\u0255a'), Rule_init('\u3061\u3085', 't\u0255\u026F'), Rule_init('\u3061\u3087', 't\u0255o'), Rule_init('\u306A', 'na'), Rule_init('\u306B', '\u0272i'), Rule_init('\u306C', 'n\u026F'), Rule_init('\u306D', 'ne'), Rule_init('\u306E', 'no'), Rule_init('\u306B\u3083', '\u0272a'), Rule_init('\u306B\u3085', '\u0272\u026F'), Rule_init('\u306B\u3087', '\u0272o'), Rule_init('\u306F', 'ha'), Rule_init(' \u3072', '\xE7i'), Rule_init('\u3075', '\u0278\u026F'), Rule_init('\u3078', 'he'), Rule_init(' \u307B', 'ho'), Rule_init('\u3072\u3083', '\xE7a'), Rule_init('\u3072\u3085', '\xE7\u026F'), Rule_init('\u3072\u3087', '\xE7o'), Rule_init('\u307E', 'ma'), Rule_init('\u307F', 'mi'), Rule_init('\u3080', 'm\u026F'), Rule_init('\u3081', 'me'), Rule_init('\u3082', 'mo'), Rule_init('\u307F\u3083', 'm\u02B2a'), Rule_init('\u307F\u3085', 'm\u02B2\u026F'), Rule_init('\u307F\u3087', 'm\u02B2o'), Rule_init('\u3084', 'ja'), Rule_init('\u3086', 'j\u026F'), Rule_init('\u3088', 'jo'), Rule_init('\u3089', '\u027Ea'), Rule_init('\u308A', '\u027Ei'), Rule_init('\u308B', '\u027E\u026F'), Rule_init('\u308C', '\u027Ee'), Rule_init('\u308D', '\u027Eo'), Rule_init('\u308A\u3083', '\u027E\u02B2a'), Rule_init('\u308A\u3085', '\u027E\u02B2\u026F'), Rule_init('\u308A\u3087', '\u027E\u02B2o'), Rule_init('\u308F', '\u0270a'), Rule_init('\u3090', 'i'), Rule_init('\u3091', 'e'), Rule_init('\u3092', 'o'), Rule_init('\u304C', '\u0261a'), Rule_init('\u304E', '\u0261i'), Rule_init('\u3050', '\u0261\u026F'), Rule_init('\u3052', '\u0261e'), Rule_init('\u3054', '\u0261o'), Rule_init('\u304E\u3083', '\u0261\u02B2a'), Rule_init('\u304E\u3085', '\u0261\u02B2\u026F'), Rule_init('\u304E\u3087', '\u0261\u02B2o'), Rule_init('\u3056', '(d)za'), Rule_init('\u3058', '(d)\u0291i'), Rule_init('\u305A', '(d)z\u026F'), Rule_init('\u305C', '(d)ze'), Rule_init('\u305E', '(d)zo'), Rule_init('\u3058\u3083', '(d)\u0291a'), Rule_init('\u3058\u3085', '(d)\u0291\u026F'), Rule_init('\u3058\u3087', '(d)\u0291o'), Rule_init('\u3060', 'da'), Rule_init('\u3062', '(d)\u0291i'), Rule_init('\u3065', '(d)z\u026F'), Rule_init('\u3067', 'de'), Rule_init('\u3069', 'do'), Rule_init('\u3062\u3083', '(d)\u0291a'), Rule_init('\u3062\u3085', '(d)\u0291\u026F'), Rule_init('\u3062\u3087', '(d)\u0291o'), Rule_init('\u3070', 'ba'), Rule_init('\u3073', 'bi'), Rule_init('\u3076', 'b\u026F'), Rule_init('\u3079', 'be'), Rule_init('\u307C', 'bo'), Rule_init('\u3073\u3083', 'b\u02B2a'), Rule_init('\u3073\u3085', 'b\u02B2\u026F'), Rule_init('\u3073\u3087', 'b\u02B2o'), Rule_init('\u3071', 'pa'), Rule_init('\u3074', 'pi'), Rule_init('\u3077', 'p\u026F'), Rule_init('\u307A', 'pe'), Rule_init('\u307D', 'po'), Rule_init('\u3074\u3083', 'p\u02B2a'), Rule_init('\u3074\u3085', 'p\u02B2\u026F'), Rule_init('\u3074\u3087', 'p\u02B2o')]);
  }
  Object.defineProperty(JapaneseOnlyKatakanaHiragana.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_wmdxv7$_0;
  }});
  JapaneseOnlyKatakanaHiragana.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(nativeText, this.rules_0, this.reportAndCopy);
  };
  JapaneseOnlyKatakanaHiragana.$metadata$ = {kind: Kind_OBJECT, simpleName: 'JapaneseOnlyKatakanaHiragana', interfaces: [RuleBasedTranscriber]};
  var JapaneseOnlyKatakanaHiragana_instance = null;
  function JapaneseOnlyKatakanaHiragana_getInstance() {
    if (JapaneseOnlyKatakanaHiragana_instance === null) {
      new JapaneseOnlyKatakanaHiragana();
    }
    return JapaneseOnlyKatakanaHiragana_instance;
  }
  function KoreanHangeul() {
    KoreanHangeul_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_6ncvxn$_0 = CompletionStatus$COMPLETE_getInstance();
    this.vowels_0 = '\u1161\u1162\u1163\u1164\u1165\u1166\u1167\u1168\u1169\u116A\u116B\u116C\u116D\u116E\u116F\u1170\u1171\u1172\u1173\u1174\u1175';
    this.rules_0 = listOf([Rule_init('\u1100', 'k'), Rule_init('\u1102', 'n'), Rule_init('\u1103', 't'), Rule_init('\u1105', '\u027E'), Rule_init('\u1106', 'm'), Rule_init('\u1107', 'p'), Rule_init('\u1109', 's'), Rule_init('\u110B', ''), Rule_init('\u110C', 't\u0255'), Rule_init('\u110D', 't\u0348\u0255'), Rule_init('\u1104', 't\u0348'), Rule_init('\u1108', 'p\u0348'), Rule_init('\u110A', 's\u0348'), Rule_init('\u1101', 'k\u0348'), Rule_init('\u110E', 't\u0255\u02B0'), Rule_init('\u110F', 'k\u02B0'), Rule_init('\u1110', 't\u02B0'), Rule_init('\u1111', 'p\u02B0'), Rule_init('\u1112', 'h'), Rule_init('[\u11A8\u3132\u11BF]', 'k\u031A'), Rule_init('\u11AB', 'n'), Rule_init('\u11AF', 'l'), Rule_init('\u11B7', 'm'), Rule_init('\u11B8', 'p\u031A'), Rule_init('[\u11AE\u11C0\u11BE\u11C2\u11BA\u11BB\u11BD]', 't\u031A'), Rule_init('\u11BC', '\u014B'), Rule_init('\u11AA \u110B', 'k s'), Rule_init('\u11B0 \u110B', 'l k'), Rule_init('\u11AC \u110B', 'n t\u0255'), Rule_init('\u11AD \u110B', 'n h'), Rule_init('\u11B2 \u110B', 'l p'), Rule_init('\u11B3 \u110B', 'l s'), Rule_init('\u11B4 \u110B', 'l t\u02B0'), Rule_init('\u11B6 \u110B', 'l h'), Rule_init('\u11B1 \u110B', 'l m'), Rule_init('\u11B5 \u110B', 'l p\u02B0'), Rule_init('\u11B9 \u110B', 'p s'), Rule_init('[\u11AA\u11B0]', 'k\u031A'), Rule_init('[\u11AC\u11AD]', 'n'), Rule_init('[\u11B2\u11B3\u11B4\u11B6]', 'l'), Rule_init('[\u11B1]', 'm'), Rule_init('[\u11B5\u11B9]', 'p'), new Rule(Regex_init('[\u1161\u314F]'), 'a'), new Rule(Regex_init('[\u1162\u3150]'), '\u025B'), new Rule(Regex_init('[\u1163\u3151]'), 'ja'), new Rule(Regex_init('[\u1164\u3152]'), 'j\u025B'), new Rule(Regex_init('[\u1165\u3153]'), '\u028C'), new Rule(Regex_init('[\u1166\u3154]'), 'e'), new Rule(Regex_init('[\u1167\u3155]'), 'j\u028C'), new Rule(Regex_init('[\u1168\u3156]'), 'je'), new Rule(Regex_init('[\u1169\u3157]'), 'o'), new Rule(Regex_init('[\u116A\u3158]'), 'wa'), new Rule(Regex_init('[\u116B\u3159]'), 'w\u025B'), new Rule(Regex_init('[\u116C\u315A]'), '\xF8'), new Rule(Regex_init('[\u116D\u315B]'), 'jo'), new Rule(Regex_init('[\u116E\u315C]'), 'u'), new Rule(Regex_init('[\u116F\u315D]'), 'w\u028C'), new Rule(Regex_init('[\u1170\u315E]'), 'we'), new Rule(Regex_init('[\u1171\u315F]'), 'y'), new Rule(Regex_init('[\u1172\u3160]'), 'ju'), new Rule(Regex_init('[\u1173\u3161]'), '\u026F'), new Rule(Regex_init('[\u1174\u3162]'), '\u0270i'), new Rule(Regex_init('[\u1175\u3163]'), 'i')]);
  }
  Object.defineProperty(KoreanHangeul.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_6ncvxn$_0;
  }});
  KoreanHangeul.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(normaliseNfd(nativeText), this.rules_0, getCallableRef('reportOnceAndCopy', function ($receiver, it) {
      return $receiver.reportOnceAndCopy_61zpoe$(it);
    }.bind(null, this)));
  };
  KoreanHangeul.$metadata$ = {kind: Kind_OBJECT, simpleName: 'KoreanHangeul', interfaces: [RuleBasedTranscriber]};
  var KoreanHangeul_instance = null;
  function KoreanHangeul_getInstance() {
    if (KoreanHangeul_instance === null) {
      new KoreanHangeul();
    }
    return KoreanHangeul_instance;
  }
  function RussianCyrillic() {
    RussianCyrillic_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_2gu3s9$_0 = CompletionStatus$IN_PROGRESS_getInstance();
    this.softenableConsonants_0 = '\u0431\u0432\u0433\u0434\u0437\u043A\u043B\u043C\u043D\u043F\u0440\u0441\u0442\u0444\u0445';
    this.fakeLatinCyrillic_0 = listOf([Rule_init('A', '\u0430'), Rule_init('B', '\u0432'), Rule_init('E', '\u0435'), Rule_init('S', '\u0455'), Rule_init('I', '\u0456'), Rule_init('J', '\u0458'), Rule_init('K', '\u043A'), Rule_init('M', '\u043C'), Rule_init('H', '\u043D'), Rule_init('O', '\u043E'), Rule_init('P', '\u0440'), Rule_init('C', '\u0441'), Rule_init('T', '\u0442'), Rule_init('Y', '\u0443'), Rule_init('X', '\u0445')]);
    this.rules = plus(listOf([Rule_init('\u0430', 'a'), Rule_init('\u0431', 'b'), Rule_init('\u0432', 'v'), Rule_init('\u0433', '\u0261'), Rule_init('\u0434', 'd'), LookbackRule_init('[\u0431\u0432\u0433\u0434\u0437\u043A\u043B\u043C\u043D\u043F\u0440\u0441\u0442\u0444\u0445]', '\u0435', '\u02B2e'), Rule_init('\u0435', 'je'), LookbackRule_init('[\u0431\u0432\u0433\u0434\u0437\u043A\u043B\u043C\u043D\u043F\u0440\u0441\u0442\u0444\u0445]', '\u0451', '\u02B2o'), Rule_init('\u0451', 'jo'), Rule_init('\u0436', '\u0290'), Rule_init('\u0437', 'z'), LookbackRule_init('[\u0431\u0432\u0433\u0434\u0437\u043A\u043B\u043C\u043D\u043F\u0440\u0441\u0442\u0444\u0445]', '\u0438', '\u02B2i'), Rule_init('\u0438', 'i'), Rule_init('\u0439', 'j'), Rule_init('\u043A', 'k'), Rule_init('\u043B', '\u026B'), Rule_init('\u043C', 'm'), Rule_init('\u043D', 'n'), Rule_init('\u043E', 'o'), Rule_init('\u043F', 'p'), Rule_init('\u0440', 'r'), Rule_init('\u0441', 's'), Rule_init('\u0442', 't'), Rule_init('\u0443', 'u'), Rule_init('\u0444', 'f'), Rule_init('\u0445', 'x'), Rule_init('\u0446', 'ts'), Rule_init('\u0447', 't\u0255'), Rule_init('\u0448', '\u0282'), Rule_init('\u0449', '\u0255\u0255'), Rule_init('\u044A', ''), Rule_init('\u044B', '\u0268'), LookbackRule_init('[\u0431\u0432\u0433\u0434\u0437\u043A\u043B\u043C\u043D\u043F\u0440\u0441\u0442\u0444\u0445]', '\u044C', '\u02B2'), Rule_init('\u044D', 'e'), LookbackRule_init('[\u0431\u0432\u0433\u0434\u0437\u043A\u043B\u043C\u043D\u043F\u0440\u0441\u0442\u0444\u0445]', '\u044E', '\u02B2u'), Rule_init('\u044E', 'ju'), LookbackRule_init('[\u0431\u0432\u0433\u0434\u0437\u043A\u043B\u043C\u043D\u043F\u0440\u0441\u0442\u0444\u0445]', '\u044F', '\u02B2a'), Rule_init('\u044F', 'ja')]), this.westernPunctuation);
  }
  Object.defineProperty(RussianCyrillic.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_2gu3s9$_0;
  }});
  RussianCyrillic.prototype.transcribe_61zpoe$ = function (nativeText) {
    return this.processWithRules_lyv0qx$(this.processWithRules_lyv0qx$(nativeText, this.fakeLatinCyrillic_0, this.copy).toLowerCase(), this.rules, this.reportAndCopy);
  };
  RussianCyrillic.$metadata$ = {kind: Kind_OBJECT, simpleName: 'RussianCyrillic', interfaces: [RuleBasedTranscriber]};
  var RussianCyrillic_instance = null;
  function RussianCyrillic_getInstance() {
    if (RussianCyrillic_instance === null) {
      new RussianCyrillic();
    }
    return RussianCyrillic_instance;
  }
  function Thai() {
    Thai_instance = this;
    RuleBasedTranscriber.call(this);
    this.completionStatus_dndop5$_0 = CompletionStatus$UNSTARTED_getInstance();
  }
  Object.defineProperty(Thai.prototype, 'completionStatus', {get: function () {
    return this.completionStatus_dndop5$_0;
  }});
  Thai.prototype.transcribe_61zpoe$ = function (nativeText) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  Thai.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Thai', interfaces: [RuleBasedTranscriber]};
  var Thai_instance = null;
  function Thai_getInstance() {
    if (Thai_instance === null) {
      new Thai();
    }
    return Thai_instance;
  }
  function main$lambda(closure$slekt, closure$inputTextArea, closure$outputTextArea, closure$errorsTextArea) {
    return function (event) {
      var $receiver = Language$values();
      var firstOrNull$result;
      firstOrNull$break: do {
        var tmp$;
        for (tmp$ = 0; tmp$ !== $receiver.length; ++tmp$) {
          var element = $receiver[tmp$];
          var closure$slekt_0 = closure$slekt;
          if (element.ordinal === closure$slekt_0.selectedIndex) {
            firstOrNull$result = element;
            break firstOrNull$break;
          }
        }
        firstOrNull$result = null;
      }
       while (false);
      var transcribr = ensureNotNull(firstOrNull$result).transcriber;
      closure$outputTextArea.textContent = transcribr.transcribe_61zpoe$(closure$inputTextArea.value);
      closure$errorsTextArea.textContent = 'transcriber: ' + transcribr;
      return Unit;
    };
  }
  function main() {
    var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3;
    var slekt = Kotlin.isType(tmp$ = document.getElementById('lang_select'), HTMLSelectElement) ? tmp$ : throwCCE();
    var $receiver = Language$values();
    var tmp$_4;
    for (tmp$_4 = 0; tmp$_4 !== $receiver.length; ++tmp$_4) {
      var element = $receiver[tmp$_4];
      slekt.add(new Option(element.neim, element.name, false, false));
    }
    var inputTextArea = Kotlin.isType(tmp$_0 = document.getElementById('input_text'), HTMLTextAreaElement) ? tmp$_0 : throwCCE();
    var outputTextArea = Kotlin.isType(tmp$_1 = document.getElementById('output_text'), HTMLTextAreaElement) ? tmp$_1 : throwCCE();
    var errorsTextArea = Kotlin.isType(tmp$_2 = document.getElementById('errors_text'), HTMLTextAreaElement) ? tmp$_2 : throwCCE();
    inputTextArea.setAttribute('placeholder', UiStrings_getInstance().inputHint);
    outputTextArea.setAttribute('placeholder', UiStrings_getInstance().outputHint);
    errorsTextArea.setAttribute('placeholder', UiStrings_getInstance().errorsHint);
    var button = Kotlin.isType(tmp$_3 = document.getElementById('transliterate_button'), HTMLButtonElement) ? tmp$_3 : throwCCE();
    button.addEventListener('click', main$lambda(slekt, inputTextArea, outputTextArea, errorsTextArea));
  }
  function main$ObjectLiteral() {
  }
  function err() {
    err_instance = this;
  }
  err.prototype.print_61zpoe$ = function (err) {
    throw new NotImplementedError_init();
  };
  err.prototype.println_61zpoe$ = function (err) {
    throw new NotImplementedError_init();
  };
  err.$metadata$ = {kind: Kind_OBJECT, simpleName: 'err', interfaces: []};
  var err_instance = null;
  function err_getInstance() {
    if (err_instance === null) {
      new err();
    }
    return err_instance;
  }
  function get_unicodeName($receiver) {
    throw new NotImplementedError_init();
  }
  function normaliseNfd($receiver) {
    var tmp$;
    var s = $receiver;
    return typeof (tmp$ = s.normalize('NFD')) === 'string' ? tmp$ : throwCCE();
  }
  var package$com = _.com || (_.com = {});
  var package$github = package$com.github || (package$com.github = {});
  var package$medavox = package$github.medavox || (package$github.medavox = {});
  Object.defineProperty(package$medavox, 'UiStrings', {get: UiStrings_getInstance});
  var package$ipa_transcribers = package$medavox.ipa_transcribers || (package$medavox.ipa_transcribers = {});
  package$ipa_transcribers.BaseRules = BaseRules;
  Object.defineProperty(CompletionStatus, 'UNSTARTED', {get: CompletionStatus$UNSTARTED_getInstance});
  Object.defineProperty(CompletionStatus, 'INCOMPLETE', {get: CompletionStatus$INCOMPLETE_getInstance});
  Object.defineProperty(CompletionStatus, 'IN_PROGRESS', {get: CompletionStatus$IN_PROGRESS_getInstance});
  Object.defineProperty(CompletionStatus, 'SURFACE_LEVEL_COMPLETE', {get: CompletionStatus$SURFACE_LEVEL_COMPLETE_getInstance});
  Object.defineProperty(CompletionStatus, 'COMPLETE_PARTIAL', {get: CompletionStatus$COMPLETE_PARTIAL_getInstance});
  Object.defineProperty(CompletionStatus, 'COMPLETE', {get: CompletionStatus$COMPLETE_getInstance});
  package$ipa_transcribers.CompletionStatus = CompletionStatus;
  Object.defineProperty(Language, 'ARABIC', {get: Language$ARABIC_getInstance});
  Object.defineProperty(Language, 'BENGALI', {get: Language$BENGALI_getInstance});
  Object.defineProperty(Language, 'CHINESE_BOPOMOFO', {get: Language$CHINESE_BOPOMOFO_getInstance});
  Object.defineProperty(Language, 'CHINESE_PINYIN', {get: Language$CHINESE_PINYIN_getInstance});
  Object.defineProperty(Language, 'ENGLISH', {get: Language$ENGLISH_getInstance});
  Object.defineProperty(Language, 'FILIPINO_TAGALOG', {get: Language$FILIPINO_TAGALOG_getInstance});
  Object.defineProperty(Language, 'FRENCH', {get: Language$FRENCH_getInstance});
  Object.defineProperty(Language, 'GERMAN', {get: Language$GERMAN_getInstance});
  Object.defineProperty(Language, 'GUJARATI', {get: Language$GUJARATI_getInstance});
  Object.defineProperty(Language, 'HAUSA', {get: Language$HAUSA_getInstance});
  Object.defineProperty(Language, 'HINDI', {get: Language$HINDI_getInstance});
  Object.defineProperty(Language, 'INDONESIAN_MALAY', {get: Language$INDONESIAN_MALAY_getInstance});
  Object.defineProperty(Language, 'ITALIAN', {get: Language$ITALIAN_getInstance});
  Object.defineProperty(Language, 'JAPANESE_LIMITED', {get: Language$JAPANESE_LIMITED_getInstance});
  Object.defineProperty(Language, 'KOREAN', {get: Language$KOREAN_getInstance});
  Object.defineProperty(Language, 'MALAY', {get: Language$MALAY_getInstance});
  Object.defineProperty(Language, 'MARATHI', {get: Language$MARATHI_getInstance});
  Object.defineProperty(Language, 'PERSIAN', {get: Language$PERSIAN_getInstance});
  Object.defineProperty(Language, 'PORTUGUESE_BRAZILIAN', {get: Language$PORTUGUESE_BRAZILIAN_getInstance});
  Object.defineProperty(Language, 'PORTUGUESE_EUROPEAN', {get: Language$PORTUGUESE_EUROPEAN_getInstance});
  Object.defineProperty(Language, 'PUNJABI_GURMUKHI', {get: Language$PUNJABI_GURMUKHI_getInstance});
  Object.defineProperty(Language, 'PUNJABI_SHAHMUKHI', {get: Language$PUNJABI_SHAHMUKHI_getInstance});
  Object.defineProperty(Language, 'RUSSIAN', {get: Language$RUSSIAN_getInstance});
  Object.defineProperty(Language, 'SPANISH_AMERICAN', {get: Language$SPANISH_AMERICAN_getInstance});
  Object.defineProperty(Language, 'SPANISH_EUROPEAN', {get: Language$SPANISH_EUROPEAN_getInstance});
  Object.defineProperty(Language, 'SWAHILI', {get: Language$SWAHILI_getInstance});
  Object.defineProperty(Language, 'TAMIL', {get: Language$TAMIL_getInstance});
  Object.defineProperty(Language, 'TELUGU', {get: Language$TELUGU_getInstance});
  Object.defineProperty(Language, 'THAI', {get: Language$THAI_getInstance});
  Object.defineProperty(Language, 'TURKISH', {get: Language$TURKISH_getInstance});
  Object.defineProperty(Language, 'URDU', {get: Language$URDU_getInstance});
  Object.defineProperty(Language, 'VIETNAMESE', {get: Language$VIETNAMESE_getInstance});
  package$ipa_transcribers.Language = Language;
  package$ipa_transcribers.IRule = IRule;
  package$ipa_transcribers.Rule_init_18t77l$ = Rule_init;
  package$ipa_transcribers.Rule = Rule;
  package$ipa_transcribers.EverythingRule = EverythingRule;
  package$ipa_transcribers.RevisingRule_init_1zodlv$ = RevisingRule_init;
  package$ipa_transcribers.RevisingRule = RevisingRule;
  package$ipa_transcribers.CapturingRule = CapturingRule;
  package$ipa_transcribers.LookbackRule_init_c13jh$ = LookbackRule_init;
  package$ipa_transcribers.LookbackRule = LookbackRule;
  RuleBasedTranscriber.UnmatchedOutput_init_puj7f4$ = RuleBasedTranscriber$RuleBasedTranscriber$UnmatchedOutput_init;
  RuleBasedTranscriber.UnmatchedOutput = RuleBasedTranscriber$UnmatchedOutput;
  package$ipa_transcribers.RuleBasedTranscriber = RuleBasedTranscriber;
  package$ipa_transcribers.Transcriber = Transcriber;
  var package$arabic = package$ipa_transcribers.arabic || (package$ipa_transcribers.arabic = {});
  Object.defineProperty(package$arabic, 'Arabic', {get: Arabic_getInstance});
  Object.defineProperty(package$arabic, 'Persian', {get: Persian_getInstance});
  Object.defineProperty(package$arabic, 'PunjabiShahmukhi', {get: PunjabiShahmukhi_getInstance});
  Object.defineProperty(package$arabic, 'Urdu', {get: Urdu_getInstance});
  var package$brahmic = package$ipa_transcribers.brahmic || (package$ipa_transcribers.brahmic = {});
  Object.defineProperty(package$brahmic, 'Bengali', {get: Bengali_getInstance});
  Object.defineProperty(package$brahmic, 'DevanagariBaseRules', {get: DevanagariBaseRules_getInstance});
  Object.defineProperty(package$brahmic, 'Gujarati', {get: Gujarati_getInstance});
  Object.defineProperty(package$brahmic, 'Hindi', {get: Hindi_getInstance});
  Object.defineProperty(package$brahmic, 'Marathi', {get: Marathi_getInstance});
  Object.defineProperty(package$brahmic, 'PunjabiGurmukhi', {get: PunjabiGurmukhi_getInstance});
  Object.defineProperty(package$brahmic, 'Tamil', {get: Tamil_getInstance});
  Object.defineProperty(package$brahmic, 'Telugu', {get: Telugu_getInstance});
  var package$latin = package$ipa_transcribers.latin || (package$ipa_transcribers.latin = {});
  Object.defineProperty(package$latin, 'ChinesePinyin', {get: ChinesePinyin_getInstance});
  Object.defineProperty(package$latin, 'English', {get: English_getInstance});
  Object.defineProperty(package$latin, 'FilipinoTagalog', {get: FilipinoTagalog_getInstance});
  Object.defineProperty(package$latin, 'French', {get: French_getInstance});
  Object.defineProperty(package$latin, 'German', {get: German_getInstance});
  Object.defineProperty(package$latin, 'Hausa', {get: Hausa_getInstance});
  Object.defineProperty(package$latin, 'IndonesianMalay', {get: IndonesianMalay_getInstance});
  Object.defineProperty(package$latin, 'Italian', {get: Italian_getInstance});
  Object.defineProperty(package$latin, 'LatinScriptCommonalities', {get: LatinScriptCommonalities_getInstance});
  Object.defineProperty(package$latin, 'PortugueseBrazilian', {get: PortugueseBrazilian_getInstance});
  Object.defineProperty(package$latin, 'PortugueseEuropean', {get: PortugueseEuropean_getInstance});
  Object.defineProperty(package$latin, 'SpanishPanAmerican', {get: SpanishPanAmerican_getInstance});
  Object.defineProperty(package$latin, 'SpanishPeninsular', {get: SpanishPeninsular_getInstance});
  Object.defineProperty(package$latin, 'Swahili', {get: Swahili_getInstance});
  Object.defineProperty(package$latin, 'Turkish', {get: Turkish_getInstance});
  Object.defineProperty(package$latin, 'Vietnamese', {get: Vietnamese_getInstance});
  var package$other = package$ipa_transcribers.other || (package$ipa_transcribers.other = {});
  Object.defineProperty(package$other, 'ChineseBopomofoZhuyin', {get: ChineseBopomofoZhuyin_getInstance});
  Object.defineProperty(package$other, 'JapaneseOnlyKatakanaHiragana', {get: JapaneseOnlyKatakanaHiragana_getInstance});
  Object.defineProperty(package$other, 'KoreanHangeul', {get: KoreanHangeul_getInstance});
  Object.defineProperty(package$other, 'RussianCyrillic', {get: RussianCyrillic_getInstance});
  Object.defineProperty(package$other, 'Thai', {get: Thai_getInstance});
  package$ipa_transcribers.main = main;
  Object.defineProperty(package$medavox, 'err', {get: err_getInstance});
  package$medavox.get_unicodeName_s8ev3n$ = get_unicodeName;
  package$medavox.normaliseNfd_pdl1vz$ = normaliseNfd;
  Object.defineProperty(RuleBasedTranscriber.prototype, 'westernPunctuation', Object.getOwnPropertyDescriptor(BaseRules.prototype, 'westernPunctuation'));
  Object.defineProperty(RuleBasedTranscriber.prototype, 'comprehensiveArabic', Object.getOwnPropertyDescriptor(BaseRules.prototype, 'comprehensiveArabic'));
  Object.defineProperty(main$ObjectLiteral.prototype, 'westernPunctuation', Object.getOwnPropertyDescriptor(BaseRules.prototype, 'westernPunctuation'));
  Object.defineProperty(main$ObjectLiteral.prototype, 'comprehensiveArabic', Object.getOwnPropertyDescriptor(BaseRules.prototype, 'comprehensiveArabic'));
  main();
  return _;
}));

//# sourceMappingURL=IPA-transcribers.js.map
