package org.laplace.scenes.gamescene;

import com.raylib.Jaylib;
import org.laplace.Game;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.systems.modelmanager.ModelManager;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class GameScene extends ScenesGeneric {

    public GameScene() {
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
            Game.getModelManager().DrawModel("goblin", new Jaylib.Vector3(0, 0, 0));
            DrawGrid(20, 1.0f);
        EndMode3D();


        EndDrawing();
    }
}
