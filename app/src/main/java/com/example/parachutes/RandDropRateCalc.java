package com.example.parachutes;

import java.util.Random;

public class RandDropRateCalc implements DropRateCalculator {
    @Override
    public boolean shouldDrop() {
        int DROP_RATE = 10;
        return new Random().nextInt(DROP_RATE)==0;
    }
}
