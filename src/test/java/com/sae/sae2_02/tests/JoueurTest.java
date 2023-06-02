package com.sae.sae2_02.tests;

import com.sae.sae2_02.modele.Joueur;
import com.sae.sae2_02.modele.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void mouvement()
    {
        Joueur joueurTest = new Joueur();
        assertEquals(9, joueurTest.mouvement(new int[]{4, 5}));
        joueurTest.move(new int[]{3, 2});
        assertEquals(5, joueurTest.mouvement(new int[]{0, 0}));
        joueurTest.move(new int[]{2, 1});
        assertEquals(6, joueurTest.mouvement(new int[]{5, 4}));
        joueurTest.move(new int[]{0, 0});
        assertEquals(9, joueurTest.mouvement(new int[]{0, 0}));
    }
}