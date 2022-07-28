package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.eventsystem.eventdata.PlayerUnknownEnityCollisionData;
import org.laplace.systems.eventsystem.eventdata.RoomClearedChestsData;

public class RoomClearedChests extends GameEvent {
    public RoomClearedChests() {
        eventType = EventTypes.ROOM_CLEARED_FROM_CHESTS;
    }

    public void onEvent(RoomClearedChestsData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((RoomClearedChestsData) event);
    }
}
