package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;

public class PlayerThrowCombatDices extends GameEvent {
    public PlayerThrowCombatDices() {
        eventType = EventTypes.PLAYER_THROWING_COMBAT_DICES;
    }
}
