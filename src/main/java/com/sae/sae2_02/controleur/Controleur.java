package com.sae.sae2_02.controleur;

import com.sae.sae2_02.modele.*;
import com.sae.sae2_02.vue.VBoxRoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import java.io.File;
import java.util.*;

import static com.sae.sae2_02.vue.ConstanteScenario.SCENARIOS;

/**
 * Classe représentant le contrôleur de l'application.
 * Le contrôleur gère les événements et les actions
 * effectuées par l'utilisateur.
 */
public class Controleur implements EventHandler<ActionEvent>
{
    /**
     * Méthode appelée lorsqu'un événement se produit.
     *
     * @param event L'événement déclenché.
     */
    @Override
    public void handle(ActionEvent event)
    {
        if (event.getSource() instanceof Button button)
        {
            try {
                if (button.getAccessibleText().equals("Exhautive"))
                {
                    // Gestion de l'action "Exhaustive"
                    String selectedItem = VBoxRoot.getComboBox().getSelectionModel().getSelectedItem();
                    Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + selectedItem));
                    TreeMap<Integer, LinkedList<Integer>> efficace = Algorithme.exhaustive(scenario);
                    VBoxRoot.getBoiteAffichage().afficher(efficace, "Exhaustive");
                }
                else if (button.getAccessibleText().equals("Efficace"))
                {
                    // Gestion de l'action "Efficace"
                    String selectedItem = VBoxRoot.getComboBox().getSelectionModel().getSelectedItem();
                    Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + selectedItem));
                    TreeMap<Integer, LinkedList<Integer>> efficace = Algorithme.efficace(scenario);
                    VBoxRoot.getBoiteAffichage().afficher(efficace, "Efficace");
                }
                else if (button.getAccessibleText().equals("En savoir plus..."))
                {
                    // Gestion de l'action "En savoir plus..."
                    String selectedItem = VBoxRoot.getComboBox().getSelectionModel().getSelectedItem();
                    Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + selectedItem));
                    Dialog<ButtonType> dialog = new Dialog<>();  // Création de la boite de dialogue
                    dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE));
                    if (Arrays.asList(SCENARIOS).contains(selectedItem))  // Si le scénario sélectionné existe
                    {
                        dialog.setTitle("Info : " + selectedItem);
                        ArrayList<Quete> firstQuests = scenario.getFirstQuests();
                        ArrayList<Integer> firstQuestsNum = new ArrayList<>();
                        for (Quete quete : firstQuests)  // On récupère uniquement les numéros des quêtes
                        {
                            firstQuestsNum.add(quete.numero);
                        }
                        String showedText = "Premières quêtes : " + firstQuestsNum + "\n";
                        showedText += "Dernière Quête : " + scenario.getLastQuest().numero + "\n";
                        showedText += "Nombre de quêtes : " + scenario.questArr.size();
                        dialog.setContentText(showedText);
                    }
                    else
                    {

                        dialog.setTitle("Aucun scénario sélectionné");
                        dialog.setContentText("Veuillez sélectionner un scénario");
                    }
                    dialog.showAndWait();
                }
            }
            catch (ExceptionScenario error)
            {
                System.out.println(error.getError());
            }
            catch (ExceptionJoueur error)
            {
                System.out.println(error.getError());
            }
            catch (ExceptionAlgorithme error)
            {
                System.out.println(error.getError());
            }
        }
    }
}
