class Solution {

    HashSet<String> set = new HashSet<>();

    private boolean helper(String s, List<String> dict, String newS) {
        if (newS.length() > s.length() 
        || set.contains(newS)
        || !s.substring(0, newS.length()).equals(newS))
            return false;

        if (s.equals(newS)) return true;

        boolean ans = false;
        for (String word : dict) {
            ans = ans || helper(s, dict, newS + word);
        }

        if (!ans) set.add(newS);

        return ans;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, "");
    }
}