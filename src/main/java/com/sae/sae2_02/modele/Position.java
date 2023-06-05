package com.sae.sae2_02.modele;

import java.util.Arrays;

/**
 * Classe représentant une position avec des coordonnées [x, y].
 */
public class Position {
    protected int[] position;

    /**
     * Constructeur de la classe Position.
     *
     * @param parPosition un tableau d'entiers représentant les coordonnées (x, y)
     */
    public Position(int[] parPosition) {
        this.position = parPosition;
    }

    /**
     * Retourne les coordonnées de la position.
     *
     * @return un tableau d'entiers représentant les coordonnées (x, y)
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * Calcule l'écart entre la position actuelle et une autre position donnée.
     *
     * @param pos les coordonnées de la position à comparer
     * @return un tableau d'entiers représentant l'écart en valeur absolue entre les coordonnées (x, y)
     */
    public int[] posGap(int[] pos) {
        int[] ecartPositions = new int[2];
        ecartPositions[0] = Math.abs(this.getPosition()[0] - pos[0]);
        ecartPositions[1] = Math.abs(this.getPosition()[1] - pos[1]);
        return ecartPositions;
    }

    /**
     * Définit les coordonnées de la position.
     *
     * @param pos les nouvelles coordonnées (x, y)
     */
    public void setPosition(int[] pos) {
        this.position = pos;
    }
}
