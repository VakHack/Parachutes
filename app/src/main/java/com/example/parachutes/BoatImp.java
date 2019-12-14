package com.example.parachutes;

public class BoatImp extends Boat {
    private int boatVerticalPos = boardHeight-1;
    private int pos = 0;

    public BoatImp(int boardHeight, int boardWidth) {
        super(boardHeight, boardWidth);
    }

    private void moveLogic(final int addToPos){
        new Thread(new Runnable() {
            public void run(){
                int oldPos = pos;
                //two possibilities to boat position change - right, meaning adding + 1. Modulo covers
                //the return to the left end. In case of left, subtraction can get us past zero,
                //in that case, returning the the right end
                pos = (oldPos + addToPos) >= 0 ? (oldPos + addToPos) % boardWidth : boardWidth - 1;
                Board.getInstance().setBoard(boatVerticalPos, oldPos, false);
                Board.getInstance().setBoard(boatVerticalPos, pos, true);
            }
        }).start();
    }

    @Override
    void setInitialPos() {
        Board.getInstance().setBoard(boatVerticalPos, 0, true);
    }

    @Override
    void moveLeft() {
        moveLogic(-1);
    }

    @Override
    void moveRight() {
        moveLogic(1);
    }
}
