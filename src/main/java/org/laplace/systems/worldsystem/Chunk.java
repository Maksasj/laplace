package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;

import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.*;
import org.laplace.systems.worldsystem.RandomChankType;


public class Chunk extends ChunkMesh{
    private int X; //relative to world
    private int Y; //relative to world
    private ChunkTypes chankType;
    private GameEntity[][] gameObjects = new GameEntity[8][8];

    public Chunk(int X, int Y) {
        super(X, Y);

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
                gameObjects[x][y] = new Goblin(x*2 + 8*X*2, y*2 + 8*Y*2); //Testing
            }
        }
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

    public void CreatePlayer(int x, int y) {
        gameObjects[x][y] = new Player(x + 8*this.X*2, y + 8*this.Y*2);
    }
}
