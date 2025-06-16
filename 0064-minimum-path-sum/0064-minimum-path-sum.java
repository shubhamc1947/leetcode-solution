class Solution {
    int func(int arr[][],int i,int j,int dp[][]){
        if(i==0 && j==0 ) return arr[i][j];
        if(i<0 || j<0) return (int)1e8;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=func(arr,i,j-1,dp)+arr[i][j];
        int top=func(arr,i-1,j,dp)+arr[i][j];
        return dp[i][j]= Math.min(left,top);
    }
    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,n-1,m-1,dp);
    }
}