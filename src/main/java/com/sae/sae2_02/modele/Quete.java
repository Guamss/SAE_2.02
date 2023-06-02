package com.sae.sae2_02.modele;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Quete extends Position
{
    public int numero;
    private int[] position;
    private String precond;
    public int duree;
    public int experience;
    public String intitule;
    public Quete(String ligne)
    {
        super(lecturePos(ligne));
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while(scanner.hasNext())
        {
            this.numero = scanner.nextInt();
            scanner.next(); // Ignore le deuxième champ
            this.precond = scanner.next();
            this.duree = scanner.nextInt();
            this.experience = scanner.nextInt();
            this.intitule = scanner.next();
        }
    }
    public static int[] lecturePos(String parString)
    {
        int[] positiontab = new int[2];
        Scanner scanner = new Scanner(parString).useDelimiter("\\|");
        scanner.nextInt(); // Ignorer le premier champ
        String positionStr = scanner.next();
        positionStr = positionStr.replace("(","");
        positionStr = positionStr.replace(")","");
        positionStr = positionStr.replace(" ","");
        Scanner scanPosition = new Scanner(positionStr).useDelimiter(",");
        int i = 0;
        while(scanPosition.hasNext())
        {
            String extrait = scanPosition.next();
            if(! extrait.equals(""))
            {
                positiontab[i] = Integer.parseInt(extrait);
            }
            i++;
        }
        return positiontab;
    }
    public int[] getQuestPrecond()
    {
        int[] preconditions = new int[4];
        precond = precond.replace("(","");
        precond = precond.replace(")","");
        precond = precond.replace(" ","");
        Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
        int i = 0;
        while(scanPrecondition.hasNext())
        {
            String extrait = scanPrecondition.next();
            if (! extrait.equals(""))
            {
                preconditions[i] = Integer.parseInt(extrait);
            }
            i++;
        }
        return preconditions;
    }
    public static boolean questExists(LinkedList<Integer> array, int element)
    {
        for (int value : array)
        {
            if (value == element)
            {
                return true;
            }
        }
        return false;
    }
    public boolean hasPrecond()
    {
        int[] precondTab = this.getQuestPrecond();
        int compteur = 0;
        for(int precond_int : precondTab)
        {
            if (precond_int == 0)
            {
                compteur+=1;
            }
        }
        return !(compteur==precondTab.length);
    }
    public String toString()
    {
        return numero + " | " + Arrays.toString(this.getPosition()) +  " | " + Arrays.toString(this.getQuestPrecond()) + " | " + duree + " | " + experience + " | " + intitule;
    }
}
