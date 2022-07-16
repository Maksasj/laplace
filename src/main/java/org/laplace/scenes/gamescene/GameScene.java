package org.laplace.scenes.gamescene;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.systems.modelmanager.ModelManager;
import org.laplace.systems.worldsystem.GameWorld;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class GameScene extends ScenesGeneric {
    private Raylib.RenderTexture target; //Rendering target

    private float iTime = 0; //For now i used only with rendering
    private int shaderLoc;
    private Texture texture;
    
    private GameWorld gameWorld;

    public GameScene() {
        super(); //Parent constructor

        target = LoadRenderTexture(
                Game.getWindowWidth() / Game.pixelezationRate,
                Game.getWindowHeight() / Game.pixelezationRate);

        gameWorld = new GameWorld();

        texture = LoadTexture("target/shaders/defaultBackground/tex.png");

        shaderLoc = Game.getShaderManager().GetShaderLocation("defaultBackground", "iTime");
        Game.getShaderManager().SetShaderValue("defaultBackground", "iTime", shaderLoc, iTime);
    }

    @Override
    public void Update() {
        iTime += 0.01;
        Game.getShaderManager().SetShaderValue("defaultBackground", "iTime", shaderLoc, iTime);
        //UpdateCamera(Game.getCamera());
    }

    @Override
    public void Draw() {


        BeginTextureMode(target);
            Game.getShaderManager().ActivateShader("defaultBackground");
                DrawTexture(texture, 0, 0, RAYWHITE);
            Game.getShaderManager().DeactivateShader();

            BeginMode3D(Game.getCamera()); //Scope for 3d stuff
                gameWorld.Draw(0, 0);
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
