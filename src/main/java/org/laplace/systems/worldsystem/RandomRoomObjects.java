package org.laplace.systems.worldsystem;

import com.raylib.Raylib;
import org.laplace.systems.objectsystem.GameEntitys.*;
import org.laplace.systems.objectsystem.GameEntity;
import java.util.Random;

import org.laplace.systems.objectsystem.GameObject;
import org.laplace.systems.worldsystem.ChunkMesh;

public class RandomRoomObjects {
    public RandomRoomObjects(int X, int Y, GameEntity[][] gameObjects, Chunk chunk)
    {
        Random rand = new Random();
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 9; y++) {
                int j = rand.nextInt(65);
                if (j < 2) {
                    gameObjects[x][y] = new Goblin(x * 2 + 10 * X * 2, y * 2 + 10 * Y * 2); //Testing
                }
                if (j > 6 && j < 9) {
                    gameObjects[x][y] = new Spider(x * 2 + 10 * X * 2, y * 2 + 10 * Y * 2); //Testing
                }
                if (j > 62) {
                    gameObjects[x][y] = new Skeleton(x * 2 + 10 * X * 2, y * 2 + 10 * Y * 2); //Testing
                }
            }
        }
        int rand_num1 = rand.nextInt(5);
        switch (rand_num1)
        {
            case 0:
                for (int x = 3; x < 9; x++)
                {
                    gameObjects[x][6] = null;
                    chunk.CreateWall(x, 6);
                }
                for (int y = 1; y < 4; y++)
                {
                    gameObjects[3][y] = null;
                    gameObjects[6][y] = null;
                    chunk.CreateWall(3, y);
                    chunk.CreateWall(6, y);
                }
                break;
            case 1:
                for (int x = 3; x < 7; x++)
                {
                    gameObjects[x][3] = null;
                    chunk.CreateWall(x, 3);
                }
                for (int x = 6; x < 9; x++)
                {
                    gameObjects[x][6] = null;
                    chunk.CreateWall(x, 6);
                }
                for (int y = 1; y < 7; y++)
                {
                    gameObjects[3][y] = null;
                    chunk.CreateWall(3, y);
                }
                break;
            case 2:
                for (int x = 1; x < 4; x++)
                {
                    gameObjects[x][6] = null;
                    chunk.CreateWall(x, 6);
                }
                for (int x = 6; x < 9; x++)
                {
                    gameObjects[x][3] = null;
                    chunk.CreateWall(x, 3);
                }
                for (int y = 1; y < 4; y++)
                {
                    gameObjects[3][y] = null;
                    chunk.CreateWall(3, y);
                }
                for (int y = 6; y < 9; y++)
                {
                    gameObjects[6][y] = null;
                    chunk.CreateWall(6, y);
                }
                break;
            case 3:
                for (int x = 1; x < 4; x++)
                {
                    gameObjects[x][6] = null;
                    chunk.CreateWall(x, 6);
                }
                for (int x = 3; x < 7; x++)
                {
                    gameObjects[x][3] = null;
                    chunk.CreateWall(x, 3);
                }
                gameObjects[6][6] = null;
                chunk.CreateWall(6, 6);
                for (int y = 3; y < 7; y++)
                {
                    gameObjects[3][y] = null;
                    gameObjects[6][y] = null;
                    chunk.CreateWall(3, y);
                    chunk.CreateWall(6, y);
                }
                break;
            case 4:
                for (int y = 3; y < 7; y++)
                {
                    gameObjects[3][y] = null;
                    gameObjects[4][y] = null;
                    gameObjects[5][y] = null;
                    gameObjects[6][y] = null;
                    chunk.CreateWall(3, y);
                    chunk.CreateWall(4, y);
                    chunk.CreateWall(5, y);
                    chunk.CreateWall(6, y);
                }
                break;
        }
    }
}
