class Solution {
    public int func(int arr[],int idx,int prev,int n,int dp[][]){
        if(idx==n) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        //not Take
        int notTake=func(arr,idx+1,prev,n,dp);
        
        int take=-(int)1e8;
        if(prev==-1 || arr[idx]>arr[prev]){
            take=1+func(arr,idx+1,idx,n,dp);
        }
        return dp[idx][prev+1]= Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] arr) {
        //recursive approch
        int idx=0;
        int n=arr.length;
        int prev=-1;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return func(arr,idx,prev,n,dp);
        
    }
}