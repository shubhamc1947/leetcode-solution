class Solution {
    public int climbStairs(int n) {
        if(n<0) return 0;
        int dp[]=new int[n+1];
        int prev=1;
        int prev2=1;
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        
        return prev;
    }
}