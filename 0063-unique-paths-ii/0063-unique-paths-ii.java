class Solution {
    public int func(int i,int j,int arr[][],int dp[][]){
        if(i==0 && j==0 && arr[i][j]==0) return 1;

        if(i<0 || j<0 || arr[i][j]==1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int left=func(i,j-1,arr,dp);
        int top=func(i-1,j,arr,dp);

        return dp[i][j]= top+left;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return func(n-1,m-1,arr,dp);
    }
}