package com.github.medavox.syllabifiers

interface Syllabifier {
    fun syllabify(input:String):Array<Int>
    fun stressedSyllableOf(input:String):Int
}