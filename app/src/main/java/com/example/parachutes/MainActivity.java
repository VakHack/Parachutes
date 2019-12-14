package com.example.parachutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int BOARD_HEIGHT = 8;
    private static int BOARD_WIDTH = 10;
    private GameEngine gameEngine;
    private GraphicEngine graphicEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init views
        ImageButton leftButton = findViewById(R.id.leftButton);
        ImageButton rightButton = findViewById(R.id.rightButton);

        //setting the size of the game board
        Board.getInstance().setSize(BOARD_HEIGHT, BOARD_WIDTH);

        //running both engines
        gameEngine = new GameEngineImp();
        gameEngine.run();

        graphicEngine = new GraphicEngineImp(this);
        graphicEngine.render();

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
    }
}
