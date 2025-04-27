class Solution {
    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]= arr[i][j];
                }
                else{
                    int right=Integer.MAX_VALUE,down=Integer.MAX_VALUE;
                    if(j-1>=0) right=dp[i][j-1]+arr[i][j];
                    if(i-1>=0) down=dp[i-1][j]+arr[i][j];

                    dp[i][j]=Math.min(right,down);
                }
            }
        }
        return dp[n-1][m-1];
    }
}