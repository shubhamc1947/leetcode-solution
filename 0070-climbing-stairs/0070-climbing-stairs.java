class Solution {
    public int helper(int n,int dp[]){
        // if(n==0) return 1;// no stair, don't write, keep it for 1 and 2 stairs, as at n==0, returning 1 makes no sense
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n]!=-1) return dp[n];
        dp[n]= helper(n-1,dp)+helper(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
        
    }
}