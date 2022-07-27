package org.laplace.systems.eventsystem.eventdata;

import org.laplace.systems.eventsystem.EventDataGeneric;
import org.laplace.systems.objectsystem.GameEntitys.Chest;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class PlayerChestEntityCollisionData extends EventDataGeneric {
    public PlayerCharacter player;
    public Chest chest;

    public PlayerChestEntityCollisionData(PlayerCharacter player, Chest chest) {
        this.player = player;
        this.chest = chest;
    }
}
