package org.laplace.systems.renderer.shadermanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.Pointer;

import java.util.HashMap;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.SHADER_UNIFORM_FLOAT;
import static com.raylib.Raylib.SHADER_UNIFORM_VEC2;

public class ShaderManager {
    public HashMap<String, Raylib.Shader> shaders;

    public ShaderManager() {
        shaders = new HashMap<String, Raylib.Shader>();

        this.LoadShader("basePixelated", "target/shaders/defaultPixelated/base.vs", "target/shaders/defaultPixelated/base.fs");
        this.LoadShader("defaultBackground", "target/shaders/defaultBackground/base.vs", "target/shaders/defaultBackground/base.fs");
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

    public int GetShaderLocation(String name, String arg) {
        return Raylib.GetShaderLocation(getShader(name), arg);
    }

    public void SetShaderValue(String name, String args, float value) {
        Pointer val = new FloatPointer(value);
        Raylib.SetShaderValue(this.getShader(name), this.GetShaderLocation(name, args), val, SHADER_UNIFORM_FLOAT);
        val.close();
    }

    public void SetShaderValue(String name, String args, int loc, float value) {
        Pointer val = new FloatPointer(value);
        Raylib.SetShaderValue(this.getShader(name), loc, val, SHADER_UNIFORM_FLOAT);
        val.close();
    }
}
