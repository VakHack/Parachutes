package com.example.parachutes;

import java.util.Vector;

public class Board {
    private static final Board ourInstance = new Board();
    public static Board getInstance() {
        return ourInstance;
    }
    private boolean[][] board;

    //here board size is to be determined. Min 4*4
    //starting with an empty board (no initialization needed - default val is already false)
    public void setSize(int m, int n) {
        m = m < 4 ? 4 : m;
        n = n < 4 ? 4 : n;
        board = new boolean[m][n];
    }

    //synchronized because will be edited by two threads - airplane and boat
    //to avoid race condition
    public synchronized void setBoard(int m, int n, boolean val){
        if(m > 0 && n > 0)
            board[m - 1][n - 1] = val;
    }

    public boolean[][] getBoard() {
        return board;
    }}
