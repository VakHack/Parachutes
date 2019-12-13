package com.example.parachutes;

abstract class Airplane {
    protected int boardWidth;
    protected int boardHeight;

    public Airplane(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }

    abstract void setInitialPos();
    abstract void fly();
    abstract void stop();
    abstract void difficulty(Difficulty diff);
}
