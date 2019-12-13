package com.example.parachutes;

public abstract class Parachute {
    protected int boardWidth;
    protected int boardHeight;
    protected int initialPos;

    public Parachute(int boardWidth, int boardHeight, int initialPos) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.initialPos = initialPos;
    }

    public abstract void drop();
    public abstract boolean isLanded();
}
