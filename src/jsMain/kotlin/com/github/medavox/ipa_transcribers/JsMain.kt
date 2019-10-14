package com.github.medavox.ipa_transcribers

import com.github.medavox.UiStrings
import org.w3c.dom.*
import org.w3c.dom.events.Event
import kotlin.browser.document

fun main() {
    val slekt = document.getElementById("lang_select") as HTMLSelectElement
    Language.values().forEach {
        slekt.add(Option(
            text= it.neim,
            value = it.name,
            defaultSelected = false,
            selected = false
        ))
    }

    val inputTextArea = document.getElementById("input_text") as HTMLTextAreaElement
    val outputTextArea = document.getElementById("output_text") as HTMLTextAreaElement
    val errorsTextArea = document.getElementById("errors_text") as HTMLTextAreaElement

    inputTextArea.setAttribute("placeholder", UiStrings.inputHint)
    outputTextArea.setAttribute("placeholder", UiStrings.outputHint)
    errorsTextArea.setAttribute("placeholder", UiStrings.errorsHint)


    val button = document.getElementById("transliterate_button") as HTMLButtonElement
    button.addEventListener("click", { event:Event ->
        val transcribr = Language.values().firstOrNull { it.ordinal == slekt.selectedIndex }!!.transcriber
        outputTextArea.textContent = transcribr.transcribe(inputTextArea.value)
        errorsTextArea.textContent = "transcriber: $transcribr"
    })

    //remove js warning
    val jsWarning = document.getElementById("js_warning") as HTMLDivElement
    jsWarning.remove()
}