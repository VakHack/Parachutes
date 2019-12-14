package com.example.parachutes;

class AirplaneImp implements Airplane {
    private int PLANE_SPEED = 1000;
    private ParachutesHandler parachutesHandler = new QueueParachutesHandler();
    private DropRateCalculator dropRateCalculator = new RandDropRateCalc();
    private int pos = 0;

    @Override
    public void setInitialPos() {
        Board.getInstance().setBoard(0, 0, true);
    }

    @Override
    public void fly() {
        new Thread(new Runnable() {
            public void run(){
                while (true) {
                    try {
                        int oldPos = pos;
                        pos = (oldPos + 1) % Board.getInstance().getWidth();
                        Board.getInstance().setBoard(0, oldPos, false);
                        Board.getInstance().setBoard(0, pos, true);

                        if(dropRateCalculator.shouldDrop()){
                            parachutesHandler.drop(new ParachuteImp(pos));
                        }

                        Thread.sleep(PLANE_SPEED);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}