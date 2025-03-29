class Solution {
    // Used to navigate to 8 directional neighbors
private static final int[][] DIRS = {{-1, -1}, // top-left
 									 {-1, 0},  // top
									 {-1, 1},  // top-right
									 {0, -1},  // left
									 {0, 1},   // right
									 {1, -1},  // bottom-left
									 {1, 0},   // bottom
									 {1, 1}};  // bottom-right

public void gameOfLife(int[][] board) {
    var m = board.length;
    var n = board[0].length;
    playGame(board, m, n);
    updateBoard(board, m, n);
}

private void playGame(int[][] board, int m, int n) {
    for (var i = 0; i < m; i++)
        for (var j = 0; j < n; j++) {

            var alive = aliveNeighbors(board, m, n, i, j);
            
            if (board[i][j] == 0 && alive == 3) // board[i][j] = 00. Dead cell with 3 live neighbors becomes alive
                board[i][j] = 2; // board[i][j] = 10
            else if (board[i][j] == 1 && (alive == 2 || alive == 3)) // board[i][j] = 01. Live cell with 2 or 3 live neighbors lives on
                board[i][j] = 3; // board[i][j] = 11
        }
}

private int aliveNeighbors(int[][] board, int m, int n, int i, int j) {
    var alive = 0;

    for (var dir : DIRS) {

        var x = i + dir[0]; // neighborX
        var y = j + dir[1]; // neighborY

        if (x == -1 || x == m || y == -1 || y == n) // out of bounds
            continue;

        alive += board[x][y] & 1;
    }

    return alive;
}

private void updateBoard(int[][] board, int m, int n) {
    for (var i = 0; i < m; i++)
        for (var j = 0; j < n; j++)
            if (board[i][j] != 0) // this check is not necessary but improves efficiency
                board[i][j] >>= 1; // // right shift 1 bit to replace old state with new state
}
}