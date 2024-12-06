class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using two pointer and sliding window technique and Hashset
        
        // tc=O(n) ans Sc=O(n)
         HashSet<Character> hs = new HashSet<>();
        int ans = 0;
        for (int si = 0, ei = 0; ei < s.length(); ei++) {
            while (hs.contains(s.charAt(ei))) {
                hs.remove(s.charAt(si));
                si++;
            }
            hs.add(s.charAt(ei));
            ans = Math.max(ans, ei - si + 1);
        }
        return ans;
    }
}