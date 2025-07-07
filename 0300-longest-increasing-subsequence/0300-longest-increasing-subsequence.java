class Solution {
    public int func(int arr[],int idx,int prev,int dp[][]){
        //
        if(idx==arr.length) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int notTake=0+func(arr,idx+1,prev,dp);
        int take=Integer.MIN_VALUE;
        if(prev==-1|| arr[idx]>arr[prev]){
            take=1+func(arr,idx+1,idx,dp);
        }
        return dp[idx][prev+1]= Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++ ) Arrays.fill(dp[i],-1);
        return func(arr,0,-1,dp);
    }
}