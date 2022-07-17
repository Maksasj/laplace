package org.laplace.systems.worldsystem;

import com.raylib.Raylib;
import org.laplace.systems.objectsystem.GameEntitys.*;
import org.laplace.systems.objectsystem.GameEntity;
import java.util.Random;
import org.laplace.systems.worldsystem.ChunkMesh;

public class RandomRoomObjects {
    public RandomRoomObjects(int X, int Y, GameEntity[][] gameObjects, Chunk chunk)
    {
        Random rand = new Random();
        int rand_num = rand.nextInt(5);
        switch (rand_num)
        {
            case 0:
                for (int x = 3; x < 9; x++)
                {
                    chunk.CreateWall(x, 6);
                }
                for (int y = 1; y < 4; y++)
                {
                    chunk.CreateWall(3, y);
                    chunk.CreateWall(6, y);
                }
                break;
            case 1:
                for (int x = 3; x < 7; x++)
                {
                    chunk.CreateWall(x, 3);
                }
                for (int x = 6; x < 9; x++)
                {
                    chunk.CreateWall(x, 6);
                }
                for (int y = 1; y < 7; y++)
                {
                    chunk.CreateWall(3, y);
                }
                break;
            case 2:
                for (int x = 1; x < 4; x++)
                {
                    chunk.CreateWall(x, 6);
                }
                for (int x = 6; x < 9; x++)
                {
                    chunk.CreateWall(x, 3);
                }
                for (int y = 1; y < 4; y++)
                {
                    chunk.CreateWall(3, y);
                }
                for (int y = 6; y < 9; y++)
                {
                    chunk.CreateWall(6, y);
                }
                break;
            case 3:
                for (int x = 1; x < 4; x++)
                {
                    chunk.CreateWall(x, 6);
                }
                for (int x = 3; x < 7; x++)
                {
                    chunk.CreateWall(x, 3);
                }
                chunk.CreateWall(6, 6);
                for (int y = 3; y < 7; y++)
                {
                    chunk.CreateWall(3, y);
                    chunk.CreateWall(6, y);
                }
                break;
            case 4:
                for (int y = 3; y < 7; y++)
                {
                    chunk.CreateWall(3, y);
                    chunk.CreateWall(4, y);
                    chunk.CreateWall(5, y);
                    chunk.CreateWall(6, y);
                }
                break;
        }

    }
}
