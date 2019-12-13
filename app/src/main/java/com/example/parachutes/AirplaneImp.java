package com.example.parachutes;

class AirplaneImp extends Airplane {
    private int PLANE_SPEED = 1000;
    private ParachutesHandler parachutesHandler = new QueueParachutesHandler();
    private DropRateCalculator dropRateCalculator = new RandDropRateCalc();

    public AirplaneImp(int boardWidth, int boardHeight) {
        super(boardWidth, boardHeight);
    }

    private int getPlanePos(){
        int i = 0;
        for(; i < boardWidth; ++i)
            if(Board.getInstance().getBoard()[0][i])
                break;
        return i;
    }

    @Override
    void setInitialPos() {
        Board.getInstance().setBoard(0, 0, true);
    }

    @Override
    public void fly() {
        new Thread(new Runnable() {
            public void run(){
                while (true) {
                    try {
                        int pos = getPlanePos();
                        int newPos = (pos + 1) % boardWidth;
                        Board.getInstance().setBoard(0, pos, false);
                        Board.getInstance().setBoard(0, newPos, true);

                        if(dropRateCalculator.shouldDrop()){
                            parachutesHandler.drop(new ParachuteImp(boardWidth, boardHeight, newPos));
                        }

                        Thread.sleep(PLANE_SPEED);
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
    public void difficulty(Difficulty difficulty) {
       dropRateCalculator.setDifficulty(difficulty);
    }
}