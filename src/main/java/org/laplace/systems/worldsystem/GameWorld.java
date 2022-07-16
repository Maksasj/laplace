package org.laplace.systems.worldsystem;

import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.worldsystem.RandomChankType;
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

        if(X < 0 || X > 8) {
            return;
        }

        if(Y < 0 || Y > 8) {
            return;
        }

        if(chunks[X][Y] == null) {
            return;
        }

        chunks[X][Y].setEntity(null, x, y);
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
    
        GenerateChunk(0, 0);
        GenerateChunk(1, 0);
        GenerateChunk(0, 1);
        GenerateChunk(1, 1);
        chunks[0][0].CreatePlayer(5, 3);

        /*
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
        int some_action = 0;
        while(some_action <= 64)
        {
            for (int i = 0; i < 64; i++) {
                if (buff[i][2] == 0 && chunks[buff[i][0]][buff[i][1]] != null) {
                    switch (chunks[buff[i][0]][buff[i][1]].getType()) {
                        case ONE_UP_DOOR:
                            if((buff[i][1] + 1) < 8) {
                                if (chunks[buff[i][0]][buff[i][1] + 1] == null) {
                                    chunks[buff[i][0]][buff[i][1] + 1] = new Chunk(buff[i][0], (buff[i][1] + 1));
                                    buff[i][2] = 1;
                                    some_action = 0;
                                } else {
                                    buff[i][2] = 1;
                                    some_action = 0;
                                }
                            }
                            break;

                        case ONE_RIGHT_DOOR:
                            if((buff[i][0] + 1) < 8) {
                                if (chunks[buff[i][0] + 1][buff[i][1]] == null) {
                                    chunks[buff[i][0] + 1][buff[i][1]] = new Chunk((buff[i][0] + 1), buff[i][1]);
                                    buff[i][2] = 1;
                                    some_action = 0;
                                } else {
                                    buff[i][2] = 1;
                                    some_action = 0;
                                }
                            }
                            break;

                        case ONE_DOWN_DOOR:
                            if ((buff[i][1] - 1) >= 0) {
                                if (chunks[buff[i][0]][buff[i][1] - 1] == null) {
                                    chunks[buff[i][0]][buff[i][1] - 1] = new Chunk(buff[i][0], (buff[i][1] - 1));
                                    buff[i][2] = 1;
                                    some_action = 0;
                                } else {
                                    buff[i][2] = 1;
                                    some_action = 0;
                                }
                            }
                            break;

                        case ONE_LEFT_DOOR:
                            if ((buff[i][0] - 1) >= 0) {
                                if (chunks[buff[i][0] - 1][buff[i][1]] == null) {
                                    chunks[buff[i][0] - 1][buff[i][1]] = new Chunk((buff[i][0] - 1), buff[i][1]);
                                    buff[i][2] = 1;
                                    some_action = 0;
                                } else {
                                    buff[i][2] = 1;
                                    some_action = 0;
                                }
                            }
                            break;
                            /*
                        case TWO_LEFT_RIGHT_DOOR:
                            break;
                        case TWO_UP_DOWN_DOOR:
                            break;
                        case TWO_LEFT_UP_DOOR:
                            break;
                        case TWO_UP_RIGHT_DOOR:
                            break;
                        case TWO_RIGHT_DOWN_DOOR:
                            break;
                        case TWO_DOWN_LEFT_DOOR:
                            break;
                        case THREE_F_UP_DOOR:
                            break;
                        case THREE_F_RIGHT_DOOR:
                            break;
                        case THREE_F_DOWN_DOOR:
                            break;
                        case THREE_F_LEFT_DOOR:
                            break;
                        case FOUR_DOOR:
                            break;
                        case NULL:
                            int pull[] = new int[15];
                            for(int a = 0; a < 15; a++)
                            {
                                pull[a] = 1;
                            }
                            if(chunks[buff[i][0] + 1][buff[i][1]] != null)
                            {

                                pull[1] = 0;

                            }
                            break;
                        default:
                            break;
                    }
                }
                some_action++;
            }
        }
        */
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
        int k = rand.nextInt(mas.size());
        String g = String.valueOf(mas.get(k));
        int j = Integer.parseInt(g);
        //

        chunks[x][y] = new Chunk(x, y, RandomChankType.randomChank(j));
    }
}

