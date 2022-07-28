package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.eventsystem.eventdata.PlayerThrowCombatDicesData;
import org.laplace.systems.eventsystem.eventdata.PlayerUnknownEnityCollisionData;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerUnknownEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerUnknownEntityCollision() {
        eventType = EventTypes.PLAYER_UNKNOWN_ENTITY_COLLISION;
    }

    public void onEvent(PlayerUnknownEnityCollisionData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerUnknownEnityCollisionData) event);
    }
}
