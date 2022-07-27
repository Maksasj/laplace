package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerStartedBattleEvent extends GameEvent {
    private PlayerCharacter player;

    public PlayerStartedBattleEvent() {
        eventType = EventTypes.PLAYER_START_BATTLE_EVENT;
    }

    public PlayerStartedBattleEvent(PlayerCharacter player) {
        this.player = player;
        eventType = EventTypes.PLAYER_START_BATTLE_EVENT;
    }
}
