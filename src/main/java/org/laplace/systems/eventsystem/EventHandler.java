package org.laplace.systems.eventsystem;

import org.laplace.systems.eventsystem.events.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {

    List<GameEvent> eventListeners = new ArrayList<GameEvent>();

    public void handleEvent(EventTypes eventType) {
        for (GameEvent event : eventListeners) {
            if(event.eventType.equals(eventType)) {
                event.onEvent();
            }
        }
    }

    public void addEvent(GameEvent event) {
        eventListeners.add(event);
    }
}
