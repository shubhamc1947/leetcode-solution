class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int ans=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int si=0, ei=0; ei<n; ei++){
            if(hm.containsKey(s.charAt(ei))){
                si = Math.max(si, hm.get(s.charAt(ei)) + 1);
            }
            hm.put(s.charAt(ei), ei);
            ans = Math.max(ans, ei - si + 1);
        }
        return ans;
    }
}