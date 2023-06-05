package com.sae.sae2_02.modele;


public interface ConstanteErreur
{
    public final String[] ERREUR_JOUEUR =
            {
                    "Le joueur n'est pas à l'emplacement de la quête ou il ne peut atteindre aucune quête"
            };
    public final String[] ERREUR_SCENARIO =
            {
                    "Plusieurs quêtes numéro 0 sont présentes dans le Scenario",
                    "Il n'y a pas de quête numéro 0",
                    "Il n'y a pas de première quête dans le scenario ou le scénario n'éxiste pas"
            };
    public final String[] ERREUR_ALGO =
            {
                    "La solution ne se termine pas par la dernière quête"
            };
}
