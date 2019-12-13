package com.example.parachutes;

public class EngineImp extends Engine {
    private Airplane airplane;
    private Boat boat;

    public EngineImp(int boardHeight, int boardWidth) {
        super(boardHeight, boardWidth);
        airplane = new AirplaneImp(boardWidth);
        boat = new BoatImp(boardWidth, boardHeight);
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
