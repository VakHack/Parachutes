package com.example.parachutes;
import java.util.LinkedList;
import java.util.Queue;

//an implementation of the 'ParachutesHandler' object. Queue is a good fit here, because we can
//assume the first parachutist in will also be the first out
public class QueueParachutesHandler implements ParachutesHandler {
    private Queue<Parachute> parachuteList = new LinkedList<>();
    //defining the interval on which the handler checks if a Parachute object need removal (ms)
    private final int CLEANING_INTERVAL = 10000;

    private void cleanLandedParachutes(){
        new Thread(new Runnable() {
            public void run(){
                while (true) {
                    try {
                        if(!parachuteList.isEmpty() && parachuteList.peek().isLanded())
                            parachuteList.remove();
                        Thread.sleep(CLEANING_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    QueueParachutesHandler(){
        cleanLandedParachutes();
    }

    @Override
    public void add(Parachute parachute) {
        parachute.drop();
        parachuteList.add(parachute);
    }
}
