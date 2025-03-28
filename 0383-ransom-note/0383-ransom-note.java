import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> storage = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            storage.put(c, storage.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (storage.containsKey(c)) {
                if (storage.get(c) > 0) {
                    storage.put(c, storage.get(c) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}