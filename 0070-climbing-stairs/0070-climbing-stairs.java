class Solution {
    
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        // Arrays.fill(dp,-1);
        if(n<=2) return n;
        int n1=2;
        int n2=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            int curr= n1+n2;
            n2=n1;
            n1=curr;
        }
        
        return n1;
    }
}