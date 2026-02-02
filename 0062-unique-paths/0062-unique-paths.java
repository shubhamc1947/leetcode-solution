class Solution {
    public int helper(int i,int j,int dp[][]){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int top=helper(i-1,j,dp);
        int left=helper(i,j-1,dp);
        return dp[i][j]= top+left;
    }
    public int uniquePaths(int n, int m) {
        int dp[][]=new int[n][m];
   
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else{
                    int top=0;
                    int left=0;
                    if(i-1>=0) top=dp[i-1][j];
                    if(j-1>=0) left=dp[i][j-1];
                    dp[i][j]=top+left;
                }
            }
        }
        return dp[n-1][m-1];
    }
}