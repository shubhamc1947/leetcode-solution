class Solution {
    public boolean isPalindrome(int num) {
               int n = num, rev = 0;
        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        return rev == num ? true : false;
    }
}