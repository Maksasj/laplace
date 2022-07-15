package org.laplace.scenes.mainmenu;

import org.laplace.Game;
import org.laplace.Main;
import org.laplace.scenes.ScenesGeneric;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.VIOLET;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.EndDrawing;

public class MainMenu extends ScenesGeneric {

    public MainMenu() {
        super(); //Parent constructor

    }

    @Override
    public void Update() {
        UpdateCamera(Game.getCamera());
    }

    @Override
    public void Draw() {
        BeginDrawing();
        ClearBackground(RAYWHITE);

        BeginMode3D(Game.getCamera()); //Scope for 3d stuff
            DrawGrid(20, 1.0f);
        EndMode3D();

        //There will be scope for 2d staff, guid soo on
        //DrawText("Hello world", 190, 200, 20, VIOLET);
        //DrawFPS(20, 20);
        EndDrawing();
    }
}
