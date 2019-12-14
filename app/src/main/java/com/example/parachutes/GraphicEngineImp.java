package com.example.parachutes;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GraphicEngineImp extends GraphicEngine {
    private int BOARD_HEIGHT = Board.getInstance().getHeight();
    private int BOARD_WIDTH = Board.getInstance().getWidth();
    private static int RENDER_DELAY = 700;

    private ImageView[][] imageViews = new ImageView[BOARD_HEIGHT][BOARD_WIDTH];
    private TextView score;

    public GraphicEngineImp(Activity mainActivity) {
        super(mainActivity);
        initImageViews();
        score = mainActivity.findViewById(R.id.score);
    }

    void debugPrintBoard(){
        boolean[][] board = Board.getInstance().getBoard();
        for(int i = 0; i < BOARD_HEIGHT; ++i) {
            String line = "";
            for (int k = 0; k < BOARD_WIDTH; ++k)
                if(board[i][k]) line += " " + 'x';
                else line+= " " + 'o';
            Log.e("test", line);
        }
        Log.e("test", "====================");
    }

    void initImageViews(){
        for(int i = 0; i < BOARD_HEIGHT; ++i)
            for(int j=0; j < BOARD_WIDTH; ++j){
                String img = "_" + i + "_" + j;
                int id = mainActivity.getResources().getIdentifier(img, "id", mainActivity.getPackageName());
                imageViews[i][j] = mainActivity.findViewById(id);
                imageViews[i][j].setVisibility(View.INVISIBLE);
            }
    }

    void printBoard(){
        boolean[][] board = Board.getInstance().getBoard();
        for(int i = 0; i < BOARD_HEIGHT; ++i) {
            for (int j = 0; j < BOARD_WIDTH; ++j){
                if(board[i][j]) imageViews[i][j].setVisibility(View.VISIBLE);
                else imageViews[i][j].setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void render() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                printBoard();
                String newScore = "Score: " + Board.getInstance().getScore();
                score.setText(newScore);
                handler.postDelayed(this, RENDER_DELAY);
            }
        }, RENDER_DELAY);
    }

    @Override
    public void stop() {

    }
}
