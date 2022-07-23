package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentBlock;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.renderer.lightsystem.Light;

import static com.raylib.Jaylib.RAYWHITE;

public class HealthBar extends Component {
    private GameEntity gameEntity;

    private Health healthComp;
    private Model3D model;

    public HealthBar(GameEntity gameEntity) {
        super(ComponentTypes.HEALTH_BAR);

        this.gameEntity = gameEntity;
    }

    @Override
    public void AskDependencies(ComponentBlock dependencies) {
        if(dependencies.components.containsKey(ComponentTypes.HEALTH)) {
            //throw new Exception("COMPONENT DEPENDENCIE MISSING");
            healthComp = (Health) dependencies.components.get(ComponentTypes.HEALTH);
        }

        if(dependencies.components.containsKey(ComponentTypes.MODEL3D)) {
            //throw new Exception("COMPONENT DEPENDENCIE MISSING");
            model = (Model3D) dependencies.components.get(ComponentTypes.MODEL3D);
        }
    }

    @Override
    public void Draw() {
        if(healthComp.getHealth() != healthComp.getMaxHealth()) {
            Raylib.DrawBillboardRec(
                    Game.getCamera(),
                    Game.getTextureManager().GetTexture("healthbarui"),
                    new Jaylib.Rectangle(0, 0, 220 * ((float) healthComp.getHealth() / healthComp.getMaxHealth()), 40),
                    new Jaylib.Vector3(
                            model.getPos().x() + model.getOffset().x()     - 0.01f,
                            model.getPos().y() + model.getOffset().y()    + 1.99f,
                            model.getPos().z() + model.getOffset().z()    - 0.01f
                    ),
                    new Jaylib.Vector2(0.3f, 0.3f),
                    RAYWHITE);

            Raylib.DrawBillboardRec(
                    Game.getCamera(),
                    Game.getTextureManager().GetTexture("healthbar"),
                    new Jaylib.Rectangle(0, 0, 220, 40),
                    new Jaylib.Vector3(
                            model.getPos().x() + model.getOffset().x(),
                            model.getPos().y() + model.getOffset().y() + 2.0f,
                            model.getPos().z() + model.getOffset().z()
                    ),
                    new Jaylib.Vector2(0.3f, 0.3f),
                    RAYWHITE);
        }
    }
}
