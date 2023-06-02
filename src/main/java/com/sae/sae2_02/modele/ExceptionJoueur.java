package com.sae.sae2_02.modele;


public class ExceptionJoueur extends Exception implements ConstanteErreur
{
    private int chErrorCode;
    public ExceptionJoueur(int errorCode)
    {
        super();
        chErrorCode=errorCode;
    }
    public String getError()
    {
        return ERREUR_JOUEUR[chErrorCode] + " - Error code : " + chErrorCode;
    }
}
