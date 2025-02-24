class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        long nonZeroProduct = 1;
        int[] result = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                zeroCount++;
            } else {
                nonZeroProduct *= nums[index];
            }
        }

        if (zeroCount > 1) {
            return result;
        }

        if (zeroCount == 1) {
            for (int index = 0; index < nums.length; index++) {
                if (nums[index] == 0) {
                    result[index] = (int) nonZeroProduct;
                } else {
                    result[index] = 0;
                }
            }
            return result;
        }

        for (int index = 0; index < nums.length; index++) {
            result[index] = (int) nonZeroProduct / nums[index];
        }
        return result;
    }
}