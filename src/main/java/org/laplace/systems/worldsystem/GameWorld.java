package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;

public class GameWorld {
    private Chunk[][] chunks = new Chunk[8][8];;

    public GameWorld() {
        chunks[0][0] = new Chunk();
    }

    public void Draw(int x, int y) {
        if(chunks[x][y] != null) {
            chunks[x][y].Draw();
        }
    }
}
