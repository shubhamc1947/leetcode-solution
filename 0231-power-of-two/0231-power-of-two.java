class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==Integer.MIN_VALUE) return false;
        if(n==0) return false;
        return (n & (n-1)) ==0;
    }
}