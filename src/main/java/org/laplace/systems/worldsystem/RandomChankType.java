package org.laplace.systems.worldsystem;

import java.util.Random;

public class RandomChankType {

    public static ChunkTypes randomChank() {
        Random rand = new Random();
        int int_random = rand.nextInt(4);
        switch (int_random) {
            case 0:
                return ChunkTypes.ONE_UP_DOOR;
            case 1:
                return ChunkTypes.ONE_RIGHT_DOOR;
            case 2:
                return ChunkTypes.ONE_DOWN_DOOR;
            case 3:
                return ChunkTypes.ONE_LEFT_DOOR;
            case 4:
                return ChunkTypes.TWO_LEFT_RIGHT_DOOR;
            case 5:
                return ChunkTypes.TWO_UP_DOWN_DOOR;
            case 6:
                return ChunkTypes.TWO_LEFT_UP_DOOR;
            case 7:
                return ChunkTypes.TWO_UP_RIGHT_DOOR;
            case 8:
                return ChunkTypes.TWO_RIGHT_DOWN_DOOR;
            case 9:
                return ChunkTypes.TWO_DOWN_LEFT_DOOR;
            case 10:
                return ChunkTypes.THREE_F_UP_DOOR;
            case 11:
                return ChunkTypes.THREE_F_RIGHT_DOOR;
            case 12:
                return ChunkTypes.THREE_F_DOWN_DOOR;
            case 13:
                return ChunkTypes.THREE_F_LEFT_DOOR;
            case 14:
                return ChunkTypes.FOUR_DOOR;
            default:
                return ChunkTypes.NULL;
        }
    }

    public static ChunkTypes randomChank(int int_random) {
        switch (int_random) {
            case 0:
                return ChunkTypes.ONE_UP_DOOR;
            case 1:
                return ChunkTypes.ONE_RIGHT_DOOR;
            case 2:
                return ChunkTypes.ONE_DOWN_DOOR;
            case 3:
                return ChunkTypes.ONE_LEFT_DOOR;
            case 4:
                return ChunkTypes.TWO_LEFT_RIGHT_DOOR;
            case 5:
                return ChunkTypes.TWO_UP_DOWN_DOOR;
            case 6:
                return ChunkTypes.TWO_LEFT_UP_DOOR;
            case 7:
                return ChunkTypes.TWO_UP_RIGHT_DOOR;
            case 8:
                return ChunkTypes.TWO_RIGHT_DOWN_DOOR;
            case 9:
                return ChunkTypes.TWO_DOWN_LEFT_DOOR;
            case 10:
                return ChunkTypes.THREE_F_UP_DOOR;
            case 11:
                return ChunkTypes.THREE_F_RIGHT_DOOR;
            case 12:
                return ChunkTypes.THREE_F_DOWN_DOOR;
            case 13:
                return ChunkTypes.THREE_F_LEFT_DOOR;
            case 14:
                return ChunkTypes.FOUR_DOOR;
            default:
                return ChunkTypes.NULL;
        }
    }
}
