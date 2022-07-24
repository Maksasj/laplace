package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Health;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Model3D;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Positionable;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntityTypes;

public class Chest extends GameEntity {

    public Chest(int x, int y) {
        super("chest", GameEntityTypes.CHEST);

        this.x = x;
        this.y = y;

        components.addComponent(new Positionable());
        components.addComponent(new Health(this, 20));
        components.addComponent(
                new Model3D(this, "chest")
                        .setModelScale(0.015f)
                        .setModelOffset(new Jaylib.Vector3(0.0f, -1.0f,1.0f))
                        .setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f))
                        .setRot(270));
    }
}
