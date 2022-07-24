package org.laplace.systems.objectsystem.ComponentSystem.Components;

import org.laplace.Game;
import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;

public class Timer extends Component {
    private int time;
    private int shaderLoc;
    String shaderName;
    String timerUni;
    private boolean shadered;


    public Timer(String shaderName, String timerUni) {
        super(ComponentTypes.TIMER);

        shaderLoc = Game.getShaderManager().GetShaderLocation(shaderName, timerUni);

        this.shaderName = shaderName;
        this.timerUni = timerUni;

        shadered = true;

        time = 0;
    }

    public Timer() {
        super(ComponentTypes.TIMER);
        time = 0;
        shadered = false;
    }

    @Override
    public void Update() {
        time++;

        if(shadered) {
            Game.getShaderManager().SetShaderValue(shaderName, timerUni, shaderLoc, time);
        }
    }

    public int GetTime() {
        return time;
    }
}