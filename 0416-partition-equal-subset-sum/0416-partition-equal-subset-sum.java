class Solution {
    public boolean func(int arr[],int i,int tar,int dp[][]){
        if(tar==0) return true;
        if(i==0) return arr[i]==tar;

        if(dp[i][tar]!=-1) return dp[i][tar]==1;
        boolean notTake=func(arr,i-1,tar,dp);
        boolean take=false;
        if(tar>=arr[i]){

            take=func(arr,i-1,tar-arr[i],dp);
        }
        dp[i][tar]=take||notTake?1:0;
        return take||notTake;
    }
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
            Arrays.fill(dp[i],-1);
        }

        return func(arr,n-1,target,dp);

    }
}