package com.github.medavox.ipa_transcribers

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.GridPane
import javafx.stage.Stage

//some more tutorial & learning resources;
//https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm#CFHEAHGB
//https://docs.oracle.com/javase/8/javafx/get-started-tutorial/hello_world.htm
//
/**Provides a Desktop GUI for the library.
 * Implemented with JavaFX, available as part of Java 8's language API.
 * Note that after Java 8, JavaFX was made an external library.
 * @see [https://docs.oracle.com/javase/8/javafx/api](JavaFX javadoc)*/
class Gui : Application() {
    //input = multi-line text input field
    //language choice = dropdown list
    //result = multi-line text output field
    //errors = multi-line text output field
    override fun start(primaryStage:Stage) {
        val root = GridPane()
        root.setAlignment(Pos.CENTER)
        root.setHgap(10.0); root.setVgap(10.0)
        root.setPadding(Insets(10.0, 10.0, 10.0, 10.0))

        val input = TextArea()
        input.setEditable(true)
        input.setPromptText("enter native text")
        input.setWrapText(true)

        val output = TextArea()
        output.promptText = "transliteration goes here"
        output.setEditable(false)
        output.setWrapText(true)

        val errors = TextArea()
        errors.promptText = "errors go here"
        errors.setEditable(false)
        errors.setWrapText(true)
        errors.text

        val menuButton = MenuButton()
        var selection: Language =
            Language.ENGLISH
        val languagesMenuItems:Array<MenuItem> = Language.values().
            map{
                val m = MenuItem(it.neim)
                m.setOnAction {
                        event -> menuButton.text = it.neim
                    selection = it
                }
                m
            }.toTypedArray()
        menuButton.items.addAll(*languagesMenuItems)

        //val out = PrintStreamCapturer(output, System.out)
        val err = PrintStreamCapturer(errors, System.err)
        System.setErr(err)

        val btn = Button()
        btn.setText("Transliterate")
        btn.alignment = Pos.CENTER_RIGHT
        btn.setOnAction { event:ActionEvent ->
            System.out.println("transcribing with $selection")
            errors.text = ""
            output.text = selection.transcriber.transcribe(input.text)
            //err.println("error text")
            //out.println("output text")
        }


        root.add(input, 0, 0, 2, 1)
        root.add(menuButton, 0, 1)
        root.add(btn, 1, 1)
        root.add(output, 0, 3, 2, 1)
        root.add(errors, 0, 4, 2, 1)

        val scene = Scene(root, 400.0, 400.0)

        primaryStage.setTitle("IPA Transliterator")
        primaryStage.setScene(scene)
        primaryStage.show()
    }
}
