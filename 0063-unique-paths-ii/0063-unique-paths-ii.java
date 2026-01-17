class Solution {
    public int helper(int arr[][],int i,int j,int dp[][]){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0 || arr[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=helper(arr,i,j-1,dp);
        int top=helper(arr,i-1,j,dp);

        return dp[i][j] = left+top;

    }
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr[0][0]==1) return 0;
        int n=arr.length;
        int m=arr[0].length;
        if(arr[n-1][m-1]==1) return 0;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(arr,n-1,m-1,dp);
    }
}