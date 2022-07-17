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
        EndDrawing();
    }
}
