package com.sae.sae2_02.tests;

import com.sae.sae2_02.modele.ExceptionScenario;
import com.sae.sae2_02.modele.LectureFichierTexte;
import com.sae.sae2_02.modele.Quete;
import com.sae.sae2_02.modele.Scenario;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScenarioTest {

    @Test
    void getLastQuest()
    {
        Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + "scenario0.txt"));
        Quete lastQuest = null;
        for(Quete quete: scenario.questArr )
        {
            if(quete.numero==0)
            {
                lastQuest= quete;
            }
        }
        assertEquals(lastQuest, scenario.getLastQuest());

    }

    @Test
    void getFirstQuests() throws ExceptionScenario {
        ArrayList<Quete> firstQuestsTest = null;
        Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + "scenario1.txt"));
        for (Quete quete : scenario.questArr)
        {
            if (!quete.hasPrecond())
            {
                firstQuestsTest.add(quete);
            }
        }
        assertEquals(firstQuestsTest, scenario.getFirstQuests());
    }
}