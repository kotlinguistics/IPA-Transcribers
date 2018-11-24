package com.github.medavox

/**A wrapper around a string which keeps track of a cursor position.*/
class AnalysableString(val string:String, initialCursorPosition:Int=0) {
    var cursor = initialCursorPosition

    /**Check that the substring matches this and enough following characters.
     * If this Analysable doesn't have that many letters, it returns false anyway.*/
    fun nextLettersMatch(other:String):Boolean {
        if(((string.length-1)-cursor) < other.length) {
            return false
        }else {
            for(i in 0 until other.length) {
               if(other[i] != string[cursor+i]) return false
            }
            return true
        }
    }

    fun lastLettersMatch(other:String):Boolean {
        if(cursor+1 < other.length || other.length >1 && cursor == 0) {
            return false
        }else {
            fur({0}, {it < other.length}, {it+1}) {i ->
                if(other[(other.length-1)-i] != string[cursor-i]) return false
            }
            return true
        }
    }

    fun next():AnalysableString {
        return AnalysableString(string, cursor+1)
    }

}