package com.sae.sae2_02.modele;
import static com.sae.sae2_02.modele.ConstanteErreur.ERREUR_ALGO;

public class ExceptionAlgorithme extends Exception {
    private int chErrorCode;
    public ExceptionAlgorithme(int errorCode)
    {
        super();
        chErrorCode=errorCode;
    }
    public String getError()
    {
        return ERREUR_ALGO[chErrorCode] + " - Error code : " + chErrorCode;
    }
}