class Solution {
    public boolean func(int arr[],int i,int tar,int dp[][]){
        if(tar==0) return true;
        if(i<0) return false;
        if(dp[i][tar]!=-1) return dp[i][tar]==1;
        boolean notTake=func(arr,i-1,tar,dp);
        boolean take=false;
        if(tar>=arr[i]){
            take=func(arr,i-1,tar-arr[i],dp);
        }

        dp[i][tar]= take|| notTake?1:0;
        return take||notTake;

    }
    public boolean canPartition(int[] arr) {
        int totalSum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            totalSum+=arr[i];
        }
        if(totalSum%2!=0){
            return false;
        }
        int tar=totalSum/2;
        int dp[][]=new int[n][tar+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,n-1,tar,dp);
    }
}