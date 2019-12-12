package com.example.parachutes;

import java.util.Vector;

public class EngineImp implements Engine {
    private AirPlane airPlane = new AirPlaneImp();

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
