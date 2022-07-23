package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.Game;
import org.laplace.systems.eventsystem.events.PlayerMoveEvent;

import java.util.Random;

public class PlayerFootStepListener extends PlayerMoveEvent {
    private PlayerCharacter player;

    public PlayerFootStepListener() {
        super();
    }

    @Override
    public void onEvent() {
        Random rand = new Random();
        int int_random = rand.nextInt(3);
        Game.getSoundManager().PlaySound("footstep"+(int_random+1), 0.2f);
    }
}
