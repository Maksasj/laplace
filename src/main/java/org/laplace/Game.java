package org.laplace;

import com.raylib.Raylib;
import org.laplace.Dice.Dice;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.scenes.mainmenu.MainMenu;
import org.laplace.systems.modelmanager.ModelManager;
import org.laplace.systems.renderer.shadermanager.ShaderManager;
import org.laplace.systems.texturemanager.TextureManager;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.VIOLET;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.CloseWindow;

public class Game {
    private static int windowWidth = 1280;
    private static int windowHeight = 720;

    public static int pixelezationRate = 1;
    private static Raylib.Camera3D camera;
    private boolean gameRunning;
    private static ModelManager modelManager;
    private static ShaderManager shaderManager;
    private static TextureManager textureManager;
    private static ScenesGeneric activeScene;

    //Game constructor
    public Game() {
        InitWindow(windowWidth, windowHeight, "Laplace");
        SetTargetFPS(60);

        camera = new Raylib.Camera3D();
        SetCameraMode(camera, CAMERA_ORBITAL);

        gameRunning = true;

        shaderManager = new ShaderManager();
        modelManager = new ModelManager();
        textureManager = new TextureManager();

        activeScene = new GameScene();
    }

    //Main game loop
    public void run() {
        while (gameRunning) {
            activeScene.Update();
            activeScene.Draw();
        }

        CloseWindow();
    }

    public static TextureManager getTextureManager() {
        return textureManager;
    }
    public void handleDrawing() {
        activeScene.Draw();
    }

    public void setGameRunning(boolean value) {
        gameRunning = value;
    }

    public void close() {
        setGameRunning(false);
    }

    public static Raylib.Camera3D getCamera() {
        return camera;
    }

    public static ModelManager getModelManager() {
        return modelManager;
    }

    public static ShaderManager getShaderManager() {
        return shaderManager;
    }

    public Game getInstance() {
        return this;
    }

    public static int getWindowWidth() {
        return windowWidth;
    }
    public static int getWindowHeight() {
        return windowHeight;
    }
    public static int getPixelezationRate() {
        return pixelezationRate;
    }
}
