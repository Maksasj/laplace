package org.laplace.systems.objectsystem;

import com.raylib.Jaylib;
import org.laplace.Game;

public class GameEntity extends GameObject{
    protected int x = 0; //Relative to world cords
    protected int y = 0; //Relative to world cords
    private Jaylib.Vector3 pos = new Jaylib.Vector3(0.0f, 0.0f, 0.0f); //Graphic thing
    private Jaylib.Vector3 offset = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
    private Jaylib.Vector3 rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
    private float rot = 0.0f;

    private float modelScale = 1.0f;

    public GameEntity(String name) {
        super(name);
    }

    @Override
    public void Update() {
        this.setPos(new Jaylib.Vector3(this.x, 0.0f, this.y));
    }

    @Override
    public void Draw() {
        Game.getModelManager().DrawModel(
                this.getName(),
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

    public void setModelScale(float value) {
        modelScale = value;
    }

    public void setModelOffset(Jaylib.Vector3 value) {
        offset = value;
    }

    public void setRotAxis(Jaylib.Vector3 value) {
        rotAxis = value;
    }

    public void setRot(float value) {
        rot = value;
    }

    public void setPos(Jaylib.Vector3 pos) {
        this.pos = pos;
    }

    public Jaylib.Vector3 getPos() {
        return pos;
    }
}
