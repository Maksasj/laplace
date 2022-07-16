package org.laplace.systems.objectsystem;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Dice.Dice;
import org.laplace.Game;
import org.laplace.systems.objectsystem.GameEntitys.Player;
import org.laplace.systems.worldsystem.GameWorld;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class GameEntity extends GameObject{
    protected int x = 0; //Relative to world cords
    protected int y = 0; //Relative to world cords

    private int health;
    private int maxhealth;
    private int damage = 0;

    public Jaylib.Vector3 pos = new Jaylib.Vector3(0.0f, 0.0f, 0.0f); //Graphic thing
    public Jaylib.Vector3 offset = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
    public Jaylib.Vector3 rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
    public float rot = 0.0f;

    public float modelScale = 1.0f;

    public GameEntity(String name) {
        super(name);
    }

    public void setHealth(int x, int y) {
        health = x;
        maxhealth = y;
    }

    public void setHealth(int x) {
        health = x;
        maxhealth = x;
    }

    public int x() {
        return x;
    }
    public int y() {
        return y;
    }

    public void setDamage(int x) {
        damage = x;
    }

    public int dealDamage() {
        return damage;
    }

    @Override
    public void Update() {
        this.setPos(new Jaylib.Vector3(this.x, 0.0f, this.y));
        if(health <= 0) {
            GameWorld.killEnity(x, y);
        }
    }

    @Override
    public void Draw() {
        //Healt bar drawing
        if(getName() != "player") {
            if(health != maxhealth) {
                Raylib.DrawBillboardRec(
                        Game.getCamera(),
                        Game.getTextureManager().GetTexture("healthbarui"),
                        new Jaylib.Rectangle(0, 0, 220 * ((float) health / maxhealth), 40),
                        new Jaylib.Vector3(
                                pos.x() + offset.x()     - 0.01f,
                                pos.y() + offset.y()    + 1.39f,
                                pos.z() + offset.z()    - 0.01f
                        ),
                        new Jaylib.Vector2(0.3f, 0.3f),
                        RAYWHITE);

                Raylib.DrawBillboardRec(
                        Game.getCamera(),
                        Game.getTextureManager().GetTexture("healthbar"),
                        new Jaylib.Rectangle(0, 0, 220, 40),
                        new Jaylib.Vector3(
                                pos.x() + offset.x(),
                                pos.y() + offset.y() + 1.4f,
                                pos.z() + offset.z()
                        ),
                        new Jaylib.Vector2(0.3f, 0.3f),
                        RAYWHITE);
            }
        }

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

    public void receiveDamage(int value) {
        health -= value;
    }
}
