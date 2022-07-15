package org.laplace.systems.modelmanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.HashMap;

import static com.raylib.Jaylib.RAYWHITE;

public class ModelManager {
    public HashMap<String, Raylib.Model> models;

    public ModelManager() {
        models = new HashMap<String, Raylib.Model>();

        this.LoadModel("goblin", "target/models/goblin/scene.gltf");
    }

    public void LoadModel(String name, String path) {
        Raylib.Model model = Raylib.LoadModel(path);
        models.put(name, model);
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
