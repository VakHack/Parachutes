package com.example.parachutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static int BOARD_HEIGHT = 8;
    private static int BOARD_WIDTH = 10;
    private static int RENDER_DELAY = 500;

    private Engine engine = new EngineImp(BOARD_HEIGHT, BOARD_WIDTH);
    private ImageView[][] imageViews = new ImageView[BOARD_HEIGHT][BOARD_WIDTH];

    ImageButton leftButton;
    ImageButton rightButton;

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

    void printBoard(){
        boolean[][] board = Board.getInstance().getBoard();
        for(int i = 0; i < BOARD_HEIGHT; ++i) {
            for (int j = 0; j < BOARD_WIDTH; ++j){
                if(board[i][j]) imageViews[i][j].setVisibility(View.VISIBLE);
                else imageViews[i][j].setVisibility(View.INVISIBLE);
            }
        }
    }

    void render() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                printBoard();
                handler.postDelayed(this, RENDER_DELAY);
            }
        }, RENDER_DELAY);
    }

    void initImageViews(){
        for(int i = 0; i < BOARD_HEIGHT; ++i)
            for(int j=0; j < BOARD_WIDTH; ++j){
                String img = "_" + i + "_" + j;
                int id = getResources().getIdentifier(img, "id", getPackageName());
                imageViews[i][j] = findViewById(id);
                imageViews[i][j].setVisibility(View.INVISIBLE);
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Board.getInstance().setSize(BOARD_HEIGHT, BOARD_WIDTH);
        initImageViews();
        engine.run();
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        render();

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engine.moveLeft();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engine.moveRight();
            }
        });
    }
}
