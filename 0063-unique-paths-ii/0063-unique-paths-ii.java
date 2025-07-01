class Solution {

    public int func(int arr[][],int i,int j,int dp[][]){
        if(i<0 || j<0 || arr[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int top=func(arr,i-1,j,dp);
        int left=func(arr,i,j-1,dp);
        return dp[i][j]= top+left;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return func(arr,n-1,m-1,dp);
    }
}