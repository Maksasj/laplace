package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Components.*;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntityTypes;

public class Torch extends GameEntity {

    public Torch(int x, int y) {
        super("torch", GameEntityTypes.AMBIENT);

        this.x = x;
        this.y = y;

        components.addComponent(new Positionable());
        components.addComponent(new Health(this, 20));
        components.addComponent(new LightSource(this, new Jaylib.Vector3(1.0f, 0.5f, 0.3f)));
        components.addComponent(
                new Model3D(this, "torch")
                        .setModelScale(0.015f)
                        .setModelOffset(new Jaylib.Vector3(0.0f, -1.0f,0.0f))
                        .setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f))
                        .setRot(90));
    }
}
