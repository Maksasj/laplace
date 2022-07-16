package org.laplace.systems.objectsystem.GameEntitys;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.systems.objectsystem.GameEntity;
import org.laplace.systems.worldsystem.GameWorld;

import static com.raylib.Raylib.CAMERA_PERSPECTIVE;
import static com.raylib.Raylib.IsKeyPressed;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Player extends GameEntity {
    private boolean walkCd = false;

    public Player(int x, int y) {
        super("player");
        setHealth(35);

        this.x = x;
        this.y = y;

        this.setModelScale(0.3f);
        this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
        this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
        this.setRot(270);
    }

    @Override
    public void Update() {
        Game.getCamera()
                ._position(new Jaylib.Vector3((float) this.x*2 - 7, 5.0f, (float) this.y*2 - 7))
                .target(    new Jaylib.Vector3(this.x*2, 1.0f, (float) this.y*2))
                .up(        new Raylib.Vector3().x(0).y(1).z(0))
                .fovy(45)
                .projection(CAMERA_PERSPECTIVE);

        if(!walkCd) {
            if(IsKeyPressed(83)) { //S
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, 1.0f, 1.0f));
                this.setRot(240.0f);

                if(!GameWorld.ChechIfWall(x - 1, y)) {
                    if(GameWorld.getEntity(x - 1, y) != null) {

                        //BATLE LOGIC
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x - 1, y);
                        this.x -= 1;
                        walkCd = true;
                    }
                }
            }

            if(IsKeyPressed(87)) { //W
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, -1.0f, -1.0f));
                this.setRot(240);

                if(!GameWorld.ChechIfWall(x + 1, y)) {
                    if(GameWorld.getEntity(x + 1, y) != null) {
                        //BATLE LOGIC
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x + 1, y);
                        this.x += 1;
                        walkCd = true;
                    }
                }
            }

            if(IsKeyPressed(65)) { //A
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(1.0f, 0.0f, 0.0f));
                this.setRot(270);

                if(!GameWorld.ChechIfWall(x, y + 1)) {
                    if(GameWorld.getEntity(x, y + 1) != null) {
                        //BATLE LOGIC
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x, y + 1);
                        this.y += 1;
                        walkCd = true;

                    }
                }
            }

            if(IsKeyPressed(68)) { //D
                this.setModelOffset(new Jaylib.Vector3(0.2f, 0.3f,0.2f));
                this.setRotAxis(new Jaylib.Vector3(0.0f, 0.7f, 0.7f));
                this.setRot(180);

                if(!GameWorld.ChechIfWall(x, y - 1)) {
                    if(GameWorld.getEntity(x, y - 1) != null) {

                        //BATLE LOGIC
                    } else {
                        GameWorld.TranlocateEntity(this, x, y, x, y - 1);
                        this.y -= 1;
                        walkCd = true;
                    }
                }
            }
        } else {
            walkCd = false;
        }

        if(IsKeyPressed(66)) { //test
            Game.getDice().ThrowDice(6);
        }

        this.setPos(new Jaylib.Vector3(this.x*2, 0.0f, this.y*2));
    }
}
