class Solution {

    public boolean canPartition(int[] arr) {
        int n=arr.length;

        if(n==1) return false;

        int totSum=0;
        for(int i=0;i<n;i++){
            totSum+=arr[i];
        }

        if(totSum%2!=0) return false;

        int target=totSum/2;
        boolean dp[][]=new boolean[n][target+1];


        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(target>=arr[0]){
            dp[0][arr[0]]=true;
        }
        
        for(int i=1;i<n;i++){
            for(int tar=1;tar<target+1;tar++){
            boolean notTake=dp[i-1][tar];
            boolean take=false;
            if(tar>=arr[i]){

                take=dp[i-1][tar-arr[i]];
            }
                dp[i][tar]=take||notTake;
            }
        }

        return dp[n-1][target];
    }
}
