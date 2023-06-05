package com.sae.sae2_02.modele;


public class ExceptionScenario extends Exception implements ConstanteErreur
{
    private int chErrorCode;
    public ExceptionScenario(int errorCode)
    {
        super();
        chErrorCode=errorCode;
    }
    public String getError()
    {
        return ERREUR_SCENARIO[chErrorCode] + " - Error code : " + chErrorCode;
    }
}

