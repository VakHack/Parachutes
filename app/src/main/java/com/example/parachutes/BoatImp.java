package com.example.parachutes;

public class BoatImp implements Boat {
    private int boatVerticalPos = Board.getInstance().getHeight()-1;
    private int pos = 0;

    private void moveLogic(final int addToPos){
        new Thread(new Runnable() {
            public void run(){
                int oldPos = pos;
                int boardWidth = Board.getInstance().getWidth();
                //two possibilities to the boat position change - right, meaning adding + 1. Modulo covers
                //the return to the left end. In case of a left, subtraction can get us past zero,
                //in that case, returning to the right end
                pos = (oldPos + addToPos) >= 0 ? (oldPos + addToPos) % boardWidth : boardWidth - 1;
                Board.getInstance().setBoard(boatVerticalPos, oldPos, false);
                Board.getInstance().setBoard(boatVerticalPos, pos, true);
            }
        }).start();
    }

    @Override
    public void setInitialPos() {
        Board.getInstance().setBoard(boatVerticalPos, 0, true);
    }

    @Override
    public void moveLeft() {
        moveLogic(-1);
    }

    @Override
    public void moveRight() {
        moveLogic(1);
    }
}
