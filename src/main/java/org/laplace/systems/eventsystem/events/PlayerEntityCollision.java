package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerDeathData;
import org.laplace.systems.eventsystem.eventdata.PlayerEnityCollisionData;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.eventsystem.eventdata.PlayerPlayerEntityCollisionData;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerEntityCollision() {
        eventType = EventTypes.PLAYER_ENTITY_COLLISION;
    }

    public void onEvent(PlayerEnityCollisionData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerEnityCollisionData) event);
    }
}
