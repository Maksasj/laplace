package org.laplace.systems.worldsystem;

import com.raylib.Jaylib;

import javax.lang.model.type.NullType;
import java.util.Iterator;
import java.util.Vector;

public class GameWorld {
    public Chunk[][] chunks = new Chunk[8][8];;

    public GameWorld() {

        chunks[0][0] = new Chunk();
    }

    public void GenerateWorld()
    {
        new WorldGeneration(chunks);
    }
    public void Draw(int x, int y) {
        if(chunks[x][y] != null) {
            chunks[x][y].Draw();
        }
    }
}

class WorldGeneration
{
    WorldGeneration(Chunk[][] chunks)
    {
        RandomChankType rand = new RandomChankType();
        chunks[5][3] = new Chunk();
        chunks[5][3].changeType(rand.randomChank());
        Vector buff1 = new Vector();
        Vector buff2 = new Vector();
        buff1.add(5);
        buff2.add(3);
        while(buff1 != null && buff2 != null)
        {
            switch (chunks[buff1.firstElement()][buff2.firstElement()].getType())
            {
                case ONE_UP_DOOR:
                    chunks[buff[0][0]][buff[0][1]+1] = new Chunk();
                    break;
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
}
