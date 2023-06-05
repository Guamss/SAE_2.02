package com.sae.sae2_02.modele;

import java.util.*;

/**
 * Classe représentant le joueur qui généralise la classe Position.
 */
public class Joueur extends Position {
    private int experience;
    private int[] position;
    private int time;

    /**
     * Constructeur par défaut du joueur.
     * Initialise la position du joueur à [0, 0], l'expérience à 0 et le temps à 0.
     */
    public Joueur() {
        super(new int[]{0, 0});
        this.experience = 0;
        this.time = 0;
    }

    /**
     * Obtient l'expérience du joueur.
     *
     * @return l'expérience du joueur
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Obtient le temps du joueur.
     *
     * @return le temps du joueur
     */
    public int getTime() {
        return time;
    }

    /**
     * Effectue la complétion d'une quête.
     *
     * @param quete  la quête à compléter
     * @param liste  la liste de quêtes complétées
     * @throws ExceptionJoueur si le joueur n'est pas à l'emplacement de la quête
     */
    public void completeQuest(Quete quete, LinkedList<Integer> liste) throws ExceptionJoueur {
        int[] gap = this.posGap(quete.getPosition());
        if (Arrays.equals(gap, new int[]{0, 0})) {
            liste.add(quete.numero);
            time += quete.duree;
            if (quete.numero != 0) {
                experience += quete.experience;
            }
        } else {
            throw new ExceptionJoueur(0);
        }
    }

    /**
     * Déplace le joueur à une nouvelle position.
     *
     * @param parPos la nouvelle position
     */
    public void move(int[] parPos) {
        time += this.mouvement(parPos);
        setPosition(parPos);
    }

    /**
     * Calcule le nombre de mouvements nécessaires pour atteindre une position donnée.
     *
     * @param parPos la position cible
     * @return le nombre de mouvements nécessaires
     */
    public int mouvement(int[] parPos) {
        int deltaX = Math.abs(this.getPosition()[0] - parPos[0]);
        int deltaY = Math.abs(this.getPosition()[1] - parPos[1]);
        return deltaX + deltaY;
    }
    
    public String toString() {
        return "Joueur à la position : " + Arrays.toString(this.getPosition()) + " | expérience : " + this.experience + " | temps de jeu : " + this.time;
    }
}
