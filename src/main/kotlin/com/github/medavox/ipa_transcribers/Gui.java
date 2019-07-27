package com.github.medavox.ipa_transcribers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.PrintStream;

public class Gui extends Application {
    //input = multi-line text input field
    //language choice = dropdown list
    //result = multi-line text output field
    //errors = multi-line text output field
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10); root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        TextArea input = new TextArea();
        input.setEditable(true);
        input.setPromptText("enter native text");
        input.setWrapText(true);

        TextArea output = new TextArea("transliteration goes here");
        output.setEditable(false);
        output.setWrapText(true);

        TextArea errors = new TextArea("errors go here");
        errors.setEditable(false);
        errors.setWrapText(true);

        String[] languages = new String[]{"Arabic", "Bengali", "English", "German", "Hindi", "Italian",
                "Japanese/Katakana&HiraganaOnly", "Korean", "Marathi", "Malay", "Persian", "Portuguese", "Russian",
                "Spanish/European", "Spanish/PanAmerican", "Swahili", "Telugu", "Turkish" };
        for(String lang : languages) {

        }
        //final Image image = new Image(getClass().getResource("cross_red.png").toExternalForm(), 20, 20, true, true);
        SplitMenuButton menuButton = new SplitMenuButton();
        //menuButton.setGraphic(new ImageView(image));
        menuButton.getItems().addAll(
                new MenuItem("Really"), new MenuItem("Do not")
        );

        PrintStreamCapturer out = new PrintStreamCapturer(output, System.out);
        PrintStreamCapturer err = new PrintStreamCapturer(errors, System.err);

        Button btn = new Button();
        btn.setText("Transliterate");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.setErr(new PrintStream(output.));

            }
        });


        root.add(input, 0, 0, 2, 1);
        root.add(menuButton, 0, 1);
        root.add(btn, 1, 1);
        root.add(output, 0, 3, 2, 1);
        root.add(errors, 0, 4, 2, 1);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
