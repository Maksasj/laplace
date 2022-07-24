package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Health;
import org.laplace.systems.objectsystem.ComponentSystem.Components.HealthBar;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Model3D;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Positionable;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntityTypes;

public class Goblin extends GameEntity {

    public Goblin(int x, int y) {
        super("goblin", GameEntityTypes.HOSTILE);

        this.x = x;
        this.y = y;

        components.addComponent(new Positionable());
        components.addComponent(new Health(this, 20));
        components.addComponent(new Model3D(this, "goblin"));
        components.addComponent(new HealthBar(this));
    }
}
