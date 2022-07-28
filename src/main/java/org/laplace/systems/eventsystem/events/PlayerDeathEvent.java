package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerBattleData;
import org.laplace.systems.eventsystem.eventdata.PlayerChestEntityCollisionData;
import org.laplace.systems.eventsystem.eventdata.PlayerDeathData;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerDeathEvent extends GameEvent {
    private PlayerCharacter player;

    public PlayerDeathEvent() {
        eventType = EventTypes.PLAYER_DEATH_EVENT;
    }

    public PlayerDeathEvent(PlayerCharacter player) {
        this.player = player;
        eventType = EventTypes.PLAYER_DEATH_EVENT;
    }

    public void onEvent(PlayerDeathData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerDeathData) event);
    }
}