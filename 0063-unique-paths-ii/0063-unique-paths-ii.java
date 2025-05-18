class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0 && arr[i][j]==0) {
                    dp[i][j]=1;
                }else{
                    if(arr[i][j]==1){
                        dp[i][j]=0;
                    }else{
                        int left=0,top=0;   
                        if(j>0) left=dp[i][j-1];
                        if(i>0) top=dp[i-1][j];
                        dp[i][j]=top+left;
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}