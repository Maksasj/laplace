package org.laplace.systems.texturemanager;

import com.raylib.Raylib;

import java.util.HashMap;

public class TextureManager {
    private HashMap<String, Raylib.Texture> textureHashMap;

    public TextureManager() {
        textureHashMap = new HashMap<String, Raylib.Texture>();

        this.LoadTexture("healthbar", "target/textures/healthbar/healthbar.png");
    }

    public void LoadTexture(String name, String path) {
        Raylib.Texture tex = Raylib.LoadTexture(path);
        textureHashMap.put(name, tex);
    }

    public Raylib.Texture GetTexture(String name) {
        return textureHashMap.get(name);
    }
}
