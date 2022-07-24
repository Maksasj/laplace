package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerDeathEvent extends GameEvent {
    private PlayerCharacter player;

    public PlayerDeathEvent() {
        eventType = EventTypes.PLAYER_DEATH_EVENT;
    }

    public PlayerDeathEvent(PlayerCharacter player) {
        this.player = player;
        eventType = EventTypes.PLAYER_DEATH_EVENT;
    }
}