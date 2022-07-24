package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
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

    @Override
    public void onEvent() { }
}
