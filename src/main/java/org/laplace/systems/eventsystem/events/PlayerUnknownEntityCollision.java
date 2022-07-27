package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerUnknownEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerUnknownEntityCollision() {
        eventType = EventTypes.PLAYER_UNKNOWN_ENTITY_COLLISION;
    }
}
