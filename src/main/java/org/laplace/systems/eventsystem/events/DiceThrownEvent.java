package org.laplace.systems.eventsystem.events;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.GameEvent;
import org.laplace.systems.eventsystem.eventdata.DiceThrowData;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;

public class DiceThrownEvent extends GameEvent {
    public DiceThrownEvent() {
        eventType = EventTypes.DICE_THROWN;
    }

    public void onEvent(DiceThrowData event) {};

    @Override
    public void castEvent(EventDataGeneric event) {
        this.onEvent((DiceThrowData) event);
    }
}
