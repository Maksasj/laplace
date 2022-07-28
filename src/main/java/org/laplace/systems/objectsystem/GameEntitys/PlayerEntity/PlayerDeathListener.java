package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.systems.eventsystem.eventdata.PlayerDeathData;
import org.laplace.systems.eventsystem.events.PlayerDeathEvent;

public class PlayerDeathListener extends PlayerDeathEvent {
    private PlayerCharacter player;
    public PlayerDeathListener(PlayerCharacter player) {
        super();

        this.player = player;
    }

    @Override
    public void onEvent(PlayerDeathData event) {
        System.out.println("Player should be dead");
    }
}
