package org.laplace;

public class Main {
    public static Game game;
    public static void main(String[] args) {
        game = new Game();
        game.run();
        game.close();
    }
}