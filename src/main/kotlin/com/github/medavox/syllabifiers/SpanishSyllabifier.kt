package com.github.medavox.syllabifiers

import java.util.*

class SpanishSyllabifier : Syllabifier {
    /**Makes consistent the representation of spanish accented letters.
     * That is, replaces letters with combined diacritic marks with single-character equivalents.*/
    private fun String.normalise():String {
        return this
            .toLowerCase()
            .replace(Regex("(ñ|̃n)"), "ñ")
            .replace(Regex("(á|́a)"), "á")
            .replace(Regex("(é|́e)"), "é")
            .replace(Regex("(í|́i)"), "í")
            .replace(Regex("(ó|́o)"), "ó")
            .replace(Regex("(ú|́u)"), "ú")
    }

    override fun syllabify(input: String): Array<Int> {
        return syllabifyPlainLanguage(input)
    }


    /*val String.syllableBoundaries:Array<IntRange> get() {
        enum class Syllable
        val word = toLowerCase()
        val validVowels = "aeiouáéíóúü"
        val validConsonants = "bcdfghjklmnñpqrstuvwxyz"
        if(word.contains(Regex("[^$validVowels$validConsonants ]"))) {
            throw IllegalArgumentException("input must only contain valid spanish characters")
        }

    }*/

    override fun stressedSyllableOf(input:String):Int {
        return 0//todo!
    }

    //Spanish letters are either vowels (a,e,i,o,u)
    // or consonants (b,c,d,f,g,h,j,k,l,ll,m,n ̃, n,p,q,r,rr,s,t,v,w,x,y,z),
    // and vowels are either weak (i,u) or strong (a,e,o).
    private val unaccentedVowels = "aeiou"
    private val accentedVowels = "áéíóú"
    private val vowels = unaccentedVowels+accentedVowels
    private val strongVowels = "aeo"
    private val weakAccentedVowels = "íú"
    //́

