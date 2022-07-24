package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;

//Note: Positionable in 3d space
public class Positionable extends Component {
    public Jaylib.Vector3 pos; //Graphic thing
    public Jaylib.Vector3 offset;
    public Jaylib.Vector3 rotAxis;

    public float rot;

    public Positionable() {
        super(ComponentTypes.POSITIONABLE);
        Init();
    }

    @Override
    public void Init() {
        pos = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
        offset = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);
        rotAxis = new Jaylib.Vector3(0.0f, 0.0f, 0.0f);

        rot = 0.0f;
    }

    public void setOffset(Jaylib.Vector3 value) {
        offset = value;
    }

    public void setRotAxis(Jaylib.Vector3 value) {
        rotAxis = value;
    }

    public void setRot(float value) {
        rot = value;
    }

}
