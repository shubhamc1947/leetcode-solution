class Solution {
    static final int MOD = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int firstComplexity = complexity[0];

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= firstComplexity) {
                return 0;
            }
        }
        return fact(n - 1);
    }

    private static int fact(int n) {
        long num = 1;
        while (n > 0) {
            num = (num * n) % MOD; 
            n--;
        }
        return (int) num;
    }
}