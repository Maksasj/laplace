package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.Game;
import org.laplace.systems.eventsystem.events.PlayerMoveEvent;
import org.laplace.systems.eventsystem.events.PlayerStartBattleEvent;

import java.util.Random;

public class PlayerStartBattleListener extends PlayerStartBattleEvent {
    private PlayerCharacter player;

    public PlayerStartBattleListener(PlayerCharacter player) {
        super();
        this.player = player;
    }

    @Override
    public void onEvent() {
        System.out.println("BATTLE SHOULD START");

         /*
        if(!battleMode) {
            battleMode = true;
            battleCd = 0;
            attackingTarget = entity;

            rValue = GameScene.getRightDice().ThrowDice(6);
            lValue = GameScene.getLeftDice().ThrowDice(6);

            //attackingTarget.receiveDamage(1);

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

         */
    }
}
