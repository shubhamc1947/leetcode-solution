class Solution {
    public int lengthOfLastWord(String str) {
        str = str.trim();
        int si = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length()) {
                si = i + 1;
            }
        }
        String s = str.substring(si);
        return s.length();
    }
}