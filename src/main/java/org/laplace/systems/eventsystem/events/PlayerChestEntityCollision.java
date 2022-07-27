package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerChestEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerChestEntityCollision() {
        eventType = EventTypes.PLAYER_CHEST_ENTITY_COLLISION;
    }
}
