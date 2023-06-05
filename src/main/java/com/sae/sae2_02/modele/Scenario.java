package com.sae.sae2_02.modele;

import java.util.ArrayList;

/**
 * Classe représentant un scénario composé de quêtes.
 */
public class Scenario {
    public ArrayList<Quete> questArr = new ArrayList<Quete>();

    /**
     * Ajoute une quête au scénario.
     *
     * @param quete la quête à ajouter
     */
    public void ajout(Quete quete) {
        questArr.add(quete);
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du scénario.
     *
     * @return une chaîne de caractères représentant le scénario
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Quete quete : questArr) {
            str.append(quete.toString()).append("\n");
        }
        return str.toString();
    }

    /**
     * Récupère la dernière quête du scénario.
     *
     * @return la dernière quête du scénario
     * @throws ExceptionScenario si aucune quête numéro 0 n'est présente ou si plusieurs quêtes numéro 0 sont présentes
     */
    public Quete getLastQuest() throws ExceptionScenario {
        Quete lastQuete = null;
        boolean foundZero = false;

        for (Quete quete : questArr) {
            if (quete.numero == 0) {
                if (foundZero) {
                    throw new ExceptionScenario(0);
                } else {
                    lastQuete = quete;
                    foundZero = true;
                }
            }
        }

        if (!foundZero) {
            throw new ExceptionScenario(1);
        }

        return lastQuete;
    }

    /**
     * Récupère les premières quêtes du scénario (celles qui n'ont pas de préconditions).
     *
     * @return une liste des premières quêtes du scénario
     * @throws ExceptionScenario si aucune première quête n'est présente dans le scénario
     */
    public ArrayList<Quete> getFirstQuests() throws ExceptionScenario {
        ArrayList<Quete> firstQuests = new ArrayList<Quete>();
        for (Quete quete : this.questArr) {
            if (!quete.hasPrecond()) {
                firstQuests.add(quete);
            }
        }
        if (firstQuests.isEmpty()) {
            throw new ExceptionScenario(2);
        }
        return firstQuests;
    }
}
