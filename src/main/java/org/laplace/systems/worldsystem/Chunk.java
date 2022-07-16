package org.laplace.systems.worldsystem;

import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.*;


public class Chunk extends ChunkMesh{
    private int X; //relative to world
    private int Y; //relative to world
    private ChunkTypes chankType;
    private GameEntity[][] gameObjects = new GameEntity[10][10];

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

        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 9; y++) {
                //gameObjects[x][y] = new Goblin(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
            }
        }
    }

    public void changeType(ChunkTypes type){
        chankType = type;
    }

    public ChunkTypes getType(){ return chankType;}
    public void Draw() {
        this.DrawChunkMesh();

        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 9; y++) {
                if(gameObjects[x][y] != null) {
                    gameObjects[x][y].Draw();
                }
            }
        }
    }

    public void Update() {
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 9; y++) {
                if(gameObjects[x][y] != null) {
                    gameObjects[x][y].Update();
                }
            }
        }
    }

    public void CreatePlayer(int x, int y) {
        gameObjects[x][y] = new Player(x + 10*this.X*2, y + 10*this.Y*2);
    }
}
