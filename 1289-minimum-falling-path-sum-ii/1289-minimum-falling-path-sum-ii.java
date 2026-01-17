class Solution {
    public int helper(int arr[][],int idx,int prev,int m,int dp[][]){
        if(idx==0){
            int mini=Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                if(j!=prev) mini=Math.min(mini,arr[0][j]);
            }
            return mini;
        }
        if(dp[idx][prev]!=-1) return dp[idx][prev];
        int mini=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            if(j!=prev) mini=Math.min(mini,arr[idx][j]+helper(arr,idx-1,j,m,dp));
        }
        return dp[idx][prev]= mini;
    }
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,n-1,m,m,dp);
    }
}