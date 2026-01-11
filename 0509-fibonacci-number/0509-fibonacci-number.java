class Solution {
    public int fiboHelper(int i,int dp[]){
		if(i<=1) return i;
		if(dp[i]!=-1) return dp[i];
		dp[i]=fiboHelper(i-1,dp)+fiboHelper(i-2,dp);
		return dp[i];
	}
    public int fib(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        fiboHelper(n,dp);
        return dp[n];
    }
}