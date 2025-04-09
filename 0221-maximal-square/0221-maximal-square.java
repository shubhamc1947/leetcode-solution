class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] grid = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                grid[i][j] = matrix[i][j] - '0';               
                if (i < m - 1 && j < n - 1 && grid[i][j] == 1) {
                    grid[i][j] += Math.min(grid[i + 1][j + 1], Math.min(grid[i + 1][j], grid[i][j + 1]));
                }
                max = Math.max(max, grid[i][j]);
            }
        }
        return max * max;
    }
}