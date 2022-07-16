package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;

public class Skeleton extends GameEntity {

    public Skeleton(int x, int y) {
        super("skeleton");
        setHealth(20);
        setDamage(6);

        this.x = x;
        this.y = y;

        this.setModelScale(0.01f);
        this.setModelOffset(new Jaylib.Vector3(0.0f, -1.0f,0.0f));
    }

}
