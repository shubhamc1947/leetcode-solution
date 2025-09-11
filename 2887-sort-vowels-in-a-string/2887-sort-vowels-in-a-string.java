import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String sortVowels(String s) {
        // Step 1: Collect all vowels from the string.
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Step 2: Sort the collected vowels.
        Collections.sort(vowels);

        // Step 3: Build the result string by replacing vowels in order.
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                // If the character is a vowel, append the next sorted vowel.
                result.append(vowels.get(vowelIndex));
                vowelIndex++;
            } else {
                // If it's a consonant, append it as is.
                result.append(c);
            }
        }

        return result.toString();
    }

   
    // Helper function to check if a character is a vowel (case-sensitive).
     
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}