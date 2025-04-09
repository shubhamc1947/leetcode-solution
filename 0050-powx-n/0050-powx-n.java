class Solution {
    public double myPow(double x, int n) {
          if (n == 0) {
            return 1;
        } else if (n > 0) {
            return Pow(x, n);
        } else {
            return 1 / Pow(x, -n);
        }
    }
     public static double Pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = Pow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    
}