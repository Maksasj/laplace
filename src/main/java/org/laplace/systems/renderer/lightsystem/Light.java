package org.laplace.systems.renderer.lightsystem;

import com.raylib.Jaylib;

public class Light {
    public Jaylib.Vector3 pos;
    public Jaylib.Vector3 color;

    public Light(Jaylib.Vector3 pos, Jaylib.Vector3 color) {
        this.pos = pos;
        this.color = color;
    }
}
