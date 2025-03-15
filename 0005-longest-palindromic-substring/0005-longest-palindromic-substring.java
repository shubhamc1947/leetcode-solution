class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Get lengths for both odd and even length palindromes
            int len1 = expandAroundCenter(s, i, i);     // Odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // Even length palindrome
            
            // Get the maximum length
            int len = Math.max(len1, len2);
            
            // Update start and end if we found a longer palindrome
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // Helper function to expand around center
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        // Return the length of the palindrome
        // (right - left - 1) is the length of the palindrome
        return right - left - 1;
    }
}