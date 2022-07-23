package org.laplace;

import org.laplace.scenes.ScenesGeneric;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.scenes.mainmenu.MainMenu;

public class SceneManager {
    public static ScenesGeneric activeScene;
    public static ScenesGeneric gameScene;
    public static ScenesGeneric mainmenuScene;

    public void CreateScenes() {
        gameScene = new GameScene();
        mainmenuScene = new MainMenu();

        Game.setActiveScene(Game.GetMainMenu());
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
}
