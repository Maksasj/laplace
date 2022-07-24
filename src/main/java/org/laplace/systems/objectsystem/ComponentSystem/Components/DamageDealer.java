package org.laplace.systems.objectsystem.ComponentSystem.Components;

import org.laplace.systems.objectsystem.ComponentSystem.Component;
import org.laplace.systems.objectsystem.ComponentSystem.ComponentTypes;

public class DamageDealer extends Component {
    private int defaultDamage;

    public DamageDealer(int defaultDamage) {
        super(ComponentTypes.DAMAGE_DEALER);

        this.defaultDamage = defaultDamage;
    }

    public int DealDamage() {
        return defaultDamage;
    }
}
