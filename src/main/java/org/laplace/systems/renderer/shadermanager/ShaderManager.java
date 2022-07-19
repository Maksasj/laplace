package org.laplace.systems.renderer.shadermanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.Pointer;

import java.util.HashMap;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class ShaderManager {
    public HashMap<String, Raylib.Shader> shaders;

    public ShaderManager() {
        shaders = new HashMap<String, Raylib.Shader>();

        this.LoadShader("basePixelated", "data/shaders/defaultPixelated/base.vs", "data/shaders/defaultPixelated/base.fs");
        this.LoadShader("defaultBackground", "data/shaders/defaultBackground/base.vs", "data/shaders/defaultBackground/base.fs");
        this.LoadShader("defaultLight", "data/shaders/defaultLight/base.vs", "data/shaders/defaultLight/base.fs");
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

    public void SetShaderValueVec3(String name, String args, int loc, Jaylib.Vector3 value) {
        Raylib.SetShaderValue(this.getShader(name), loc, value, SHADER_UNIFORM_VEC3);
    }
}
