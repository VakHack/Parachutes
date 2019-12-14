package com.example.parachutes;

public class GameEngineImp implements GameEngine {
    private Airplane airplane;
    private Boat boat;

    public GameEngineImp() {
        airplane = new AirplaneImp();
        boat = new BoatImp();
    }

    @Override
    public void run() {
        airplane.setInitialPos();
        boat.setInitialPos();
        airplane.fly();
    }

    @Override
    public void stop() {

    }

    @Override
    public void setDifficulty(Difficulty dif) {
        airplane.difficulty(dif);
    }

    @Override
    public void moveLeft() {
        boat.moveLeft();
    }

    @Override
    public void moveRight() {
        boat.moveRight();
    }
}
