class Solution {
    public int f(int arr[][],int i,int j,int dp[][]){
        if(i==0 && j==0) return arr[0][0];
        if(i<0 || j<0 ) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int top=f(arr,i-1,j,dp)+arr[i][j];
        int left=f(arr,i,j-1,dp)+arr[i][j];

        return dp[i][j]= Math.min(top,left);
    }
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