package org.laplace.systems.objectsystem.GameEntitys.PlayerEntity;

import com.raylib.Jaylib;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.eventsystem.EventTypes;
import org.laplace.systems.eventsystem.events.PlayerMoveEvent;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.Components.*;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntityTypes;
import org.laplace.systems.worldsystem.GameWorld;

import java.util.Random;

import static com.raylib.Raylib.IsKeyPressed;

public class PlayerCharacter extends GameEntity {
    public PlayerCharacter(int x, int y) {
        super("player", GameEntityTypes.PLAYER);

        this.x = x;
        this.y = y;

        components.addComponent(new Positionable());
        components.addComponent(
                new Model3D(this, "player")
                        .setModelScale(0.3f)
                        .setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f))
                        .setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f))
                        .setRot(270));
        components.addComponent(new Health(this, 35));
        components.addComponent(new CameraControl(this));
        components.addComponent(new Battleble(this));
        components.addComponent(new rBorder(this));
        components.addComponent(new PlayerWalk(this));

        Game.GetEventHandler().addEvent(new PlayerFootStepListener());
        Game.GetEventHandler().addEvent(new PlayerStartBattleListener(this));
        Game.GetEventHandler().addEvent(new PlayerDeathListener(this));
        Game.GetEventHandler().addEvent(new PlayerRotateListener(this));
    }

    @Override
    public void Update() { components.updateComponents(); }

    @Override
    public void Draw() {
        components.drawComponents();
    }
}
