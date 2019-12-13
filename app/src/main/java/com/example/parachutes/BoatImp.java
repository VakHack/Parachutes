package com.example.parachutes;

public class BoatImp extends Boat {
    private int boatVerticalPos = boardHeight-1;

    public BoatImp(int boardWidth, int boardHeight) {
        super(boardWidth, boardHeight);
    }

    private int getBoatPos(){
        int i = 0;
        for(; i < boardWidth; ++i)
            if(Board.getInstance().getBoard()[boatVerticalPos][i])
                break;
        return i;
    }

    private void moveLogic(final int addToPos){
        new Thread(new Runnable() {
            public void run(){
                int pos = getBoatPos();
                //two possibilities to boat position change - right, meaning adding + 1. Modulo covers
                //the return to the left end. In case of left, subtraction can get us past zero,
                //in that case, returning the the right end
                int newPos = (pos + addToPos) >= 0 ? (pos + addToPos) % boardWidth : boardWidth - 1;
                Board.getInstance().setBoard(boatVerticalPos, pos, false);
                Board.getInstance().setBoard(boatVerticalPos, newPos, true);
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
