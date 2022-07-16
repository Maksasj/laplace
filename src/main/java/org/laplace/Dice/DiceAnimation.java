package org.laplace.Dice;

import com.raylib.Jaylib;

public class DiceAnimation {
    public Jaylib.Vector3 pos;
    public Jaylib.Vector3 rotAxis;
    public float rot;
    public float scale;

    public float Timer = 0.0f;

    public boolean active = false;

    public DiceAnimation() {
        pos = new Jaylib.Vector3(0.0f, 8.0f, 0.0f);
        setRot5();
        scale = 1;
    }
    public void BeginAnimation(int value) {
        Timer++;

        if(pos.y() > 0) {
            float y = pos.y();
            pos.y(y - 0.05f);
            rot += 3;
        } else {
            //active = false;
        }
    }

    public void ResetAnimation() {
        setRot1();
        Timer = 0;
        pos = new Jaylib.Vector3(0.0f, 8.0f, 0.0f);
    }

    public void setRot1() {
        rotAxis = new Jaylib.Vector3(1.0f, 1.0f, 0.0f);
        rot = 180;
    }

    public void setRot2() {
        rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
        rot = 0;
    }

    public void setRot3() {
        rotAxis = new Jaylib.Vector3(0.0f, 1.0f, 0.0f);
        rot = 270;
    }

    public void setRot4() {
        rotAxis = new Jaylib.Vector3(0.0f, 1.0f, 0.0f);
        rot = 90;
    }

    public void setRot5() {
        rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 1.0f);
        rot = 180;
    }

    public void setRot6() {
        rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 1.0f);
        rot = 90;
    }
}
