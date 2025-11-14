class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int[][] matrix = new int[n][n];

        // process each query
        for (int[] q : queries) {
            int startx = q[0], starty = q[1];
            int endx = q[2], endy = q[3];

            // mark start and end for each row
            for (int row = startx; row <= endx; row++) {
                matrix[row][starty]++;

                // if end+1 is within bounds
                if (endy + 1 < n) {
                    matrix[row][endy + 1]--;
                }
            }
        }

        // perform prefix sum on each row
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        // replace negative values with zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.max(0, matrix[i][j]);
            }
        }

        return matrix;
    
    }
}