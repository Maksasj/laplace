package org.laplace.systems.worldsystem;

import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.objectsystem.GameEntitys.Door;

import java.util.*;

public class GameWorld {
    public static Chunk[][] chunks = new Chunk[8][8];

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

    public void Update() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(chunks[x][y] != null) {
                    chunks[x][y].Update();
                }
            }
        }
    }

    public static GameEntity getEntity(int ix, int iy) {
        int X = ix / 10;
        int Y = iy / 10;

        int x = ix % 10;
        int y = iy % 10;

        if(X < 0 || X > 8) {
            return null;
        }

        if(Y < 0 || Y > 8) {
            return null;
        }

        if(chunks[X][Y] == null) {
            return null;
        }

        return chunks[X][Y].getEntity(x, y);
    }

    public static void killEnity(int ix, int iy) {
        int X = ix / 10;
        int Y = iy / 10;
        int x = ix % 10;
        int y = iy % 10;

        chunks[X][Y]
                .setEntity(null, x, y);
    }

    public static boolean ChechIfWall(int ix, int iy) {
        int X = ix / 10;
        int Y = iy / 10;

        int x = ix % 10;
        int y = iy % 10;

        if(X < 0 || X > 8) {
            return false;
        }

        if(Y < 0 || Y > 8) {
            return false;
        }

        if(x > 9 || x < 0) {
            return false;
        }

        if(y > 9 || y < 0) {
            return false;
        }

        if(chunks[X][Y] == null) {
            return false;
        }

        return chunks[X][Y].getWall(x, y);
    }

    public static void TranlocateEntity(GameEntity entity, int px, int py, int ix, int iy) {
        int X = ix / 10;
        int Y = iy / 10;
        int x = ix % 10;
        int y = iy % 10;

        int X1 = px / 10;
        int Y1 = py / 10;
        int x1 = px % 10;
        int y1 = py % 10;

        chunks[X][Y]
                .setEntity(entity, x, y);
        chunks[X1][Y1]
                .setEntity(null, x1, y1);
    }

    public void GenerateWorld() {
    
        chunks[0][0] = new Chunk(0,0, ChunkTypes.TWO_UP_RIGHT_DOOR);
        GenerateChunk(1, 0);
        GenerateChunk(0, 1);

        int buff[][] = new int[64][3];
        int l = 0;
            for (int i = 0; i < 8; i++) {
                for (int k = 0; k < 8; k++) {
                        buff[l][0] = i;
                        buff[l][1] = k;
                        buff[l][2] = 0;
                        l++;
                }
            }
        boolean some_action = true;
        while(some_action)
        {;
            some_action = false;
            for (int i = 0; i < 64; i++) {
                if (buff[i][2] == 0 && chunks[buff[i][0]][buff[i][1]] != null) {
                    switch (chunks[buff[i][0]][buff[i][1]].getType())
                    {
                        case ONE_UP_DOOR:
                            GenerateUpChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case ONE_LEFT_DOOR:
                            GenerateLeftChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case ONE_RIGHT_DOOR:
                            GenerateRightChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case ONE_DOWN_DOOR:
                            GenerateDownChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;

                        case TWO_LEFT_RIGHT_DOOR:
                            GenerateLeftChunk(buff, i);
                            GenerateRightChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case TWO_UP_DOWN_DOOR:
                            GenerateUpChunk(buff, i);
                            GenerateDownChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case TWO_LEFT_UP_DOOR:
                            GenerateLeftChunk(buff, i);
                            GenerateUpChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case TWO_UP_RIGHT_DOOR:
                            GenerateUpChunk(buff, i);
                            GenerateRightChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case TWO_RIGHT_DOWN_DOOR:
                            GenerateRightChunk(buff, i);
                            GenerateDownChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case TWO_DOWN_LEFT_DOOR:
                            GenerateDownChunk(buff, i);
                            GenerateLeftChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case THREE_F_UP_DOOR:
                            GenerateLeftChunk(buff, i);
                            GenerateRightChunk(buff, i);
                            GenerateDownChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case THREE_F_RIGHT_DOOR:
                            GenerateDownChunk(buff, i);
                            GenerateUpChunk(buff, i);
                            GenerateLeftChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case THREE_F_DOWN_DOOR:
                            GenerateUpChunk(buff, i);
                            GenerateLeftChunk(buff, i);
                            GenerateRightChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case THREE_F_LEFT_DOOR:
                            GenerateUpChunk(buff, i);
                            GenerateRightChunk(buff, i);
                            GenerateDownChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                        case FOUR_DOOR:
                            GenerateUpChunk(buff, i);
                            GenerateRightChunk(buff, i);
                            GenerateLeftChunk(buff, i);
                            GenerateDownChunk(buff, i);
                            buff[i][2] = 1;
                            some_action = true;
                            break;
                    }
                }
            }
        }

        chunks[0][0].CreatePlayer(1, 1);
    }

    public void RoomCleared(int X, int Y)
    {
        //In the chunk
        chunks[X][Y].DeleteRightDoors();
        chunks[X][Y].DeleteLeftDoors();
        chunks[X][Y].DeleteUpDoors();
        chunks[X][Y].DeleteDownDoors();

        //Nearby chunks
        if (X + 1 < 8 && chunks[X + 1][Y] != null)
        {
            chunks[X + 1][Y].DeleteLeftDoors();
        }
        if (X - 1 >= 0 && chunks[X - 1][Y] != null)
        {
            chunks[X - 1][Y].DeleteRightDoors();
        }
        if (Y + 1 < 8 && chunks[X][Y + 1] != null)
        {
            chunks[X][Y + 1].DeleteDownDoors();
        }
        if (Y - 1 >= 0 && chunks[X][Y - 1] != null)
        {
            chunks[X][Y - 1].DeleteUpDoors();
        }
    }

    public void GenerateRightChunk(int buff[][], int i)
    {
        if (buff[i][0] + 1 <= 7 && chunks[buff[i][0] + 1][buff[i][1]] == null)
        {
            GenerateChunk(buff[i][0] + 1, buff[i][1]);
        }
    }
    public void GenerateLeftChunk(int buff[][], int i)
    {
        if (buff[i][0] - 1 >= 0 && chunks[buff[i][0] - 1][buff[i][1]] == null)
        {
            GenerateChunk(buff[i][0] - 1, buff[i][1]);
        }
    }
    public void GenerateUpChunk(int buff[][], int i)
    {
        if (buff[i][1] + 1 <= 7 && chunks[buff[i][0]][buff[i][1] + 1] == null)
        {
            GenerateChunk(buff[i][0], buff[i][1] + 1);
        }
    }
    public void GenerateDownChunk(int buff[][], int i)
    {
        if (buff[i][1] - 1 >= 0 && chunks[buff[i][0]][buff[i][1] - 1] == null)
        {
            GenerateChunk(buff[i][0], buff[i][1] - 1);
        }
    }
    public static void GenerateChunk(int x, int y)
    {
        int[] pull = new int[15];
        for (int i = 0; i < 15; i++)
        {
            pull[i] = 1;
        }
        if(x + 1 < 8) {
            if (chunks[x + 1][y] != null) {
                if (chunks[x + 1][y].getType() == ChunkTypes.ONE_LEFT_DOOR
                        || chunks[x + 1][y].getType() == ChunkTypes.TWO_LEFT_RIGHT_DOOR
                        || chunks[x + 1][y].getType() == ChunkTypes.TWO_DOWN_LEFT_DOOR || chunks[x + 1][y].getType() == ChunkTypes.TWO_LEFT_UP_DOOR || chunks[x + 1][y].getType() == ChunkTypes.THREE_F_DOWN_DOOR || chunks[x + 1][y].getType() == ChunkTypes.THREE_F_RIGHT_DOOR || chunks[x + 1][y].getType() == ChunkTypes.THREE_F_UP_DOOR || chunks[x + 1][y].getType() == ChunkTypes.FOUR_DOOR) {
                    pull[0] = 0;
                    pull[2] = 0;
                    pull[3] = 0;
                    pull[5] = 0;
                    pull[6] = 0;
                    pull[9] = 0;
                    pull[11] = 0;
                } else {
                    pull[1] = 0;
                    pull[4] = 0;
                    pull[7] = 0;
                    pull[8] = 0;
                    pull[10] = 0;
                    pull[12] = 0;
                    pull[13] = 0;
                    pull[14] = 0;
                }
            }
        }
        else
        {
            pull[1] = 0;
            pull[4] = 0;
            pull[7] = 0;
            pull[8] = 0;
            pull[10] = 0;
            pull[12] = 0;
            pull[13] = 0;
            pull[14] = 0;
        }
        if(x - 1 >= 0)
        {
            if(chunks[x-1][y] != null)
            {
                if(chunks[x-1][y].getType() == ChunkTypes.ONE_RIGHT_DOOR || chunks[x-1][y].getType() == ChunkTypes.TWO_LEFT_RIGHT_DOOR || chunks[x-1][y].getType() == ChunkTypes.TWO_RIGHT_DOWN_DOOR || chunks[x-1][y].getType() == ChunkTypes.TWO_UP_RIGHT_DOOR || chunks[x-1][y].getType() == ChunkTypes.THREE_F_DOWN_DOOR || chunks[x-1][y].getType() == ChunkTypes.THREE_F_UP_DOOR || chunks[x-1][y].getType() == ChunkTypes.THREE_F_LEFT_DOOR || chunks[x-1][y].getType() == ChunkTypes.FOUR_DOOR)
                {
                    pull[0] = 0;
                    pull[1] = 0;
                    pull[2] = 0;
                    pull[5] = 0;
                    pull[7] = 0;
                    pull[8] = 0;
                    pull[13] = 0;
                }
                else
                {
                    pull[3] = 0;
                    pull[4] = 0;
                    pull[6] = 0;
                    pull[9] = 0;
                    pull[10] = 0;
                    pull[11] = 0;
                    pull[12] = 0;
                    pull[14] = 0;
                }
            }
        }
        else
        {
            pull[3] = 0;
            pull[4] = 0;
            pull[6] = 0;
            pull[9] = 0;
            pull[10] = 0;
            pull[11] = 0;
            pull[12] = 0;
            pull[14] = 0;
        }
        if(y + 1 < 8)
        {
            if(chunks[x][y+1] != null)
            {
                if(chunks[x][y+1].getType() == ChunkTypes.ONE_DOWN_DOOR || chunks[x][y+1].getType() == ChunkTypes.TWO_RIGHT_DOWN_DOOR || chunks[x][y+1].getType() == ChunkTypes.TWO_DOWN_LEFT_DOOR || chunks[x][y+1].getType() == ChunkTypes.TWO_UP_DOWN_DOOR || chunks[x][y+1].getType() == ChunkTypes.THREE_F_LEFT_DOOR || chunks[x][y+1].getType() == ChunkTypes.THREE_F_RIGHT_DOOR || chunks[x][y+1].getType() == ChunkTypes.THREE_F_UP_DOOR || chunks[x][y+1].getType() == ChunkTypes.FOUR_DOOR)
                {
                    pull[1] = 0;
                    pull[2] = 0;
                    pull[3] = 0;
                    pull[4] = 0;
                    pull[8] = 0;
                    pull[9] = 0;
                    pull[10] = 0;

                }
                else
                {
                    pull[0] = 0;
                    pull[5] = 0;
                    pull[6] = 0;
                    pull[7] = 0;
                    pull[11] = 0;
                    pull[12] = 0;
                    pull[13] = 0;
                    pull[14] = 0;
                }
            }
        }
        else
        {
            pull[0] = 0;
            pull[5] = 0;
            pull[6] = 0;
            pull[7] = 0;
            pull[11] = 0;
            pull[12] = 0;
            pull[13] = 0;
            pull[14] = 0;
        }

        if(y - 1 >= 0)
        {
            if(chunks[x][y-1] != null)
            {
                if(chunks[x][y-1].getType() == ChunkTypes.ONE_UP_DOOR || chunks[x][y-1].getType() == ChunkTypes.TWO_UP_DOWN_DOOR || chunks[x][y-1].getType() == ChunkTypes.TWO_UP_RIGHT_DOOR || chunks[x][y-1].getType() == ChunkTypes.TWO_LEFT_UP_DOOR || chunks[x][y-1].getType() == ChunkTypes.THREE_F_LEFT_DOOR || chunks[x][y-1].getType() == ChunkTypes.THREE_F_RIGHT_DOOR || chunks[x][y-1].getType() == ChunkTypes.THREE_F_DOWN_DOOR || chunks[x][y-1].getType() == ChunkTypes.FOUR_DOOR)
                {
                    pull[0] = 0;
                    pull[1] = 0;
                    pull[3] = 0;
                    pull[4] = 0;
                    pull[6] = 0;
                    pull[7] = 0;
                    pull[12] = 0;

                }
                else
                {
                    pull[2] = 0;
                    pull[5] = 0;
                    pull[8] = 0;
                    pull[9] = 0;
                    pull[10] = 0;
                    pull[11] = 0;
                    pull[13] = 0;
                    pull[14] = 0;
                }
            }
        }
        else
        {
            pull[2] = 0;
            pull[5] = 0;
            pull[8] = 0;
            pull[9] = 0;
            pull[10] = 0;
            pull[11] = 0;
            pull[13] = 0;
            pull[14] = 0;
        }

        //
        Vector<Integer> mas = new Vector<Integer>();
        for (int i = 0; i < 15; i++)
        {
            if(pull[i] == 1)
            {
                mas.add(i);
            }
        }
        Random rand = new Random();
        int j = Integer.parseInt(String.valueOf(mas.get(rand.nextInt(mas.size()))));
        //

        chunks[x][y] = new Chunk(x, y, RandomChunkType.randomChank(j));
    }
}

