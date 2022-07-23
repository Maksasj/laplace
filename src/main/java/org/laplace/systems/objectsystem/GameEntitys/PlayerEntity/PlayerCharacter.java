package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import com.raylib.Jaylib;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.events.PlayerMoveEvent;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.worldsystem.GameWorld;

import java.util.Random;

import static com.raylib.Raylib.IsKeyPressed;

public class PlayerCharacter extends GameEntity {
    private PlayerCameraController camController;

    private boolean walkCd = false;

    private boolean battleMode = false;
    private GameEntity attackingTarget;

    private int rValue;
    private int lValue;

    private int battleCd = 0;

    //Red Boreder thing
    private float rBorder = 0; //For now iTime used only with rendering
    private int rBorderShaderLoc;

    public PlayerCharacter(int x, int y) {
        super("player");
        setHealth(35);
        setDamage(15);

        this.x = x;
        this.y = y;

        this.setModelScale(0.3f);
        this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);

        camController = new PlayerCameraController();

        rBorderShaderLoc = Game.getShaderManager().GetShaderLocation("basePixelated", "rBorder");

        this.setPos(new Jaylib.Vector3(this.x, 0.0f, this.y));
    }

    @Override
    public void Update() {
        if(battleMode && attackingTarget != null) {
            //GameWorld.killEnity( attackingTarget.x(), attackingTarget.y());
        }

        GameScene.pHealth = getHealth();
        GameScene.pMaxHealth = getMaxHealth();

        if(getHealth() < 0) {
            battleMode = false;
            walkCd = false;

            setHealth(35);
            setDamage(15);

            battleCd = 0;
            rBorder = 0;

            this.setModelScale(0.3f);
            this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
            this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
            this.setRot(270);

            GameScene.playerDied();
        }

        //Walking Cd
        if(!walkCd && !battleMode) {
            if(IsKeyPressed(68)) { //W
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_MOVE_EVENT);

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
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_MOVE_EVENT);

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
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_MOVE_EVENT);

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
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_MOVE_EVENT);

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
            //GameScene.getMainDice().ThrowDice(6);
            setHealth(-2, getMaxHealth());

        }

        camController.ControlCamera(this);

        if(!battleMode && rBorder > 0.0) {
            rBorder -= 0.01;
            Game.getShaderManager().SetShaderValue("basePixelated", "rBorder", rBorderShaderLoc, rBorder);
        }

        //Update mesh location
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

    public void StartBattle(GameEntity entity) {
        if(!battleMode) {
            battleMode = true;
            battleCd = 0;
            attackingTarget = entity;

            rValue = GameScene.getRightDice().ThrowDice(6);
            lValue = GameScene.getLeftDice().ThrowDice(6);

            attackingTarget.receiveDamage(1);

            Game.getSoundManager().PlaySound("battlebeggining", 0.2f);
        }

        if(battleMode && battleCd > 100) {
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


            if(attackingTarget != null && battleCd > 800) {
                if(rValue > lValue) {
                    attackingTarget.receiveDamage(rValue + this.dealDamage());
                } else if (rValue < lValue){
                    this.receiveDamage(lValue + attackingTarget.dealDamage());
                } else {
                    attackingTarget.receiveDamage(rValue + + this.dealDamage());
                }


                if(attackingTarget.getHealth() > 1) {
                    rValue = GameScene.getRightDice().ThrowDice(6);
                    lValue = GameScene.getLeftDice().ThrowDice(6);
                }

                battleCd = 0;
            }
        }

        battleCd++;

        if(battleMode && rBorder < 0.3) {
            rBorder += 0.05;
            Game.getShaderManager().SetShaderValue("basePixelated", "rBorder", rBorderShaderLoc, rBorder);
        }
    }
}
