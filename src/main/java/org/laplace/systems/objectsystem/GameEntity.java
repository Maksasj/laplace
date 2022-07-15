package org.laplace.systems.objectsystem;

public class GameEntity extends GameObject{

    public GameEntity(String name) {
        super(name);
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw() {
        model.draw()
    }
}
