package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;

public class RoomClearedHosileMob extends GameEvent {
    public RoomClearedHosileMob() {
        eventType = EventTypes.ROOM_CLEARED_FROM_HOSTILE_MOBS;
    }
}
