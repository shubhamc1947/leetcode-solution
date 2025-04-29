class Solution {
    public int f(int arr[][],int i,int j,int n,int m,int dp[][]){
        if(i==n-1){
            return arr[i][j];
        }
        int mini=(int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=-1;k<=1;k++){
            if(j+k>=0 && j+k <m){
                int curr=f(arr,i+1,j+k,n,m,dp)+arr[i][j];
                mini=Math.min(mini,curr);
            }
        }
        return dp[i][j]= mini;
    }
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int ans=Integer.MAX_VALUE;
        int dp[][]=new int[n][m];

        for(int j=0;j<m;j++){
            dp[n-1][j]=arr[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                int mini=(int)1e9;
                for(int k=-1;k<=1;k++){
                    if(j+k>=0 && j+k <m){
                        int curr=dp[i+1][j+k]+arr[i][j];
                        mini=Math.min(mini,curr);
                    }
                }
                dp[i][j]=mini;
            }
        }

        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp[0][i]);
        }
        return ans;
    }
}