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
        int dp[][]=new int[n][target+1];


        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        if(target>=arr[0]){
            dp[0][arr[0]]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int tar=1;tar<target+1;tar++){
            boolean notTake=dp[i-1][tar]==1;
            boolean take=false;
            if(tar>=arr[i]){

                take=dp[i-1][tar-arr[i]]==1;
            }
                dp[i][tar]=take||notTake?1:0;
            }
        }

        return dp[n-1][target]==1;
    }
}
