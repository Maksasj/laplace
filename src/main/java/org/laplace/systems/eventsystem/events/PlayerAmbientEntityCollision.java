package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerAmbientEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerAmbientEntityCollision() {
        eventType = EventTypes.PLAYER_AMBIENT_ENTITY_COLLISION;
    }
}
