package org.laplace.scenes.gamescene;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Dice.Dice;
import org.laplace.Game;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.systems.worldsystem.GameWorld;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.DrawTextEx;

public class GameScene extends ScenesGeneric {
    private Raylib.RenderTexture target; //Rendering target

    private static Dice mainDice = new Dice();
    private static Dice leftDice = new Dice(0, -2.5f);
    private static Dice rightDice = new Dice(0, 2.5f);
    private float iTime = 0; //For now iTime used only with rendering
    private int shaderLoc;
    private Texture texture;

    public GameWorld gameWorld;

    public static int pHealth = 1;
    public static int pMaxHealth = 1;

    private static boolean playerDied = false;
    private float playerDeathTint = 1.0f;

    private int shaderLocPlayerDeathTint;

    private Font font;

    public GameScene() {
        super(); //Parent constructor

        target = LoadRenderTexture(
                Game.getWindowWidth() / Game.pixelezationRate,
                Game.getWindowHeight() / Game.pixelezationRate);

        gameWorld = new GameWorld();

        texture = LoadTexture("target/shaders/defaultBackground/tex.png");

        shaderLoc = Game.getShaderManager().GetShaderLocation("defaultBackground", "iTime");
        Game.getShaderManager().SetShaderValue("defaultBackground", "iTime", shaderLoc, iTime);

        shaderLocPlayerDeathTint = Game.getShaderManager().GetShaderLocation("basePixelated", "playertint");
        Game.getShaderManager().SetShaderValue("basePixelated", "playertint", shaderLocPlayerDeathTint, playerDeathTint);

        font = LoadFont("target/fonts/deathFont.ttf");

        System.out.println("CALLING CONSTRUCTOR");

        playerDied = false;
    }

    public void ResetScene() {
        playerDied = false;
        mainDice = new Dice();
        rightDice = new Dice(0, 2.5f);
        leftDice = new Dice(0, -2.5f);

        target = LoadRenderTexture(
                Game.getWindowWidth() / Game.pixelezationRate,
                Game.getWindowHeight() / Game.pixelezationRate);

        pHealth = 1;
        pMaxHealth = 1;

        gameWorld = new GameWorld();

        mainDice = new Dice();
        leftDice = new Dice(0, -2.5f);
        rightDice = new Dice(0, 2.5f);
    }

    @Override
    public void Update() {
        if(!playerDied) {
            iTime += 0.01;
            gameWorld.Update();
            Game.getShaderManager().SetShaderValue("defaultBackground", "iTime", shaderLoc, iTime);
        } else {
            if(playerDeathTint > 0.5f) {
                playerDeathTint -= 0.05f;
            }

            Game.getShaderManager().SetShaderValue("basePixelated", "playertint", shaderLocPlayerDeathTint, playerDeathTint);

            if(IsKeyPressed(32)) {
                System.out.println("PRESSIGN SPACE");

                ResetScene();
                Game.GameRestart();
            }
        }
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
                DrawFPS(20, 20);

                if(playerDied) {
                    DrawTextEx(
                            font,
                            "YOU DIED",
                            new Jaylib.Vector2(350.0f, 120.0f),
                            250,
                            1,
                            new Jaylib.Color(255, 0, 0, 255*((int)(1.5 - playerDeathTint))));

                    DrawText(
                            "press space to begin",
                            500,
                            600,
                            25,
                            new Jaylib.Color(
                                    255,
                                    255,
                                    255,
                                    150*((int)(1.5 - playerDeathTint))
                            ));
                }

        EndDrawing();
    }
    public static void playerDied() {
        playerDied = true;
    }
}
