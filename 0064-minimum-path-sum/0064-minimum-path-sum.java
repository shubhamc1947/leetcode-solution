class Solution {
    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=arr[i][j];
                }else{
                    int left=Integer.MAX_VALUE;
                    int top=Integer.MAX_VALUE;
                    if(i>0) top=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];

                    dp[i][j]=arr[i][j]+Math.min(left,top);
                }
            }
        }
        return dp[n-1][m-1];
    }
}