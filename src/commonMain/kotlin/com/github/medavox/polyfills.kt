package com.github.medavox

expect object err {
    fun print(err:String)
    fun println(err:String)
}

/**Get the unicode name of the character with this codepoint.*/
expect val Int.unicodeName:String
expect fun String.normaliseNfd():String
