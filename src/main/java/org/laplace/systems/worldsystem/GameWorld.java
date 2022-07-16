package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;

public class GameWorld {
    public Chunk[][] chunks = new Chunk[8][8];;

    public GameWorld() {

        chunks[0][0] = new Chunk();
    }

    public void GenerateWorld()
    {
        new WorldGeneration(chunks);
    }
    public void Draw(int x, int y) {
        if(chunks[x][y] != null) {
            chunks[x][y].Draw();
        }
    }
}

class WorldGeneration
{
    WorldGeneration(Chunk[][] chunks)
    {
        RandomChankType rand = new RandomChankType();
        chunks[5][3] = new Chunk();
        chunks[5][3].changeType(rand.randomChank());

        
    }
}
