package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.RoomClearedChestsData;
import org.laplace.systems.eventsystem.eventdata.RoomClearedHostileMobData;

public class RoomClearedHosileMob extends GameEvent {
    public RoomClearedHosileMob() {
        eventType = EventTypes.ROOM_CLEARED_FROM_HOSTILE_MOBS;
    }

    public void onEvent(RoomClearedHostileMobData event) { }

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((RoomClearedHostileMobData) event);
    }
}
