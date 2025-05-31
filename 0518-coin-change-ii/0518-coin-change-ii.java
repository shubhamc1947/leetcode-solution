class Solution {
    public int change(int t, int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n][t+1];

        for(int tar=0;tar<=t;tar++){
            if(tar % arr[0]==0) dp[0][tar]=1;
        }

        for(int idx=1;idx<n;idx++){
            for(int tar=0;tar<=t;tar++){
                int notTake=0+dp[idx-1][tar];
                int take=0;
                if(tar>=arr[idx]){
                    take=dp[idx][tar-arr[idx]];
                }
                dp[idx][tar]= take+notTake;
            }
        }
        return dp[n-1][t];
    }
}