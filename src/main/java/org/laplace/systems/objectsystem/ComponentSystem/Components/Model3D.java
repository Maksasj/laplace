package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import org.apache.tools.ant.taskdefs.ManifestTask;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.renderer.lightsystem.Light;

public class Model3D extends Component {
    private String modelName;
    private GameEntity gameEntity;

    public Jaylib.Vector3 pos = new Jaylib.Vector3(0.0f, 0.0f, 0.0f); //Graphic thing
    public Jaylib.Vector3 offset = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
    public Jaylib.Vector3 rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
    public float rot = 0.0f;
    public float modelScale = 1.0f;

    public Model3D(GameEntity gameEntity, String modelName) {
        super(ComponentTypes.MODEL3D);

        this.gameEntity = gameEntity;
        this.modelName = modelName;
        this.Init();
    }

    @Override
    public void Update() {
        pos = new Jaylib.Vector3(gameEntity.x*2, 0, gameEntity.y*2);
    }

    @Override
    public void Draw() {
        Game.getModelManager().DrawModel(
                modelName,
                new Jaylib.Vector3(
                        pos.x() + offset.x(),
                        pos.y() + offset.y(),
                        pos.z() + offset.z()
                ),
                modelScale,
                rotAxis,
                rot
        );
    }

    public Model3D setModelScale(float value) {
        modelScale = value;
        return this;
    }

    public Model3D setModelOffset(Jaylib.Vector3 value) {
        offset = value;
        return this;
    }

    public Model3D setRotAxis(Jaylib.Vector3 value) {
        rotAxis = value;
        return this;
    }

    public Model3D setRot(float value) {
        rot = value;
        return this;
    }

    public Jaylib.Vector3 getPos() {
        return pos;
    }

    public Jaylib.Vector3 getOffset() {
        return offset;
    }

    public Jaylib.Vector3 getRotAxis() {
        return rotAxis;
    }
}
