package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.events.PlayerBattleEvent;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Battleble;

public class PlayerBattleListener extends PlayerBattleEvent {
    private PlayerCharacter player;
    private int battleCd;
    private int lValue;
    private int rValue;
    private Battleble battleble;

    public PlayerBattleListener(PlayerCharacter player) {
        super();
        this.player = player;

        battleble = (Battleble) player.components.components.get(ComponentTypes.BATTLEBLE);

        Game.GetEventHandler().addEvent(new PlayerStartBattleSoundListener());
    }

    @Override
    public void onEvent() {
        if(!battleble.GetBattleMode()) {
            battleble.SetBattleMode(true);
            battleCd = 0;

            Game.GetEventHandler().handleEvent(EventTypes.PLAYER_START_BATTLE_EVENT, new EventDataGeneric());
        }

        //Battle logic
        if(battleble.GetBattleMode()) {
            if(battleCd <= 1) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_THROWING_COMBAT_DICES, new EventDataGeneric());

                rValue = GameScene.getRightDice().ThrowDice(6);
                lValue = GameScene.getLeftDice().ThrowDice(6);
            }

            if(battleCd > 400) {
                battleCd = 0;
            }
        }

        battleCd++;
    }


        /*
        if(battleMode && battleCd > 100) {
            if(battleble.GetAttackingTarget().getHealth() < 1) {
                if(GameWorld.getEntity(player.x + 1, player.y) == attackingTarget) {
                    GameWorld.killEnity(player.x + 1, player.y);
                }else if(GameWorld.getEntity(player.x - 1, player.y) == attackingTarget) {
                    GameWorld.killEnity(player.x - 1, player.y);

                }else if(GameWorld.getEntity(player.x, player.y + 1) == attackingTarget) {
                    GameWorld.killEnity(player.x, player.y + 1);

                }else if(GameWorld.getEntity(player.x, player.y - 1) == attackingTarget) {
                    GameWorld.killEnity(player.x, player.y - 1);
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
                    //rValue = GameScene.getRightDice().ThrowDice(6);
                    //lValue = GameScene.getLeftDice().ThrowDice(6);
                }

                battleCd = 0;
            }
        }
        */
}
