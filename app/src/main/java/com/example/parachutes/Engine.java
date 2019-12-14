package com.example.parachutes;

public interface Engine {
    void run();
    void stop();
    void setDifficulty(Difficulty dif);
    void moveLeft();
    void moveRight();
}
