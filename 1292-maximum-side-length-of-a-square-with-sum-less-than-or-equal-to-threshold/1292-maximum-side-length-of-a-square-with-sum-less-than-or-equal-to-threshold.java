class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] pref = new int[m + 1][n + 1];

        // Build prefix sum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                           + pref[i - 1][j]
                           + pref[i][j - 1]
                           - pref[i - 1][j - 1];
            }
        }

        int maxLen = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = maxLen + 1;
                if (i >= k && j >= k) {
                    int currSum = pref[i][j]
                                - pref[i - k][j]
                                - pref[i][j - k]
                                + pref[i - k][j - k];
                    if (currSum <= threshold) {
                        maxLen = k;
                    }
                }
            }
        }

        return maxLen;
    }
}