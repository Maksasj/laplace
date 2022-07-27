package org.laplace.systems.objectsystem.ComponentSystem.Components;

import org.laplace.Game;
import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntityTypes;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;
import org.laplace.systems.worldsystem.GameWorld;

public class Battleble extends Component {
    private PlayerCharacter player;
    private boolean battleMode;
    private GameEntity attackingTarget;

    public Battleble(PlayerCharacter player) {
        super(ComponentTypes.BATTLEBLE);

        this.player = player;
        battleMode = false;

        this.Init();
    }

    @Override
    public void Update() {
        if(GameWorld.getEntity(player.x + 1, player.y) != null) {
            if(GameWorld.getEntity(player.x + 1, player.y).getType().equals(GameEntityTypes.HOSTILE)) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_BATTLE_EVENT, new EventDataGeneric());
                attackingTarget = GameWorld.getEntity(player.x + 1, player.y);
            }
        } else if(GameWorld.getEntity(player.x - 1, player.y) != null) {
            if(GameWorld.getEntity(player.x - 1, player.y).getType().equals(GameEntityTypes.HOSTILE)) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_BATTLE_EVENT, new EventDataGeneric());
                attackingTarget = GameWorld.getEntity(player.x - 1, player.y);
            }
        } else if(GameWorld.getEntity(player.x, player.y + 1) != null) {
            if(GameWorld.getEntity(player.x, player.y + 1).getType().equals(GameEntityTypes.HOSTILE)) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_BATTLE_EVENT, new EventDataGeneric());
                attackingTarget = GameWorld.getEntity(player.x, player.y + 1);
            }
        } else if(GameWorld.getEntity(player.x, player.y - 1) != null) {
            if(GameWorld.getEntity(player.x, player.y - 1).getType().equals(GameEntityTypes.HOSTILE)) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_BATTLE_EVENT, new EventDataGeneric());
                attackingTarget = GameWorld.getEntity(player.x, player.y - 1);
            }
        }
    }

    public boolean GetBattleMode() {
        return battleMode;
    }

    public void SetBattleMode(boolean value) {
        battleMode = value;
    }

    public GameEntity GetAttackingTarget() {
        return attackingTarget;
    }
}