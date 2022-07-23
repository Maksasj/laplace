package org.laplace.systems.objectsystem.ComponentSystem.Components;

import org.laplace.Game;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentBlock;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;
import org.laplace.systems.objectsystem.GameEntitys.PlayerEntity.PlayerCharacter;

public class rBorder extends Component {
    private float rBorder = 0;
    private int rBorderShaderLoc;
    private PlayerCharacter player;

    private Battleble battleble;

    public rBorder(PlayerCharacter player) {
        super(ComponentTypes.RBORDER);
        this.player = player;

        Init();
    }

    @Override
    public void Update() {
        if(!battleble.GetBattleMode() && rBorder > 0.0) {
            rBorder -= 0.01;
            Game.getShaderManager().SetShaderValue("basePixelated", "rBorder", rBorderShaderLoc, rBorder);
        }
    }

    @Override
    public void AskDependencies(ComponentBlock dependencies) {
        if(dependencies.components.containsKey(ComponentTypes.BATTLEBLE)) {
            battleble = (Battleble) dependencies.components.get(ComponentTypes.BATTLEBLE);
        }
    }

    @Override
    public void Init() {
        rBorderShaderLoc = Game.getShaderManager().GetShaderLocation("basePixelated", "rBorder");
    }
}
