package com.sae.sae2_02.modele;

/**
 * Exception personnalisée pour les erreurs liées au scénario.
 */
public class ExceptionScenario extends Exception implements ConstanteErreur {
    private int chErrorCode;

    /**
     * Constructeur de l'exception avec le code d'erreur.
     *
     * @param errorCode le code d'erreur
     */
    public ExceptionScenario(int errorCode) {
        super();
        chErrorCode = errorCode;
    }

    /**
     * Récupère le message d'erreur correspondant au code d'erreur.
     *
     * @return le message d'erreur
     */
    public String getError() {
        return ERREUR_SCENARIO[chErrorCode] + " - Error code: " + chErrorCode;
    }
}
    

