

class Solution {

    public boolean canRobWithCapability(int[] nums, int cap, int k) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= cap) {
                count++;
                i += 2;  
            } else {
                i++;
            }
        }
        return count >= k;
    }

    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

       
        while (left < right) {
            int mid = (left + right) / 2;
            if (canRobWithCapability(nums, mid, k)) {
                right = mid;  
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

