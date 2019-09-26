package com.github.medavox

actual object err {
    actual fun print(err: String) {
    }

    actual fun println(err: String) {
    }
}

actual val Int.unicodeName: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual fun String.normaliseNfd():String {
    //intended javascript:
    //return this.normalize('NFD')
    TODO()
}