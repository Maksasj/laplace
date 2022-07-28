package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import org.laplace.Game;
import org.laplace.systems.eventsystem.eventdata.PlayerDeathData;
import org.laplace.systems.eventsystem.eventdata.PlayerStartedBattleData;
import org.laplace.systems.eventsystem.events.PlayerDeathEvent;

public class PlayerStartBattleSoundListener extends PlayerDeathEvent {
    public PlayerStartBattleSoundListener() { super(); }
    @Override
    public void onEvent(PlayerDeathData event) {
        Game.getSoundManager().PlaySound("battlebeggining", 0.2f);
    }
}

//=====================================================================
//Todo implement proper EventData passing to all listeners and events !
//=====================================================================