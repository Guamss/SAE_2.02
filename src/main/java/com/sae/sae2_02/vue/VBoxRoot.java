package com.sae.sae2_02.vue;

import com.sae.sae2_02.controleur.Controleur;
import com.sae.sae2_02.modele.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static com.sae.sae2_02.vue.ConstanteScenario.SCENARIOS;

public class VBoxRoot extends VBox
{
    private final static Controleur controleur = new Controleur();
    private static ComboBox<String> comboBoxScenario = new ComboBox<>();
    private static BoiteAffichage boiteAffichage = new BoiteAffichage();
    public VBoxRoot() throws ExceptionScenario, ExceptionJoueur, ExceptionAlgorithme
    {
        this.setPadding(new Insets(10));
        boiteAffichage.setId("solutions");
        VBox boiteBouton = new VBox();
        comboBoxScenario.getItems().addAll(SCENARIOS);
        Button btnMore = new Button("En savoir plus...");
        btnMore.setAccessibleText("En savoir plus...");
        Button btnexhaustive= new Button("Exhaustive");
        btnexhaustive.setAccessibleText("Exhautive");
        Button btnefficace= new Button("Efficace");
        btnefficace.setAccessibleText("Efficace");

        btnexhaustive.setOnAction(controleur);
        btnefficace.setOnAction(controleur);
        btnMore.setOnAction(controleur);
        boiteBouton.setSpacing(10);
        boiteBouton.getChildren().addAll(btnexhaustive, btnefficace, btnMore);
        HBox hBoxScenario = new HBox();
        Label scenarioLabel = new Label("Scénario choisi : ");
        hBoxScenario.getChildren().addAll(scenarioLabel, comboBoxScenario);
        HBox boiteSolutions = new HBox(50);
        ScrollPane scrollPane = new ScrollPane(boiteAffichage);
        boiteSolutions.getChildren().addAll(scrollPane, boiteBouton);
        this.getChildren().addAll(hBoxScenario, boiteSolutions);
    }

    public static Controleur getControleur()
    {
        return controleur;
    }
    public static ComboBox<String> getComboBox() {
        return comboBoxScenario;
    }
    public static BoiteAffichage getBoiteAffichage()
    {
        return boiteAffichage;
    }
}
