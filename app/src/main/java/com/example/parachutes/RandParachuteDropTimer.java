package com.example.parachutes;

import java.util.Random;

public class RandParachuteDropTimer implements ParachuteDropTimer {
    @Override
    public boolean shouldDrop() {
        //defining the probability (1/n) of plane moves until the next Parachute drops
        final int DROP_RATE = 5;
        return new Random().nextInt(DROP_RATE)==0;
    }
}
