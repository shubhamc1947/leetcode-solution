class Solution {
    
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        // for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0]=1;
                }else{
                    int top=0;
                    int left=0;
                    if(i-1>=0){
                        top=dp[i-1][j];
                    }
                    if(j-1>=0) {
                        left=dp[i][j-1];
                    }
                    dp[i][j]= top+left;
                }
            }
        }

        return dp[m-1][n-1];
    }
}