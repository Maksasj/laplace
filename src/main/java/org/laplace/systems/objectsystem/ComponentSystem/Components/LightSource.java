package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.renderer.lightsystem.Light;

public class LightSource extends Component {
    private GameEntity gameEntity;
    private Jaylib.Vector3 color;

    private int lightId;

    public LightSource(GameEntity gameEntity, Jaylib.Vector3 color) {
        this.gameEntity = gameEntity;
        this.color = color;

        this.Init();
    }

    @Override
    public void Init() {
        lightId = GameScene.getLightManager().addLight(
                new Light(
                        new Jaylib.Vector3(gameEntity.pos.x(), 1.0f, gameEntity.pos.z()),
                        color));
    }

    @Override
    public void Update() {

    }
}
