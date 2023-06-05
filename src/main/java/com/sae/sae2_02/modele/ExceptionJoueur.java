package com.sae.sae2_02.modele;

/**
 * Exception personnalisée pour les erreurs liées au joueur.
 */
public class ExceptionJoueur extends Exception implements ConstanteErreur {
    private int chErrorCode;

    /**
     * Constructeur de l'exception avec le code d'erreur.
     *
     * @param errorCode le code d'erreur
     */
    public ExceptionJoueur(int errorCode) {
        super();
        chErrorCode = errorCode;
    }

    /**
     * Récupère le message d'erreur correspondant au code d'erreur.
     *
     * @return le message d'erreur
     */
    public String getError() {
        return ERREUR_JOUEUR[chErrorCode] + " - Error code: " + chErrorCode;
    }
}