package com.sae.sae2_02.vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

/**
 * Classe représentant une boîte d'affichage dans l'application.
 * Cette boîte affiche les solutions et leurs informations associées.
 */
public class BoiteAffichage extends VBox {
    private Label solutionText = new Label("Veuillez choisir un scénario");
    private Label nbrSolution = new Label("");
    private Label typeSolution = new Label("");

    /**
     * Constructeur de la classe BoiteAffichage.
     * Initialise les labels de la boîte d'affichage et configure le style.
     */
    public BoiteAffichage() {
        nbrSolution.setId("solution");
        solutionText.setId("solution");
        typeSolution.setId("solution");
        this.setPadding(new Insets(20));
        this.getChildren().addAll(typeSolution, solutionText, nbrSolution);
    }

    /**
     * Affiche les solutions dans la boîte d'affichage.
     *
     * @param map  Une TreeMap contenant les solutions, avec les clés représentant les unités de temps et les valeurs représentant les chemins.
     * @param type Le type de solution (efficace, exhaustive...).
     */
    public void afficher(TreeMap<Integer, LinkedList<Integer>> map, String type) {
        typeSolution.setText(type + " :\n----------");
        Set<Integer> keys = map.keySet();
        int counter = 1;
        String content = "";
        for (int key : keys) {
            content += counter + ") Le joueur a mis " + Integer.toString(key) + " unités de temps. \n" + "Chemin : " + map.get(key) + "\n----------" + "\n";
        }
        solutionText.setText(content);
        nbrSolution.setText("Nombre de solution : " + map.size());
    }
}