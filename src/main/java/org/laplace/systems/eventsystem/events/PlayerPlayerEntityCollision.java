package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.eventsystem.eventdata.PlayerPlayerEntityCollisionData;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerPlayerEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerPlayerEntityCollision() {
        eventType = EventTypes.PLAYER_PLAYER_ENTITY_COLLISION;
    }

    public void onEvent(PlayerPlayerEntityCollisionData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerPlayerEntityCollisionData) event);
    }
}
