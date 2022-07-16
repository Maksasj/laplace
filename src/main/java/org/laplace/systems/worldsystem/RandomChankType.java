package org.laplace.systems.worldsystem;

import java.util.Random;

public class RandomChankType {

    ChunkTypes randomChank()
    {
        Random rand = new Random();
        int int_random = rand.nextInt(15);
        switch (int_random) {
            case 0:
                return ChunkTypes.ONE_UP_DOOR;
            case 1:
                return ChunkTypes.ONE_RIGHT_DOOR;
            case 2:
                return ChunkTypes.ONE_RIGHT_DOOR;
            default:
                return ChunkTypes.NULL;

        }
    }
}
