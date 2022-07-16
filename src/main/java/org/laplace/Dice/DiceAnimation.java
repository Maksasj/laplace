package org.laplace.Dice;

import com.raylib.Jaylib;
import com.raylib.Raylib;

public class DiceAnimation {
    public Jaylib.Vector3 pos;
    public Jaylib.Vector3 rotAxis;
    public float rot;
    public float scale;

    public float Timer = 0.0f;

    public boolean active = false;

    public DiceAnimation() {
        pos = new Jaylib.Vector3(0.0f, 8.0f, 0.0f);
        scale = 1;
    }
    public void BeginAnimation(int value) {
        if(pos.y() > 0) {
            pos = this.lep( new Jaylib.Vector3(0.0f, 8.0f, 0.0f),
                            new Jaylib.Vector3(0.0f, 0.0f, 0.0f),
                            Timer / 200.0f);

            rot = this.lep( 720, this.getRot(value).rot, Timer / 200.0f);

            rotAxis = this.lep( new Jaylib.Vector3(1.0f, 1.0f, 1.0f),
                                this.getRot(value).rotAxis,
                                Timer / 200.0f);
            Timer++;
        } else {
            //Timer++;
        }
    }

    public void ResetAnimation() {
        Timer = 0;
        pos = new Jaylib.Vector3(0.0f, 8.0f, 0.0f);
    }

    public DiceRotationType getRot(int value) {
        switch (value) {
            case 1:
                return getRot1();
            case 2:
                return getRot2();
            case 3:
                return getRot3();
            case 4:
                return getRot4();
            case 5:
                return getRot5();
            case 6:
                return getRot6();
        }

        return getRot1();
    }

    public DiceRotationType getRot1() {
        return new DiceRotationType(new Jaylib.Vector3(1.0f, 1.0f, 0.0f), 180);
    }
    public DiceRotationType getRot2() {
        return new DiceRotationType(new Jaylib.Vector3(0.0f, 0.0f, 0.0f), 0);
    }

    public DiceRotationType getRot3() {
        return new DiceRotationType(new Jaylib.Vector3(0.0f, 1.0f, 0.0f), 270);
    }

    public DiceRotationType getRot4() {
        return new DiceRotationType(new Jaylib.Vector3(0.0f, 1.0f, 0.0f), 90);
    }

    public DiceRotationType getRot5() {
        return new DiceRotationType(new Jaylib.Vector3(0.0f, 0.0f, 1.0f), 180);
    }

    public DiceRotationType getRot6() {
        return new DiceRotationType(new Jaylib.Vector3(0.0f, 0.0f, 1.0f), 90);
    }

    public Jaylib.Vector3 lep(Jaylib.Vector3 a, Jaylib.Vector3 b, float v) {

        return new Jaylib.Vector3(
                a.x() * (1 - v) + (b.x() * v),
                a.y() * (1 - v) + (b.y() * v),
                a.z() * (1 - v) + (b.z() * v));
    }

    public float lep(float a, float b, float v) {
        return a*(1-v)+b*v;
    }
}
