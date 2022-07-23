package org.laplace.systems.objectsystem.ComponentSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComponentBlock {
    public HashMap<ComponentTypes, Component> components = new HashMap<>();

    public void addComponent(Component comp) {
        comp.AskDependencies(this);
        components.put(comp.GetType(), comp);
    }

    public void updateComponents() {
        for (Component comp : components.values()) {
            comp.Update();
        }
    }

    public void drawComponents() {
        for (Component comp : components.values()) {
            comp.Draw();
        }
    }
}
