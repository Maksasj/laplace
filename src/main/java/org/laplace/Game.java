package org.laplace;

import com.raylib.Raylib;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.scenes.mainmenu.MainMenu;
import org.laplace.systems.modelmanager.ModelManager;
import org.laplace.systems.renderer.shadermanager.ShaderManager;
import org.laplace.systems.soundmanager.SoundManager;
import org.laplace.systems.texturemanager.TextureManager;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.CloseWindow;

public class Game {
    private static int windowWidth = 1280;
    private static int windowHeight = 720;

    public static int pixelezationRate = 4;
    private static Raylib.Camera3D camera;
    private boolean gameRunning;
    private static ModelManager modelManager;
    private static ShaderManager shaderManager;
    private static TextureManager textureManager;


    private static SoundManager soundManager;


    private static ScenesGeneric activeScene;
    private static ScenesGeneric gameScene;
    private static ScenesGeneric mainmenuScene;

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

        gameScene = new GameScene();
        mainmenuScene = new MainMenu();

        soundManager = new SoundManager();
        
        Game.setActiveScene(Game.GetMainMenu());
    }

    public static void GameRestart() {
        gameScene = new GameScene();

        Game.setActiveScene(GetMainMenu());
    }

    //Main game loop
    public void run() {
        while (!WindowShouldClose()) {
            activeScene.Update();
            activeScene.Draw();
        }

        CloseWindow();
    }

    public static ScenesGeneric GetMainMenu() {
        return mainmenuScene;
    }

    public static ScenesGeneric GetGameScene() {
        return gameScene;
    }

    public static void setActiveScene(ScenesGeneric value) {
        activeScene = value;
    }

    public static SoundManager getSoundManager() {
        return soundManager;
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
