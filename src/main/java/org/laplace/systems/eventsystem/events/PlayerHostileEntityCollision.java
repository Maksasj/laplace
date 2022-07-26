package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerHostileEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerHostileEntityCollision() {
        eventType = EventTypes.PLAYER_HOSTILE_ENTITY_COLLISION;
    }

    @Override
    public void onEvent() { }
}
