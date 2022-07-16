package org.laplace.Dice;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static java.lang.Math.cos;

public class DiceAnimation {
    public Jaylib.Vector3 pos;
    public Jaylib.Vector3 rotAxis;
    public float rot;
    public float scale;

    private float x = 0;
    private float y = 0;
    public float Timer = 0.0f;

    public boolean active = false;
    public DiceAnimation() {
        pos = new Jaylib.Vector3(0.0f, 8.0f, 0.0f);
        scale = 1;
    }

    public DiceAnimation(float x, float y) {
        this.x = x;
        this.y = y;

        pos = new Jaylib.Vector3(0.0f, 8.0f, 0.0f);
        scale = 1;
    }
    public void BeginAnimation(int value) {
        if(pos.y() > 0) {
            pos = this.cubic_interpolation( new Jaylib.Vector3(x, 8.0f, y),
                            new Jaylib.Vector3(x, 0.0f, y),
                            Timer / 200.0f);

            rot = this.CosineInterpolate( 2400, this.getRot(value).rot, Timer / 200.0f);

            rotAxis = this.CosineInterpolate( new Jaylib.Vector3(1.0f, 1.0f, 1.0f),
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

    public Jaylib.Vector3 cubic_interpolation(Jaylib.Vector3 a, Jaylib.Vector3 b, float v) {
        return new Jaylib.Vector3(
                    a.x() + (b.x() - a.x() * v),
                a.y() + (b.y() - a.y() * v),
                a.z() + (b.z() - a.z() * v));
    }
    public float cubic_interpolation(float a, float b, float v) {
        return a + (b - a) * v;
    }

    public float CosineInterpolate(double y1,double y2,double mu) {
        double mu2 = (1-cos(mu*3.14))/2;
        return (float)( y1*(1-mu2)+y2*mu2);
    }

    public Jaylib.Vector3 CosineInterpolate(Jaylib.Vector3 y1,Jaylib.Vector3 y2,double mu) {
        return new Jaylib.Vector3(
                CosineInterpolate(y1.x(), y2.x(), mu),
                CosineInterpolate(y1.y(), y2.y(), mu),
                CosineInterpolate(y1.z(), y2.z(), mu));
    }
}
