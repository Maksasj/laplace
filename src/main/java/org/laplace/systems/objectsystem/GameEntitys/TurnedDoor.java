package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Health;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Model3D;
import org.laplace.systems.objectsystem.GameEntity;

public class TurnedDoor extends GameEntity {

    public TurnedDoor(int x, int y) {
        super("door");

        this.x = x;
        this.y = y;

        components.addComponent(new Health(this, 20));
        components.addComponent(
                new Model3D(this, "door")
                        .setModelScale(0.4f)
                        .setModelOffset(new Jaylib.Vector3(0.0f, 0.0f,0.0f))
                        .setRotAxis(new Jaylib.Vector3(0.0f, 1.0f, 0.0f))
                        .setRot(90));
    }
}
