package org.laplace.scenes.gamescene;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Dice.Dice;
import org.laplace.Game;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.systems.worldsystem.GameWorld;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class GameScene extends ScenesGeneric {
    private Raylib.RenderTexture target; //Rendering target

    private static Dice mainDice = new Dice();
    private static Dice leftDice = new Dice(0, -2.5f);
    private static Dice rightDice = new Dice(0, 2.5f);
    private float iTime = 0; //For now iTime used only with rendering
    private int shaderLoc;
    private Texture texture;

    public static GameWorld gameWorld;

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
        gameWorld.Update();
        Game.getShaderManager().SetShaderValue("defaultBackground", "iTime", shaderLoc, iTime);
        UpdateCamera(Game.getCamera());
    }

    public static Dice getMainDice() {
        return mainDice;
    }

    public static Dice getLeftDice() {
        return leftDice;
    }

    public static Dice getRightDice() {
        return rightDice;
    }

    @Override
    public void Draw() {
        BeginTextureMode(target);
            ClearBackground(RAYWHITE);

            Game.getShaderManager().ActivateShader("defaultBackground");
                DrawTexture(texture, 0, 0, RAYWHITE);
            Game.getShaderManager().DeactivateShader();

            Game.getShaderManager().ActivateShader("defaultLight");
                BeginMode3D(Game.getCamera()); //Scope for 3d stuff
                    gameWorld.Draw();
                EndMode3D();

                BeginMode3D(mainDice.GetCamera());
                    mainDice.Draw();
                    leftDice.Draw();
                    rightDice.Draw();
                EndMode3D();
            Game.getShaderManager().DeactivateShader();
        EndTextureMode();

        BeginDrawing();
                Game.getShaderManager().ActivateShader("basePixelated"); // Render generated texture using selected postprocessing shader
                    SetTextureWrap(target.texture(), 1);
                    DrawTextureEx(target.texture(), new Jaylib.Vector2(Game.getWindowWidth() , Game.getWindowHeight()), 180, Game.getPixelezationRate(), RAYWHITE);
                Game.getShaderManager().DeactivateShader();

                DrawFPS(20, 20);
        EndDrawing();
    }
}
