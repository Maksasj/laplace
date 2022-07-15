package org.laplace.systems.modelmanager;

import java.util.Random;

public class RandomChankType {

    ChankType randomChank()
    {
        Random rand = new Random();
        int int_random = rand.nextInt(15);
        switch (int_random) {
            case 0:
                return ChankType.ONE_UP_DOOR;
            case 1:
                return ChankType.ONE_RIGHT_DOOR;
            case 2:
                return ChankType.ONE_RIGHT_DOOR;
            default:
                return ChankType.NULL;

        }
    }
}
