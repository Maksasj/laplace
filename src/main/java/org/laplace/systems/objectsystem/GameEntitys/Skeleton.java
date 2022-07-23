package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Health;
import org.laplace.systems.objectsystem.ComponentSystem.Components.HealthBar;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Model3D;
import org.laplace.systems.objectsystem.GameEntity;

public class Skeleton extends GameEntity {

    public Skeleton(int x, int y) {
        super("skeleton");
        setDamage(10);

        this.x = x;
        this.y = y;

        components.addComponent(new Health(this, 20));
        components.addComponent(
                new Model3D(this, "skeleton")
                        .setModelScale(0.01f)
                        .setModelOffset(new Jaylib.Vector3(0.0f, -1.0f,0.0f)));
        components.addComponent(new HealthBar(this));
    }
}
