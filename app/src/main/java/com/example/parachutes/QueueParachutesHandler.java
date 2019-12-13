package com.example.parachutes;
import java.util.LinkedList;
import java.util.Queue;

public class QueueParachutesHandler implements ParachutesHandler {
    private Queue<Parachute> parachuteList = new LinkedList<>();
    private int CLEANING_INTERVAL = 1000;

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
    public void drop(Parachute parachute) {
        parachute.drop();
        parachuteList.add(parachute);
    }
}
