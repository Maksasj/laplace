package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;

public class RoomClearedChests extends GameEvent {
    public RoomClearedChests() {
        eventType = EventTypes.ROOM_CLEARED_FROM_CHESTS;
    }
}
