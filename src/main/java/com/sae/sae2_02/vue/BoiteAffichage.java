package com.sae.sae2_02.vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

public class BoiteAffichage extends VBox
{
    private Label solutionText = new Label("Veuillez choisir un scénario");
    private Label nbrSolution = new Label("");
    private Label typeSolution = new Label("");
    public BoiteAffichage()
    {
        nbrSolution.setId("solution");
        solutionText.setId("solution");
        typeSolution.setId("solution");
        this.setPadding(new Insets(20));
        this.getChildren().addAll(typeSolution, solutionText, nbrSolution);
    }
    public void afficher(TreeMap<Integer, LinkedList<Integer>> map, String type)
    {
        typeSolution.setText(type + " :\n----------");
        Set<Integer> keys = map.keySet();
        int counter = 1;
        String content = "";
        for (int key : keys)
        {
            content += counter + ") Le joueur a mit " + Integer.toString(key) + " unités de temps. \n" + "Chemin : " + map.get(key) + "\n----------" + "\n";
        }
        solutionText.setText(content);
        nbrSolution.setText("Nombre de solution : " + map.size());
    }
}
