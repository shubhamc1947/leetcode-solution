class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] freq = new boolean[10001];
        int maxsum = 0, sum = 0, l = 0;
        
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (freq[nums[r]]) {
                sum -= nums[l];
                freq[nums[l]] = false;
                l++;
            }
            freq[nums[r]] = true;
            maxsum = Math.max(maxsum, sum);
        }
        
        return maxsum;
    }
}