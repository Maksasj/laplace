package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntityTypes;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;
import org.laplace.systems.renderer.lightsystem.Light;
import org.laplace.systems.worldsystem.GameWorld;

public class Battleble extends Component {
    private PlayerCharacter player;

    private boolean battleMode;

    public Battleble(PlayerCharacter player) {
        super(ComponentTypes.BATTLEBLE);

        this.player = player;

        this.Init();
    }

    @Override
    public void Update() {
        if(GameWorld.getEntity(player.x + 1, player.y) != null) {
            if(GameWorld.getEntity(player.x + 1, player.y).getType().equals(GameEntityTypes.HOSTILE)) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_START_BATTLE_EVENT);
            }
        } else if(GameWorld.getEntity(player.x - 1, player.y) != null) {
            if(GameWorld.getEntity(player.x - 1, player.y).getType().equals(GameEntityTypes.HOSTILE)) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_START_BATTLE_EVENT);
            }
        } else if(GameWorld.getEntity(player.x, player.y + 1) != null) {
            if(GameWorld.getEntity(player.x, player.y + 1).getType().equals(GameEntityTypes.HOSTILE)) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_START_BATTLE_EVENT);
            }
        } else if(GameWorld.getEntity(player.x, player.y - 1) != null) {
            if(GameWorld.getEntity(player.x, player.y - 1).getType().equals(GameEntityTypes.HOSTILE)) {
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_START_BATTLE_EVENT);
            }
        }
    }

    public boolean GetBattleMode() {
        return battleMode;
    }
}