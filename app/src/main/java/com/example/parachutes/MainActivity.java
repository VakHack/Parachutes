package com.example.parachutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private static int BOARD_HEIGHT = 6;
    private static int BOARD_WIDTH = 6;
    private Engine engine = new EngineImp(BOARD_HEIGHT, BOARD_WIDTH);

    ImageButton leftButton;
    ImageButton rightButton;
    GridLayout grid;

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

    void debugRender() {
        new Thread(new Runnable() {
            public void run(){
                while (true){
                    debugPrintBoard();
                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Board.getInstance().setSize(BOARD_HEIGHT, BOARD_WIDTH);
        engine.run();
        debugPrintBoard();
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        grid = findViewById(R.id.grid);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engine.moveLeft();
                debugPrintBoard();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engine.moveRight();
                debugPrintBoard();
            }
        });
    }
}
