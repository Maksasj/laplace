package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.scenes.gamescene.GameScene;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentBlock;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;
import org.laplace.systems.renderer.lightsystem.Light;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.GetMouseX;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class CameraControl extends Component {
    private Positionable positionable;
    private boolean mauseHold;
    private float mauseX;
    private float prevMauseX;

    public PlayerCharacter player;

    public CameraControl(GameEntity gameEntity) {
        super(ComponentTypes.CAMERA_CONTROL);

        mauseHold = false;
        mauseX = 0;
        player = (PlayerCharacter) gameEntity;
    }

    @Override
    public void AskDependencies(ComponentBlock dependencies) {
        if(dependencies.components.containsKey(ComponentTypes.POSITIONABLE)) {
            positionable = (Positionable) dependencies.components.get(ComponentTypes.POSITIONABLE);
        }
    }

    @Override
    public void Update() {
        Game.getCamera()
                ._position(
                        new Jaylib.Vector3(
                                (float) ((float) positionable.pos.x() - 7.0f*sin(mauseX)),
                                5.0f, (float)
                                ((float)  positionable.pos.z() - 7*cos(mauseX))))
                .target(    new Jaylib.Vector3( positionable.pos.x(), 1.0f, (float)  positionable.pos.z()))
                .up(        new Raylib.Vector3().x(0).y(1).z(0))
                .fovy(45)
                .projection(CAMERA_PERSPECTIVE);

        GameScene.setViewPos(
                new Jaylib.Vector3(
                        (float) ((float) positionable.pos.x()),
                        2.0f,
                        (float) ((float)  positionable.pos.z())));

        if(IsMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
            mauseHold = true;

            prevMauseX = GetMouseX();
        }

        if(IsMouseButtonReleased(MOUSE_BUTTON_LEFT)) {
            mauseHold = false;
        }

        if(mauseHold) {
            mauseX += (prevMauseX - GetMouseX())*0.01f;
            prevMauseX = GetMouseX();
        }
    }
}
