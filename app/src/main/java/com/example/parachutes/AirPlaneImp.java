package com.example.parachutes;

import android.util.Log;

class AirPlaneImp extends AirPlane {
    private static int SLOW_SPEED = 1200;
    private static int MEDIUM_SPEED = 1000;
    private static int HIGH_SPEED = 700;

    public AirPlaneImp(int boardWidth) {
        super(boardWidth);
    }

    @Override
    public void fly() {
        new Thread(new Runnable() {
            public void run(){
                int planePos = 0;
                while (true) {
                    try {
                        Thread.sleep(MEDIUM_SPEED);
                        int oldPlanePos = planePos;
                        planePos = (planePos + 1) % boardWidth;
                        Board.getInstance().setBoard(1, oldPlanePos, false);
                        Board.getInstance().setBoard(1, planePos, true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void stop() {

    }

    @Override
    public void difficulty(Difficulty diff) {

    }
}
