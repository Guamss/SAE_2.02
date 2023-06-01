package com.sae.sae2_02.modele;


import java.util.*;

public class Joueur extends Position
{
    private int experience;
    private int[] position;
    private int time;
    public Joueur()
    {
        super(new int[]{0, 0});
        this.experience = 0;
        this.time = 0;
    }
    //methode à finir et à tester
    public int getExperience()
    {
        return experience;
    }
    //methode à finir et à tester
    public int getTime()
    {
        return time;
    }

    public void completeQuest(Quete quete, LinkedList<Integer> liste)
    {
        ;
    }
    public void move(int[] parPos)
    {
        ;
    }
    public int mouvement(int[] parPos)
    {
        ;
    }
    public String toString()
    {
        ;
    }
}
