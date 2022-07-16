package org.laplace.systems.worldsystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public void Update(int x, int y) {
        if(chunks[x][y] != null) {
            chunks[x][y].Update();
        }
    }

    public static boolean ChechIfWall(int ix, int iy) {
        int X = ix / 20;
        int Y = iy / 20;

        int x = ix % 20;
        int y = iy % 20;

        if(X < 0 || X > 8) {
            return false;
        }

        if(Y < 0 || Y > 8) {
            return false;
        }

        if(chunks[X][Y] == null) {
            return false;
        }

        return chunks[X][Y].getWall(x, y);
    }

    public void GenerateWorld() {
        chunks[0][0] = new Chunk(0, 0);
        chunks[0][0].CreatePlayer(5, 3);

        chunks[1][1] = new Chunk(1, 1);
        chunks[5][3] = new Chunk(5, 3);

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
                             */
                        default:
                            break;
                    }
                }
                some_action++;
            }
        }

    }
}

