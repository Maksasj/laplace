package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.*;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Chunk extends ChunkMesh{
    private ChunkTypes chankType;
    private GameEntity[][] gameObjects = new GameEntity[8][8];

    public Chunk() {
        super();

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
                gameObjects[x][y] = new Goblin(); //Testing
            }
        }

        gameObjects[0][0] = new Spider();
        gameObjects[0][2] = new Player();
        gameObjects[0][1] = new Skeleton();
        gameObjects[1][0] = new Chest();
    }

    public void changeType(ChunkTypes type){
        chankType = type;
    }

    public void Draw() {
        this.DrawChunkMesh();

        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(gameObjects[x][y] != null) {
                    gameObjects[x][y].Draw(new Jaylib.Vector3(x*2, 0, y*2));
                }
            }
        }
    }

    public void Update() {

    }
}
