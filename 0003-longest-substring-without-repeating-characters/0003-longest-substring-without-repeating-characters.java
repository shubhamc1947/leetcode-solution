class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int ans=0;
        HashSet<Character> hs=new HashSet<>();
        for(int si=0,ei=0;ei<n;ei++){
            while(hs.contains(s.charAt(ei))){
                hs.remove(s.charAt(si));
                si++;
            }
            hs.add(s.charAt(ei));
            ans=Math.max(ans,ei-si+1);  
        }
        return ans;
    }
}