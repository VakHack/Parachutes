package com.example.parachutes;

import android.util.Log;

public class ParachuteHitOrMissAssessor {
    private int lastPos;

    public ParachuteHitOrMissAssessor(int lastPos) {
        this.lastPos = lastPos;
        updateScore();
    }

    private int getBoatPos(){
        int i = 0;
        int boatHeight = Board.getInstance().getHeight()-1;
        for(; i < Board.getInstance().getWidth(); ++i)
            if(Board.getInstance().getBoard()[boatHeight][i])
                break;
        return i;
    }

    private void updateScore(){
        //if boat is plus one coordinate (x-axis) from us, its a hit
        //or when the boat right beneath it
        int boatPos = getBoatPos();
        if (lastPos==boatPos || lastPos+1==boatPos){
            Log.e("test", lastPos+"");
            Board.getInstance().pointsIncrement();
        }
        else{
            Board.getInstance().livesReduction();
        }
    }
}
