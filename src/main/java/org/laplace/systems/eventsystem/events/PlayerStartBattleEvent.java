package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

import static org.laplace.systems.eventsystem.EventTypes.PLAYER_MOVE_EVENT;

public class PlayerStartBattleEvent extends GameEvent {
    private PlayerCharacter player;

    public PlayerStartBattleEvent() {
        eventType = EventTypes.PLAYER_START_BATTLE_EVENT;
    }

    public PlayerStartBattleEvent(PlayerCharacter player) {
        this.player = player;
        eventType = EventTypes.PLAYER_START_BATTLE_EVENT;
    }

    @Override
    public void onEvent() {

    }
}
