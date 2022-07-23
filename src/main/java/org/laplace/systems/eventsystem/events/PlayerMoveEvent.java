package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

import static org.laplace.systems.eventsystem.EventTypes.PLAYER_MOVE_EVENT;

public class PlayerMoveEvent extends GameEvent {
    private PlayerCharacter player;

    public PlayerMoveEvent() {
        eventType = PLAYER_MOVE_EVENT;
    }

    public PlayerMoveEvent(PlayerCharacter player) {
        this.player = player;
        eventType = PLAYER_MOVE_EVENT;
    }

    @Override
    public void onEvent() {

    }
}
