package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import com.raylib.Jaylib;
import org.laplace.Game;
import org.laplace.systems.eventsystem.eventdata.PlayerMoveData;
import org.laplace.systems.eventsystem.events.PlayerMoveEvent;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.ComponentSystem.Components.Positionable;

import java.util.Random;

import static com.raylib.Raylib.IsKeyPressed;

public class PlayerRotateListener extends PlayerMoveEvent {
    private PlayerCharacter player;

    public PlayerRotateListener(PlayerCharacter player) {
        super();

        this.player = player;
    }

    @Override
    public void onEvent(PlayerMoveData event) {
        if(IsKeyPressed(68)) { //W
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setRotAxis(new Jaylib.Vector3(1.0f, 1.0f, 1.0f));
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setRot(240.0f);
        }

        if(IsKeyPressed(65)) { //S
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setRotAxis(new Jaylib.Vector3(1.0f, -1.0f, -1.0f));
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setRot(240);
        }

        if(IsKeyPressed(87)) { //D
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setRot(270);
        }

        if(IsKeyPressed(83)) { //A
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setRotAxis(new Jaylib.Vector3(0.0f, 0.7f, 0.7f));
            ((Positionable) player.components.components.get(ComponentTypes.POSITIONABLE))
                    .setRot(180);
        }
    }
}
