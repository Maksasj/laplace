package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;

public class Player extends GameEntity {

    public Player() {
        super("player");
        this.setModelScale(0.3f);
        this.setModelOffset(new Jaylib.Vector3(0.2f, 0.0f,0.2f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);
    }

}
