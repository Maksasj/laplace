package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;

public class Goblin extends GameEntity {

    public Goblin(int x, int y) {
        super("goblin");

        this.x = x;
        this.y = y;

        this.setPos(new Jaylib.Vector3(this.x, 0.0f, this.y));
    }
}
