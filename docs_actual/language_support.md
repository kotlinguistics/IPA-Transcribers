# Language Support

The languages I aim to support, their completion level and their eligibility for rule-based transcribers:

Language                | Eligible? | Completion
------------------------|------|------------
Arabic, Modern Standard | [^1] |      
Bengali                 | yes  | 
Chinese (Mandarin)      | no   | 
Chinese Bopomofo/Zhuyin | yes  | 
Chinese Pinyin          | yes  | 
English                 | [^2] | 
Filipino/Tagalog        | yes  | 
French                  | [^3] | 
German                  | [^3] | 
Gujarati                | yes  | 
Hausa                   | yes  | 
Hindi                   | yes  | 
Indonesian/Malay        | yes  | 
Italian                 | yes  | 
Japanese Kanji          | no   | 
Japanese Katakana       | yes  | 
Japanese Hiragana       | yes  | 
Javanese                | yes  | 
Korean                  | [^3] | 
Marathi                 | yes  | 
Persian/Dari/Farsi/Tajik| [^1] | 
Portuguese              | [^3] | 
Punjabi Gurmukhi        | yes  | 
Punjabi/Lahnda Shahmukhi| [^1] | 
Russian                 | [^4] | 
Spanish                 | yes  | 
Swahili                 | yes  | 
Tamil                   | yes  | 
Telugu                  | yes  | 
Thai                    | [^5] | 
Turkish                 | yes  | 
Urdu                    | [^1] | 
Vietnamese              | [^5] | 


[^1]: this language uses the Arabic script, which only records some vowels. 
There isn't enough information present in the orthography to make a complete transcription of all the phonemes,
without resorting to lookup-tables, and/or a context-sensitive approach.

[^2]: English is very irregular, and has many loanwords.

It has had many waves of significant foreign influence 
(and loanwords which preserve the native spelling to varying degrees) 
over the base West Germanic Language:

* Old Norse
* Latin
* Greek
* Norman French
* French

There are effectively multiple spelling systems used side-by-side, 
with no way of telling which one a word uses without further context or knowledge. 

Compare choir, chasm vs change, cheap.

[^3]: this language uses an alphabet (which means it probably can be transliterated),
but has used it for a long time (500+ years),
and has developed irregularities in that time, due to diachronic language change and other factors.
so may be too irregular for rule-based -- further research is required.

for information on the completion status for each language, look in the `project boards` section of this repo's GitHub page.


[^4]: Russian orthography records everything about the spoken language, except vowel reduction.

[^5]: technically yes, but as Thai's writing system is very old, it is reportedly very irregular
[^6]: Vietnamese uses two concurrent diacritic systems with the Latin: one for encoding tone,
and another for recording more different vowels than the standard 5 recorded by base Latin.
So yes, it's probably eligible for rule-based transliteration. But it may be difficult.