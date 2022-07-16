package org.laplace.Dice;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;

import java.util.Random;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Dice extends DiceAnimation {
    private Raylib.Model dice6;
    private static Raylib.Camera3D camera;

    int value = 1;

    public Dice() {
        super();
        camera = new Raylib.Camera3D();
        SetCameraMode(camera, CAMERA_CUSTOM);

        dice6 = Game.getModelManager().getModel("dice6");
    }

    public Dice(float x, float y) {
        super(x, y);

        camera = new Raylib.Camera3D();
        SetCameraMode(camera, CAMERA_CUSTOM);

        dice6 = Game.getModelManager().getModel("dice6");
    }

    public void Draw() {
        if(active) {
            this.BeginAnimation(value);
            camera._position( new Jaylib.Vector3( 9.0f, 0.0f,  0.0f))
                    .target(    new Jaylib.Vector3(0.0f, 0.0f, 0.0f))
                    .up(        new Raylib.Vector3().x(0.0f).y(1.0f).z(0.0f))
                    .fovy(45)
                    .projection(CAMERA_PERSPECTIVE);


            Game.getModelManager().DrawModel("dice6", pos, scale, rotAxis, rot);

            this.Update();
        }
    }

    public void Update() {

    }

    private int trow6() {
        Random rand = new Random();
        int int_random = rand.nextInt(6);
        value = int_random+1;

        this.ResetAnimation();
        active = true;
        return int_random;
    }

    public int ThrowDice(int maxVal) {
        switch (maxVal) {
            case 6:
                return trow6();
            default:
                return 1;
        }
    }

    public Raylib.Camera3D GetCamera() {
        return camera;
    }
}
