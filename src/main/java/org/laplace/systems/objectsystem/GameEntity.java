package org.laplace.systems.objectsystem;

import com.raylib.Jaylib;
import org.laplace.Game;

public class GameEntity extends GameObject{
    private Jaylib.Vector3 pos;

    public GameEntity(String name) {
        super(name);
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw() {
        Game.getModelManager().DrawModel(this.getName(), pos);
    }

    public void setPos(Jaylib.Vector3 pos) {
        this.pos = pos;
    }
}
