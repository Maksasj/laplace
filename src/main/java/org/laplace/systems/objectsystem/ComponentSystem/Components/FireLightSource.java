package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentBlock;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.renderer.lightsystem.Light;

import static java.lang.Math.sin;

public class FireLightSource extends Component {
    private GameEntity gameEntity;
    private Jaylib.Vector3 color;
    private int lightId;
    private Timer timer;

    public FireLightSource(GameEntity gameEntity, Jaylib.Vector3 color) {
        super(ComponentTypes.LIGHT_SOURCE);

        this.gameEntity = gameEntity;
        this.color = color;

        this.Init();
        AskDependencies(gameEntity.components);
    }

    public FireLightSource(GameEntity gameEntity) {
        super(ComponentTypes.LIGHT_SOURCE);

        this.gameEntity = gameEntity;
        this.color = new Jaylib.Vector3(1.0f, 0.5f, 0.3f);

        this.Init();
        AskDependencies(gameEntity.components);
    }

    @Override
    public void AskDependencies(ComponentBlock dependencies) {
        if(dependencies.components.containsKey(ComponentTypes.TIMER)) {
            timer = (Timer) dependencies.components.get(ComponentTypes.TIMER);
        }
    }

    @Override
    public void Init() {
        lightId = GameScene.getLightManager().addLight(
                new Light(
                        new Jaylib.Vector3(gameEntity.x*2, 1.0f, gameEntity.y*2),
                        color));
    }

    @Override
    public void Update() {
        GameScene.getLightManager().setLight(lightId, CalcLight());
        GameScene.getLightManager().updateLight(lightId);
    }

    public Light CalcLight() {
        return new Light(
                new Jaylib.Vector3(gameEntity.x*2, 1.0f, gameEntity.y*2),
                new Jaylib.Vector3(
                    color.x() * GetIntensity(),
                    color.y() * GetIntensity(),
                    color.z() * GetIntensity()
                ));
    }

    private float GetIntensity() {
        float x = (timer.GetTime() / 30.0f);
        return (float) (sin(x) * 0.2 + 0.8f);
    }
}
