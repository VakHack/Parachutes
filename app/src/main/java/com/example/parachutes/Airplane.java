package com.example.parachutes;

public interface Airplane {
    void setInitialPos();
    void fly();
    void stop();
    void difficulty(Difficulty diff);
}
