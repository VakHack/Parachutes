package com.example.parachutes;

abstract class Engine {
    protected int boardHeight;
    protected int boardWidth;

    public Engine(int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
    }

    abstract void run();
    abstract void stop();
    abstract void setDifficulty(Difficulty dif);
    abstract void moveLeft();
    abstract void moveRight();
}
