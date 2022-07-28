package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.eventsystem.eventdata.PlayerStartedBattleData;
import org.laplace.systems.eventsystem.eventdata.PlayerThrowCombatDicesData;

public class PlayerThrowCombatDices extends GameEvent {
    public PlayerThrowCombatDices() {
        eventType = EventTypes.PLAYER_THROWING_COMBAT_DICES;
    }

    public void onEvent(PlayerThrowCombatDicesData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((PlayerThrowCombatDicesData) event);
    }
}
