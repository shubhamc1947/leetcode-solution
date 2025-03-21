class Solution {
    public int maxProfit(int[] arr) {
        int max = 0;
        for (int left = 0, right = 1; right < arr.length; right++) {
            if (arr[left] <= arr[right]) {
                max = Math.max(arr[right] - arr[left], max);
            } else {
                left = right;
            }
        }
        return max;

    }
}