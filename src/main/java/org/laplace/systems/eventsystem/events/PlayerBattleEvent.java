package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerAmbientEntityCollisionData;
import org.laplace.systems.eventsystem.eventdata.PlayerBattleData;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerBattleEvent extends GameEvent {
    private PlayerCharacter player;

    public PlayerBattleEvent() {
        eventType = EventTypes.PLAYER_BATTLE_EVENT;
    }

    public PlayerBattleEvent(PlayerCharacter player) {
        this.player = player;
        eventType = EventTypes.PLAYER_BATTLE_EVENT;
    }

    public void onEvent(PlayerBattleData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerBattleData) event);
    }
}
