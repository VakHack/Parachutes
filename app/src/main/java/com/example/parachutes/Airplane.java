package com.example.parachutes;

abstract class Airplane {
    protected int boardWidth;

    public Airplane(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    abstract void setInitialPos();
    abstract void fly();
    abstract void stop();
    abstract void difficulty(Difficulty diff);
}
