package com.sae.sae2_02.modele;

import static com.sae.sae2_02.modele.ConstanteErreur.ERREUR_ALGO;

/**
 * Exception personnalisée pour les erreurs liées à l'algorithme.
 */
public class ExceptionAlgorithme extends Exception {
    private int chErrorCode;

    /**
     * Constructeur de l'exception avec le code d'erreur.
     *
     * @param errorCode le code d'erreur
     */
    public ExceptionAlgorithme(int errorCode) {
        super();
        chErrorCode = errorCode;
    }

    /**
     * Récupère le message d'erreur correspondant au code d'erreur.
     *
     * @return le message d'erreur
     */
    public String getError() {
        return ERREUR_ALGO[chErrorCode] + " - Error code: " + chErrorCode;
    }
}





