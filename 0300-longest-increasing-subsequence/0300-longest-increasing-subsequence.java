class Solution {
    public int lengthOfLIS(int[] arr) {
        //recursive approch
        int n=arr.length;
        int dp[][]=new int[n+1][n+1];

        for(int idx=n-1;idx>=0;idx--){
            for(int prev=-1;prev<n;prev++){
                int notTake= dp[idx+1][prev+1];

                int take=-(int)1e8;
                if(prev==-1 || arr[idx]>arr[prev]){
                    take=1+ dp[idx+1][idx+1];
                }
                dp[idx][prev+1]= Math.max(take,notTake);

            }
        }
        return dp[0][-1+1];
        
    }
}