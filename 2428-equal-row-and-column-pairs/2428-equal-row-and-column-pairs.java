class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] transpose = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //Transpose of matrix
                transpose[j][i] = grid[i][j];
            }
        }
        int ans = 0;
        for(int[] row : grid){
            for(int[] col : transpose){
                //Check for equality
                if(Arrays.equals(row, col)) ans++;
            }
        }
        return ans;
    }
}