package org.laplace.systems.modelmanager;

public class Chank {
    public ChankType chankType;
    public String[][] gameObjects = new String[8][8];

    public Chank()
    {
        chankType = ChankType.NULL;
    }

    void changeType(ChankType type)
    {
        chankType = type;
    }



}
