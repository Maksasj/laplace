package org.laplace.systems.worldsystem;

import com.raylib.Raylib;
import org.laplace.systems.objectsystem.GameEntitys.*;
import org.laplace.systems.objectsystem.GameEntity;
import java.util.Random;

public class RandomRoomObjects {
    public RandomRoomObjects(int X, int Y, GameEntity[][] gameObjects)
    {
        Random rand = new Random();
        int rand_num = rand.nextInt(3);
        switch (rand_num)
        {
            case 0:
                for(int x = 1; x < 9; x++) {
                    for(int y = 1; y < 9; y++) {

                        int int_random = rand.nextInt(40);
                        if(int_random == 3) {
                            gameObjects[x][y] = new Goblin(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
                        }
                        int_random = rand.nextInt(35);
                        if(int_random == 13) {
                            gameObjects[x][y] = new Skeleton(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
                        }
                    }
                }
                break;
            case 1:
                for(int x = 1; x < 9; x++) {
                    for(int y = 1; y < 9; y++) {

                        int int_random = rand.nextInt(60);
                        if(int_random == 3) {
                            gameObjects[x][y] = new Spider(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
                        }
                        int_random = rand.nextInt(45);
                        if(int_random == 13) {
                            gameObjects[x][y] = new Skeleton(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
                        }
                    }
                }
                break;
            case 2:
                for(int x = 1; x < 9; x++) {
                    if (x == 4)
                    {
                        x = 6;
                    }
                    for(int y = 1; y < 9; y++) {
                        if(y == 4)
                        {
                            y = 6;
                        }
                        int int_random = rand.nextInt(20);
                        if(int_random == 3) {
                            gameObjects[x][y] = new Goblin(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
                        }
                        int_random = rand.nextInt(13);
                        if(int_random == 12) {
                            gameObjects[x][y] = new Skeleton(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
                        }
                    }
                }
                gameObjects[4][4] = new Chest(8 + 10*X*2, 8 + 10*Y*2);
                break;
        }

    }
}
