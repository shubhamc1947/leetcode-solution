class Solution {
    public int func(int arr[],int idx,int dp[]){
        if(idx==0) return arr[0];
        if(idx==1) return Math.max(arr[0],arr[1]);
        if(dp[idx]!=-1) return dp[idx];
        int take=0+func(arr,idx-1,dp);
        int notTake=arr[idx]+func(arr,idx-2,dp);
        return dp[idx]= Math.max(take,notTake);
    }
    public int rob(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return func(arr,arr.length-1,dp);
    }
}