package com.example.parachutes;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GraphicEngineImp extends GraphicEngine {
    private static int RENDER_DELAY = 700;
    private int boardHeight = Board.getInstance().getHeight();
    private int boardWidth = Board.getInstance().getWidth();
    private boolean doesGameOver = false;

    //screen image view initialization
    private ImageView[][] imageViews = new ImageView[boardHeight][boardWidth];
    private ImageView[] hearts = new ImageView[3];
    private ImageView gameOver;
    private TextView score;
    private ImageButton restart;

    public GraphicEngineImp(Activity mainActivity) {
        super(mainActivity);
        initViews();
    }

    void debugPrintBoard(){
        boolean[][] board = Board.getInstance().getBoard();
        for(int i = 0; i < boardHeight; ++i) {
            String line = "";
            for (int k = 0; k < boardWidth; ++k)
                if(board[i][k]) line += " " + 'x';
                else line+= " " + 'o';
            Log.e("test", line);
        }
        Log.e("test", "====================");
    }

    void initViews(){
        //initialize all planes/parachutists/boast image views, and set them to be invisible
        for(int i = 0; i < boardHeight; ++i)
            for(int j = 0; j < boardWidth; ++j){
                String img = "_" + i + "_" + j;
                int id = mainActivity.getResources().getIdentifier(img, "id", mainActivity.getPackageName());
                imageViews[i][j] = mainActivity.findViewById(id);
                imageViews[i][j].setVisibility(View.INVISIBLE);
            }
        //initialize the live indicating hearts
        for(int i = 0; i < 3; ++i){
            String heartImg = "heart_" + (i + 1);
            int id = mainActivity.getResources().getIdentifier(heartImg, "id", mainActivity.getPackageName());
            hearts[i] = mainActivity.findViewById(id);
            hearts[i].setVisibility(View.VISIBLE);
        }
        score = mainActivity.findViewById(R.id.score);

        gameOver = mainActivity.findViewById(R.id.gameOver);
        gameOver.setVisibility(View.INVISIBLE);

        restart = mainActivity.findViewById(R.id.restart);
        restart.setVisibility(View.INVISIBLE);
    }

    void renderBoard(){
        boolean[][] board = Board.getInstance().getBoard();
        for(int i = 0; i < boardHeight; ++i) {
            for (int j = 0; j < boardWidth; ++j){
                if(board[i][j]) imageViews[i][j].setVisibility(View.VISIBLE);
                else imageViews[i][j].setVisibility(View.INVISIBLE);
            }
        }
    }

    void renderHearts() {
        int lives = Board.getInstance().getLives();
        if(lives < 3) hearts[2].setVisibility(View.INVISIBLE);
        if(lives < 2) hearts[1].setVisibility(View.INVISIBLE);
        if(lives < 1) {
            hearts[0].setVisibility(View.INVISIBLE);
            doesGameOver = true;
        }
    }

    //rendering the screen using Board boolean matrix, every n milliseconds
    @Override
    public void render() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                renderBoard();
                renderHearts();
                String newScore = "Score: " + Board.getInstance().getScore();
                score.setText(newScore);
                if(doesGameOver){
                    gameOver.setVisibility(View.VISIBLE);
                    restart.setVisibility(View.VISIBLE);
                    return;
                }
                handler.postDelayed(this, RENDER_DELAY);
            }
        }, RENDER_DELAY);
    }
}
