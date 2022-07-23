package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;

public class DiceThrownEvent extends GameEvent {
    public DiceThrownEvent() {
        eventType = EventTypes.DICE_THROWN;
    }
}
