class Solution {
    public int func(int i,int dp[]){
        if(i<0) return -1;
        
        if(i==0 || i==1){
            return 1;
        }

        if(dp[i]!=-1) return dp[i];
        return dp[i]= func(i-1,dp)+func(i-2,dp);
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return func(n,dp);
        
    }
}