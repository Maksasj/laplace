package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;

public class HostileMobDeathEvent extends GameEvent {
    public HostileMobDeathEvent() {
        eventType = EventTypes.HOSTILE_MOB_DEATH_EVENT;
    }
}
