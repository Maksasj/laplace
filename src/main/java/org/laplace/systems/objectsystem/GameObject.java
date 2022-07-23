package org.laplace.systems.objectsystem;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentBlock;

import java.util.ArrayList;
import java.util.List;

public class GameObject {
    private String name;
    public ComponentBlock components;

    public GameObject(String name) {
        components = new ComponentBlock();
        this.name = name;
    }

    public void Update() { }

    public void Draw() { }

    public String getName() {
        return name;
    }
}
