class Solution {
   
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+1][n+1];
        for(int j=0;j<n+1;j++){
            dp[n][j]=0;
        }
        for(int idx=n-1;idx>=0;idx--){
            for(int prev=n-1;prev>=-1;prev--){
                int notTake= dp[idx+1][prev+1];
                //take
                int take=0;
                if(prev==-1 || arr[idx]>arr[prev]){
                    take=1+ dp[idx+1][idx+1];
                }
                dp[idx][prev+1]= Math.max(take,notTake);
            }
        }
        return dp[0][-1+1];
    }
}