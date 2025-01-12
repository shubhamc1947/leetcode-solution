class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> patternHm = new HashMap<>();
        HashMap<String, Character> sHm = new HashMap<>();
        
        String[] arr = s.split(" ");
        
        
        if (arr.length != pattern.length()) {
            return false;
        }
        
        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String word = arr[i];
            
            
            if (patternHm.containsKey(patternChar)) {
                if (!patternHm.get(patternChar).equals(word)) {
                    return false;
                }
            } else {
                patternHm.put(patternChar, word);
            }
            
           
            if (sHm.containsKey(word)) {
                if (!sHm.get(word).equals(patternChar)) {
                    return false;
                }
            } else {
                sHm.put(word, patternChar);
            }
        }
        
        return true;
    }
}