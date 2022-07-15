package org.laplace;

import com.raylib.Raylib;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.VIOLET;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.CloseWindow;

public class Game {
    private Raylib.Camera3D camera;
    private boolean gameRunning;

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
    }

    public void handleDrawing() {
        BeginDrawing();
            ClearBackground(RAYWHITE);

            BeginMode3D(camera); //Scope for 3d stuff
                DrawGrid(20, 1.0f);
            EndMode3D();

            //There will be scope for 2d staff, guid soo on
            DrawText("Hello world", 190, 200, 20, VIOLET);
            //DrawFPS(20, 20);
        EndDrawing();
    }

    //Main game loop
    public void run() {
        while (gameRunning) {
            UpdateCamera(camera);

            this.handleDrawing();
        }

        CloseWindow();
        System.out.println("Hello world!");
    }

    public void setGameRunning(boolean value) {
        gameRunning = value;
    }

    public void close() {
        setGameRunning(false);
    }
}
