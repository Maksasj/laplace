package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerEntityCollision() {
        eventType = EventTypes.PLAYER_ENTITY_COLLISION;
    }

    @Override
    public void onEvent() { }
}
