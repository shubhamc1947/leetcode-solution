class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        
        int maxi=Integer.MAX_VALUE;

        int dp[][]=new int[n][m];

        //base case initilization
        for(int j=0;j<m;j++){
            dp[0][j]=arr[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int left=(int)1e8;
                int right=(int)1e8;
                
                int top=dp[i-1][j]+arr[i][j];
                if(j-1>=0) left=dp[i-1][j-1]+arr[i][j];
                if(j+1<m) right=dp[i-1][j+1]+arr[i][j];

                dp[i][j]=Math.min(left,Math.min(right,top));
            }
        }


        int mini=dp[n-1][0];
        for(int j=1;j<m;j++){
            mini=Math.min(mini,dp[n-1][j]);
        }
        return mini;
        
    }
}