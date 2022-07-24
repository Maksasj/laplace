package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;

import static com.raylib.Raylib.SetCameraMode;

public class CameraComponent extends Component {
    private Raylib.Camera3D camera;

    public CameraComponent() {
        super(ComponentTypes.CAMERA);

        camera = new Raylib.Camera3D();
    }

    public CameraComponent SetPosition(Jaylib.Vector3 value) {
        camera._position(value);
        return this;
    }

    public CameraComponent SetTarget(Jaylib.Vector3 value) {
        camera.target(value);
        return this;
    }

    public CameraComponent SetUp(Jaylib.Vector3 value) {
        camera.up(value);
        return this;
    }

    public CameraComponent SetFovy(int value) {
        camera.fovy(value);
        return this;
    }

    public CameraComponent SetProjection(int value) {
        camera.projection(value);
        return this;
    }

    public CameraComponent SetCameraCompMode(int value) {
        SetCameraMode(camera, value);
        return this;
    }

    public Raylib.Camera3D GetCamera() {
        return camera;
    }
}
