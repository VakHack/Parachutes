package com.example.parachutes;

class AirPlaneImp implements AirPlane {
    @Override
    public void fly() {
        new Thread(new Runnable() {
            public void run(){
                Board.getInstance().setBoard(1, 3, true);
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
