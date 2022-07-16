package org.laplace.Dice;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Dice {
    private Raylib.Model dice6;
    private static Raylib.Camera3D camera;

    boolean active = false;

    public Dice() {
        camera = new Raylib.Camera3D();
        SetCameraMode(camera, CAMERA_ORBITAL);

        dice6 = Game.getModelManager().getModel("dice6");
    }

    public void Draw() {
        if(active) {
            camera._position( new Jaylib.Vector3( 7.0f, 5.0f,  7.0f))
                    .target(    new Jaylib.Vector3(2.0f, 1.0f, 2.0f))
                    .up(        new Raylib.Vector3().x(0).y(1).z(0))
                    .fovy(45)
                    .projection(CAMERA_PERSPECTIVE);

            Jaylib.Vector3 pos = new Jaylib.Vector3(2.0f, 2.0f, 2.0f);
            Jaylib.Vector3 rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
            float rot = 0;
            float scale = 1;
            Game.getModelManager().DrawModel("dice6", pos, scale, rotAxis, rot);

            this.Update();
        }
    }

    public void Update() {

    }

    private int trow6() {
        active = true;

        return 0;
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