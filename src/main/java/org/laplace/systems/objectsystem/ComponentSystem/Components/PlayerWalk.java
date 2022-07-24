package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentBlock;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;
import org.laplace.systems.renderer.lightsystem.Light;
import org.laplace.systems.worldsystem.GameWorld;

import static com.raylib.Raylib.IsKeyPressed;

public class PlayerWalk extends Component {
    private PlayerCharacter player;

    private boolean walkCd = false;
    private Battleble battleble;

    public PlayerWalk(PlayerCharacter player) {
        super(ComponentTypes.PLAYER_WALK);

        this.player = player;
    }

    @Override
    public void AskDependencies(ComponentBlock dependencies) {
        if(dependencies.components.containsKey(ComponentTypes.BATTLEBLE)) {
            battleble = (Battleble) dependencies.components.get(ComponentTypes.BATTLEBLE);
        }
    }

    @Override
    public void Update() {
        //Walking Cd
        if(!walkCd && !battleble.GetBattleMode()) {
            if(IsKeyPressed(68)) { //W
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_MOVE_EVENT);
                if(!GameWorld.ChechIfWall(player.x - 1, player.y)) {
                    if(GameWorld.getEntity(player.x - 1, player.y) == null) {
                        GameWorld.TranlocateEntity(player, player.x, player.y, player.x - 1, player.y);
                        player.x -= 1;
                        walkCd = true;
                    }
                } else {
                    Game.GetEventHandler().handleEvent(EventTypes.PLAYER_WALL_COLLISION);
                }
            }

            if(IsKeyPressed(65)) { //S
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_MOVE_EVENT);
                if(!GameWorld.ChechIfWall(player.x + 1, player.y)) {
                    if(GameWorld.getEntity(player.x + 1, player.y) == null) {
                        GameWorld.TranlocateEntity(player, player.x, player.y, player.x + 1, player.y);
                        player.x += 1;
                        walkCd = true;
                    }
                } else {
                    Game.GetEventHandler().handleEvent(EventTypes.PLAYER_WALL_COLLISION);
                }
            }

            if(IsKeyPressed(87)) { //D
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_MOVE_EVENT);
                if(!GameWorld.ChechIfWall(player.x, player.y + 1)) {
                    if(GameWorld.getEntity(player.x, player.y + 1) == null) {
                        GameWorld.TranlocateEntity(player, player.x, player.y, player.x, player.y + 1);
                        player.y += 1;
                        walkCd = true;
                    }
                } else {
                    Game.GetEventHandler().handleEvent(EventTypes.PLAYER_WALL_COLLISION);
                }
            }

            if(IsKeyPressed(83)) { //A
                Game.GetEventHandler().handleEvent(EventTypes.PLAYER_MOVE_EVENT);
                if(!GameWorld.ChechIfWall(player.x, player.y - 1)) {
                    if(GameWorld.getEntity(player.x, player.y - 1) == null) {
                        GameWorld.TranlocateEntity(player, player.x, player.y, player.x, player.y - 1);
                        player.y -= 1;
                        walkCd = true;
                    }
                } else {
                    Game.GetEventHandler().handleEvent(EventTypes.PLAYER_WALL_COLLISION);
                }
            }
        } else {
            walkCd = false;
        }
    }
}
