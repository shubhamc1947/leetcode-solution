class Solution {
    
    public String gcdOfStrings(String a, String b) {
        if (!(a + b).equals(b + a)) {
            return "";
        }
        int len = gcd(a.length(), b.length());
        return a.substring(0, len);
       
    }
      public  int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}