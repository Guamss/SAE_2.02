package com.sae.sae2_02.modele;


import java.util.Arrays;

public class Position
{
    protected int[] position;
    public Position(int[] parPosition)
    {
        this.position = parPosition;
    }

    public int[] getPosition()
    {
        return position;
    }

    public int[] posGap(int[] pos)
    {
        int[] ecartPositions = new int[2];
        ecartPositions[0] = Math.abs(this.getPosition()[0] - pos[0]);
        ecartPositions[1] = Math.abs(this.getPosition()[1] - pos[1]);
        return ecartPositions;
    }
    public void setPosition(int[] pos)
    {
        this.position = pos;
    }
}
