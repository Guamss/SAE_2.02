package com.sae.sae2_02.tests;

import com.sae.sae2_02.modele.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void posGap() {
        Position posTest = new Position(new int[]{0,0});
        Position posTest1 = new Position(new int[]{3,2});
        Position posTest2 = new Position(new int[]{2,1});
        Position posTest3 = new Position(new int[]{0,0});

        int[] posTestarg = new int[]{4,5};
        int[] posTestarg1 = new int[]{0,0};
        int[] posTestarg2 = new int[]{5,4};
        int[] posTestarg3 = new int[]{0,0};

        assertArrayEquals(new int[]{4,5}, posTest.posGap(posTestarg));
        assertArrayEquals(new int[]{3,2}, posTest1.posGap(posTestarg1));
        assertArrayEquals(new int[]{3,3}, posTest2.posGap(posTestarg2));
        assertArrayEquals(new int[]{0,0}, posTest3.posGap(posTestarg3));
    }
}