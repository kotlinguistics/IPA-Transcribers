# IPA Transcribers

A collection of transcribers (strictly speaking, transliterators) which convert text in a language's native orthography into the International Phonetic Alphabet.

Where possible, a rule-based approach has been taken. Otherwise, publically-available data and APIs have been used.
Note that the orthography of some languages bear little or no resemblance to their 

Also note that **stress information has not been transcribed** in the rule-based transcribers,
due to the far higher complexity of writing syllabifiers.

The languages I aim to support, and their eligibility for rule-based transcribers:

Language                | Rule-based eligible?
------------------------|------------
Mandarin Chinese        | no
English                 | maybe?
Hindi                   | yes
Spanish                 | yes
French                  | probably
Modern Standard Arabic  | partially
Russian                 | mostly - no vowel reduction
Bengali                 | yes
Japanese Kanji          | no
Japanese Katakana       | yes
Japanese Hiragana       | yes
Portuguese              | probably
Indonesian              | yes
Urdu                    | partially
German                  | probably
Punjabi Gurmukhi        | yes
Punjabi/Lahnda Shahmukhi| partially
Swahili                 | yes
Javanese                | yes
Telugu                  | yes
Turkish                 | yes
Korean                  | yes, mostly
Marathi                 | yes
Tamil                   | yes
Persian/Dari            | partially
Vietnamese              | signs point to no
Italian                 | probably

Probably means that it uses the latin alphabet (which means it probably can),
but has used it for a long time (around 1000 years), so may be too irregular for rule-based -- further research is required.

Partially means that this language uses the Arabic script, which only records some vowels. 
There isn't enough information present in the orthography to make a complete transcription of all the phonemes,
without resorting to lookup-tables and a context-sensitive approach.

for information on the completion status for each language, look in the `project boards` section of this repo's GitHub page.


## This Project Actively Welcomes Pull Requests

If:-

* you have insight into *how* a particular system in a language's orthography works,
* you want to add support for a language I've not included here,
* or if you spot a mistake in the IPA output,

please do one of the following (Most preferred first):

1. Submit a pull request with the relevant work implemented (provide code)
2. Open an issue, describing *how* a language feature works (provide the language-specific knowledge),
    - or just tell me that for input *x*, output *y* is wrong and should instead be *z*
3. request a feature and I will record your interest.
    - given enough interest, I may still try to implement other languages or features.
 
As of writing this (March 2019), I'm still working on implementing the basic rule-based transcribers for all the languages which
support such an approach.

Please bear in mind that this project is a massive undertaking for one person;
It isn't possible for me (or arguably, any one person) to have sufficiently specialised knowledge of every language here to cover it perfectly.

As a result, without external help from **users like you**:
* the transcriptions will remain quite broad,
* syllable stress will not be transcribed
* and any other syllable-level language systems won't be covered (such as vowel reduction).

## DISCLAIMERS

Language and its use is a deeply personal experience, and has often been politicised.

I do not intend to make any judgment or create any offense with this software,
or to take any political stance whatsoever, towards or against any language or culture.

I have used the best information available to me at the time of writing, 
in order to provide the best support possible for each language chosen,
given the large scope of this project.

If you take issue with any inaccuracies in this software,
please submit an issue or pull request, either detailing your grievances, or fixing the problem.
