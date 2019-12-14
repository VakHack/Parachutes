package com.example.parachutes;

public interface GameEngine {
    void run();
    void stop();
    void setDifficulty(Difficulty dif);
    void moveLeft();
    void moveRight();
}
