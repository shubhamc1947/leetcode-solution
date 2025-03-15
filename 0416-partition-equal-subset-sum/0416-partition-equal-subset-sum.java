class Solution {
    public boolean canPartition(int[] nums) {
        // Calculate sum of the array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If sum is odd, we cannot partition into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        
        // Create a DP array where dp[i] indicates if sum i can be achieved
        boolean[] dp = new boolean[target + 1];
        
        // Base case: we can always achieve sum of 0
        dp[0] = true;
        
        // For each number, update the dp array
        for (int num : nums) {
            // Iterate backwards to avoid using the same element multiple times
            for (int i = target; i >= num; i--) {
                // If we can achieve sum (i - num), then we can achieve sum i by adding num
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        // Return if we can achieve the target sum
        return dp[target];
    }
}