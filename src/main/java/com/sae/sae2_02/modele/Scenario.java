package com.sae.sae2_02.modele;


import java.util.ArrayList;

public class Scenario
{
    public ArrayList<Quete> questArr = new ArrayList<Quete>();
    public void ajout(Quete quete)
    {
        questArr.add(quete);
    }
    public String toString()
    {
        String str = "";
        for (Quete quete : questArr)
        {
            str = str + quete.toString() + "\n";
        }
        return str;
    }
    public Quete getLastQuest() throws ExceptionScenario
    {
        Quete lastQuete = null;
        boolean foundZero = false;

        for (Quete quete : questArr)
        {
            if (quete.numero == 0)
            {
                if (foundZero)
                {
                    throw new ExceptionScenario(0);
                }
                else
                {
                    lastQuete = quete;
                    foundZero = true;
                }
            }
        }

        if (!foundZero)
        {
            throw new ExceptionScenario(1);
        }

        return lastQuete;
    }
    public ArrayList<Quete> getFirstQuests() throws ExceptionScenario
    {
        ArrayList<Quete> firstQuests =  new ArrayList<Quete>();
        for(Quete quete : this.questArr)
        {
            if(!quete.hasPrecond()) {
                firstQuests.add(quete);
            }
        }
        if(firstQuests.isEmpty())
        {
            throw new ExceptionScenario(2);
        }
        return firstQuests;
    }
}