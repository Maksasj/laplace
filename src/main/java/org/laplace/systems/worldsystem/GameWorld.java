package org.laplace.systems.worldsystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

        chunks[5][3] = new Chunk(5, 3);
        chunks[5][3].changeType(new RandomChankType().randomChank());
        /*
        int buff[][] = new int[64][3];
        boolean buff_is_not_empty = true;

        while(buff_is_not_empty)
        {
            for (int i = 0; i < 64; i++) {
                if(buff[i][3] == 0) {
                    switch (chunks[buff[i][0]][buff[i][1]].getType()) {
                        case ONE_UP_DOOR:
                            chunks[buff[0][0]][buff[0][1] + 1] = new Chunk( buff[0][0], (buff[0][1] + 1));
                            break;
                            /*
                        case ONE_RIGHT_DOOR:
                            break;
                        case ONE_DOWN_DOOR:
                            break;
                        case ONE_LEFT_DOOR:
                            break;
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

                        default:
                            break;
                    }
                }
            }
            buff_is_not_empty = false;
            for (int i = 0; i < 64; i++)
            {
                if (buff[i][2] == 0)
                {
                    buff_is_not_empty = true;
                }
            }
        }
        */
    }
}

