package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.DiceThrowData;
import org.laplace.systems.eventsystem.eventdata.HostileMobDeathData;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;

public class HostileMobDeathEvent extends GameEvent {
    public HostileMobDeathEvent() {
        eventType = EventTypes.HOSTILE_MOB_DEATH_EVENT;
    }

    public void onEvent(HostileMobDeathData event) {};
    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((HostileMobDeathData) event);
    }
}
