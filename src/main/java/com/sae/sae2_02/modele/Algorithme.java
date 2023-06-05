package com.sae.sae2_02.modele;

import java.util.*;

public class Algorithme
{
    private static LinkedList<Integer> solution;
    private static TreeMap<Integer, LinkedList<Integer>> solutions;
    private static Joueur joueur;
    private static LinkedHashMap<Quete, Boolean> completedQuest;

    public static TreeMap<Integer, LinkedList<Integer>> efficace(Scenario scenario) throws ExceptionScenario, ExceptionJoueur, ExceptionAlgorithme
    {
        // Pas la plus opti mais si je veux opti ce sera sur la methode speedrun
        solution = new LinkedList<>();
        solutions = new TreeMap<>();
        joueur = new Joueur();
        completedQuest = new LinkedHashMap<>();
        for (Quete quete : scenario.questArr)
        {
            completedQuest.put(quete, false);
        }
        LinkedList<Quete> todoQuests = new LinkedList<>(scenario.getFirstQuests());

        for (int i=0; i<scenario.getFirstQuests().size();i++)
        {
            Quete nextQuest = getClosestQuest(todoQuests);
            if (nextQuest == null)
            {
                throw new ExceptionJoueur(0); // Aucune quête atteignable
            }
            joueur.move(nextQuest.getPosition());
            joueur.completeQuest(nextQuest, solution);
            completedQuest.put(nextQuest, true);
            todoQuests.remove(nextQuest);
        }
        updateTodoQuests_efficace(scenario, todoQuests);
        while (!Quete.questExists(solution, 0))
        {
            Quete nextQuest = getClosestQuest(todoQuests);
            joueur.move(nextQuest.getPosition());
            joueur.completeQuest(nextQuest, solution);
            completedQuest.put(nextQuest, true);
            updateTodoQuests_efficace(scenario, todoQuests);
        }
        if (solution.get(solution.size()-1).equals(scenario.getLastQuest().numero))
        {
            solutions.put(joueur.getTime(), solution);
        }
        else
        {
            throw new ExceptionAlgorithme(0);
        }
        return solutions;
    }
    public static TreeMap<Integer, LinkedList<Integer>> exhaustive(Scenario scenario) throws ExceptionScenario, ExceptionJoueur, ExceptionAlgorithme
    {
        // Initialisation des champs
        solution = new LinkedList<>();
        solutions = new TreeMap<>();
        joueur = new Joueur();
        completedQuest = new LinkedHashMap<>();
        for (Quete quete : scenario.questArr)
        {
            completedQuest.put(quete, false);
        }
        //réalise les premières quête (sans préconditions)
        LinkedList<Quete> todoQuests = new LinkedList<>(scenario.getFirstQuests());

        for (int i=0; i<scenario.getFirstQuests().size();i++)
        {
            Quete nextQuest = getClosestQuest(todoQuests);
            if (nextQuest == null)
            {
                throw new ExceptionJoueur(0); // Aucune quête atteignable
            }
            joueur.move(nextQuest.getPosition());
            joueur.completeQuest(nextQuest, solution);
            completedQuest.put(nextQuest, true);
            todoQuests.remove(nextQuest);
        }
        //programme principal
        updateTodoQuests_exhaustif(scenario, todoQuests);
        while (!todoQuests.isEmpty())
        {
            Quete nextQuest = getClosestQuest(todoQuests);
            joueur.move(nextQuest.getPosition());
            joueur.completeQuest(nextQuest, solution);
            completedQuest.put(nextQuest, true);
            updateTodoQuests_exhaustif(scenario, todoQuests);
            if (solution.size() == scenario.questArr.size()-1) //Si toutes les quête appart la dernière sont terminée
            {
                nextQuest = scenario.getLastQuest();
                joueur.move(nextQuest.getPosition());
                joueur.completeQuest(nextQuest, solution);
                completedQuest.put(nextQuest, true);
            }
        }
        if (solution.get(solution.size()-1).equals(scenario.getLastQuest().numero))
        {
            solutions.put(joueur.getTime(), solution);
        }
        else
        {
            throw new ExceptionAlgorithme(0);
        }
        return solutions;
    }
    public static LinkedList<Integer> speedrun(Scenario scenario) throws ExceptionScenario, ExceptionJoueur, ExceptionAlgorithme
    {
        return solution;
    }

    private static Quete getClosestQuest(LinkedList<Quete> todoQuests)
    {
        Quete closestQuest = null;
        int closestDistance = 0;
        int counter = 0;

        for (Quete quete : todoQuests)
        {
            int time = joueur.mouvement(quete.getPosition()) + quete.duree;

            if (time < closestDistance || counter == 0)
            {
                closestQuest = quete;
                closestDistance = time;
            }
            counter+=1;
        }
        return closestQuest;
    }

    private static void updateTodoQuests_exhaustif(Scenario scenario, LinkedList<Quete> todoQuests) throws ExceptionScenario {
        todoQuests.clear(); //vide la liste
        for (Quete quete : scenario.questArr)
        {
            if (!completedQuest.get(quete) && arePreconditionsMet(quete) && quete != scenario.getLastQuest())
            {
                todoQuests.add(quete);
            }
        }
    }
    private static void updateTodoQuests_efficace(Scenario scenario, LinkedList<Quete> todoQuests) throws ExceptionScenario
    {
        todoQuests.clear(); //vide la liste
        for (Quete quete : scenario.questArr)
        {
            if (!completedQuest.get(quete) && arePreconditionsMet(quete))
            {
                todoQuests.add(quete);
            }
        }
    }
    private static boolean arePreconditionsMet(Quete quete)
    {
        int[] preconditions = quete.getQuestPrecond();
        //boolean de la mort qui tue 💀
        boolean preconditionsMet = Quete.questExists(solution, preconditions[0]) || Quete.questExists(solution, preconditions[1]) && ((preconditions[2] == 0 && preconditions[3] == 0) || Quete.questExists(solution, preconditions[2]) || Quete.questExists(solution, preconditions[3]));
        if (quete.numero == 0)
        {
            return preconditionsMet && joueur.getExperience() >= quete.experience;
        }
        else
        {
            return preconditionsMet;
        }
    }
}