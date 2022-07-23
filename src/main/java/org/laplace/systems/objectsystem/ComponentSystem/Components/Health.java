package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;
import org.laplace.systems.renderer.lightsystem.Light;

public class Health extends Component {
    private GameEntity gameEntity;

    private int health;
    private int maxhealth;

    public Health(GameEntity gameEntity, int health) {
        super(ComponentTypes.HEALTH);

        this.gameEntity = gameEntity;
        this.health = health;
        this.maxhealth = health;
    }

    @Override
    public void Update() {
        if(gameEntity instanceof PlayerCharacter) {
            GameScene.pHealth = health;
            GameScene.pMaxHealth = maxhealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxhealth;
    }
}
