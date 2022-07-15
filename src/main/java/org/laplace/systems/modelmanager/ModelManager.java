package org.laplace.systems.modelmanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.HashMap;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.WHITE;

public class ModelManager {
    public HashMap<String, Raylib.Model> models;

    public ModelManager() {
        models = new HashMap<String, Raylib.Model>();
    }

    public void LoadModel(String name, String path) {
        Raylib.Model tower = Raylib.LoadModel(path);
    }

    public Raylib.Model getModel(String name) {
        if(models.containsKey(name)) {
            return models.get(name);
        }
        return null;
    }

    public void DrawModel(String name, Jaylib.Vector3 pos) {
        Raylib.DrawModel(getModel(name), pos, 1.0f, RAYWHITE);
    }
}
