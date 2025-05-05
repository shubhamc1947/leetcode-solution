class Solution {
    public int f(int n,int m,int dp[][]){
        if(n==1 && m==1){
            return 1;
        }else if(n==2 && m==2){
            return 2;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int top=0;
        int left=0;
        if(n-1>=0){
            top=f(n-1,m,dp);
        }
        if(m-1>=0){
            left=f(n,m-1,dp);
        }
        return dp[n][m]=top+left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return f(m,n,dp);
    }
}