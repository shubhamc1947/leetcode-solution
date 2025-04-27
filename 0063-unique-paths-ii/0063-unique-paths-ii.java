class Solution {
    public int f(int obs[][],int i,int j,int dp[][]){
        if(i==0 && j==0) {
            if(obs[i][j]==1) return 0;
            return 1;
        }
        if(i<0 || j<0 || obs[i][j]==1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int left=f(obs,i,j-1,dp);
        int top=f(obs,i-1,j,dp);
        return dp[i][j] = left+top;
    }
    public int uniquePathsWithObstacles(int[][] obs) {
        int n=obs.length;
        int m=obs[0].length;

        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return f(obs,n-1,m-1,dp);
    }
}