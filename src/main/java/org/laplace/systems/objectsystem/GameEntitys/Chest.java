package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;

public class Chest extends GameEntity {

    public Chest() {
        super("chest");
        this.setModelScale(0.015f);
        this.setModelOffset(new Jaylib.Vector3(0.0f, -1.0f,1.0f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);
    }
}
