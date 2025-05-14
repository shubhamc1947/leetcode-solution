class Solution {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int mod = 1_000_000_007;
        int size = 26;

        long[][] T = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                int next = (i + j) % size;
                T[next][i] = 1;
            }
        }

        long[][] T_power = matrixPower(T, t, mod);

        long[] freq = new long[size];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        long[] result = new long[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i] = (result[i] + T_power[i][j] * freq[j]) % mod;
            }
        }

        long ans = 0;
        for (long val : result) {
            ans = (ans + val) % mod;
        }

        return (int) ans;
    }

    private long[][] matrixPower(long[][] matrix, int power, int mod) {
        int size = matrix.length;
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, matrix, mod);
            }
            matrix = multiplyMatrices(matrix, matrix, mod);
            power >>= 1;
        }

        return result;
    }

    private long[][] multiplyMatrices(long[][] A, long[][] B, int mod) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % mod;
                }
            }
        }
        return C;
    }
}