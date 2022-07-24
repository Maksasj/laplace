package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import org.apache.tools.ant.taskdefs.ManifestTask;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentBlock;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.renderer.lightsystem.Light;

public class Model3D extends Component {
    private String modelName;
    private GameEntity gameEntity;

    private Positionable positionable;

    public float modelScale = 1.0f;

    public Model3D(GameEntity gameEntity, String modelName) {
        super(ComponentTypes.MODEL3D);

        this.gameEntity = gameEntity;
        this.modelName = modelName;
        this.Init();

        AskDependencies(gameEntity.components);
    }

    @Override
    public void AskDependencies(ComponentBlock dependencies) {
        if(dependencies.components.containsKey(ComponentTypes.POSITIONABLE)) {
            positionable = (Positionable) dependencies.components.get(ComponentTypes.POSITIONABLE);
        }
    }

    @Override
    public void Update() {
        positionable.pos = new Jaylib.Vector3(gameEntity.x*2, 0, gameEntity.y*2);
    }

    @Override
    public void Draw() {
        Game.getModelManager().DrawModel(
                modelName,
                new Jaylib.Vector3(
                        positionable.pos.x() + positionable.offset.x(),
                        positionable.pos.y() + positionable.offset.y(),
                        positionable.pos.z() + positionable.offset.z()
                ),
                modelScale,
                positionable.rotAxis,
                positionable.rot
        );
    }

    public Model3D setModelScale(float value) {
        modelScale = value;
        return this;
    }

    public Model3D setModelOffset(Jaylib.Vector3 value) {
        positionable.offset = value;
        return this;
    }

    public Model3D setRotAxis(Jaylib.Vector3 value) {
        positionable.rotAxis = value;
        return this;
    }

    public Model3D setRot(float value) {
        positionable.rot = value;
        return this;
    }

    public Jaylib.Vector3 getPos() {
        return positionable.pos;
    }

    public Jaylib.Vector3 getOffset() {
        return positionable.offset;
    }

    public Jaylib.Vector3 getRotAxis() {
        return positionable.rotAxis;
    }
}
