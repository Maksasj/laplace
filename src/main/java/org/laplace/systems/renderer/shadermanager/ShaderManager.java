package org.laplace.systems.renderer.shadermanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.HashMap;

import static com.raylib.Jaylib.RAYWHITE;

public class ShaderManager {
    public HashMap<String, Raylib.Shader> shaders;

    public ShaderManager() {
        shaders = new HashMap<String, Raylib.Shader>();

        this.LoadShader("basePixelated", "target/shaders/defaultPixelated/base.vs", "target/shaders/defaultPixelated/base.fs");
    }

    public void LoadShader(String name, String fs, String vs) {
        Raylib.Shader shader = Raylib.LoadShader(fs, vs);
        shaders.put(name, shader);
    }

    public Raylib.Shader getShader(String name) {
        if(shaders.containsKey(name)) {
            return shaders.get(name);
        }
        return null;
    }

    public void ActivateShader(String name) {
        Raylib.BeginShaderMode(this.getShader(name));
    }

    public void DeactivateShader() {
        Raylib.EndShaderMode();
    }

}
