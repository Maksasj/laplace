package org.laplace.systems.worldsystem;

import com.raylib.Raylib;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.*;
import org.laplace.systems.worldsystem.ChunkTypes;
import org.laplace.systems.worldsystem.RandomRoomObjects;
import java.util.Random;

import static com.raylib.Jaylib.WHITE;


public class Chunk extends ChunkMesh {
    private int X; //relative to world
    private int Y; //relative to world
    private ChunkTypes chankType;
    public GameEntity[][] gameObjects = new GameEntity[10][10];

    public Chunk(int X, int Y, ChunkTypes chad) {
        super(X, Y);

        this.X = X;
        this.Y = Y;

        chankType = chad;
        switch (chankType) {

            case ONE_UP_DOOR:

                //Doors
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 9);
                }


                //Left & Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }
                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
            break;

            case ONE_LEFT_DOOR:

                //Door
                for(int y = 4; y < 6; y++)
                {
                    this.CreateTurnedDoor(0, y);
                }


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

                //Door
                for(int y = 4; y < 6; y++)
                {
                    this.CreateTurnedDoor(9, y);
                }

                //Left
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
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

                //Door
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 0);
                }

                //Left & Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                break;

            case TWO_LEFT_RIGHT_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(9, y);
                }
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(0, y);
                }


                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
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
                    this.CreateWall(x, 9);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }

                break;

            case TWO_UP_DOWN_DOOR:

                //Door
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 0);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 9);
                }

                //Left & Right
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                break;

            case TWO_LEFT_UP_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(0, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 9);
                }

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
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }
                break;

            case TWO_UP_RIGHT_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(9, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 9);
                }

                //Left
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }
                break;

            case TWO_RIGHT_DOWN_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(9, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 0);
                }


                //Left
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                break;

            case TWO_DOWN_LEFT_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(0, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 0);
                }

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
                    this.CreateWall(x, 9);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                break;

            case THREE_F_UP_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(0, y);
                }
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(9, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 0);
                }

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
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 9);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                break;

            case THREE_F_RIGHT_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(0, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 0);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 9);
                }

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
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }
                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                break;

            case THREE_F_DOWN_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(0, y);
                }
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(9, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 9);
                }

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
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }

                //Down
                for (int x = 0; x < 10; x++) {
                    this.CreateWall(x, 0);
                }
                break;

            case THREE_F_LEFT_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(9, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 0);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 9);
                }

                //Left
                for (int y = 0; y < 10; y++) { //10 bcs borders
                    this.CreateWall(0, y);
                }

                //Right
                for (int y = 0; y < 4; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                break;

            case FOUR_DOOR:

                //Door
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(0, y);
                }
                for (int y = 4; y < 6; y++) { //10 bcs borders
                    this.CreateTurnedDoor(9, y);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 0);
                }
                for (int x = 4; x < 6; x++)
                {
                    this.CreateDoor(x, 9);
                }


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
                for (int y = 6; y < 10; y++) { //10 bcs borders
                    this.CreateWall(9, y);
                }

                //Down
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 0);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 0);
                }

                //Up
                for (int x = 0; x < 4; x++)
                {
                    this.CreateWall(x, 9);
                }
                for (int x = 6; x < 10; x++)
                {
                    this.CreateWall(x, 9);
                }
                break;
        }

        new RandomRoomObjects(X, Y, gameObjects, this);

        this.RegenerateMesh();
        this.LoadAtlas();
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

        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
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
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                if(gameObjects[x][y] != null) {
                    gameObjects[x][y].Update();
                }
            }
        }
    }

    public void CreatePlayer(int x, int y) {
        gameObjects[x][y] = new Player(x*2 + 10*this.X*2, y*2 + 10*this.Y*2);
    }

    public boolean MobCheck()
    {
        for (int x = 1; x < 9; x++)
        {
            for (int y = 1; y < 9; y++)
            {
                if (gameObjects[x][y].getName() == "goblin" || gameObjects[x][y].getName() == "spider" || gameObjects[x][y].getName() == "skeleton" )
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void DeleteDownDoors()
    {
        for (int x = 4; x < 6; x++)
        {
            if(this.gameObjects[x][0].getName() == "door")
            {
                this.gameObjects[x][0] = null;
            }
        }
    }
    public void DeleteUpDoors()
    {
        for (int x = 4; x < 6; x++)
        {
            if(this.gameObjects[x][9].getName() == "door") {
                this.gameObjects[x][9] = null;
            }
        }
    }
    public void DeleteRightDoors()
    {
        for (int y = 4; y < 6; y++)
        {
            if(this.gameObjects[9][y].getName() == "door") {
                this.gameObjects[9][y] = null;
            }
        }
    }
    public void DeleteLeftDoors()
    {
        for (int y = 4; y < 6; y++)
        {
            if(this.gameObjects[0][y].getName() == "door") {
                this.gameObjects[0][y] = null;
            }
        }
    }

    public void CreateDoor(int x, int y) {
        gameObjects[x][y] = new Door(x*2 + 10*this.X*2, y*2 + 10*this.Y*2);
    }
    public void CreateTurnedDoor(int x, int y) {
        gameObjects[x][y] = new TurnedDoor(x*2 + 10*this.X*2, y*2 + 10*this.Y*2);
    }
}
