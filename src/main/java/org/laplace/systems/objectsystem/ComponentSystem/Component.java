package org.laplace.systems.objectsystem.ComponentSystem;

public class Component {
    private ComponentTypes type;

    public Component(ComponentTypes type) {
        this.type = type;
    }
    public void Update() {}
    public void Init() {}
    public void Draw() {}
    public void AskDependencies(ComponentBlock dependencies) {}
    public ComponentTypes GetType() {
        return type;
    }
}
