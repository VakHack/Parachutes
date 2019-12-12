package com.example.parachutes;

import android.util.Log;

import java.util.Vector;

public class EngineImp extends Engine {
    private AirPlane airPlane;

    public EngineImp(int boardHeight, int boardWidth) {
        super(boardHeight, boardWidth);
        airPlane = new AirPlaneImp(boardWidth);
    }

    @Override
    public void run() {
        airPlane.fly();
    }

    @Override
    public void stop() {

    }

    @Override
    public void setDifficulty(Difficulty dif) {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }
}
