package com.sae.sae2_02.modele;



import java.io.File;
import java.util.Arrays;

public class Client
{
    public static void main(String[] args) throws ExceptionJoueur
    {
        try
        {
            Scenario scenario = LectureFichierTexte.lecture(new File("txt" + File.separator + "scenario_0.txt"));
            System.out.println("Exhaustive : " + Algorithme.exhaustive(scenario));
            System.out.println("Efficace : " + Algorithme.efficace(scenario));
        }
        catch (ExceptionScenario exception)
        {
            System.out.println(exception.getError());
        }
        catch (ExceptionAlgorithme exception)
        {
            System.out.println(exception.getError());
        }
    }
}