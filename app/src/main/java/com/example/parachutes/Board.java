package com.example.parachutes;

//an object holding the data regarding the positioning of the game objects, and the current
//score/lives status.
//Implemented as a Singleton because need to be accessible for several modules,
//and also should be single, as it holds the game data
public class Board {
    private static final Board ourInstance = new Board();
    public static Board getInstance() {
        return ourInstance;
    }
    private boolean[][] board;
    private int score;
    private int lives;
    private int height;
    private int width;

    //here the board size is to be determined. Min 4*4
    //starting with an empty board (no initialization needed - default boolean val is already false)
    public void InitBoard(int height, int width) {
        final int MIN_HEIGHT = 4;
        final int MIN_WIDTH = 4;
        this.height = height < MIN_HEIGHT ? MIN_HEIGHT : height;
        this.width = width < MIN_WIDTH ? MIN_WIDTH : width;
        score = 0;
        lives = 3;
        board = new boolean[this.height][this.width];
    }

    //synchronized because will be edited by two threads - airplane and boat
    //to avoid race condition. Same for all the following setting/getting data
    public synchronized void setBoard(int m, int n, boolean val){
        if(m >= 0 && n >= 0)
            board[m][n] = val;
    }

    public synchronized boolean[][] getBoard() {
        return board;
    }

    public synchronized int getScore() {
        return score;
    }

    public synchronized int getLives() {
        return lives;
    }

    public synchronized void livesReduction() {
        this.lives -= 1;
    }

    public synchronized void pointsIncrement() {
        int POINTS_INC_INTERVAL = 10;
        this.score += POINTS_INC_INTERVAL;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}


