package com.example.parachutes;

public abstract class Parachute {
    protected int boardHeight;
    protected int boardWidth;
    protected int initialPos;

    public Parachute(int boardHeight, int boardWidth, int initialPos) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        this.initialPos = initialPos;
    }

    public abstract void drop();
    public abstract boolean isLanded();
}
