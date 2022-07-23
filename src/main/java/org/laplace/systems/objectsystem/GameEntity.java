package org.laplace.systems.objectsystem;

import javax.swing.text.html.parser.Entity;

public class GameEntity extends GameObject {
    private GameEntityTypes type;
    public int x = 0; //Relative to world cords
    public int y = 0; //Relative to world cords

    public GameEntity(String name, GameEntityTypes type) {
        super(name);
        this.type = type;
    }

    @Override
    public void Update() {
        components.updateComponents();
    }

    @Override
    public void Draw() {
        components.drawComponents();
    }

    public GameEntityTypes getType() {
        return type;
    }
}
