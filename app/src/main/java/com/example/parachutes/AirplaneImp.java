package com.example.parachutes;

class AirplaneImp extends Airplane {
    private static int[] DROP_RATES = {700, 1000, 1200};
    //as a default, initializing the drop rate to mid-range
    private int dropRate = DROP_RATES[1];

    public AirplaneImp(int boardWidth) {
        super(boardWidth);
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
                        Thread.sleep(dropRate);
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
        switch (diff){
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
