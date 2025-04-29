class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int ans=Integer.MAX_VALUE;
        // int dp[][]=new int[n][m];
        int dp[]=new int[m];

        for(int j=0;j<m;j++){
            dp[j]=arr[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            int currArr[]=new int[m];
            for(int j=0;j<m;j++){
                int mini=(int)1e9;
                for(int k=-1;k<=1;k++){
                    if(j+k>=0 && j+k <m){
                        int curr=dp[j+k]+arr[i][j];
                        mini=Math.min(mini,curr);
                    }
                }
                currArr[j]=mini;
            }
            dp=currArr;
        }

        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp[i]);
        }
        return ans;
    }
}