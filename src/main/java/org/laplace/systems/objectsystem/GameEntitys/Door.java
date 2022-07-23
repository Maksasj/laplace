package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Health;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Model3D;
import org.laplace.systems.objectsystem.GameEntity;

public class Door extends GameEntity {

    public Door(int x, int y) {
        super("door");

        this.x = x;
        this.y = y;

        components.addComponent(new Health(this, 20));
        components.addComponent(
                new Model3D(this, "door")
                        .setModelScale(0.4f)
                        .setModelOffset(new Jaylib.Vector3(0.0f, 0.0f,0.0f))
                        .setRotAxis(new Jaylib.Vector3(0.0f, 0.0f, 0.0f))
                        .setRot(0));
    }
}
