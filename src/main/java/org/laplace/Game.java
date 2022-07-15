package org.laplace;

import com.raylib.Raylib;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.scenes.mainmenu.MainMenu;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.VIOLET;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.CloseWindow;

public class Game {
    private static Raylib.Camera3D camera;
    private boolean gameRunning;

    ScenesGeneric activeScene;

    //Game constructor
    public Game() {
        InitWindow(800, 450, "Demo");
        SetTargetFPS(60);

        camera = new Raylib.Camera3D()
                ._position(new Raylib.Vector3().x(18).y(16).z(18))
                .target(new Raylib.Vector3())
                .up(new Raylib.Vector3().x(0).y(1).z(0))
                .fovy(45).projection(CAMERA_PERSPECTIVE);
        SetCameraMode(camera, CAMERA_ORBITAL);

        gameRunning = true;
        activeScene = new MainMenu();
    }

    //Main game loop
    public void run() {
        while (gameRunning) {
            activeScene.Update();
            activeScene.Draw();
        }

        CloseWindow();
    }
    public void handleDrawing() {
        activeScene.Draw();
    }

    public void setGameRunning(boolean value) {
        gameRunning = value;
    }

    public void close() {
        setGameRunning(false);
    }

    public static Raylib.Camera3D getCamera() {
        return camera;
    }

    public Game getInstance() {
        return this;
    }
}
