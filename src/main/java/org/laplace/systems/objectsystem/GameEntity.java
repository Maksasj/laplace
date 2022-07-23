package org.laplace.systems.objectsystem;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;
import org.laplace.systems.objectsystem.ComponentSystem.Component;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.Jaylib.RAYWHITE;

public class GameEntity extends GameObject {
    public int x = 0; //Relative to world cords
    public int y = 0; //Relative to world cords
    private int damage = 0;

    public GameEntity(String name) {
        super(name);
    }

    public void setDamage(int x) {
        damage = x;
    }

    public int dealDamage() {
        return damage;
    }

    @Override
    public void Update() {
        components.updateComponents();
    }

    @Override
    public void Draw() {
        components.drawComponents();
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
