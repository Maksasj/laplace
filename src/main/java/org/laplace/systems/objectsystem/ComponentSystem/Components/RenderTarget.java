package org.laplace.systems.objectsystem.ComponentSystem.Components;

import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;

import static com.raylib.Raylib.LoadRenderTexture;

public class RenderTarget extends Component {
    private Raylib.RenderTexture target;

    public RenderTarget() {
        super(ComponentTypes.RENDER_TARGET);

        Init();
    }

    @Override
    public void Init() {
        target = LoadRenderTexture(
                Game.getWindowWidth() / Game.pixelezationRate,
                Game.getWindowHeight() / Game.pixelezationRate);
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw() {

    }

    public Raylib.RenderTexture GetTarget() {
        return target;
    }
}
