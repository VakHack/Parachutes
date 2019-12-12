package com.example.parachutes;

import java.util.Vector;

public interface Engine {
    void run();
    void stop();
    void setDifficulty(Difficulty dif);
    void moveLeft();
    void moveRight();
}
