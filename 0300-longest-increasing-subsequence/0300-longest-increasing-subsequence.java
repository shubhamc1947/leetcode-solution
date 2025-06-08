class Solution {
    public int func(int arr[],int idx,int prev,int n,int dp[][]){
        if(idx==n) return 0;
        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
        //not take
        int notTake=0+func(arr,idx+1,prev,n,dp);
        //take
        int take=0;
        if(prev==-1 || arr[idx]>arr[prev]){
            take=1+func(arr,idx+1,idx,n,dp);
        }
        return dp[idx][prev+1]= Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,0,-1,n,dp);
    }
}