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
    public int getExperience()
    {
        return experience;
    }

    public int getTime()
    {
        return time;
    }

    public void completeQuest(Quete quete, LinkedList<Integer> liste)
    {
        int[] gap = this.posGap(quete.getPosition());
        if (Arrays.equals(gap, new int[]{0, 0}))
        {
            liste.add(quete.numero);
            time+=quete.duree;
            if (quete.numero != 0)
            {
                experience+=quete.experience;
            }
        }
        else
        {
            throw new ExceptionJoueur(0);
        }
    }

    public void move(int[] parPos)
    {
        time+=this.mouvement(parPos);
        setPosition(parPos);
    }

    public int mouvement(int[] parPos)
    {
        int deltaX = Math.abs(this.getPosition()[0] - parPos[0]);
        int deltaY = Math.abs(this.getPosition()[1] - parPos[1]);
        return deltaX + deltaY;
    }

    public String toString()
    {
        return "Joueur à la position : " + Arrays.toString(this.getPosition()) + " | experience : " + this.experience + " | temps de jeu : " + this.time;
    }
}
