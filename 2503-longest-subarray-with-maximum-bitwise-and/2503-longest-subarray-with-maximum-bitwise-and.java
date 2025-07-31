class Solution {
    public int longestSubarray(int[] nums) {
        int len = 0; // Tracks the length of the current consecutive subarray of 'max'
        int max = nums[0]; // Stores the maximum element found in the array so far
        int ans = len; // Stores the overall longest consecutive subarray of 'max' found

        // First pass: Find the maximum element in the array
        for (int a : nums) {
            max = Math.max(max, a); // Update 'max' if a larger element is found
        }

        // Second pass: Find the longest consecutive subarray of the 'max' element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                len++; // If the current element is 'max', increment the current length
                ans = Math.max(len, ans); // Update 'ans' if 'len' is greater (found a new longest)
            } else {
                len = 0; // If the current element is not 'max', reset 'len' as the sequence is broken
            }
        }
        return ans; // Return the maximum length found
    }
}