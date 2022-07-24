package org.laplace.scenes.mainmenu;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.ComponentSystem.Components.CameraComponent;
import org.laplace.systems.objectsystem.ComponentSystem.Components.CameraControl;
import org.laplace.systems.objectsystem.ComponentSystem.Components.RenderTarget;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Timer;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.EndDrawing;

public class MainMenu extends ScenesGeneric {
    public MainMenu() {
        super(); //Parent constructor

        components.addComponent(new RenderTarget());
        components.addComponent(new CameraComponent()
                .SetPosition(new Jaylib.Vector3( 9.0f, 0.0f,  0.0f))
                .SetTarget(new Jaylib.Vector3(0.0f, 0.0f, 0.0f))
                .SetUp(new Jaylib.Vector3(0.0f, 1.0f, 0.0f))
                .SetFovy(45)
                .SetProjection(CAMERA_PERSPECTIVE)
                .SetCameraCompMode(CAMERA_CUSTOM));
        components.addComponent(new Timer("defaultBackground", "iTime"));
    }

    @Override
    public void Update() {
        if(IsKeyPressed(32)) {
            Game.setActiveScene(Game.GetGameScene());
        }

        UpdateCamera(Game.getCamera());
        components.updateComponents();
    }

    @Override
    public void Draw() {
        components.drawComponents();
            BeginTextureMode(((RenderTarget) components.components.get(ComponentTypes.RENDER_TARGET)).GetTarget());
                ClearBackground(RAYWHITE);

                Game.getShaderManager().ActivateShader("defaultBackground");
                    DrawTexture(Game.getTextureManager().GetTexture("background"), 0, 0, RAYWHITE);
                Game.getShaderManager().DeactivateShader();

                Game.getShaderManager().ActivateShader("defaultLight");
                    BeginMode3D(((CameraComponent) components.components.get(ComponentTypes.CAMERA)).GetCamera());
                        Game.getModelManager().DrawModel("dice6",new Jaylib.Vector3(0,-1.5f,-3),1.25f,new Jaylib.Vector3(1.0f, 1.0f, 1.0f),
                                ((Timer) components.components.get(ComponentTypes.TIMER)).GetTime() );
                        Game.getModelManager().DrawModel("player",new Jaylib.Vector3(4,-3.25f,3.25f),1.0f,new Jaylib.Vector3(-1.0f, 1.0f, 1.0f),150);
                    EndMode3D();
                Game.getShaderManager().DeactivateShader();
            EndTextureMode();

            BeginDrawing();
                Game.getShaderManager().ActivateShader("basePixelated"); // Render generated texture using selected postprocessing shader

                DrawTexturePro(
                        ((RenderTarget) components.components.get(ComponentTypes.RENDER_TARGET)).GetTarget().texture(),
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
