class Solution {
    public int singleNumber(int[] arr) {
        int ones = 0, twos = 0;
        for (int i = 0; i < arr.length; i++) {
            ones = (ones ^ arr[i]) & (~twos);
            twos = (twos ^ arr[i]) & (~ones);
        }
        return ones;
    }
}