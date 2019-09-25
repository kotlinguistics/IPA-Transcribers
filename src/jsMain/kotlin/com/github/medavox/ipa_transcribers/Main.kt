package com.github.medavox.ipa_transcribers

import kotlinx.html.dom.append
import kotlinx.html.js.*
import kotlin.browser.document

fun main() {
    document.getElementById("app")
        ?.also { it.innerHTML = "" }
        ?.append {
            h1 { +"IPA Transcribers" }
            h2 { +"JS Edition" }
            //img(src = "$jvmBackend/mandelbrot")
        }
}