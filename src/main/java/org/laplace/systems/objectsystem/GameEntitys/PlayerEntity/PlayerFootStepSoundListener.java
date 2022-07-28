package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.Game;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.eventsystem.events.PlayerMoveEvent;

import java.util.Random;

public class PlayerFootStepSoundListener extends PlayerMoveEvent {
    public PlayerFootStepSoundListener() {
        super();
    }

    @Override
    public void onEvent(PlayerMoveData event) {
        System.out.println("CALLING PLAYERMOVEDATA");

        Random rand = new Random();
        int int_random = rand.nextInt(3);
        Game.getSoundManager().PlaySound("footstep"+(int_random+1), 0.2f);
    }
}
