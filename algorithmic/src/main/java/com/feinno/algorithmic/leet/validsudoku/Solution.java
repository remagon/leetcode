package com.feinno.algorithmic.leet.validsudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] vertical = new boolean[9][9];
        boolean[][] horizontal = new boolean[9][9];
        boolean[][] square = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] == '.') {
        			continue;
        		}
        		int cell = board[i][j] - '0';
        		if (cell < 1 || cell > 9) {
        			return false;
        		}
        		cell--;

        		if (horizontal[i][cell]) {
        			return false;
        		} else {
        			horizontal[i][cell] = true;
        		}
        		
        		if (vertical[j][cell] == true) {
        			return false;
        		} else {
        			vertical[j][cell] = true;
        		}
        		int squareNum = i / 3 + (j / 3) * 3;
        		if (square[squareNum][cell] == true) {
        			return false;
        		} else {
        			square[squareNum][cell] = true;
        		}
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
    	char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		board[i][j] = '.';
        	}
        }
        board[1][1] = '1';
        board[8][8] = '1';
        Solution sol = new Solution();
        System.out.println(sol.isValidSudoku(board));
    }
}