package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Health;
import org.laplace.systems.objectsystem.ComponentSystem.Components.HealthBar;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Model3D;
import org.laplace.systems.objectsystem.GameEntity;

public class Spider extends GameEntity {

    public Spider(int x, int y) {
        super("spider");
        setDamage(10);

        this.x = x;
        this.y = y;

        components.addComponent(new Health(this, 20));
        components.addComponent(
                new Model3D(this, "spider")
                        .setModelScale(0.2f)
                        .setModelOffset(new Jaylib.Vector3(0.2f, -0.5f,0.2f))
                        .setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f))
                        .setRot(270));
        components.addComponent(new HealthBar(this));
    }
}
