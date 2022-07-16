package org.laplace.systems.worldsystem;

public class GameWorld {
    public Chunk[][] chunks = new Chunk[8][8];

    public GameWorld() {
        this.GenerateWorld();
    }

    public void Draw() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(chunks[x][y] != null) {
                    chunks[x][y].Draw();
                }
            }
        }
    }

    public void Update(int x, int y) {
        if(chunks[x][y] != null) {
            chunks[x][y].Update();
        }
    }

    public void GenerateWorld() {
        chunks[0][0] = new Chunk(0, 0);
        chunks[0][0].CreatePlayer(1, 1);

        chunks[1][0] = new Chunk(1, 0);
        chunks[1][0].changeType(new RandomChankType().randomChank());
    }
}

