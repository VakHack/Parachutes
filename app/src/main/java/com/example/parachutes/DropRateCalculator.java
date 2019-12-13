package com.example.parachutes;

public interface DropRateCalculator {
    boolean shouldDrop();
    void setDifficulty(Difficulty difficulty);
}
