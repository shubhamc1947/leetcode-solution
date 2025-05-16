class Solution {
    public int func(int i,int j,int dp[][]){
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=0,top=0;
        if(i-1>=0) top=func(i-1,j,dp);
        if(j-1>=0) left=func(i,j-1,dp);

        return dp[i][j]= left+top;
    }
    public int uniquePaths(int n, int m) {
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return func(n-1,m-1,dp);
    }
}