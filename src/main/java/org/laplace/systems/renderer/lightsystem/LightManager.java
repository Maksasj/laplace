package org.laplace.systems.renderer.lightsystem;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.bytedeco.javacpp.Pointer;
import org.laplace.Game;

import static com.raylib.Raylib.*;

public class LightManager {
    final int maxLightCount = 16;

    private int lightCountUniform;

    private int[] lightsPosUniforms = new int[maxLightCount];
    private int[] lightsColorUniforms = new int[maxLightCount];
    private Light[] lights = new Light[maxLightCount];
    private float lightCount = 0;

    private String shaderName;

    public LightManager(String shaderName) {
        this.shaderName = shaderName;
        allocateUniforms();
    };

    public int addLight(Light newLight) {
        lights[(int) lightCount] = newLight;
        lightCount++;

        return ((int)lightCount - 1);
    }

    public int getLightCount() {
        return (int) lightCount;
    }

    public void allocateUniforms() {
        lightCountUniform = Game.getShaderManager().GetShaderLocation(shaderName, "lightCount");

        for(int x = 0; x < maxLightCount; x++) {
            lightsPosUniforms[x] = Game.getShaderManager().GetShaderLocation(shaderName, "lightPos["+x+"]");
            lightsColorUniforms[x] = Game.getShaderManager().GetShaderLocation(shaderName, "lightColor["+x+"]");
        }
    }

    public void updateLights() {
        Game.getShaderManager().SetShaderValue(shaderName, "lightCount", lightCountUniform, lightCount);
        System.out.println(lightCount);

        for(int x = 0; x < lightCount; x++) {
            Raylib.SetShaderValue(
                    Game.getShaderManager().getShader(shaderName),
                    lightsPosUniforms[x],
                    lights[x].pos,
                    SHADER_UNIFORM_VEC3);

            Raylib.SetShaderValue(
                    Game.getShaderManager().getShader(shaderName),
                    lightsColorUniforms[x],
                    lights[x].color,
                    SHADER_UNIFORM_VEC3);
        }
    }

    public void updateLight(int x) {
        Raylib.SetShaderValue(
                Game.getShaderManager().getShader(shaderName),
                lightsPosUniforms[x],
                lights[x].pos,
                SHADER_UNIFORM_VEC3);

        Raylib.SetShaderValue(
                Game.getShaderManager().getShader(shaderName),
                lightsColorUniforms[x],
                lights[x].color,
                SHADER_UNIFORM_VEC3);
    }

    public void setLight(int x, Light newLight) {
        lights[x] = newLight;
    }
}
