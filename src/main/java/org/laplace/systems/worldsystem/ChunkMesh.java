package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.LoadTexture;

public class ChunkMesh {
    private Model chunkModel;
    private  Jaylib.Vector3 mapPosition;

    private Raylib.Image image;

    public ChunkMesh() {
        image = LoadImage("target/maps/test/cubicmap.png");      // Load cubicmap image (RAM)

        mapPosition = new Jaylib.Vector3( 0.0f, -1.0f, 0.0f);
    }

    public void DrawChunkMesh() {
        Raylib.DrawModelEx(chunkModel, mapPosition, new Jaylib.Vector3(0.0f, 0.0f, 0.0f) , 0, new Jaylib.Vector3(2.0f, 3.0f, 2.0f), RAYWHITE);
    }

    public void RegenerateMesh() {
        Raylib.Mesh mesh = GenMeshCubicmap(image, new Jaylib.Vector3(1.0f, 1.0f, 1.0f ));
        chunkModel = LoadModelFromMesh(mesh);
    }

    public void CreateWall(int x, int y) {
        Raylib.ImageDrawPixel(image, x,y, WHITE);
    }

    public void LoadAtlas() {
        Texture texture = LoadTexture("target/maps/test/cubicmap_atlas.png");    // Load map texture
        chunkModel.materials().maps().texture(texture);
    }
}
