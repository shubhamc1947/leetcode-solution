class Solution {
    public long flowerGame(int n, int m) {
        long M = (long) m, N = (long) n, res = 0;
        //left odd, right even;
        res += ((N + 1) / 2 * (M / 2));
        //left even, right odd;
        res += ((N / 2) * ((M + 1) / 2));
        return res;

    }
}