package com.example.parachutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private static int BOARD_HEIGHT = 8;
    private static int BOARD_WIDTH = 10;
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

        //init button
        ImageButton leftButton = findViewById(R.id.leftButton);
        ImageButton rightButton = findViewById(R.id.rightButton);
        ImageButton restart = findViewById(R.id.restart);

        //setting the size of the game board
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

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Board.getInstance().InitBoard(BOARD_HEIGHT, BOARD_WIDTH);
                runGame();
            }
        });
    }
}
