class Solution {
    int rows,cols;
    private static int mod = 1_000_000_007;
    public int numberOfPaths(int[][] grid, int k) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        long[][][] dp = new long[rows][cols][k];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                for(int m=0;m<k;m++) dp[i][j][m] = -1;
            }
        }
        return (int)(f(0,0,dp,0,k,grid)%mod);
    }
    private long f(int r, int c, long[][][] dp, int sum,int k,int[][] g){
        if(r==rows || c==cols) return 0;
        sum+=g[r][c];
        int rem = sum%k;
        if(dp[r][c][rem]!=-1) return dp[r][c][rem];
        if(r==rows-1 && c==cols-1) return dp[r][c][rem] = ((rem==0)?1:0);
        return dp[r][c][rem]=(f(r+1,c,dp,sum,k,g) + f(r,c+1,dp,sum,k,g))%mod;
    }
}