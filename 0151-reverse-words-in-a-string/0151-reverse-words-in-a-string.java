class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.trim().split("\\s+");//regex for removing all the spacing in between

        for(int i = words.length-1; i >= 0; i--){
            res.append(words[i]).append(" ");
        }

        return res.toString().trim();
    }
}