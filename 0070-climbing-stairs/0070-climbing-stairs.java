class Solution {
    public int climbStairsFun(int n,int dp[]){
        if(n<0 ) return 0;
        if(n==0 || n==1) return 1;

        if(dp[n]!=-1) return dp[n];
        dp[n]=climbStairsFun(n-1,dp)+climbStairsFun(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       return climbStairsFun(n,dp);
    }
}