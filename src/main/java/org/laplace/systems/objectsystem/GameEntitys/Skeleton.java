package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;

public class Skeleton extends GameEntity {

    public Skeleton() {
        super("skeleton");
        this.setModelScale(0.01f);
        this.setModelOffset(new Jaylib.Vector3(0.4f, -1.0f,0.4f));
    }

}
