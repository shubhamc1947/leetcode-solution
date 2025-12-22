class Solution {

    // Recursive DP: minimum deletions starting from column 'cur'
    // 'pre' is the previously kept column (-1 if none)
    private int rec(char[][] a, int cur, int pre, int[][] dp) {
        int n = a.length;
        int m = a[0].length;

        // All columns processed
        if (cur == m) return 0;

        // Memoization lookup (shifted by +1 to handle pre = -1)
        if (dp[cur + 1][pre + 1] != -1)
            return dp[cur + 1][pre + 1];

        // Check if we can keep the current column
        boolean canKeep = true;
        if (pre != -1) {
            for (int i = 0; i < n; i++) {
                if (a[i][pre] > a[i][cur]) {
                    canKeep = false;
                    break;
                }
            }
        }

        // Option 1: delete current column
        int delete = 1 + rec(a, cur + 1, pre, dp);

        // Option 2: keep current column (only if valid)
        int keep = Integer.MAX_VALUE;
        if (canKeep) {
            keep = rec(a, cur + 1, cur, dp);
        }

        // Store and return the best result
        return dp[cur + 1][pre + 1] = Math.min(delete, keep);
    }

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = strs[i].toCharArray();
        }

        // DP table: dp[cur+1][pre+1]
        int[][] dp = new int[102][102];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return rec(a, 0, -1, dp);
    }
}
