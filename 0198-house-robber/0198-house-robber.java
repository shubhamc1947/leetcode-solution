class Solution {
    public int func(int arr[],int i,int dp[]){
        if(i==0) return arr[i];
        if(i==1) return Math.max(arr[0],arr[1]);

        if(dp[i]!=-1) return dp[i];
        int take=func(arr,i-2,dp)+arr[i];
        int notTake=func(arr,i-1,dp)+0;

        return dp[i]= Math.max(take,notTake);
    }
    public int rob(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++) dp[i]=-1;
        return func(arr,n-1,dp);
    }
}