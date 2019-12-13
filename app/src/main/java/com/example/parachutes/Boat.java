package com.example.parachutes;

abstract class Boat {
    protected int boardWidth;
    protected int boardHeight;

    public Boat(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }

    abstract void setInitialPos();
    abstract void moveLeft();
    abstract void moveRight();
}
