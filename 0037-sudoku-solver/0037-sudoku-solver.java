class Solution {
       public static boolean isSafe(char board[][], int row, int col, int degit) {
        // col check
        for (int i = 0; i <= 8; i++) {
            if (board[i][col] == (char) (degit + '0')) {
                return false;
            }
        }

        // row check
        for (int j = 0; j <= 8; j++) {
            if (board[row][j] == (char) (degit + '0')) {
                return false;
            }
        }

        // grid check
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (degit + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveBoard(char[][] board, int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }
        // updation part
        int nextRow = row;
        int nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // check if empty

        if (board[row][col] != '.') {
            return solveBoard(board, nextRow, nextCol);
        }

        // loop
        for (int degit = 1; degit <= 9; degit++) {
            if (isSafe(board, row, col, degit)) {
                board[row][col] = (char) ('0' + degit);
                if (solveBoard(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    public static void solveSudoku(char[][] board) {
        if (solveBoard(board, 0, 0)) {
           for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        } 
    }
}