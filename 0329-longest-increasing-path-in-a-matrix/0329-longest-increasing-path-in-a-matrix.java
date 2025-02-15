class Solution {
    public int findLongest(int[][] matrix, int i, int j, int[][] memo) {
        // If the result is already computed, return it
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int maxPath = 1; // At least the current cell itself

        // Explore all four directions
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            maxPath = Math.max(maxPath, 1 + findLongest(matrix, i + 1, j, memo));
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            maxPath = Math.max(maxPath, 1 + findLongest(matrix, i, j + 1, memo));
        }
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            maxPath = Math.max(maxPath, 1 + findLongest(matrix, i - 1, j, memo));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            maxPath = Math.max(maxPath, 1 + findLongest(matrix, i, j - 1, memo));
        }

        // Store the result in the memo array and return it
        memo[i][j] = maxPath;
        return maxPath;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // Initialize memoization array with -1
        }

        int maxPath = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxPath = Math.max(maxPath, findLongest(matrix, i, j, memo));
            }
        }
        return maxPath;//this would be the solution 
    }
}