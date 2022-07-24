package org.laplace.systems.texturemanager;

import com.raylib.Raylib;

import java.util.HashMap;

import static com.raylib.Raylib.LoadTexture;

public class TextureManager {
    private HashMap<String, Raylib.Texture> textureHashMap;

    public TextureManager() {
        textureHashMap = new HashMap<String, Raylib.Texture>();

        this.LoadTexture("healthbar", "data/textures/healthbar/healthbar.png");
        this.LoadTexture("healthbarui", "data/textures/healthbar/healthbarui.png");
        this.LoadTexture("background", "data/shaders/defaultBackground/tex.png");
    }

    public void LoadTexture(String name, String path) {
        Raylib.Texture tex = Raylib.LoadTexture(path);
        textureHashMap.put(name, tex);
    }

    public Raylib.Texture GetTexture(String name) {
        return textureHashMap.get(name);
    }
}
