package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerBattleData;
import org.laplace.systems.eventsystem.eventdata.PlayerHostileEntityCollisionData;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

import static org.laplace.systems.eventsystem.EventTypes.PLAYER_MOVE_EVENT;

public abstract class PlayerMoveEvent extends GameEvent {
    private PlayerCharacter player;

    public PlayerMoveEvent() {
        eventType = PLAYER_MOVE_EVENT;
    }

    public PlayerMoveEvent(PlayerCharacter player) {
        this.player = player;
        eventType = PLAYER_MOVE_EVENT;
    }

    public void onEvent(PlayerMoveData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerMoveData) event);
    }
}
