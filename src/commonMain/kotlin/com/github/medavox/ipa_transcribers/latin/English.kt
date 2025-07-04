/*
IPA Transcribers
Copyright (C) 2018 - 2025  Adam Howard

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.medavox.ipa_transcribers.latin

import com.github.medavox.ipa_transcribers.*
import com.github.medavox.ipa_transcribers.latin.English.Vowels.*
import com.github.medavox.ipa_transcribers.latin.LatinScriptCommonalities.latinBaseRules

/**I'm not hopeful that this will work well enough to use,
 * but Mark Rosenfelder seems fairly confident that he's compiled a list of English spelling rules
 * which get it right ~85% of the time.
 *
 * So here goes.
 * Based on [work by Mark Rosenfelder](http://zompist.com/spell.html)
 * See also more formal work by Edward Carney*/

//fixme: examples with BUGS:
// cloud = kloʌd
// thanks to jan Misali
object English:RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS
    //todo:english: download Mellon Carnegie Uni pronouncing dictionary, check it has the 1000 most common english words
//fallback system: try MCU (which includes exceptions), then try composable morphemes, then mark rosenfelder's rules
    //mark rosenfelder's transcription system:
    /*
    Consonants
    ----------
IPA 	Phoneme 	Samples
θ 	 + 	 thin
ð 	 + 	 this  NOTE: was originally underlined in HTML. Check original page for the rules involving this
ʃ 	 $ 	 shack
ʒ 	 $ 	 measure NOTE: was also originally underlined in the HTML version.
dʒ 	 j 	 judge


    Vowels
    ------
IPA 	Phoneme 	Samples
 e 	 ä 	 rate
 æ 	 â 	 rat
 o 	 ö 	 note, sow
 ɒ 	 ô 	 not, clock
 ju 	 ü 	 cute, you

 u 	 u 	 coot
 ɔ 	 ò 	 caught, dog
 ʊ 	 ù 	 cook, put

 aw 	 ôw 	 crowd, loud
 oj 	 öy 	 boy, droid

 j 	 y 	 you, million
 w 	 w 	 wait, cow

 ɚ 	 ər 	 search, manor, bird
 n̩ 	 ən 	 button, happen
 l̩ 	 əl 	 battle, final
 */

    //rules still to do:
    /*

Simplification of stl

13. The t in stl is lost before a final vowel: bustle = bʌsəl", bristly = brɪsli.

This could perhaps be generalized; but in slow speech I leave the t in (say) coastline or Christlike.
I'm also tempted to generalize to all stops, but the only instance in the sample lexicon is muscle,
and it's pretty silly to have a rule that applies to a single word.

(Af)frication before <i>
-----------------------

15. tu becomes tʃu before a vowel, or before a liquid (r, l) followed by a vowel: mutual = mütʃuəl, mature = mətʃur.

16. s becomes ʃ (or ʒ if it's preceded by a vowel):

    before o-- passion = paʃən, vision = vɪʒən". Note that the i is lost.
    before ur-- assure = əʃur; leisure = liʒər.
    after k and before a vowel: sexual = sɛkʃuəl.

At some point English affricated a number of consonants before a i or y that preceded another vowel,
including the [y] sound that begins ü Sometimes the y has been lost since.
This process seems to be no longer productive-- compare costume, Casio. (Or is it? In quick speech I do say kôstʃùm.)

Voicing of s
----------

17. s is voiced between two vowels (amuse, design, prison), except after <a> (base, parasite).

It's easy to find exception to this rule: disagree, opposite, analysis--
there's even words where the rule applies only for verbs (abuse, house).
The rule as stated has more successes than failures,
and I haven't been able to find merely lexical rules that do much better.

A better rule might take the language of origin into account:
the voicing tends to occur in French and Latin words (resent, please, reason, miserable),
but not if they're from Greek (analysis, isoceles) or more exotic languages (papoose, Osaka).

The voicing of s is so almost predictable that there are orthographic conventions (borrowed from French) to indicate
that we really do want an s: double the s (cf. Moses vs. mosses), or use c instead (race vs. rase).
Annoyingly, there are a few cases of unexpectedly voiced ss (dessert, dissolve).

As a corollary of this rule, the American use of -ize for British -ise was unnecessary,
although of course it is more foolproof.

Softening of velars
------------------

Front vowels are i and e; note that y was changed to i by rule 12.
We owe these rules to a sound change, and not even our own-- it derives from the history of French.

The last two rules allow g to be used for two sounds:

    ga ge gi go gu can be written ga gue gui go gu
    ja je ji jo ju can be written gea ge gi geo geu.

The inserted e or u are orthographic only; they make sure rule 21 applies or doesn't apply, as desired.

In French, there's a parallel with c:

    ka ke ki ko ku can be written ca que qui co cu
    sa se si so su can be written cea ce ci ceo ceu (but it's more usual to write tʃa ce ci tʃo tʃu)

but it doesn't work so well in English, since our qu is still kw.
The inserted e is found in just a few words (e.g. placeable), due to compounding.

Exceptions, but general ones
---------------------------

28. o also becomes ɒ before f and another consonant (offer = ɒfər, soften = sɒfən).

29. wa is pronounced wô before a dental or alveolar consonant (t d n s +): want, wander, swan,
Rwanda, swat, wad, wasp, and as wò between w and (t)ʃ: wash, squash, watch = wɒʃ skwɒʃ wɒtʃ.

29a. u is pronounced u before l, or after a labial stop (pb) and before a sibilant (sʃtʃ):
adult, push, butch. (This doesn't apply if the u is long: mule.)

I don't think I ever noticed these generalizations till I started working out the rules for this page.
At least some of these, such as 29a, are sound changes from Shakespeare's time.

Rules such as 6, 18, 19, 27, 28, and 51 introduce ɒ,
a vowel which (as signalled by the odd diacritic in my transcription) doesn't fit well into English phonology.
The fact that a velar occurs in many of the rule conditions suggests that
it was originally an allophonic variant of /ô/ and /â/ in this environment --
compare dog, ought, long, walk with dot, out, lot, wad.
But it's now phonemic in GA, as can be seen in the minimum triad caught, cot, cat.
These rules would have to be modified (and some could be eliminated) in dialects that merge ò and ô.

For some speakers, rule 29a only applies after labials, so that pull and dull don't rhyme.

Add shortening; stir
--------

Some vowels that are orthographically long are pronounced short,
and frankly I haven't put my finger on the pattern.
In the file I did add this rule:

34. Shorten a vowel that precedes a simple, final CV syllable (and is not the first syllable in the word).

This handles words like anomaly, cinema, sanity, biology, century;
but it fails on other words, like patina, tuxedo, agora.
Obviously the shortened vowels are all unstressed;
but the idea here is to predict pronunciations from the spelling,
and the spelling doesn't indicate the stress.

(We've already removed silent e, so this rule isn't triggered by words like phoneme.)

Somewhere I read that long vowels can't occur earlier than the antepenult;
but obvious counterexamples are isolating or unification. I'll see if I can improve the generalization, however.

Vowel digraphs
--------------

Besides the long/short trick, English expands its repertoire of vowel representations with digraphs.
Quite a few of these are redundant, and there are lots of exceptions--
this, and not ch or ough, is the real weak point of English spelling.

36. Exceptions to the following rule:

    Final ow is pronounced əʊ: slow, rainbow, overthrow.
    oo is pronuonced ʊ before a k: book, crook, look.
    ei is pronuonced i after s: perceive, ceiling, seize.
    ie is pronounced aj finally: dye, necktie.
    oul becomes ʊ before a final d.

 e 	 ä 	 rate
 æ 	 â 	 rat
 əʊ 	 ö 	 note, sow
 ɒ 	 ô 	 not, clock
 ju 	 ü 	 cute, you

 u 	 u 	 coot
 ɔ 	 ò 	 caught, dog
 ʊ 	 ù 	 cook, put

 aw 	 aʊ 	 crowd, loud
 oj 	 öy 	 boy, droid

37. Make the following substitutions:
 eau     əʊ this seems wrong: beauty, beautiful
 ai 	 ä
 au, aw 	 ɔ
 ea 	 i
 ei 	 eɪ
 eo 	 iə
 eu, ew, 	 ju
 ie 	 i
 iV 	 iə
 oa 	 əʊ
 oe 	 ö
 ou, ow 	 aʊ
 oi 	 oj
 ua 	 üə
 ui 	 u

Again, the program is not smart enough to recognize when the digraph spans a morpheme boundary,
and thus should be treated as two separate vowels: goer = gəʊər, coaxial = kəʊæksiəl.

Annoyingly, some of these digraphs have at least two values:
cf. wool, fool; mead, dread; fief, friend; reign, seize; ground, group.
The values in the table are those that occur most often.
(The alternatives are generally just a step or two apart phonetically, e.g. u/ʊ, i/ɛ, e/i.)

For ease of exposition I've put the final ie rule here, but it really goes before rule 14 (affrication);
otherwise terrible things happen to words like untie.

Those pesky final syllabics
--------------------------

39. Any short vowel reduces to ə before a final n: human, frighten, cabin, button.

These rules don't apply to monosyllables (pal, can),
nor to vowels that have already been assigned a particular value by an earlier rule (e.g. meal to mil by rule 37).

These rules could probably be refined; they don't apply to stressed finals, but again,
the orthography doesn't indicate stress.

You can take əl as a phonemic representation, or add a rule at the end to replace it with vocalic l. Ditto for ən.
Suffix simplifications

40. The following suffixes are reduced as follows:
 -able, -ible      	 əbəl
 -lion 	 lyən
 -nion 	 nyən

Again, we really shouldn't have 'rules' for single lexical entries.
But these suffixes are common, so the rule has a large yield.
Unpronounceable finals

41. A final b or n is not pronounced if preceded by an m: damn bomb = dam bɒm.
Final vowel coloration


Vowels before r
-------------

<r> is hell on English vowels; it tends to color the vowels, and in many dialects, disappear.
In GA there are 12 monophthongal vowels, but only 6 can appear before <r> -- ä i ô ö ò u-- plus ər,
which is really just a prolonged vocalic r.

43. An ôw, ô, or ò resulting from the previous rules changes to ɔ before an r: course = kɔrs, for = fɔr.

44. war is pronounced wɔr, except before a vowel: warlock, war, dwarf = wɔrlɑk, wɔr, dwɔrf;
and wor is pronounced wər: word, worst, worry.

45. ɛ or â before a double r (and ɛ before ri) become ä: terror, marry, merit = tɛrər, mari, mɛrɪt.

46. â before any other r becomes ô: mark, star = môrk, stôr.

47. ɛ, ɪ, ʌ before r are reduced to schwa: perk, fir, fur = pərk, fər, fər.

Thanks to the infamous rule 45, I pronounce Mary, merry, marry the same. If you left this rule out,
it would probably correctly predict the pronunciation of Easterners and Britons who distinguish them.

The velar nasal ng
-----------

The careful reader may wonder why ng was not handled earlier, with the other consonantal digraphs.
The reason is that orthographically, it acts as a double consonant-- e.g. singer has a short not a long i.
But now it's time to handle it.

48. ng becomes ŋg before a liquid (r, l) or semivowel (y, w):
angry, England, singular, anguish = äŋgri, ɪŋglând, sɪŋgjulər, aŋgwɪʃ.

49. ng becomes ŋ finally, or before another consonant: hung = hʌng, length = lɛŋθ.

50. n becomes ŋ before a velar stop (k, g): anger = aŋgər, think = θɪŋk.

51. ô becomes ò, and â becomes ä before ŋ: song = sɒŋ; hang = haŋ.

Note that rule 50 doesn't apply to words like hung, because rule 49 already removed the g in those words.

50 is arguably merely allophonic, but since it's completely consistent I treated it as a spelling rule.
You could certainly say that a word like ungrateful 'really' has an underlying /ng/,
because it's composed of <un> plus grateful;
then this, as in most languages, will get pronounced ŋg.
But if you go that route, you can't actually show that English allows /ŋg/ as well as /ng/--
how do we know that wrong isn't actually /rɒng/, modified by the allophonic rule?
The important thing is not to pretend that we have a contrast of /ng/ and /ŋg/.

Voicing of s
-----------

52. s is voiced finally, after a voiced oral stop: dogs = dɒgz.

53. It's also voiced before final m: prism = prɪzm.

The first of these rules is really morphophonemic: the plural, possessive, and 3p singular inflections of English are spelled s even when, by assimilation, they're pronounced z. This rule is not phonological, as can be seen by a word like chance = tʃâns; compare fans = fânz.

Double consonants
----------------

54. A double consonant is pronounced singly: dinner, buzzard, hassle = dɪnər, bʌzərd, hasəl.

55. A t disappears before tʃ, and a d before j: batch = batʃ, judge = dʒʌdʒ.

56. An s disappears before ʃ: pressure = prɛʃər.

Rule 56 goes with rule 16, which changed s to $ before some instances of u. */

    val vowelShorteningConsonantPairs:String = "(bb|ck|dd|dg|ff|gg|ll|mm|ng|nn|pp|rr|ss|tt|tch|zz)"

    /**Stolen from German!
     * (who knew that English could use the spelling rules of its closest included relative?)

    Short and long vowels
    --------------------

    English has a dozen or so vowel phonemes,
    and this silly alphabet we inherited from the Romans has just five vowel symbols
    (y is sometimes used as a vowel, but as we've seen, it pointlessly duplicates i).
    The five symbols can represent ten sounds, thanks to these rules.

    Each vowel letter has two basic interpretations, which by convention are called long and short.
    (Phonetically they're not distinguished by length; tense and lax would be more accurate.
    But I think the more familiar terms will be more readable,
    and remind readers that their old English teachers were onto something after all.)

    The above rules work in conjunction with rule 54,
    which means that doubling a consonant changes a medial vowel from long to short:
    later/latter, Peter/petter, biter/bitter, hoping/hopping, cuter/cutter.
     * */
    private enum class Vowels(val short:String, val long:String) {
        A("a", "eɪ"),
        E("ɛ", "iː"),
        I("ɪ", "aɪ"),
        O("ɒ", "əʊ"),
        U("ʌ", "ju");

        companion object {
            fun from(vowel: String): Vowels = when (vowel) {
                "a" -> A
                "e" -> E
                "i" -> I
                "o" -> O
                "u" -> U
                else -> throw IllegalArgumentException(
                    "only the following Strings of length 1 are valid input to this method:" +
                            "aeiouäöü"
                )
            }
        }
    }
    const val vowels = "aeiou"
    const val consonants = "bcdfghjklmnpqrstvwxz"
    const val longI = "aɪ"
    //const val longO = "oʊ"//might not actually be what he means by long o
    val rules:List<IRule> = listOf(
        //1. Make the following unconditional replacements:
        Rule("t?ch", "tʃ"),
        Rule("sc?h", "ʃ"),
        Rule("th", "θ"),
        Rule("qu", "kw"),
        Rule("wr", "r"),
        //Before an o, replace wh with h instead: who, whore, whole.
        Rule("who", "h", 2),
        Rule("wh", "w"),
        //2. Replace x with ks; but after e and before another vowel, use gz instead.
        // (This is not an allophonic rule: compare the near-minimal pair exist and excite.)
        LookbackRule("e", "xh[$vowels]", "gz", 2),
        Rule("xh", "ks"),
        LookbackRule("e", "x[$vowels]", "gz", 1),
        Rule("x", "ks"),

        Rule("rh", "r"),

        //The notorious gh
        //4. Before a vowel, gh becomes g: ghost = göst.
        Rule("gh[$vowels]", "g", 2),
        //5. gh turns a preceding single vowel long: right = rajt.
        //[my note: i don't think <aght>, <eght>, <oght> or <ught> occur naturally in english, so this can just be for i ]
        Rule("igh", I.long),
        //6. aught and ought become òt: daughter = dòtər, sought = sòt.
        Rule("aught", "ɔt"),
        Rule("ought", "ɔt"),
        //7. Any other ough becomes ö: dough = dö.
        //[note: Americans and their blind-spots for ough!]
        Rule("rough", "rʌf"),
        Rule(" cough", " kɒf"),
        Rule(" through ", " θru "),
        Rule("ough", "oʊ"),
        //8. Elsewhere, gh is simply dropped: freight = frät.
        Rule("gh", ""),

        //9. In initial gn, kn, mn, pt, ps, tm, pronounce the second letter only: gnostic = nôstɪk, psycho = sajkö, knight = najt.
        LookbackRule("( |^)", "gn", "n"),
        LookbackRule("( |^)", "kn", "n"),
        LookbackRule("( |^)", "mn", "n"),
        LookbackRule("( |^)", "pt", "t"),
        LookbackRule("( |^)", "tm", "m"),


        // 10. Replace y with aj if it ends a one-syllable word: ply = plaj.
        LookbackRule("(^|\\s)[^$vowels]+", "y(\\s|$)", "aɪ", 1),

        //11. ey is pronounced i;
        Rule("ey", "i"),
        // ay is ä;
        Rule("ay", "eɪ"),
        // and oy is öy: say, monkey boy = se mʌnki bɔɪ.
        Rule("oy", "ɔɪ"),

        //12. Replace y with i if it's not adjacent to a vowel-- we'll worry later about how to pronounce the i.
        //Thus, system = sɪstəm but you, where the y adjoins a vowel, is yu.
        Rule("y[^$vowels]", "ɪ", 1),
        Rule("y[$vowels]", "j", 1),

        //14. ci or ti becomes ʃ before a vowel: gracious = greɪʃəs, nation = neɪʃən.
        Rule(Regex("(ti|ci)[$vowels]"), "ʃ", 2),

        //18. al is pronounced òl before r, s, m, a dental stop, or final ll: also, already, wall, bald, although, almost.
        Rule(Regex("al([lrsmtd]|th)"), "ɔɫ", 2),

        //19. alk becomes òk, except initially: walk = wòk.
        LookbackRule("[^\\s]", "alk", "ɔk"),

        //20. c becomes s before a front vowel, k elsewhere: cell = sɛl, acid = âsɪd,
        // but cow = kôw, backer = bâkər, clear = klir.
        Rule("c[iey]", "s", 1),
        Rule("c", "k"),

        //22. If the g doesn't begin the word, and the triggering e precedes o or a, the e is lost:
        // changeable = tʃeɪndʒəbəl; dungeon = dʌndʒən (but geology = dʒiɒlədʒi).
        Rule("ge[oa]", "dʒ", 2),
        //21. g becomes j before a front vowel, g elsewhere: gel = dʒɛl, turgid = tərdʒɪd, but got = gôt, twig = twɪg, gleam = glim.
        Rule("g[iey]", "dʒ", 1),
        Rule("g", "g"),
        //23. Initial gu or final gue is pronounced g: guest = gɛst, plague = pläg.
        LookbackRule("(^$|\\s)", "gu", "g"),
        Rule("gue\\b", "g"),
        // (Medially, it tends to be gw instead: language, anguish.)
        Rule("gu", "gw"),

        //27. Final ind is ajnd
        Rule("ind\\b", "ajnd"),

        //31. The g is simply lost in eign: feign = feɪn.
        Rule("eig[nm][^$vowels]", A.long, 3),
        //30. Except before a vowel, the vowel in ign or igm lengthens,
        //and the g is lost: alignment paradigm = əlajnmənt, parədajm, but igneous = ɪgniəs.
        Rule("ig[nm][^$vowels]", I.long, 2),

        //24. le and re (after a consonant, and ending the word) should be rewritten əl, ər.
        //To be precise, they become syllabic consonants: the final sound in bottle is a prolonged dark l.
        //I think this is an allophonic detail, however:
        // if you like, just add a rule at the end to turn all instances of ər into syllabic r.
        LookbackRule("[$consonants]", "le\\b", "əɫ", 2),
        LookbackRule("[$consonants]", "re\\b", "ər", 2),

        //these are the two most important rules of English spelling.
        //25. Vowels are pronounced long before an intervocalic consonant
        // (rate, mete, fine, rote, cute = rät mit fajn röt küt).
        //26. They're short before two consonants (baffle, held, children, rotten, butler),
        //or before a final consonant (pat, pet, pit, pot, but = pât pɛt pɪt pôt bʌt).
        Rule(Regex("a[$consonants][$vowels]"), A.long, 1),
        Rule(Regex("e[$consonants][$vowels]"), E.long, 1),
        Rule(Regex("i[$consonants][$vowels]"), I.long, 1),
        Rule(Regex("o[$consonants][$vowels]"), O.long, 1),
        Rule(Regex("u[$consonants][$vowels]"), U.long, 1),


        //Rule 54 works hand in hand with rule 25:
        // a consonant is doubled to show that the preceding vowel is short: redder = rɛdər
        //(compare red, where the d doesn't need to be doubled because a vowel preceding a final
        // consonant is already short).

        //Rule 55 is something of a corollary: to 'double' tʃ, we write tch rather than chch;
        //and to double a /dʒ/, we write dg rather than jj or gg.
        Rule(Regex("a$vowelShorteningConsonantPairs"),  A.short, 1),
        Rule(Regex("a[$consonants]\\b"), A.short, 1),

        Rule(Regex("e$vowelShorteningConsonantPairs"), E.short, 1),
        Rule(Regex("e[$consonants]\\b"), E.short, 1),

        Rule(Regex("i$vowelShorteningConsonantPairs"), I.short, 1),
        Rule(Regex("i[$consonants]\\b"), I.short, 1),

        Rule(Regex("o$vowelShorteningConsonantPairs"), O.short, 1),
        Rule(Regex("o[$consonants]\\b"), O.short, 1),

        Rule(Regex("u$vowelShorteningConsonantPairs"), U.short, 1),
        Rule(Regex("u[$consonants]\\b"), U.short, 1),

        Rule("ee", E.long),
        Rule("oo", O.long),

        //32. Except before a vowel, ous reduces to əs: jealous = jɛləs.
        //Note the importance of order: this rule has to be ordered before silent e deletion,
        // or it will apply to words like arouse.
        Rule("ous[^e]", "əs"),

        //33. Remove final e: rate mike cute = rät majk küt (unless it's the only vowel in the word, as in he).
        LookbackRule("[$vowels][$consonants]{1,2}", "e", ""),
        //This and rules 25 and 26 (on long and short vowels) are the guts of the English spelling system. They allow the five vowel symbols to represent ten vowel phonemes.

        //English orthography tends to preserve the spelling of morphemes in derived words, including their final e.
        // The program is too stupid to handle this, since it has no way of recognizing compounds.
        // But of course in words like
        // safety, lovely, changeable, careful, warehouse, jukebox, placement, placeholder
        // the e in the first morpheme should be deleted by this rule.

        //42. Pronounce any remaining final vowel as follows:
        // -a      	 ə
        // -i 	 i
        // -o 	 əʊ
        // -u 	 u
        //
        //A final vowel is usually the mark of a foreign word,
        //which is why final vowels tend to have the 'continental' values: sushi, cello, haiku.
        //Earlier borrowings were nativized, meaning that final vowels had to be written as diphthongs (e.g. Munsee, Hindoo).
        //
        //Since final -e is already in use, we used to mark one that was supposed to be pronounced (Chloi = kləʊi),
        //or, if we were borrowing from French, we retained the accent (café = kafe).
        //But English seems to be so allergic to diacritics that these helpful conventions have largely been lost.
        Rule(Regex("a\\b"), A.long, 1),
        Rule(Regex("e\\b"), E.long, 1),//this will probably never apply, due to #33
        Rule(Regex("i\\b"), I.long, 1),
        Rule(Regex("o\\b"), O.long, 1),
        Rule(Regex("u\\b"), U.long, 1),


        //35. <i> before another vowel becomes ajə [ajə] in the initial syllable: bias, diagram = bajəs, dajəgrâm.
        LookbackRule("(^|\\s)[^$vowels]+","[iy][$vowels]", "ajə"),

        //38. Any vowel reduces to ə before final l: battle, final, hovel, evil, symbol.
        Rule("[$vowels]l", "əɫ"),

        //3. Ignore apostrophes (can't, cop's, o'clock).
        Rule("'", ""),

        // Hyphens can however be treated as word separators (mother-in-law is pronounced like mother in law).
        Rule("-", " "),
        Rule("", "")
    )+latinBaseRules+westernPunctuation
    override fun transcribe(nativeText: String): String {
        return nativeText.toLowerCase().processWithRules(rules, reportAndCopy)
    }
}