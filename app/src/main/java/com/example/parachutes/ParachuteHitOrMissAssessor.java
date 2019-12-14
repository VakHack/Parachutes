package com.example.parachutes;

import android.util.Log;

public class ParachuteHitOrMissAssessor {
    private int lastPos;

    public ParachuteHitOrMissAssessor(int lastPos) {
        this.lastPos = lastPos;
        updateBoardScore();
    }

    private int getBoatPos(){
        int i = 0;
        for(; i < Board.getInstance().getWidth(); ++i)
            if(Board.getInstance().getBoard()[0][i])
                break;
        return i;
    }

    private void updateBoardScore(){
        //if boat is plus one coordinate (x-axis) from us, its a hit
        if (lastPos+1==getBoatPos()){
            Board.getInstance().pointsIncrement();
        }
        else{
            Board.getInstance().livesReduction();
        }
    }
}
