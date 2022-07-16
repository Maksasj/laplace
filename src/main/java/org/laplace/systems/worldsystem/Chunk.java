package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;

import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.*;

public class Chunk extends ChunkMesh{
    private int X; //relative to world
    private int Y; //relative to world
    private ChunkTypes chankType;
    private GameEntity[][] gameObjects = new GameEntity[8][8];

    public Chunk(int X, int Y) {
        super();

        this.X = X;
        this.Y = Y;

        for(int x = 0; x < 10; x++) { //10 bcs borders
            this.CreateWall(0, x);
            this.CreateWall(9, x);
        }

        for(int x = 0; x < 10; x++) {
            this.CreateWall(x, 0);
            this.CreateWall(x, 9);
        }

        this.RegenerateMesh();
        this.LoadAtlas();

        chankType = ChunkTypes.NULL;

        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                gameObjects[x][y] = new Goblin(0*2 + 8*X, 0*2 + 8*Y); //Testing
            }
        }

        gameObjects[0][0] = new Spider(0 + 8*X, 0 + 8*Y);
        gameObjects[3][3] = new Player(3 + 8*X, 3 + 8*Y);
        gameObjects[0][1] = new Skeleton(0 + 8*X, 0 + 8*Y);
        gameObjects[1][0] = new Chest(1 + 8*X, 0 + 8*Y);
    }

    public void changeType(ChunkTypes type){
        chankType = type;
    }

    public void Draw() {
        this.DrawChunkMesh();

        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(gameObjects[x][y] != null) {
                    gameObjects[x][y].Draw();
                }
            }
        }
    }

    public void Update() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(gameObjects[x][y] != null) {
                    gameObjects[x][y].Update();
                }
            }
        }
    }
}
