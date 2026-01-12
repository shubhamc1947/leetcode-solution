class Solution {
    public int helper(int arr[],int idx,int dp[]){
        if(idx==0) return arr[0];
        if(idx==1) return Math.max(arr[0],arr[1]);
        if(dp[idx]!=-1) return dp[idx];
        //take
        int take=helper(arr,idx-2,dp)+arr[idx];
        //nottake
        int notTake=helper(arr,idx-1,dp)+0;
        dp[idx]=Math.max(take,notTake);
        return dp[idx];
    }
    public int rob(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,arr.length-1,dp);
    }
}