    private val prefixes = arrayOf<String>("circun", "cuadri", "cuadru", "cuatri", "quinqu", "archi", "arqui", "citer",
        "cuasi", "infra", "inter", "intra", "multi", "radio", "retro", "satis", "sobre", "super", "supra", "trans",
        "ulter", "ultra", "yuxta", "ante", "anti", "cata", "deci", "ecto", "endo", "hemi", "hipo", "meta", "omni",
        "pali", "para", "peri", "post", "radi", "tras", "vice", "cons", "abs", "ana", "apo", "arz", "bis", "biz", "cis",
        "com", "con", "des", "dia", "dis", "dis", "epi", "exo", "met", "pen", "pos", "pre", "pro", "pro", "tri", "uni",
        "viz", "ins", "nos")
    private fun syllabifyPlainLanguage(input:String): Array<Int> {
        val s = input.normalise()
            // Letters ch, ll, and rr are considered as single consonants.
            .replace("ch", "C")
            .replace("ll", "L")
            .replace("rr", "R")
        //allows us to treat each orthographic character as a single logical character
        val consonants = "bcdfghjklmnñpqrstuvwxyzCLR"

        //allows us to add ints in any order, but maintain natural ordering
        val syllableBoundaries: SortedSet<Int> = TreeSet()
        //2. If the word begins with a prefix,
        // divide between the word and the prefix
        var start = 0
        for(prefix in prefixes) {
            if(s.startsWith(prefix)) {
                syllableBoundaries.add(prefix.length)
                start = prefix.length
                break
            }
        }
        //3. Ignore one or two consonants if they begin a word
        if(s.substring(start).matches(Regex("[$consonants]{2}"))) {
            start += 2
        }else if(s.substring(start).matches(Regex("[$consonants]"))) {
            start += 1
        }
        fun String.continuousConsonants():String {
            var out = ""
            for(i in this) {
                if(i in consonants) {
                    out += i
                }
                else {
                    break
                }
            }
            return out
        }
        //1. Scan the word from left to right
        for(i in start until s.length) {
            //4. (Skip over vowels) - not skipping.

            //5. When you come to a consonant
            if(s[i] in consonants) {
                //6. If the consonant ends the word, ignore it
                if(i == s.length-1) {
                    continue//or break?
                }//defacto else
                //see how many consonants are between vowels
                val continuousConsonants = s.substring(i).continuousConsonants()
                val consonantBoundary = when(continuousConsonants.length) {
                    //a) If there is only one consonant,
                    1 -> i //divide to the left of it;

                    //b) If there are two consonants,
                    2 -> {
                        //if the second one is l or r,
                        if(s[i+1] == 'l' || s[i+1] == 'r') {
                            //divide to the left of the first one
                            i
                        }
                        else {
                            //divide to the left of the second one
                            i+1
                        }
                    }

                    //c) If there are three consonants
                    3 -> {
                        //if the third one is l or r
                        if(s[i+2] == 'l' || s[i+2] == 'r') {
                            //divide to the left of the second one;
                            i+1
                        }
                        else {
                            //divide to the left of the third one
                            i+2
                        }
                    }
                    //d) If there are four,
                    4 -> {
                        if(s[i+3] != 'l' && s[i+3] != 'r') {
                            System.err.println("letter ${i+3} '${s[i+3]}' of $s should be l or r")
                            -1
                        }else {
                            //the fourth one will always be l or r,
                            //so divide before the third consonant.
                            i + 2
                        }
                    }
                    else -> -1
                }
                syllableBoundaries.add(consonantBoundary)
            }
            //7. (Scan the word a second time to) - only scanning once
            // see if two or more vowels are together
            else if(s[i] in vowels) {
                //a) If two vowels together are both weak,
                    //ignore them;
                //b) If one of the vowels is weak,
                    //if the u or i has an accent mark,
                        //divide between the two vowels;
                    // else
                        //ignore it,
                //c) If only one of the vowels is weak,
                // AND there is an accent mark which is not on the u or i,
                    // ignore them;
                //d) If both vowels are strong,
                    //divide between the vowels;
                //e) If there are three vowels together,
                    //if two of them are weak,
                        //ignore them  even if there is an accent mark;
                    //if two of the three vowels are strong,
                        //if the two strong vowels are side by side,
                            //separate them
            }
            else {
                throw IllegalArgumentException("Character '${s[i]}' of input \"$input\" is not a valid Spanish vowel or consonant")
            }
        }
        return arrayOf()
    }

    /**Adapted from the 2004 paper
     * "A Syllabification Algorithm for Spanish" by Heriberto Cuayáhuitl.
     *
     * This function is based on the pseudocode version.
     * I have serious doubts about its correctness,
     * but this is the algorithm converted to Kotlin,
     * as verbatim as possible.*/
    private fun syllabifyPseudocode(input:String): String {
        /**Returns this.get(index), or null if the index is not valid for the string.*/
        fun String.c(index:Int):Char?{
            return try {
                get(index)
            }catch (sioobe:StringIndexOutOfBoundsException) {
                null
            }
        }
        val consonants = "bcdfghjklmnñpqrstuvwxyz"
        val s:String = input.normalise()
        var N = ""
        var T = ""
        var preIndex = 0

        for(prefix in prefixes) {
            if(s.contains(prefix)) {
                N = prefix+"-"
                preIndex = prefix.length
                break
            }
        }

        for(i in preIndex until s.length) {

            if( ( (s[i-1] in strongVowels || s[i-1] in weakAccentedVowels) && s[i] in strongVowels ) ||
                (s.c(i-1) in vowels && s[i] in weakAccentedVowels) ) {
                N += "-"
                T = s[i].toString()
                continue
            }

            if((s[i] in consonants && s[i+1] in vowels) ||
                (s[i+1] in accentedVowels && T.isNotEmpty()) ) {
                if(s[i] in "lr" && s[i-1] in consonants) {
                    if(i > 1) {
                        T = T //?? "T = T[k], for all 0 <= k <= R.length-1"
                        N += T+"-"
                        T = String(charArrayOf(s[i-1], s[i]))
                    }
                    else {
                        T += s[i]
                    }
                }
                else {
                    N += T+"-"
                    T = s[i].toString()
                }
            }
            else {
                T += s[i]
            }
        }
        return N+T
    }
}