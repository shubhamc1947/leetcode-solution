class Solution 
{
    public int[] maxSubsequence(int[] nums, int k) 
    {
        int n = nums.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) 
        {
            pairs[i][0] = nums[i]; // value
            pairs[i][1] = i;        // index
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        Arrays.sort(pairs, 0, k, Comparator.comparingInt(a -> a[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) 
        {
            result[i] = pairs[i][0];
        }

        return result;
    }
}