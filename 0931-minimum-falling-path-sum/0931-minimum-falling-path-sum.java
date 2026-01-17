class Solution {
   
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int j=0;j<m;j++){
            dp[0][j]=arr[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int top=dp[i-1][j];
                int leftDia=Integer.MAX_VALUE;
                if(j>0 && i>0) leftDia= dp[i-1][j-1];

                int rightDia=Integer.MAX_VALUE;
                if(i>0 && j<m-1) rightDia=dp[i-1][j+1];
                dp[i][j]= arr[i][j] + Math.min(top,Math.min(leftDia,rightDia));

            }
        }
        int mini=Integer.MAX_VALUE;

        for(int j=0;j<m;j++){
            mini=Math.min(mini,dp[n-1][j]);
        }
        return mini;
        
    }
}