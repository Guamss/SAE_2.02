package com.sae.sae2_02.vue;

import com.sae.sae2_02.controleur.Controleur;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static com.sae.sae2_02.vue.ConstanteScenario.SCENARIOS;

/**
 * Classe représentant la boîte racine de l'application.
 * Cette boîte contient les éléments graphiques principaux de
 * l'interface, tels que les boutons, les combobox et la boîte d'affichage des solutions.
 */
public class VBoxRoot extends VBox {
    private final static Controleur controleur = new Controleur();
    private static ComboBox<String> comboBoxScenario = new ComboBox<>();
    private static BoiteAffichage boiteAffichage = new BoiteAffichage();

    /**
     * Constructeur de la classe VBoxRoot.
     * Initialise les éléments graphiques de la
     * boîte racine de l'interface utilisateur.
     */
    public VBoxRoot(){
        this.setPadding(new Insets(10));
        boiteAffichage.setId("solutions");
        VBox boiteBouton = new VBox();
        comboBoxScenario.getItems().addAll(SCENARIOS);
        Button btnMore = new Button("En savoir plus...");
        btnMore.setAccessibleText("En savoir plus...");
        Button btnexhaustive = new Button("Exhaustive");
        btnexhaustive.setAccessibleText("Exhautive");
        Button btnefficace = new Button("Efficace");
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

    /**
     * Retourne le contrôleur associé à la boîte racine.
     *
     * @return Le contrôleur de l'application.
     */
    public static Controleur getControleur() {
        return controleur;
    }

    /**
     * Retourne la ComboBox des scénarios.
     *
     * @return La ComboBox des scénarios.
     */
    public static ComboBox<String> getComboBox() {
        return comboBoxScenario;
    }

    /**
     * Retourne la boîte d'affichage des solutions.
     *
     * @return La boîte d'affichage des solutions.
     */
    public static BoiteAffichage getBoiteAffichage() {
        return boiteAffichage;
    }
}
