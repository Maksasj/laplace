package org.laplace;

import com.raylib.Raylib;
import org.laplace.scenes.ScenesGeneric;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.scenes.mainmenu.MainMenu;
import org.laplace.systems.eventsystem.EventHandler;
import org.laplace.systems.eventsystem.events.PlayerMoveEvent;
import org.laplace.systems.fontmanager.FontManager;
import org.laplace.systems.modelmanager.ModelManager;
import org.laplace.systems.renderer.shadermanager.ShaderManager;
import org.laplace.systems.soundmanager.SoundManager;
import org.laplace.systems.texturemanager.TextureManager;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.CloseWindow;

public class Game extends SceneManager {
    private static int windowWidth = 1280;
    private static int windowHeight = 720;

    public static int pixelezationRate = 4;
    private static Raylib.Camera3D camera;
    private static ModelManager modelManager;
    private static ShaderManager shaderManager;
    private static TextureManager textureManager;

    private static SoundManager soundManager;

    private static EventHandler eventHandler;

    private static FontManager fontManager;

    //Game constructor
    public Game() {
        InitWindow(windowWidth, windowHeight, "Laplace");
        SetTargetFPS(60);

        camera = new Raylib.Camera3D();
        SetCameraMode(camera, CAMERA_ORBITAL);

        eventHandler = new EventHandler();

        shaderManager = new ShaderManager();
        modelManager = new ModelManager();
        textureManager = new TextureManager();
        soundManager = new SoundManager();
        fontManager = new FontManager();

        this.CreateScenes();
    }

    public static void GameRestart() {
        gameScene = new GameScene();

        setActiveScene(GetMainMenu());
    }

    public static FontManager GetFontManager() {
        return fontManager;
    }

    public static EventHandler GetEventHandler() {
        return eventHandler;
    }

    //Main game loop
    public void run() {
        while (!WindowShouldClose()) {
            activeScene.Update();
            activeScene.Draw();
        }

        CloseWindow();
    }

    public static SoundManager getSoundManager() {
        return soundManager;
    }

    public static TextureManager getTextureManager() {
        return textureManager;
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
