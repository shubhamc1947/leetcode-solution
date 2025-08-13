class Solution {
    private final int M = 1000000007;
    private int[][] t = new int[301][301]; // memo table

    private int solve(int n, int num, int x) {
        // Base case: exact match
        if (n == 0) return 1;
        // If overshoot
        if (n < 0) return 0;

        int currPower = (int) Math.pow(num, x);
        if (currPower > n) return 0;

        // Check memo
        if (t[n][num] != -1) return t[n][num];

        // Choice 1: Take current number
        int take = solve(n - currPower, num + 1, x);
        // Choice 2: Skip current number
        int skip = solve(n, num + 1, x);

        // Store and return result
        return t[n][num] = (take + skip) % M;
    }

    public int numberOfWays(int n, int x) {
        // Initialize memo with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                t[i][j] = -1;
            }
        }
        return solve(n, 1, x);
    }
}