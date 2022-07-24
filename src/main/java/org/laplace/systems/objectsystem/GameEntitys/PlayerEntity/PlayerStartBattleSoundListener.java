package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.Game;
import org.laplace.systems.eventsystem.events.PlayerDeathEvent;

public class PlayerStartBattleSoundListener extends PlayerDeathEvent {
    public PlayerStartBattleSoundListener() { super(); }
    @Override
    public void onEvent() {
        Game.getSoundManager().PlaySound("battlebeggining", 0.2f);
    }
}
