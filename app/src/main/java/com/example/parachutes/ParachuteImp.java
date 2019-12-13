package com.example.parachutes;

public class ParachuteImp extends Parachute {
    //initializing height to the top of the board (parachutes constant initial height)
    private int height;
    private int pos;
    private int DROP_SPEED = 1200;
    private boolean isLanded = false;

    public ParachuteImp(int boardWidth, int boardHeight, int initialPos) {
        super(boardWidth, boardHeight, initialPos);
        height = boardHeight - 1;
        pos = initialPos;
    }

    @Override
    public void drop() {
        new Thread(new Runnable() {
            public void run(){
                while (height > 0) {
                    try {
                        int oldHeight = height;
                        height -= 1;
                        int oldPos = pos;
                        pos = (pos + 1) % boardWidth;
                        Board.getInstance().setBoard(oldHeight, oldPos, false);
                        Board.getInstance().setBoard(height, pos, true);
                        Thread.sleep(DROP_SPEED);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isLanded = true;
            }
        }).start();
    }

    @Override
    public boolean isLanded() {
        return isLanded;
    }
}
