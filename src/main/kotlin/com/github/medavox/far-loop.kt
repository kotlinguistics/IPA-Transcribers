package com.github.medavox

inline fun <T> far(initializer: () -> T,
            loopCheck:(T) -> Boolean,
            update:(T) -> T,
            loopBody:(T) -> Unit) {
    var index:T = initializer()
    while(loopCheck(index)) {
        loopBody(index)
        index = update(index)
    }
}

val array = arrayOf("Alice", "Bob", "Charles", "David", "Emma")

fun main() {
    far({0}, {it < array.size}, {it+1}) {i->
        far({i+1}, {it < array.size}, {it+1}) {j ->
            System.out.println("$i,$j:${array[i]} - ${array[j]}")
        }
    }
}