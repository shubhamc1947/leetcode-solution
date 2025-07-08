class Solution {
    private int[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        dp = new int[events.length][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);  

        return solve(0, k, events);
    }

    private int solve(int i, int k, int[][] events) {
        if (i >= events.length || k == 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];

        int skip = solve(i + 1, k, events);

        int nextIndex = findNextEvent(events[i][1], i + 1, events);
        int attend = events[i][2] + solve(nextIndex, k - 1, events);

        return dp[i][k] = Math.max(skip, attend);
    }

    private int findNextEvent(int endDay, int left, int[][] events) {
        int right = events.length - 1;
        int ans = events.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > endDay) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}