package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;

public class Spider extends GameEntity {

    public Spider(int x, int y) {
        super("spider");

        this.x = x;
        this.y = y;

        this.setModelScale(0.2f);
        this.setModelOffset(new Jaylib.Vector3(0.2f, -0.5f,0.2f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);
    }
}
