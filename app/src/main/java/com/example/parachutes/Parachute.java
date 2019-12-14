package com.example.parachutes;

public abstract class Parachute {
    protected int initialPos;

    public Parachute(int initialPos) {
        this.initialPos = initialPos;
    }

    public abstract void drop();
    public abstract boolean isLanded();
}
