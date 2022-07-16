package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.*;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Chunk {
    private ChunkTypes chankType;
    private GameEntity[][] gameObjects = new GameEntity[8][8];

    private Model model;
    public Chunk() {
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

        Raylib.Image image = LoadImage("target/maps/test/cubicmap.png");      // Load cubicmap image (RAM)
        Raylib.Texture cubicmap = LoadTextureFromImage(image);                  // Convert image to texture to display (VRAM)

        Raylib.Mesh mesh = GenMeshCubicmap(image, new Jaylib.Vector3(1.0f, 1.0f, 1.0f ));
        model = LoadModelFromMesh(mesh);

        Texture texture = LoadTexture("target/maps/test/cubicmap_atlas.png");    // Load map texture
        model.materials().maps().texture(texture);
    }

    public void changeType(ChunkTypes type){
        chankType = type;
    }

    public void Draw() {
        Jaylib.Vector3 mapPosition = new Jaylib.Vector3( 0.0f, -1.0f, 0.0f);
        Raylib.DrawModelEx(model, mapPosition, new Jaylib.Vector3(0.0f, 0.0f, 0.0f) , 0, new Jaylib.Vector3(2.0f, 3.0f, 2.0f), RAYWHITE);

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
