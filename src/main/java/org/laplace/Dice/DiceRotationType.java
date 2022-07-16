package org.laplace.Dice;

import com.raylib.Jaylib;

public class DiceRotationType {
    public Jaylib.Vector3 rotAxis;
    public float rot;

    public DiceRotationType(Jaylib.Vector3 rotAxis, float rot) {
        this.rotAxis = rotAxis;
        this.rot = rot;
    }
}
