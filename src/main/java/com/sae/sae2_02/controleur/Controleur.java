package com.sae.sae2_02.controleur;

import com.sae.sae2_02.modele.*;
import com.sae.sae2_02.vue.VBoxRoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import java.io.File;
import java.util.*;

import static com.sae.sae2_02.vue.ConstanteScenario.SCENARIOS;

public class Controleur implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent event)
    {
        if (event.getSource() instanceof Button button)
        {
            if (button.getAccessibleText().equals("Exhautive"))
            {
                String selectedItem = VBoxRoot.getComboBox().getSelectionModel().getSelectedItem();
                Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + selectedItem));
                try
                {
                    TreeMap<Integer, LinkedList<Integer>> efficace = Algorithme.exhaustive(scenario);
                    VBoxRoot.getBoiteAffichage().afficher(efficace, "Exhaustive");
                }
                catch (ExceptionScenario e)
                {
                    System.out.println(e.getError());
                }
                catch (ExceptionJoueur e)
                {
                    System.out.println(e.getError());
                }
                catch (ExceptionAlgorithme e)
                {
                    System.out.println(e.getError());
                }
            }
            else if (button.getAccessibleText().equals("Efficace"))
            {
                String selectedItem = VBoxRoot.getComboBox().getSelectionModel().getSelectedItem();
                Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + selectedItem));
                try
                {
                    TreeMap<Integer, LinkedList<Integer>> efficace = Algorithme.efficace(scenario);
                    VBoxRoot.getBoiteAffichage().afficher(efficace, "Efficace");
                }
                catch (ExceptionScenario e)
                {
                    System.out.println(e.getError());
                }
                catch (ExceptionJoueur e)
                {
                    System.out.println(e.getError());
                }
                catch (ExceptionAlgorithme e)
                {
                    System.out.println(e.getError());
                }
            }
            else if (button.getAccessibleText().equals("En savoir plus..."))
            {
                String selectedItem = VBoxRoot.getComboBox().getSelectionModel().getSelectedItem();
                Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + selectedItem));
                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE));
                if (Arrays.asList(SCENARIOS).contains(selectedItem))
                {
                    dialog.setTitle("Info : " + selectedItem);
                    try
                    {
                        ArrayList<Quete> firstQuests =  scenario.getFirstQuests();
                        ArrayList<Integer> firstQuestsNum = new ArrayList<>();
                        for (Quete quete : firstQuests)
                        {
                            firstQuestsNum.add(quete.numero);
                        }
                        String showedText = "Premières quêtes : " + firstQuestsNum + "\n";
                        showedText += "Dernière Quête : " + scenario.getLastQuest().numero + "\n";
                        showedText += "Nombre de quêtes : " + scenario.questArr.size();
                        dialog.setContentText(showedText);
                    }
                    catch (ExceptionScenario e)
                    {
                        System.out.println(e.getError());
                    }
                }
                else
                {
                    dialog.setTitle("Aucun scénario sélectionné");
                    dialog.setContentText("Veuillez sélectionner un scénario");
                }
                dialog.showAndWait();
            }
        }
    }
}
