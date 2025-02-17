class Solution {
    public boolean canJump(int[] nums) {
        int index = 0;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++) {
            if(index < i) return false;
            index = Math.max(index, i + nums[i]);
        }
        return true;
    }
}