class Solution {
    
    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=arr[i][j];
                }else{
                    int top=(int)1e8;
                    if(i-1>=0){
                        top=arr[i][j]+dp[i-1][j];
                    }
                    int left=(int)1e8;
                    if(j-1>=0){
                        left=arr[i][j]+dp[i][j-1];
                    }
                    dp[i][j]=Math.min(left,top);
                }
            }

        }
        return dp[n-1][m-1];
    }
}