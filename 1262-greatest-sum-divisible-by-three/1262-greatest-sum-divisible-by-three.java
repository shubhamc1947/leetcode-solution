class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int k = 3;
        long[][] dp = new long[n + 1][k];
        
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        
        dp[0][0] = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int newRemainder = (j + nums[i]) % k;
                
                dp[i + 1][newRemainder] = Math.max(dp[i][newRemainder], dp[i][j] + nums[i]);
            }
        }
        
        return (int) dp[n][0];
    }
}