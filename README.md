# IPA Transcribers

A collection of transcribers (strictly speaking, transliterators) 
which convert text in a language's native orthography into the International Phonetic Alphabet.

This library uses a replacement-rule based approach, 
which is capable of transcribing most orthographical information present in a language's writing system.

Some languages are partially or completely incompatible with this approach; [details are 
below](#depth).

## How To Install

First, add the jitpack repository if you haven't already:

`gradle`
``` gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

`maven`
``` xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then add this library to your project:

`gradle`
``` gradle
dependencies {
    implementation 'com.github.medavox:IPA-Transcribers:v0.1'
}
```

`maven`
``` xml
<dependency>
    <groupId>com.github.medavox</groupId>
    <artifactId>IPA-Transcribers</artifactId>
    <version>v0.1</version>
</dependency>
```

## Language Support

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


**"Probably"**: this language uses the latin alphabet (which means it probably can be transliterated),
but has used it for a long time (say, at least 1000 years),
so may be too irregular for rule-based -- further research is required.

**"Partially"**: this language uses the Arabic script, which only records some vowels. 
There isn't enough information present in the orthography to make a complete transcription of all the phonemes,
without resorting to lookup-tables, and/or a context-sensitive approach.

for information on the completion status for each language, look in the `project boards` section of this repo's GitHub page.


## This Project Actively Welcomes Pull Requests

If:-

* you have insight into *how* a system works in a particular language's orthography,
* you want to add support for a language I've not included here,
* or if you spot a mistake in the IPA output,

please do one of the following (Most preferred first):

1. Submit a pull request with the relevant work implemented (*provide code*)
2. Open an issue, describing *how* a language feature works (*provide language-specific knowledge*),
3. Tell me that for input *x*, output *y* is wrong and should instead be *z* (*provide correct example(s)*)
4. Request a feature and I will record your interest. Given enough interest, I *may* still try to implement other languages or features.
 
As of writing this (March 2019), I'm still working on implementing the basic rule-based transcribers
for all the eligible languages I'll be covering.

Please bear in mind that this project is a massive undertaking for one person;
It isn't possible for me (or arguably, any one person) 
to have sufficient knowledge of *every* language here to cover it perfectly.

As a result, without external help from **users like you**:

* the transcriptions will remain quite "broad",
* syllable stress will not be transcribed
* and any other syllable-level pronunciation systems won't be covered.

## Limitations

### <a name="depth"> Languages with High Orthographic Depth (Spelling doesn't convey pronunciation)</a>

The orthography of some languages contains little or no information about its intended pronunciation.

This is called [Orthographic Depth](https://en.wikipedia.org/wiki/Orthographic_depth).
Languages with high orthographic depth cannot be transliterated (or fully transliterated) in a purely rule-based way,
using only the native orthography. 

Examples of prominent languages with high orthographic depth are

* Chinese (whose writing system is a modified ideography, 
  containing little to no pronunciation information beyond rhyming hints), 
* Arabic (whose writing system doesn't normally record short vowels), and
* Japanese (it's complicated, but in short the roots of words in normal text are written down with modified versions of Chinese characters called Kanji)

I have withheld web-scraper-based transliterators for languages like these.

That work to transliterate those languages is not mine,
and as such it would be wrong for me to provide a means for placing an undue burden on these public online services.

(If these online transliterators were run by some huge tech corporation I might feel differently, but they're not.)

### Syllable and Stress-Level Systems

* Neither syllable nor stress information has been transcribed in the rule-based transcribers,
  due to the higher difficulty of writing syllabifiers.
   - syllabification rules (what constitutes a syllable, and where syllable boundaries lie) vary across languages,
     and are often complex.
  - Syllabification is not impossible however, and may be attempted later.
* [Vowel reduction](https://en.wikipedia.org/wiki/Vowel_reduction), such as in
  [English](https://en.wikipedia.org/wiki/Stress_and_vowel_reduction_in_English) 
  and [Russian](https://en.wikipedia.org/wiki/Vowel_reduction_in_Russian) has accordingly been ignored.

## Why?

(AKA Motivation)

A few years ago, I began my own attempt at creating an 
[International Auxiliary Language](https://en.wikipedia.org/wiki/International_auxiliary_language).

One goal of the language was to maximise the verbal familiarity of each word to as many people as possible
(Orthographic familiarity is already a lost cause, due to the aforementioned different writing systems).

For instance, the word for 'bridge' in French is *ponte*, and in Italian is *puente*. 
There is also a more obscure English word 'pont', which is a type of ferry boat.
Although the definition is not related, it is related. 
So by choosing a word in my language for bridge that sounded similar (say, 'pont'),
I could reduce the difficulty in remembering the words of the language for more people.

In practice, there need to be comparisons between more languages than just French, Italian and English. 
I decided to compare words in the top 25<sup>[1](#numlangs)</sup> most widely spoken languages on the planet,
and prioritise that language based on its number of speakers (both L1 and L2).

Originally, I simply compared the spelling of each word to its equivalent in other languages, 
transliterating where necessary.

However, even between languages with Latin writing systems,
differences in the spelling system caused my text-only approach to miss words that were 
*spelled differently, but pronounced the same*.

So I created this software to allow direct, equivalent comparisons between languages --
regardless of orthography or spelling system used.

I'm sure, however, that this software can be put to other uses.

<a name="numlangs">1</a>: Cantonese and other Chinese languages that aren't Mandarin haven't been counted, 
             due to the lack of good resources for these languages on the English internet. Sorry!
             
## DISCLAIMER

Language and its use is a deeply personal experience, and has often been politicised.

I do not intend to make any judgment or create any offense with this software,
or to take any political stance whatsoever, towards or against any language or culture.

I have used the best information available to me at the time of writing,
in order to provide the best support possible for each language chosen,
given the large scope of this project.

If you take issue with any inaccuracies in this software,
please submit an issue or pull request, either detailing your grievances, or fixing the problem.
