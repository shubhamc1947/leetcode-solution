class Solution {
    public boolean canPartition(int[] arr) {
        int totSum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            totSum+=arr[i];
        }
        if(totSum%2!=0){
            return false;
        }
        int tar2=totSum/2;
        int idx2=n-1;
        boolean dp[][]=new boolean[n][tar2+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }

        for(int idx=1;idx<n;idx++){
            for(int tar=0;tar<=tar2;tar++){
                boolean notTake= dp[idx-1][tar];
                boolean take=false;
                if(tar>=arr[idx] && tar-arr[idx]>=0){
                    take=dp[idx-1][tar-arr[idx]];
                }
                dp[idx][tar]= take||notTake;
            }
        }
        return dp[idx2][tar2];
    }
}