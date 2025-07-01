class Solution {

    public int uniquePathsWithObstacles(int[][] arr) {
        
        int n=arr.length;
        int m=arr[0].length;
        if(arr[0][0]==1) return 0;
        int dp[][]=new int[n][m];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else{
                    if(arr[i][j]==1){
                        dp[i][j]=0;
                    }else{
                        int top=0;
                        if(i-1>=0){
                            top=dp[i-1][j];
                        }
                        int left=0;
                        if(j-1>=0){
                            left=dp[i][j-1];
                        }
                        dp[i][j]= top+left;
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}