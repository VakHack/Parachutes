package com.example.parachutes;

abstract class AirPlane {
    protected int boardWidth;

    public AirPlane(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    abstract void fly();
    abstract void stop();
    abstract void difficulty(Difficulty diff);
}
