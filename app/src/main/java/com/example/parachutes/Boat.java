package com.example.parachutes;

abstract class Boat {
    protected int boardHeight;
    protected int boardWidth;

    public Boat(int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
    }

    abstract void setInitialPos();
    abstract void moveLeft();
    abstract void moveRight();
}
