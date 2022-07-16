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
        this.LoadModel("skeleton", "target/models/skeleton/scene.gltf");
        this.LoadModel("chest", "target/models/chest/scene.gltf");
        this.LoadModel("player", "target/models/knight/scene.gltf");
        this.LoadModel("spider", "target/models/spider/scene.gltf");

        this.LoadModel("dice6", "target/models/dice6/scene.gltf");
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

    public void DrawModel(String name, Jaylib.Vector3 pos, float scale, Jaylib.Vector3 rotAxis, float rot) {
        Raylib.DrawModelEx(getModel(name), pos, rotAxis,rot, new Jaylib.Vector3(scale, scale, scale), RAYWHITE);
    }
}
