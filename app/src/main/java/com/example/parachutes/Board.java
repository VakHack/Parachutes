package com.example.parachutes;

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

    //here board size is to be determined. Min 4*4
    //starting with an empty board (no initialization needed - default val is already false)
    public void InitBoard(int height, int width) {
        this.height = height < 4 ? 4 : height;
        this.width = width < 4 ? 4 : width;
        score = 0;
        lives = 3;
        board = new boolean[this.height][this.width];
    }

    //synchronized because will be edited by two threads - airplane and boat
    //to avoid race condition
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


