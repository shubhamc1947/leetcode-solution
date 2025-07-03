class Solution {
    public boolean func(int arr[],int idx,int tar,int dp[][]){
        if(tar==0) return true;
        if(idx==0){
            return false;
        }
        if(dp[idx][tar]!=-1) return dp[idx][tar]==1;
        // not Take
        boolean notTake=func(arr,idx-1,tar,dp);
        boolean take=false;
        if(tar>=arr[idx]){
            take=func(arr,idx-1,tar-arr[idx],dp);
        }
        dp[idx][tar]= take||notTake?1:0;
        return take||notTake;
    }
    public boolean canPartition(int[] arr) {
        int totSum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            totSum+=arr[i];
        }
        if(totSum%2!=0){
            return false;
        }
        int tar=totSum/2;
        int idx=n-1;
        int dp[][]=new int[n][tar+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,idx,tar,dp);
    }
}