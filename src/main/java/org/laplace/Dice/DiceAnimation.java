package org.laplace.Dice;

import com.raylib.Jaylib;

public class DiceAnimation {
    public Jaylib.Vector3 pos = new Jaylib.Vector3(2.0f, 2.0f, 2.0f);
    public Jaylib.Vector3 rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
    public float rot = 0;
    public float scale = 1;

    public float Timer = 0.0f;

    public DiceAnimation() {
        pos = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
        rotAxis = new Jaylib.Vector3(1.0f, 0.0f, 1.0f);
        rot = 90;
        scale = 1;
    }
    public void BeginAnimation() {
        Timer++;

        rot += 1;
    }

    public void RotateTo2() {
        pos = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
        rotAxis = new Jaylib.Vector3(1.0f, 0.0f, 1.0f);
    }
}
