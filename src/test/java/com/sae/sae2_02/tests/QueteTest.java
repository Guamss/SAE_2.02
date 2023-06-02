package com.sae.sae2_02.tests;

import com.sae.sae2_02.modele.Quete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class QueteTest {

    @Test
    void lecturePos()
    {
        Assertions.assertArrayEquals(new int[]{0, 0}, Quete.lecturePos("1|(0, 0)|()|0|0|test"));
        assertArrayEquals(new int[]{0, 1}, Quete.lecturePos("1|(0, 1)|()|0|0|test"));
        assertArrayEquals(new int[]{1, 0}, Quete.lecturePos("1|(1, 0)|()|0|0|test"));
        assertArrayEquals(new int[]{1, 1}, Quete.lecturePos("1|(1, 1)|()|0|0|test"));
    }

    @Test
    void getQuestPrecond()
    {
        assertArrayEquals(new int[]{0, 0, 0, 0}, new Quete("1|(4, 3)|()|0|0|test").getQuestPrecond());
        assertArrayEquals(new int[]{1, 0, 0, 0}, new Quete("1|(4, 3)|((1,),)|0|0|test").getQuestPrecond());
        assertArrayEquals(new int[]{1, 0, 2, 0}, new Quete("1|(4, 3)|((1,),2,))|0|0|test").getQuestPrecond());
        assertArrayEquals(new int[]{1, 0, 2, 3}, new Quete("1|(4, 3)|((1,),(2,3))|0|0|test").getQuestPrecond());
        assertArrayEquals(new int[]{1, 2, 0, 0}, new Quete("1|(4, 3)|((1,2),)|0|0|test").getQuestPrecond());
        assertArrayEquals(new int[]{1, 2, 3, 0}, new Quete("1|(4, 3)|((1,2),(3,))|0|0|test").getQuestPrecond());
        assertArrayEquals(new int[]{1, 2, 0, 3}, new Quete("1|(4, 3)|((1,2),(,3))|0|0|test").getQuestPrecond());
        assertArrayEquals(new int[]{1, 2, 3, 4}, new Quete("1|(4, 3)|((1,2),(3,4))|0|0|test").getQuestPrecond());
    }

    @Test
    void questExists()
    {
        LinkedList<Integer> linkedListTest = new LinkedList<>();
        linkedListTest.add(1);
        linkedListTest.add(2);
        linkedListTest.add(3);
        linkedListTest.add(4);
        assertTrue(Quete.questExists(linkedListTest, 2));
        assertFalse(Quete.questExists(linkedListTest, 5));
    }

    @Test
    void hasPrecond()
    {
        assertFalse(new Quete("1|(1, 1)|()|0|0|test").hasPrecond());
        assertTrue(new Quete("1|(1, 1)|((1,2),(3,4))|0|0|test").hasPrecond());
    }
}