# IPA Transcribers

A collection of transcribers (strictly speaking, transliterators) 
which convert text in a language's native orthography into the International Phonetic Alphabet.

This library uses a replacement-rule based approach, 
which is capable of transcribing most orthographical information present in a language's writing system.

Some languages are partially or completely incompatible with this approach; [details are 
below](#depth).

## How to use

You can use this repo in the following ways:

* The [online version](https://kotlinguistics.github.io/IPA-Transcribers)
* Desktop app
* local webpage
* as a library in your JVM/Android project

<details>
  <summary><b>As a local webpage</b></summary>

To build it:

```shell script
./gradlew jsBrowserWebpack
./update-site.sh # or manually copy the files specified in that script
```

then open `./docs/index.html` in your browser.

</details>

<details>
  <summary> <b>As a Java desktop app</b></summary>

to build it:

```shell script
./gradlew shadowJar
```

to run it:

```shell script
java -jar build/libs/IPA-transcribers-0.3-all.jar
```

</details>

<details>
  <summary><b>As a library in a Gradle/Maven project</b></summary>


First, add the jitpack repository to your repositories if you haven't already:

`gradle`
``` gradle
allprojects {
    repositories {
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
    implementation 'com.github.medavox:IPA-Transcribers:v0.3'
}
```

`maven`
``` xml
<dependency>
    <groupId>com.github.medavox</groupId>
    <artifactId>IPA-Transcribers</artifactId>
    <version>v0.3</version>
</dependency>
```
</details>

The bulk of this project lives in [this directory](./src/commonMain/kotlin/com/github/medavox/ipa_transcribers).

## Limitations

### <a name="depth"> Languages with High Orthographic Depth (Spelling doesn't convey pronunciation)</a>

The orthography of some languages contains little or no information about its intended pronunciation.

This is called [Orthographic Depth](https://en.wikipedia.org/wiki/Orthographic_depth).
Languages with high orthographic depth cannot be transliterated (or fully transliterated) in a purely rule-based way,
using only the native orthography.
They require familiarity with the language, writing system or culture to be pronounced correctly.

Examples of prominent languages with high orthographic depth are

* Chinese (whose primary writing system is a modified ideography, 
  containing very little pronunciation information), 
* Arabic (whose writing system doesn't normally record short vowels), and
* Japanese (it's complicated, but in short the roots of words in normal text are written down with
 modified versions of Chinese ideograms called Kanji,
 whose pronunciation comes from a 17th-century Japanese approximation of classical Chinese,
 and has only a very tenuous relation to the modern Chinese pronunciation)

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

## HELP WANTED

If:-

* you know how a particular language's writing system works,
* you want to add support for a language not included here,
* or if you spot a mistake in the IPA output,

please do one of the following (most preferred first):

1. Submit a pull request with the relevant work implemented (*provide code*)
    - This project supports code in either Java or Kotlin;
    - but you can also just pass me some Regex rules.
2. Open an issue, describing *how* a language feature works (*provide language-specific knowledge*)
    - regular rules are best, if they exist.
3. Mention that for input *x*, output *y* is wrong and should instead be *z* (*provide correct example(s)*)
    - I'll do my best to work this into an applicable rule.
4. Request a feature and I will record your interest.
    - Given enough interest, I *may* still try to implement other languages or features.
 
As of writing this (November 2019), I'm still working on implementing the basic rule-based transcribers
for all the eligible languages I'll be covering.

Please bear in mind that this project is a massive undertaking for one person;
It isn't possible for me (or arguably, any one person) 
to have sufficient knowledge of *every* language here to cover it perfectly.

As a result, without external help from **users like you**:

* the transcriptions will remain quite "broad",
* syllable stress will not be transcribed
* and any other syllable-level pronunciation systems won't be covered.

## Why?

(AKA Motivation)

A few years ago, I began my own attempt at creating an 
[International Auxiliary Language](https://en.wikipedia.org/wiki/International_auxiliary_language).

One goal of the language was to maximise the verbal familiarity of each word to as many people as possible
(Orthographic familiarity is already a lost cause, due to the aforementioned different writing systems).

For instance, the word for 'bridge' in French is *ponte*, and in Italian is *puente*. 
There is also a more obscure English word 'pont', which is a type of ferry boat.
Although the definition is not the same, it is related -- both are means of crossing water. 
So by choosing a word in my language for bridge that sounded similar (say, 'pont'),
I could reduce the difficulty in remembering the words of the language for more people.

In reality, there need to be comparisons between more languages than just French, Italian and English. 
I decided to compare words in the top 25<sup>[1](#numlangs)</sup> most widely spoken languages on the planet,
and prioritise that language based on its number of speakers (both L1 and L2).

Originally, I simply compared the spelling of each word to its equivalent in other languages, 
transliterating where necessary.

However, even between languages with Latin writing systems,
differences in the spelling system caused my text-only approach to miss words that were 
*spelled differently, but pronounced the same*.

So I created this software to allow more direct, accurate comparisons between languages --
regardless of orthography or spelling system used.

I'm sure, however, that this software can be put to other uses.

<a name="numlangs">1</a>: Cantonese and other Chinese languages that aren't Mandarin haven't been counted, 
             due to the lack of good resources for these languages on the English internet. Sorry!
             
## DISCLAIMER

Language and its use is an inherently personal experience, 
and has often been politicised as a result.

I do not intend to make any judgment or create any offense with this software,
or to take any political stance whatsoever, towards or against any language or culture.

I have used the best information available to me at the time of writing,
in order to provide the best support possible for each language chosen,
given the large scope of this project.

If you take issue with any inaccuracies in this software,
please submit an issue or pull request, either detailing your grievances, or fixing the problem.

### Grouping Rationale

This software is primarily designed around writing systems, not languages. 
However, the way that a language uses a writing system is often highly unique to that language, 
and tied to the language itself. 

For instance, every European language has its own spelling conventions; 
and every language using the Arabic script uses it slightly differently, 
to represent its own phonemic inventory.

Therefore, it makes sense to include the name of a language in a transcriber,
as it has been designed for that particular language's idiomatic use of that writing system.

I have grouped transcribers solely by writing system family,
not by any linguistic, political, historical or geographic considerations.

This means that in some cases, different writing systems for the same language 
(or closely-related languages, or different dialects of the same language, depending on your view)
have been included in different packages.

An example of this is Hindi and Urdu (collectively called Hindustani), 
which use the Devanagari and Arabic scripts respectively, but are mutually intelligible languages.
