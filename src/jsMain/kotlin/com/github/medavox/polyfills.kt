package com.github.medavox

actual object err {
    actual fun print(err: String) {
        TODO()
    }

    actual fun println(err: String) {
        TODO()
    }
}

actual val Int.unicodeName: String
    get() {
        TODO()
    }
actual fun String.normaliseNfd():String {
    //intended javascript:
    //return this.normalize('NFD')
    val s = this
    return js("s.normalize('NFD')") as String
}
