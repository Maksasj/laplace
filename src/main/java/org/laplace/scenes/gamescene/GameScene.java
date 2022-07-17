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

    public static int pHealth = 1;
    public static int pMaxHealth = 1;

    private boolean playerDied = false;
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

            /*
        DrawTextureEx(
                Game.getTextureManager().GetTexture("healthbarui"), //Red thing
                new Jaylib.Vector2(105.0f, 160.0f),
                0.0f,
                0.5f,
                RAYWHITE);

             */

        DrawTexturePro(
                Game.getTextureManager().GetTexture("healthbarui"), //Red thing
                new Jaylib.Rectangle(
                    0.0f,
                    0.0f,
                        220,
                        40),
                new Jaylib.Rectangle(
                        0.0f,
                        0.0f,
                        110 * ((float) pHealth / pMaxHealth), //TODO fix healthbar gui
                        20),
                new Jaylib.Vector2(-105.0f, -160.0f),
                0,
                RAYWHITE
        );

        DrawTextureEx(
                Game.getTextureManager().GetTexture("healthbar"),
                new Jaylib.Vector2(105.0f, 160.0f),
                0.0f,
                0.5f,
                RAYWHITE);

        Raylib.DrawText("STR",
                10,
                160,
                10,
                RAYWHITE);

        Raylib.DrawText("DEF",
                290,
                160,
                10,
                RAYWHITE);


        EndTextureMode();

        BeginDrawing();
                Game.getShaderManager().ActivateShader("basePixelated"); // Render generated texture using selected postprocessing shader
                    SetTextureWrap(target.texture(), 1);


                    DrawTexturePro(
                            target.texture(),
                            new Jaylib.Rectangle(
                                    0,
                                    0,
                                    Game.getWindowWidth() / Game.pixelezationRate,
                                    -Game.getWindowHeight() / Game.pixelezationRate),
                            new Jaylib.Rectangle(
                                    0,
                                    0,
                                    Game.getWindowWidth(),
                                    Game.getWindowHeight()),
                            new Jaylib.Vector2(0.0f, 0.0f),
                            0,
                            RAYWHITE);

                Game.getShaderManager().DeactivateShader();

                //DrawFPS(20, 20);
        EndDrawing();
    }
    
    public static void playerDied() {
        this.playerDied = true;
    }
}
