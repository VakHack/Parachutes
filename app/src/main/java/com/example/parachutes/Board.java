package com.example.parachutes;

import java.util.Vector;

public class Board {
    private static final Board ourInstance = new Board();
    public static Board getInstance() {
        return ourInstance;
    }
    private boolean[][] board;
    private int points = 0;
    private int lives = 3;

    //here board size is to be determined. Min 4*4
    //starting with an empty board (no initialization needed - default val is already false)
    public void setSize(int height, int width) {
        height = height < 4 ? 4 : height;
        width = width < 4 ? 4 : width;
        board = new boolean[height][width];
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}


