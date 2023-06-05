package com.sae.sae2_02.modele;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe représentant une quête généralisant la classe
 * Postition avec un numéro, une position, des préconditions,
 * une durée, une expérience et un intitulé.
 */
public class Quete extends Position {
    public int numero;
    private String precond;
    public int duree;
    public int experience;
    public String intitule;

    /**
     * Constructeur de la classe Quete.
     *
     * @param ligne la ligne de texte contenant les informations de la quête
     */
    public Quete(String ligne) {
        super(lecturePos(ligne)); // Lecture de la position
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while (scanner.hasNext()) {
            this.numero = scanner.nextInt();
            scanner.next(); // Ignore le deuxième champ
            this.precond = scanner.next();
            this.duree = scanner.nextInt();
            this.experience = scanner.nextInt();
            this.intitule = scanner.next();
        }
    }

    /**
     * Lecture et extraction des positions x et y à partir d'une chaîne de caractères.
     *
     * @param parString la chaîne de caractères contenant les positions x et y
     * @return un tableau d'entiers représentant les positions x et y
     */
    public static int[] lecturePos(String parString) {
        int[] positiontab = new int[2];
        Scanner scanner = new Scanner(parString).useDelimiter("\\|");
        scanner.nextInt(); // Ignorer le premier champ
        String positionStr = scanner.next();
        positionStr = positionStr.replace("(", "");
        positionStr = positionStr.replace(")", "");
        positionStr = positionStr.replace(" ", "");
        Scanner scanPosition = new Scanner(positionStr).useDelimiter(",");
        int i = 0;
        while (scanPosition.hasNext()) {
            String extrait = scanPosition.next();
            if (!extrait.equals("")) {
                positiontab[i] = Integer.parseInt(extrait);
            }
            i++;
        }
        return positiontab;
    }

    /**
     * Récupère les préconditions de la quête.
     *
     * @return un tableau d'entiers représentant les préconditions de la quête
     */
    public int[] getQuestPrecond() {
        int[] preconditions = new int[4];
        precond = precond.replace("(", "");
        precond = precond.replace(")", "");
        precond = precond.replace(" ", "");
        Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
        int i = 0;
        while (scanPrecondition.hasNext()) {
            String extrait = scanPrecondition.next();
            if (!extrait.equals("")) {
                preconditions[i] = Integer.parseInt(extrait);
            }
            i++;
        }
        return preconditions;
    }

    /**
     * Vérifie si une quête donnée existe dans une liste donnée.
     *
     * @param array   la liste de quêtes
     * @param element la quête à rechercher
     * @return true si la quête existe dans la liste, sinon false
     */
    public static boolean questExists(LinkedList<Integer> array, int element) {
        for (int value : array) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie si la quête a des préconditions.
     *
     * @return true si la quête a des préconditions, sinon false
     */
    public boolean hasPrecond() {
        int[] precondTab = this.getQuestPrecond();
        int compteur = 0;
        for (int precond_int : precondTab) {
            if (precond_int == 0) {
                compteur += 1;
            }
        }
        return !(compteur == precondTab.length);
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la quête.
     *
     * @return une chaîne de caractères représentant la quête
     */
    public String toString() {
        return numero + " | " + Arrays.toString(this.getPosition()) + " | " + Arrays.toString(this.getQuestPrecond()) + " | " + duree + " | " + experience + " | " + intitule;
    }
}
