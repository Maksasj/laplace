package org.laplace.systems.objectsystem;

import com.raylib.Jaylib;

public class GameObject {
    private String name;

    public GameObject(String name) {
        this.name = name;
    }

    public void Update() {

    }

    public void Draw(Jaylib.Vector3 pos) {

    }

    public String getName() {
        return name;
    }
}
