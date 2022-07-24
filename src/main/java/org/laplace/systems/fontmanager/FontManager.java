package org.laplace.systems.fontmanager;

import com.raylib.Raylib;

import java.util.HashMap;

import static com.raylib.Raylib.LoadFont;

public class FontManager {

    private HashMap<String, Raylib.Font> fontHashMap = new HashMap<>();

    public FontManager() {
        fontHashMap = new HashMap<String, Raylib.Font>();

        this.AddFont("playerDeath", "data/fonts/deathFont.ttf");
    }

    public void AddFont(String name, String path) {
        Raylib.Font font = LoadFont(path);
        fontHashMap.put(name, font);
    }

    public Raylib.Font GetFont(String name) {
        return fontHashMap.get(name);
    }
}
