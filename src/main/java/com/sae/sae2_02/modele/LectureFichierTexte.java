package com.sae.sae2_02.modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe permettant de lire un fichier texte contenant les informations d'un scénario.
 */
public class LectureFichierTexte {

    /**
     * Lit le contenu d'un fichier texte et génère un scénario.
     *
     * @param fichier le fichier texte à lire
     * @return le scénario généré à partir du fichier
     */
    public static Scenario lecture(File fichier) {
        Scenario scenario = new Scenario();
        try {
            Scanner scanner = new Scanner(fichier);
            while (scanner.hasNext()) {
                scenario.ajout(new Quete(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return scenario;
    }
}
