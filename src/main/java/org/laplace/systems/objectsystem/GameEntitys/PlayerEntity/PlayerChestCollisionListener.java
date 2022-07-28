package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.systems.eventsystem.eventdata.PlayerChestEntityCollisionData;
import org.laplace.systems.eventsystem.events.PlayerChestEntityCollision;
import org.laplace.systems.eventsystem.events.PlayerDeathEvent;

public class PlayerChestCollisionListener extends PlayerChestEntityCollision {
    private PlayerCharacter player;

    public PlayerChestCollisionListener(PlayerCharacter player) {
        super();

        this.player = player;
    }

    @Override
    public void onEvent(PlayerChestEntityCollisionData event) {
        System.out.println("Player collided chest");
    }
}
