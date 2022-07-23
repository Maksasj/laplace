package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.Game;
import org.laplace.systems.eventsystem.events.PlayerDeathEvent;

import java.util.Random;

public class PlayerDeathListener extends PlayerDeathEvent {
    private PlayerCharacter player;
    public PlayerDeathListener(PlayerCharacter player) {
        super();

        this.player = player;
    }

    @Override
    public void onEvent() {
        System.out.println("Player should be dead");
    }
}
