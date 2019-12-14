package com.example.parachutes;

import android.util.Log;

public class ParachuteImp extends Parachute {
    //initializing height to the top of the board (parachutes constant initial height)
    private int height;
    private int pos;
    private int DROP_SPEED = 1200;
    private boolean isLanded = false;

    public ParachuteImp(int boardHeight, int boardWidth, int initialPos) {
        super(boardHeight, boardWidth, initialPos);
        height = 0;
        //adding a parachutist pic to the first location
        pos = initialPos;
        Board.getInstance().setBoard(height, pos, true);
    }

    @Override
    public void drop() {
        final int BOAT_ROW = boardHeight - 1;
        new Thread(new Runnable() {
            public void run(){
                //we want to stop the dropping down logic one row before the boat row
                //to avoid animation collision with their objects
                while (height < BOAT_ROW - 1) {
                    try {
                        int oldHeight = height;
                        height += 1;
                        int oldPos = pos;
                        pos = (pos + 1) % boardWidth;
                        Board.getInstance().setBoard(oldHeight, oldPos, false);
                        Board.getInstance().setBoard(height, pos, true);
                        Thread.sleep(DROP_SPEED);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //when the parachutist get to last row, we want to remove its animation
                //right away (make it "disappear")
                Board.getInstance().setBoard(height, pos, false);
                isLanded = true;
            }
        }).start();
    }

    @Override
    public boolean isLanded() {
        return isLanded;
    }
}
