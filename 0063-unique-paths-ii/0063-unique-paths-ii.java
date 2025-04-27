class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int n=obs.length;
        int m=obs[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obs[i][j]==1){
                    dp[i][j]=0;
                }else{//not 1 
                    if(i==0 && j==0){
                        dp[i][j]=1;
                    }else{
                        int right=0,down=0;
                        if(j-1>=0) right=dp[i][j-1];
                        if(i-1>=0) down=dp[i-1][j];
                        dp[i][j]=right+down;
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}