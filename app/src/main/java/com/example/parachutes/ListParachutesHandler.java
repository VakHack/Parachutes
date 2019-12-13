package com.example.parachutes;

import java.util.LinkedList;

public class ListParachutesHandler implements ParachutesHandler {
    private LinkedList<Parachute> parachuteList;

    @Override
    public void drop(Parachute parachute) {
        parachute.drop();
        parachuteList.add(parachute);
    }
}
