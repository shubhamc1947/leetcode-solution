class Solution {
    public boolean isPowerOfThree(int n) {
        
        double x=(Math.log10(n))/(Math.log10(3));
        return x%1==0?true:false;
    }
}