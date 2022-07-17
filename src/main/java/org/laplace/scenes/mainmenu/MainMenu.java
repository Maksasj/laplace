package org.laplace.scenes.mainmenu;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.Main;
import org.laplace.scenes.ScenesGeneric;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.VIOLET;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.EndDrawing;

public class MainMenu extends ScenesGeneric {
    private RenderTexture target;

    private Texture texture;

    private float iTime = 0; //For now iTime used only with rendering
    private int shaderLoc;

    public MainMenu() {
        super(); //Parent constructor

        texture = LoadTexture("target/shaders/defaultBackground/tex.png");

        target = LoadRenderTexture(
                Game.getWindowWidth() / Game.pixelezationRate,
                Game.getWindowHeight() / Game.pixelezationRate);

        shaderLoc = Game.getShaderManager().GetShaderLocation("defaultBackground", "iTime");
        Game.getShaderManager().SetShaderValue("defaultBackground", "iTime", shaderLoc, iTime);
    }

    @Override
    public void Update() {
        if(IsKeyPressed(32)) {
            Game.setActiveScene(Game.GetGameScene());
        }

        iTime += 0.01;
        Game.getShaderManager().SetShaderValue("defaultBackground", "iTime", shaderLoc, iTime);
        UpdateCamera(Game.getCamera());
    }

    @Override
    public void Draw() {
            BeginTextureMode(target);
                ClearBackground(RAYWHITE);

                Game.getShaderManager().ActivateShader("defaultBackground");
                    DrawTexture(texture, 0, 0, RAYWHITE);
                Game.getShaderManager().DeactivateShader();
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
        EndDrawing();
    }
}
