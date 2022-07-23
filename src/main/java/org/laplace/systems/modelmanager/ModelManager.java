package org.laplace.systems.modelmanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.laplace.Game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.LoadModelFromMesh;
import static com.raylib.Raylib.LoadTexture;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ModelManager {
    public HashMap<String, Raylib.Model> models;

    public ModelManager() {
        models = new HashMap<String, Raylib.Model>();

        this.LoadModel("goblin", "data/models/goblin/scene.gltf");
        this.LoadModel("skeleton", "data/models/skeleton/scene.gltf");
        this.LoadModel("chest", "data/models/chest/scene.gltf");
        this.LoadModel("player", "data/models/knight/scene.gltf");
        this.LoadModel("spider", "data/models/spider/scene.gltf");

        this.LoadModel("torch", "data/models/torch/scene.gltf");

        this.LoadModel("door", "data/models/door/scene.gltf");

        this.LoadModel("dice6", "data/models/dice6/scene.gltf");
    }

    public void LoadModel(String name, String path) {
        //Raylib.Model model = Raylib.LoadModel(path);
        //models.put(name, model);
        models.put(name, LoadModelFromFile(path, "defaultLight"));
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

    private Raylib.Model LoadModelFromFile(String path, String shader) {
        Raylib.Model model = LoadModelFromMesh(Raylib.LoadModel(path).meshes());

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray images = (JSONArray) jsonParser.parse(jsonObject.get("images").toString());

            String texturePath = (((JSONObject) images.get(0)).get("uri")).toString();
            Raylib.Texture texture = LoadTexture(trimFromBack( path,"/")+"/"+texturePath);    // Load map texture

            model.materials().maps().texture(texture);
            model.materials().shader(Game.getShaderManager().getShader(shader));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return model;
    }

    private String trimFromBack(String input, String Sym) {
        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1.reverse();
        StringBuilder s1 = new StringBuilder((input1.substring(input1.indexOf(Sym) + 1)).trim());
        s1.reverse();

        return s1.toString();
    }
}
