package com.sae.sae2_02.vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

/**
 * Classe principale de l'application Appli.
 * Elle généralise la classe Application de JavaFX et
 * définit la méthode principale pour démarrer l'application.
 */
public class Appli extends Application {
    /**
     * Méthode principale qui démarre l'application.
     *
     * @param stage La fenêtre principale de l'application.
     * @throws Exception En cas d'erreur lors du démarrage de l'application.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SAE - Exploration Algorithmique");
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root, 600, 200);
        File fichierCss = new File("css" + File.separator + "style.css");
        scene.getStylesheets().add(fichierCss.toURI().toString());
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}