package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;

import static com.raylib.Raylib.CAMERA_PERSPECTIVE;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class PlayerCameraController {

    private boolean mauseHold;

    private float mauseX;

    public PlayerCameraController() {
        mauseHold = false;
        mauseX = 0;
    }

    public void ControlCamera(PlayerCharacter p) {
        Game.getCamera()
                ._position(
                        new Jaylib.Vector3(
                                (float) ((float) p.getX()*2 - 7.0f*sin(mauseX)),
                                5.0f, (float)
                                ((float)  p.getY()*2 - 7*cos(mauseX))))
                .target(    new Jaylib.Vector3( p.getX()*2, 1.0f, (float)  p.getY()*2))
                .up(        new Raylib.Vector3().x(0).y(1).z(0))
                .fovy(45)
                .projection(CAMERA_PERSPECTIVE);

        Update();
    }

    private void Update() {
        mauseX += 0.01;
    }

}
