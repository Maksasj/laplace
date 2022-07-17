package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;

public class TurnedDoor extends GameEntity {

    public TurnedDoor(int x, int y) {
        super("door");
        setHealth(20, 20);

        this.x = x;
        this.y = y;

        this.setModelScale(0.4f);
        this.setModelOffset(new Jaylib.Vector3(0.0f, 0.0f,0.0f));
        this.setRotAxis(new Jaylib.Vector3(0.0f, 1.0f, 0.0f));
        this.setRot(90);
    }
}
