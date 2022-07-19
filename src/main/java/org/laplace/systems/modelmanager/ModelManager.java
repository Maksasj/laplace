package org.laplace.systems.modelmanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.systems.renderer.shadermanager.ShaderManager;

import java.util.HashMap;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.LoadModelFromMesh;
import static com.raylib.Raylib.LoadTexture;

public class ModelManager {
    public HashMap<String, Raylib.Model> models;

    public ModelManager() {
        models = new HashMap<String, Raylib.Model>();

        this.LoadModel("goblin", "data/models/goblin/scene.gltf");
        this.LoadModel("skeleton", "datamodels/skeleton/scene.gltf");
        this.LoadModel("chest", "data/models/chest/scene.gltf");
        this.LoadModel("player", "data/models/knight/scene.gltf");
        this.LoadModel("spider", "data/models/spider/scene.gltf");

        this.LoadModel("door", "data/models/door/scene.gltf");

        this.LoadModel("dice6", "data/models/dice6/scene.gltf");
    }

    public void LoadModel(String name, String path) {
        Raylib.Model model = Raylib.LoadModel(path);

        if(name.equals("player")) {
            /*
            System.out.println("LOADING PLAYER MESH");

            Raylib.Mesh mesh = model.meshes();
            Raylib.Model m = LoadModelFromMesh(mesh);
            Raylib.Texture texture = LoadTexture("data/models/knight/textures/Plane_0_baseColor.png");    // Load map texture
            m.materials().maps().texture(texture);
            m.materials().shader(Game.getShaderManager().getShader("defaultLight"));
            */
            models.put(name, LoadModelFromFile(path));
        } else {
            model.materials().shader(Game.getShaderManager().getShader("defaultLight"));
            models.put(name, model);
        }
    }

    public Raylib.Model getModel(String name) {
        if(models.containsKey(name)) {
            return models.get(name);
        }
        return null;
    }

    public void DrawModel(String name, Jaylib.Vector3 pos, float scale, Jaylib.Vector3 rotAxis, float rot) {
        Raylib.Shader temp = getModel(name).materials().shader();
        getModel(name).materials().shader(Game.getShaderManager().getShader("defaultLight"));
        Raylib.DrawModelEx(getModel(name), pos, rotAxis,rot, new Jaylib.Vector3(scale, scale, scale), RAYWHITE);
        getModel(name).materials().shader(temp);

    }

    private Raylib.Model LoadModelFromFile(String path) {
        Raylib.Model model = Raylib.LoadModel(path);

        Raylib.Mesh mesh = model.meshes();
        Raylib.Model m = LoadModelFromMesh(mesh);
        Raylib.Texture texture = LoadTexture("data/models/knight/textures/Plane_0_baseColor.png");    // Load map texture
        m.materials().maps().texture(texture);
        m.materials().shader(Game.getShaderManager().getShader("defaultLight"));

        return m;
    }
}
