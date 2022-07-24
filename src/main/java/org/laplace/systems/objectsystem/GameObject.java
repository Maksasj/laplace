package org.laplace.systems.objectsystem;

import org.laplace.systems.objectsystem.ComponentSystem.ComponentBlock;

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
