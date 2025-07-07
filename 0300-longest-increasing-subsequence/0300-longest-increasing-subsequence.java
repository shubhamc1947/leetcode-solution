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
        int dp[][]=new int[n+1][n+1];
        //n-1=>0 and n-1=>-1
        for(int idx=n-1;idx>=0;idx--){
            for(int prev=n-1;prev>=-1;prev--){
                int notTake=0+dp[idx+1][prev+1];
                int take=Integer.MIN_VALUE;
                if(prev==-1|| arr[idx]>arr[prev]){
                    take=1+ dp[idx+1][idx+1];
                }
                dp[idx][prev+1]= Math.max(take,notTake);
            }
        }
        return dp[0][0];
    }
}