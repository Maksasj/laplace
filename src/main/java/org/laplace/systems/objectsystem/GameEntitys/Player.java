package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Dice.Dice;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.worldsystem.GameWorld;

import java.sql.Struct;
import java.util.Random;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.CAMERA_PERSPECTIVE;
import static com.raylib.Raylib.IsKeyPressed;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Player extends GameEntity {
    private boolean walkCd = false;

    private boolean battleMode = false;
    private GameEntity attackingTarget;

    private int rValue;
    private int lValue;

    private int battleCd = 0;

    //Red Boreder thing
    private float rBorder = 0; //For now iTime used only with rendering
    private int rBorderShaderLoc;

    public Player(int x, int y) {
        super("player");
        setHealth(35);

        this.x = x;
        this.y = y;

        this.setModelScale(0.3f);
        this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);

        rBorderShaderLoc = Game.getShaderManager().GetShaderLocation("basePixelated", "rBorder");
    }

    @Override
    public void Update() {
        if(battleMode && attackingTarget != null) {
            //GameWorld.killEnity( attackingTarget.x(), attackingTarget.y());
        }

        //Walking Cd
        if(!walkCd && !battleMode) {
            if(IsKeyPressed(68)) { //W
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, 1.0f, 1.0f));
                this.setRot(240.0f);

                if(!GameWorld.ChechIfWall(x - 1, y)) {
                    if(GameWorld.getEntity(x - 1, y) != null) {
                        if(!GameWorld.getEntity(x - 1, y).getName().equals("door")) {
                            StartBattle(GameWorld.getEntity(x - 1, y));
                        }
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x - 1, y);
                        this.x -= 1;
                        walkCd = true;

                        Random rand = new Random();
                        int int_random = rand.nextInt(3);
                        Game.getSoundManager().PlaySound("footstep"+(int_random+1), 0.2f);
                    }
                } else {
                    System.out.println("WALL COLLISION");
                }
            }

            if(IsKeyPressed(65)) { //S
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, -1.0f, -1.0f));
                this.setRot(240);

                if(!GameWorld.ChechIfWall(x + 1, y)) {
                    if(GameWorld.getEntity(x + 1, y) != null) {
                        if(!GameWorld.getEntity(x + 1, y).getName().equals("door")) {
                            StartBattle(GameWorld.getEntity(x + 1, y));
                        }
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x + 1, y);
                        this.x += 1;
                        walkCd = true;

                        Random rand = new Random();
                        int int_random = rand.nextInt(3);
                        Game.getSoundManager().PlaySound("footstep"+(int_random+1), 0.2f);
                    }
                } else {
                    System.out.println("WALL COLLISION");
                }
            }

            if(IsKeyPressed(87)) { //D
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
                this.setRot(270);

                if(!GameWorld.ChechIfWall(x, y + 1)) {
                    if(GameWorld.getEntity(x, y + 1) != null) {
                        if(!GameWorld.getEntity(x, y + 1).getName().equals("door")) {
                            StartBattle(GameWorld.getEntity(x, y + 1));
                        }
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x, y + 1);
                        this.y += 1;
                        walkCd = true;

                        Random rand = new Random();
                        int int_random = rand.nextInt(3);
                        Game.getSoundManager().PlaySound("footstep"+(int_random+1), 0.2f);
                    }
                } else {
                    System.out.println("WALL COLLISION");
                }
            }

            if(IsKeyPressed(83)) { //A
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(0.0f, 0.7f, 0.7f));
                this.setRot(180);

                if(!GameWorld.ChechIfWall(x, y - 1)) {
                    if(GameWorld.getEntity(x, y - 1) != null) {
                        if(!GameWorld.getEntity(x, y - 1).getName().equals("door")) {
                            StartBattle(GameWorld.getEntity(x, y - 1));
                        }
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x, y - 1);
                        this.y -= 1;
                        walkCd = true;

                        Random rand = new Random();
                        int int_random = rand.nextInt(3);
                        Game.getSoundManager().PlaySound("footstep"+(int_random+1), 0.2f);
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
                if(!GameWorld.getEntity(x + 1, y).getName().equals("door")) {
                    StartBattle(GameWorld.getEntity(x + 1, y));
                }
            }else if(GameWorld.getEntity(x - 1, y) != null) {
                if(!GameWorld.getEntity(x - 1, y).getName().equals("door")) {
                    StartBattle(GameWorld.getEntity(x - 1, y));
                }
            }else if(GameWorld.getEntity(x, y + 1) != null) {
                if(!GameWorld.getEntity(x, y + 1).getName().equals("door")) {
                    StartBattle(GameWorld.getEntity(x, y + 1));
                }
            }else if(GameWorld.getEntity(x, y - 1) != null) {
                if(!GameWorld.getEntity(x, y - 1).getName().equals("door")) {
                    StartBattle(GameWorld.getEntity(x, y - 1));
                }
            }

        if(IsKeyPressed(66)) { //test
            GameScene.getMainDice().ThrowDice(6);
        }

        Game.getCamera()
                ._position(new Jaylib.Vector3((float) this.x*2 - 7, 5.0f, (float) this.y*2 - 7))
                .target(    new Jaylib.Vector3(this.x*2, 1.0f, (float) this.y*2))
                .up(        new Raylib.Vector3().x(0).y(1).z(0))
                .fovy(45)
                .projection(CAMERA_PERSPECTIVE);

        //Update mesh location
        this.setPos(new Jaylib.Vector3(this.x*2, 0.0f, this.y*2));

        if(!battleMode && rBorder > 0.0) {
            rBorder -= 0.01;
            Game.getShaderManager().SetShaderValue("basePixelated", "rBorder", rBorderShaderLoc, rBorder);
        }
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
            Game.getSoundManager().PlaySound("battlebeggining", 0.2f);

            rValue = GameScene.getRightDice().ThrowDice(6);
            lValue = GameScene.getLeftDice().ThrowDice(6);

            entity.receiveDamage(6);
        }

        if(battleMode && rBorder < 0.3) {
            rBorder += 0.05;
            Game.getShaderManager().SetShaderValue("basePixelated", "rBorder", rBorderShaderLoc, rBorder);
        }

        if(battleMode && battleCd > 400) {
            battleCd = 0;
            if(rValue > lValue) {
                attackingTarget.receiveDamage(20);

                if(attackingTarget.getHealth() < 1) {

                    if(GameWorld.getEntity(x + 1, y) == attackingTarget) {
                        GameWorld.killEnity(x + 1, y);

                    }else if(GameWorld.getEntity(x - 1, y) == attackingTarget) {
                        GameWorld.killEnity(x - 1, y);

                    }else if(GameWorld.getEntity(x, y + 1) == attackingTarget) {
                        GameWorld.killEnity(x, y + 1);

                    }else if(GameWorld.getEntity(x, y - 1) == attackingTarget) {
                        GameWorld.killEnity(x, y - 1);
                    }

                    attackingTarget = null;
                    battleMode = false;

                    return;
                }
            } else {
                this.receiveDamage(lValue);
            }

            rValue = GameScene.getRightDice().ThrowDice(6);
            lValue = GameScene.getLeftDice().ThrowDice(6);
        } else {
            battleCd++;
        }
    }
}
