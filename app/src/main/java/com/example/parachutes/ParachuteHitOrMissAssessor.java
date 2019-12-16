package com.example.parachutes;

//a module that reads the board whenever a parachutist gets to the bottom row
//and assess whether the boat collected him successfully - and to update the board accordingly
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
        //if the boat is plus one coordinate (x-axis) from us, or when the boat
        //right beneath the parachutist, it a hit - the two location seems to be
        //valid for the parachutist collection from a player point of view
        int boatPos = findBoatPos();
        if (lastPos==boatPos || lastPos+1==boatPos){
            Board.getInstance().pointsIncrement();
        }
        else{
            Board.getInstance().livesReduction();
        }
    }
}
