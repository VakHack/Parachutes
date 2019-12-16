package com.example.parachutes;

import android.os.Handler;

class AirplaneImp implements Airplane {
    //defining the interval (milliseconds) between each plane x-axis move
    private int PLANE_SPEED = 1000;
    private ParachutesHandler parachutesHandler = new QueueParachutesHandler();
    private ParachuteDropTimer parachuteDropTimer = new RandParachuteDropTimer();
    private int pos = 0;

    private static boolean doesPlaneExist = false;

    void clearRowBesidesPlanePos(int planePos){
        for(int i = 0; i < Board.getInstance().getWidth(); ++i)
            if(i != planePos)
                Board.getInstance().setBoard(0, i, false);
    }

    @Override
    public void setInitialPos() {
        Board.getInstance().setBoard(0, 0, true);
    }

    @Override
    public void fly() {
        //this flag is overriding an issue - whenever the screen is locked and opens up again
        //the OnCreate method is being recalled (a known issue), and thus recreating the plane
        //thread, which results in plane duplication. This flag forbid the recreation of the thread
        if(doesPlaneExist) return;

        doesPlaneExist = true;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            pos = (pos + 1) % Board.getInstance().getWidth();
            clearRowBesidesPlanePos(pos);
            Board.getInstance().setBoard(0, pos, true);

            if(parachuteDropTimer.shouldDrop()){
                parachutesHandler.add(new ParachuteImp(pos));
            }
            handler.postDelayed(this, PLANE_SPEED);
            }
        }, PLANE_SPEED);
    }
}