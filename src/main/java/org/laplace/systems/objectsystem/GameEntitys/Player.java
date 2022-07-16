package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Dice.Dice;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.worldsystem.GameWorld;

import java.sql.Struct;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.CAMERA_PERSPECTIVE;
import static com.raylib.Raylib.IsKeyPressed;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Player extends GameEntity {
    private boolean walkCd = false;

    private boolean battleMode = false;
    private GameEntity attackingTarget;

    public Player(int x, int y) {
        super("player");
        setHealth(35);

        this.x = x;
        this.y = y;

        this.setModelScale(0.3f);
        this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);
    }

    @Override
    public void Update() {
        Game.getCamera()
                ._position(new Jaylib.Vector3((float) this.x*2 - 7, 5.0f, (float) this.y*2 - 7))
                .target(    new Jaylib.Vector3(this.x*2, 1.0f, (float) this.y*2))
                .up(        new Raylib.Vector3().x(0).y(1).z(0))
                .fovy(45)
                .projection(CAMERA_PERSPECTIVE);

        if(battleMode && attackingTarget != null) {
            //GameWorld.killEnity( attackingTarget.x(), attackingTarget.y());
        }

        if(!walkCd && !battleMode) {
            if(IsKeyPressed(83)) { //S
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, 1.0f, 1.0f));
                this.setRot(240.0f);

                if(!GameWorld.ChechIfWall(x - 1, y)) {
                    if(GameWorld.getEntity(x - 1, y) != null) {
                        StartBattle(GameWorld.getEntity(x - 1, y));
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x - 1, y);
                        this.x -= 1;
                        walkCd = true;
                    }
                } else {
                    System.out.println("WALL COLLISION");
                }
            }

            if(IsKeyPressed(87)) { //W
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, -1.0f, -1.0f));
                this.setRot(240);

                if(!GameWorld.ChechIfWall(x + 1, y)) {
                    if(GameWorld.getEntity(x + 1, y) != null) {
                        StartBattle(GameWorld.getEntity(x + 1, y));
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x + 1, y);
                        this.x += 1;
                        walkCd = true;
                    }
                } else {
                    System.out.println("WALL COLLISION");
                }
            }

            if(IsKeyPressed(65)) { //A
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
                this.setRot(270);

                if(!GameWorld.ChechIfWall(x, y + 1)) {
                    if(GameWorld.getEntity(x, y + 1) != null) {
                        StartBattle(GameWorld.getEntity(x, y + 1));
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x, y + 1);
                        this.y += 1;
                        walkCd = true;

                    }
                } else {
                    System.out.println("WALL COLLISION");
                }
            }

            if(IsKeyPressed(68)) { //D
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(0.0f, 0.7f, 0.7f));
                this.setRot(180);

                if(!GameWorld.ChechIfWall(x, y - 1)) {
                    if(GameWorld.getEntity(x, y - 1) != null) {
                        StartBattle(GameWorld.getEntity(x, y - 1));
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x, y - 1);
                        this.y -= 1;
                        walkCd = true;
                    }
                } else {
                    System.out.println("WALL COLLISION");
                }
            }
        } else {
            walkCd = false;
        }

        //Battle mode detection
            if(GameWorld.getEntity(x + 1, y) != null) {
                StartBattle(GameWorld.getEntity(x + 1, y));
            }else if(GameWorld.getEntity(x - 1, y) != null) {
                StartBattle(GameWorld.getEntity(x - 1, y));
            }else if(GameWorld.getEntity(x, y + 1) != null) {
                StartBattle(GameWorld.getEntity(x, y + 1));
            }else if(GameWorld.getEntity(x, y - 1) != null) {
                StartBattle(GameWorld.getEntity(x, y - 1));
            }

        if(IsKeyPressed(66)) { //test
            GameScene.getMainDice().ThrowDice(6);
        }

        //Update mesh location
        this.setPos(new Jaylib.Vector3(this.x*2, 0.0f, this.y*2));
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

    public void StartBattle(GameEntity entity) {
        if(!battleMode) {
            battleMode = true;
            attackingTarget = entity;
            System.out.println("battle started");

            GameScene.getRightDice().ThrowDice(6);
            GameScene.getLeftDice().ThrowDice(6);

            entity.receiveDamage(6);
        }
    }
}
