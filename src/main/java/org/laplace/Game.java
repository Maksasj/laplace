package org.laplace;

import com.raylib.Raylib;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.VIOLET;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.CloseWindow;

public class Game {

    //Game constructor
    public Game() {

    }

    //Main game loop
    public void run() {
        InitWindow(800, 450, "Demo");
        SetTargetFPS(60);
        Raylib.Camera3D camera = new Raylib.Camera3D()
                ._position(new Raylib.Vector3().x(18).y(16).z(18))
                .target(new Raylib.Vector3())
                .up(new Raylib.Vector3().x(0).y(1).z(0))
                .fovy(45).projection(CAMERA_PERSPECTIVE);
        SetCameraMode(camera, CAMERA_ORBITAL);

        while (!WindowShouldClose()) {
            UpdateCamera(camera);
            BeginDrawing();
            ClearBackground(RAYWHITE);
            BeginMode3D(camera);
            DrawGrid(20, 1.0f);
            EndMode3D();
            DrawText("Hello world", 190, 200, 20, VIOLET);
            DrawFPS(20, 20);
            EndDrawing();
        }
        CloseWindow();
        System.out.println("Hello world!");
    }

    public void close() {

    }
}
