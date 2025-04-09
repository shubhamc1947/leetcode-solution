class Solution {
    public int mySqrt(int n) {
         long si = 0, ei = n;
        while (si <= ei) {
            long mid = si + (ei - si) / 2;
            if (mid * mid == n) {
                return (int) mid;
            } else if (mid * mid > n) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return (int) si - 1;
    }
}