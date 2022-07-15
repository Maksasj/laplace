package org.laplace.scenes.gamescene;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.systems.modelmanager.ModelManager;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class GameScene extends ScenesGeneric {
    Raylib.RenderTexture target;

    public GameScene() {
        super(); //Parent constructor

        target = LoadRenderTexture(
                Game.getWindowWidth() / Game.pixelezationRate,
                Game.getWindowHeight() / Game.pixelezationRate);
    }

    @Override
    public void Update() {
        UpdateCamera(Game.getCamera());
    }

    @Override
    public void Draw() {

        BeginTextureMode(target);
            BeginMode3D(Game.getCamera()); //Scope for 3d stuff
                ClearBackground(RAYWHITE);
                Game.getModelManager().DrawModel("goblin", new Jaylib.Vector3(0, 0, 0));
            EndMode3D();
        EndTextureMode();

        BeginDrawing();
                Game.getShaderManager().ActivateShader("basePixelated"); // Render generated texture using selected postprocessing shader
                    SetTextureWrap(target.texture(), 1);
                    DrawTextureEx(target.texture(), new Jaylib.Vector2(Game.getWindowWidth() , Game.getWindowHeight()), 180, Game.getPixelezationRate(), RAYWHITE);
                Game.getShaderManager().DeactivateShader();
        EndDrawing();
    }
}
