class Solution {
    public int uniquePaths(int n, int m) {
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) {
                    dp[i][j]=1;
                }else{
                    int right=0,bottom=0;
                    if(j>0) right=dp[i][j-1];
                    if(i>0) bottom=dp[i-1][j];
                    dp[i][j]=right+bottom;
                }
            }
        }

        return dp[n-1][m-1];
    }
}