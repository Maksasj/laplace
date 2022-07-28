package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerEnityCollisionData;
import org.laplace.systems.eventsystem.eventdata.PlayerHostileEntityCollisionData;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerHostileEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerHostileEntityCollision() {
        eventType = EventTypes.PLAYER_HOSTILE_ENTITY_COLLISION;
    }

    public void onEvent(PlayerHostileEntityCollisionData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerHostileEntityCollisionData) event);
    }
}
