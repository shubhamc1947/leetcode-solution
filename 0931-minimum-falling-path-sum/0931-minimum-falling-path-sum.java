class Solution {
    public int helper(int arr[][],int i,int j,int n,int m,int dp[][]){
        if(j<0 ||j>=m) return (int)1e8;
        if(i==n-1){
            return arr[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int bottom=helper(arr,i+1,j,n,m,dp);
        int left=helper(arr,i+1,j-1,n,m,dp);
        int right=helper(arr,i+1,j+1,n,m,dp);
        return dp[i][j]= arr[i][j]+ Math.min(bottom,Math.min(left,right));
    }
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int mini=Integer.MAX_VALUE;
        int dp[][]=new int[n][m];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        // for(int j=0;j<n;j++){
        //     mini=Math.min(mini,helper(arr,0,j,n,m,dp));
        // }
        // return mini;

        for(int j=0;j<m;j++){
            dp[n-1][j]=arr[n-1][j];
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                int bottom= dp[i+1][j];
                int left= (int) 1e8;
                if(j-1>=0){
                    left=dp[i+1][j-1];
                }
                 
                int right= (int) 1e8;
                if(j+1<m){
                    right= dp[i+1][j+1];
                }
                dp[i][j]= arr[i][j]+ Math.min(bottom,Math.min(left,right));
            }
        }
        for(int j=0;j<m;j++){
            mini=Math.min(mini,dp[0][j]);

        }
        return mini;
        
    }
}