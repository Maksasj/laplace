package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.HostileMobDeathData;
import org.laplace.systems.eventsystem.eventdata.PlayerAmbientEntityCollisionData;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerAmbientEntityCollision extends GameEvent {
    private PlayerCharacter player;

    public PlayerAmbientEntityCollision() {
        eventType = EventTypes.PLAYER_AMBIENT_ENTITY_COLLISION;
    }

    public void onEvent(PlayerAmbientEntityCollisionData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerAmbientEntityCollisionData) event);
    }
}
