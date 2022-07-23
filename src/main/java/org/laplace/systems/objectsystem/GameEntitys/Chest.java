package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;

public class Chest extends GameEntity {

    public Chest(int x, int y) {
        super("chest");
        setHealth(20, 20);

        this.x = x;
        this.y = y;

        this.setModelScale(0.015f);
        this.setModelOffset(new Jaylib.Vector3(0.0f, -1.0f,1.0f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);

        this.setPos(new Jaylib.Vector3(this.x, 0.0f, this.y));
    }
}
