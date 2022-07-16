package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.Goblin;

public class Chunk {
    private ChunkTypes chankType;
    private GameEntity[][] gameObjects = new GameEntity[8][8];

    public Chunk() {
        chankType = ChunkTypes.NULL;

        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                gameObjects[x][y] = new Goblin(); //Testing
            }
        }
    }

    public void changeType(ChunkTypes type){
        chankType = type;
    }

    public void Draw() {
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
