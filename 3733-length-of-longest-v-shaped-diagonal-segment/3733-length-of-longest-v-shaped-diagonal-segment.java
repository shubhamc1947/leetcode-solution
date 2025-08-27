import java.util.*;
class Solution {
    // SE, SW, NW, NE in clockwise order
    private static final int[] DX = {1, 1, -1, -1};
    private static final int[] DY = {1, -1, -1, 1};

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][][] end = new int[4][n][m];   // straight segments ending at (i,j)
        int[][][] alt20 = new int[4][n][m]; // start at (i,j), needs 2,0,2,0...
        int[][][] alt02 = new int[4][n][m]; // start at (i,j), needs 0,2,0,2...

        int ans = 0;

        // Compute straight end lengths per direction
        for (int d = 0; d < 4; d++) {
            if (d == 0) { // SE: prev is (i-1,j-1)
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        ans = Math.max(ans, end[d][i][j] = computeEnd(grid, end[d], d, i, j));
                    }
                }
            } else if (d == 1) { // SW: prev is (i-1,j+1)
                for (int i = 0; i < n; i++) {
                    for (int j = m - 1; j >= 0; j--) {
                        ans = Math.max(ans, end[d][i][j] = computeEnd(grid, end[d], d, i, j));
                    }
                }
            } else if (d == 2) { // NW: prev is (i+1,j+1)
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = m - 1; j >= 0; j--) {
                        ans = Math.max(ans, end[d][i][j] = computeEnd(grid, end[d], d, i, j));
                    }
                }
            } else { // d == 3, NE: prev is (i+1,j-1)
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = 0; j < m; j++) {
                        ans = Math.max(ans, end[d][i][j] = computeEnd(grid, end[d], d, i, j));
                    }
                }
            }
        }

        // Compute forward alternating runs (to extend after the turn)
        for (int d = 0; d < 4; d++) {
            if (d == 0) { // SE: next is (i+1,j+1) -> iterate from bottom-right
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = m - 1; j >= 0; j--) {
                        computeAlt(grid, alt20[d], alt02[d], d, i, j);
                    }
                }
            } else if (d == 1) { // SW: next (i+1,j-1) -> iterate i desc, j asc
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = 0; j < m; j++) {
                        computeAlt(grid, alt20[d], alt02[d], d, i, j);
                    }
                }
            } else if (d == 2) { // NW: next (i-1,j-1) -> iterate i asc, j asc
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        computeAlt(grid, alt20[d], alt02[d], d, i, j);
                    }
                }
            } else { // NE: next (i-1,j+1) -> iterate i asc, j desc
                for (int i = 0; i < n; i++) {
                    for (int j = m - 1; j >= 0; j--) {
                        computeAlt(grid, alt20[d], alt02[d], d, i, j);
                    }
                }
            }
        }

        // Combine: straight leg ending at (i,j) in d, then clockwise to d2
        for (int d = 0; d < 4; d++) {
            int d2 = (d + 1) & 3; // clockwise 90°
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int L1 = end[d][i][j];
                    if (L1 == 0) continue;

                    int needNext; // next required value after corner (i,j)
                    int cur = grid[i][j];
                    if (cur == 1) needNext = 2;
                    else if (cur == 2) needNext = 0;
                    else needNext = 2;

                    int ni = i + DX[d2], nj = j + DY[d2];
                    if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
                        ans = Math.max(ans, L1);
                        continue;
                    }

                    int L2 = (needNext == 2) ? alt20[d2][ni][nj] : alt02[d2][ni][nj];
                    ans = Math.max(ans, L1 + L2);
                }
            }
        }

        return ans;
    }

    private int computeEnd(int[][] g, int[][] endDir, int d, int i, int j) {
        int n = g.length, m = g[0].length;
        int pi = i - DX[d], pj = j - DY[d];
        int prevLen = 0, prevVal = -1;
        if (pi >= 0 && pj >= 0 && pi < n && pj < m) {
            prevLen = endDir[pi][pj];
            prevVal = g[pi][pj];
        }

        int v = g[i][j];
        if (v == 1) return 1;
        if (v == 2) {
            if (prevVal == 1) return 2;
            if (prevVal == 0 && prevLen > 0) return prevLen + 1;
            return 0;
        } else { // v == 0
            if (prevVal == 2 && prevLen > 0) return prevLen + 1;
            return 0;
        }
    }

    private void computeAlt(int[][] g, int[][] alt20, int[][] alt02, int d, int i, int j) {
        int n = g.length, m = g[0].length;
        int ni = i + DX[d], nj = j + DY[d];
        boolean in = (ni >= 0 && nj >= 0 && ni < n && nj < m);

        if (g[i][j] == 2) {
            int len = 1;
            if (in && g[ni][nj] == 0) len += alt02[ni][nj];
            alt20[i][j] = len;
        } else {
            alt20[i][j] = 0;
        }

        if (g[i][j] == 0) {
            int len = 1;
            if (in && g[ni][nj] == 2) len += alt20[ni][nj];
            alt02[i][j] = len;
        } else {
            alt02[i][j] = 0;
        }
    }
}