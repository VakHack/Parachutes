package com.example.parachutes;

abstract class Airplane {
    protected int boardHeight;
    protected int boardWidth;

    public Airplane(int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
    }

    abstract void setInitialPos();
    abstract void fly();
    abstract void stop();
    abstract void difficulty(Difficulty diff);
}
