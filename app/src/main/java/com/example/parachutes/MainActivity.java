package com.example.parachutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static int BOARD_M = 4;
    private static int BOARD_N = 10;
    private Engine engine = new EngineImp();

    void debugPrintBoard(){
        boolean[][] board = Board.getInstance().getBoard();
        for(int i = 0; i < BOARD_M; ++i) {
            String line = "";
            for (int k = 0; k < BOARD_N; ++k)
                if(board[i][k]) line += " " + 'x';
                else line+= " " + 'o';
            Log.e("test", line);
        }
        Log.e("test", "====================");
    }

    void debugRender() {
        while (true){
            debugPrintBoard();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Board.getInstance().setSize(BOARD_M,BOARD_N);
        engine.run();
        debugRender();
    }
}
