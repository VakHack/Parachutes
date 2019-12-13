package com.example.parachutes;

import java.util.Random;

public class RandDropRateCalc implements DropRateCalculator {
    private static int[] DROP_RATES = {10, 5, 2};
    //as a default, initializing the drop rate to mid-range (1 out of n plane moves)
    private int dropRate = DROP_RATES[1];

    @Override
    public boolean shouldDrop() {
        return new Random().nextInt(dropRate)==0;
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                dropRate = DROP_RATES[0];
                break;
            case NORMAL:
                dropRate = DROP_RATES[1];
                break;
            case HARD:
                dropRate = DROP_RATES[2];
                break;

        }
    }
}
