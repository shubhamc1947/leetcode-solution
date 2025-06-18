class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length / 3;
        int[][] res = new int[n][3];
        int idx = 0;
        for (int i = 0; i < nums.length; i += 3) {
            int a = nums[i], b = nums[i+1], c = nums[i+2];
            if (c - a > k) return new int[0][0];
            res[idx++] = new int[]{a, b, c};
        }
        return res;
    }
}