package com.sae.sae2_02.vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Appli extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("SAE - Exploration Algorithmique");
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root,600,200);
        File fichierCss = new File("css" + File.separator + "style.css");
        scene.getStylesheets().add(fichierCss.toURI().toString());
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args)
    {
       Application.launch(args);
    }
}
