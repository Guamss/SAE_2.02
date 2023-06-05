package com.sae.sae2_02.modele;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectureFichierTexte
{
    public static Scenario lecture(File fichier)
    {
        Scenario scenario = new Scenario();
        try
        {
            Scanner scanner = new Scanner(fichier);
            while(scanner.hasNext())
            {
                scenario.ajout(new Quete(scanner.nextLine()));
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
        return scenario;
    }
}