package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.worldsystem.GameWorld;

import static com.raylib.Raylib.CAMERA_PERSPECTIVE;
import static com.raylib.Raylib.IsKeyPressed;

public class Player extends GameEntity {

    public Player(int x, int y) {
        super("player");

        this.x = x;
        this.y = y;

        this.setModelScale(0.3f);
        this.setModelOffset(new Jaylib.Vector3(0.2f, 0.0f,0.2f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);
    }

    @Override
    public void Update() {
        Game.getCamera()._position( new Jaylib.Vector3((float) this.x*2 + 7, 5.0f, (float) this.y*2 + 7)) //TODO x*2 may cause issues in the future
                        .target(    new Jaylib.Vector3(this.x*2, 1.0f, (float) this.y*2))
                        .up(        new Raylib.Vector3().x(0).y(1).z(0))
                        .fovy(45)
                        .projection(CAMERA_PERSPECTIVE);


        if(IsKeyPressed(83)) { //W
            if(!GameWorld.ChechIfWall(x + 1, y)) {
                this.x += 1;
            }
        }

        if(IsKeyPressed(87)) { //S
            if(!GameWorld.ChechIfWall(x - 1, y)) {
                this.x -= 1;
            }
        }

        if(IsKeyPressed(68)) { //A
            if(!GameWorld.ChechIfWall(x, y + 1)) {
                this.y += 1;
            }
        }

        if(IsKeyPressed(65)) { //D
            if(!GameWorld.ChechIfWall(x, y - 1)) {
                this.y -= 1;
            }
        }

        if(IsKeyPressed(66)) { //test
            System.out.println("testttt");
            Game.getDice().ThrowDice(6);
        }

        this.setPos(new Jaylib.Vector3(this.x*2, 0.0f, this.y*2));
    }
}
