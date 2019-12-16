package com.example.parachutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

//"Parachutes" app
//Author: Roee Vakrat
//Created: 13/12/19
public class MainActivity extends AppCompatActivity {
    private final int BOARD_HEIGHT = 8;
    private final int BOARD_WIDTH = 10;
    private GameEngine gameEngine;
    private GraphicEngine graphicEngine;

    void runGame(){
        gameEngine = new GameEngineImp();
        gameEngine.run();

        graphicEngine = new GraphicEngineImp(this);
        graphicEngine.render();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialing buttons
        ImageButton leftButton = findViewById(R.id.leftButton);
        ImageButton rightButton = findViewById(R.id.rightButton);
        ImageButton restartButton = findViewById(R.id.restart);

        //initialing the game board
        Board.getInstance().InitBoard(BOARD_HEIGHT, BOARD_WIDTH);

        runGame();

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameEngine.moveLeft();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameEngine.moveRight();
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Board.getInstance().InitBoard(BOARD_HEIGHT, BOARD_WIDTH);
                runGame();
            }
        });
    }
}
