class Solution {
    public long coloredCells(int n) {
        long x=n-1;
        long res=1+4*(x*(x+1))/2;
        return res;
    }
}