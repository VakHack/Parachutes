package com.example.parachutes;

public class ParachuteHitOrMissAssessor {
    private int lastPos;

    public ParachuteHitOrMissAssessor(int lastPos) {
        this.lastPos = lastPos;
        updateScore();
    }

    private int findBoatPos(){
        int i = 0;
        int boatHeight = Board.getInstance().getHeight()-1;
        for(; i < Board.getInstance().getWidth(); ++i)
            if(Board.getInstance().getBoard()[boatHeight][i])
                break;
        return i;
    }

    private void updateScore(){
        //if the boat is plus one coordinate (x-axis) from us, its a hit
        //or when the boat right beneath us
        int boatPos = findBoatPos();
        if (lastPos==boatPos || lastPos+1==boatPos){
            Board.getInstance().pointsIncrement();
        }
        else{
            Board.getInstance().livesReduction();
        }
    }
}
