package org.laplace.systems.worldsystem;

import com.raylib.Raylib;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.*;
import org.laplace.systems.worldsystem.ChunkTypes;

import java.util.Random;

import static com.raylib.Jaylib.WHITE;


public class Chunk extends ChunkMesh {
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

                Random rand = new Random();
                int int_random = rand.nextInt(6);

                if(int_random == 3) {
                    gameObjects[x][y] = new Goblin(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
                }
            }
        }
    }
    
    public Chunk(int X, int Y, ChunkTypes chad) {
        super(X, Y);

        this.X = X;
        this.Y = Y;

        chankType = chad;
        switch (chankType) {

            case ONE_UP_DOOR:

                //Left & Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
            break;

            case ONE_LEFT_DOOR:

                //Left
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }

                break;

            case ONE_RIGHT_DOOR:

                //Left
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }

                break;

            case ONE_DOWN_DOOR:

                //Left & Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                break;

            case TWO_LEFT_RIGHT_DOOR:

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Left
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }

                break;

            case TWO_UP_DOWN_DOOR:

                //Left & Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                break;

            case TWO_LEFT_UP_DOOR:

                //Left
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }
                break;

            case TWO_UP_RIGHT_DOOR:

                //Left
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }
                break;

            case TWO_RIGHT_DOWN_DOOR:

                //Left
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                break;

            case TWO_DOWN_LEFT_DOOR:

                //Left
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                break;

            case THREE_F_UP_DOOR:

                //Left
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                break;

            case THREE_F_RIGHT_DOOR:

                //Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Left
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                break;

            case THREE_F_DOWN_DOOR:

                //Left
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }
                break;

            case THREE_F_LEFT_DOOR:

                //Left
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                break;

            case FOUR_DOOR:

                //Left
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                break;
        }
        this.RegenerateMesh();
        this.LoadAtlas();



        /*
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 9; y++) {

                Random rand = new Random();
                int int_random = rand.nextInt(6);

                if(int_random == 3) {
                    gameObjects[x][y] = new Goblin(x*2 + 10*X*2, y*2 + 10*Y*2); //Testing
                }
            }
        }*/
    }

    public void setEntity(GameEntity entity, int x, int y) {
        gameObjects[x][y] = entity;
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

    public boolean getWall(int x, int y) {
        return walls[x][y];
    }

    public GameEntity getEntity(int x, int y) {
        if(gameObjects[x][y] != null) {
            return gameObjects[x][y];
        }
        return null;
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
