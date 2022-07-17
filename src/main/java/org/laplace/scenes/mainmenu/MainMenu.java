package org.laplace.scenes.mainmenu;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Dice.Dice;
import org.laplace.Game;
import org.laplace.Main;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.systems.modelmanager.ModelManager;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.VIOLET;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.EndDrawing;

public class MainMenu extends ScenesGeneric {
    private RenderTexture target;

    public Raylib.Camera3D camera;
    private Texture texture;

    private float iTime = 0; //For now iTime used only with rendering
    private int shaderLoc;

    public int cubicSpin = 0;

    public MainMenu() {
        super(); //Parent constructor

        camera = new Raylib.Camera3D()
                ._position( new Jaylib.Vector3( 9.0f, 0.0f,  0.0f))
                .target(    new Jaylib.Vector3(0.0f, 0.0f, 0.0f))
                .up(        new Raylib.Vector3().x(0.0f).y(1.0f).z(0.0f))
                .fovy(45)
                .projection(CAMERA_PERSPECTIVE);

        SetCameraMode(camera, CAMERA_CUSTOM);

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

        cubicSpin++;
    }

    @Override
    public void Draw() {
            BeginTextureMode(target);
                ClearBackground(RAYWHITE);

                Game.getShaderManager().ActivateShader("defaultBackground");
                    DrawTexture(texture, 0, 0, RAYWHITE);
                Game.getShaderManager().DeactivateShader();

                Game.getShaderManager().ActivateShader("defaultLight");
                    BeginMode3D(camera);
                        camera.
                            _position( new Jaylib.Vector3( 9.0f, 0.0f,  0.0f))
                            .target(    new Jaylib.Vector3(0.0f, 0.0f, 0.0f))
                            .up(        new Raylib.Vector3().x(0.0f).y(1.0f).z(0.0f))
                            .fovy(45)
                            .projection(CAMERA_PERSPECTIVE);

                        Game.getModelManager().DrawModel(
                                "dice6",
                                new Jaylib.Vector3(
                                        0,
                                        -1.5f,
                                        -3
                                ),
                                1.25f,
                                new Jaylib.Vector3(1.0f, 1.0f, 1.0f),
                                cubicSpin
                        );

                        Game.getModelManager().DrawModel(
                                "player",
                                new Jaylib.Vector3(
                                        4,
                                        -3.25f,
                                        3.25f
                                ),
                                1.0f,
                                new Jaylib.Vector3(-1.0f, 1.0f, 1.0f),
                                150
                        );

                    EndMode3D();
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
