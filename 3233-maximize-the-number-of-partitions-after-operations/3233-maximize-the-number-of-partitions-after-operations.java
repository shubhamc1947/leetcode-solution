public class Solution {
    private Map<Long, Integer> calculatedResults = new HashMap<>();
    private String inputString;
    private int maxUniqueCharacters;

    public int calculate(long currentIndex, long uniqueCharacters, boolean canChangeCharacter) {
        long key = (currentIndex << 27) | (uniqueCharacters << 1) | (canChangeCharacter ? 1 : 0);

        if (calculatedResults.containsKey(key)) {
            return calculatedResults.get(key);
        }

        if (currentIndex == inputString.length()) {
            return 0;
        }

        int characterIndex = inputString.charAt((int) currentIndex) - 'a';
        long updatedUniqueCharacters = uniqueCharacters | (1L << characterIndex);
        int uniqueCharacterCount = Long.bitCount(updatedUniqueCharacters);

        int result;
        if (uniqueCharacterCount > maxUniqueCharacters) {
            result = 1 + calculate(currentIndex + 1, 1L << characterIndex, canChangeCharacter);
        } else {
            result = calculate(currentIndex + 1, updatedUniqueCharacters, canChangeCharacter);
        }

        if (canChangeCharacter) {
            for (int newCharacterIndex = 0; newCharacterIndex < 26; ++newCharacterIndex) {
                long newSet = uniqueCharacters | (1L << newCharacterIndex);
                int newUniqueCharacterCount = Long.bitCount(newSet);

                if (newUniqueCharacterCount > maxUniqueCharacters) {
                    result = Math.max(result, 1 + calculate(currentIndex + 1, 1L << newCharacterIndex, false));
                } else {
                    result = Math.max(result, calculate(currentIndex + 1, newSet, false));
                }
            }
        }

        calculatedResults.put(key, result);
        return result;
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        inputString = s;
        maxUniqueCharacters = k;
        return calculate(0, 0, true) + 1;
    }
}
