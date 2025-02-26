class Solution {

    public int maxVowels(String str, int k) {
        char[] chrArr = str.toCharArray();
        int i = 0;
        int countVowels = 0;
        int maxVowels;

        while(i < k){
            if(isVowel(chrArr[i])) countVowels++;
            i++;
        }

        maxVowels = countVowels;

        while(i < chrArr.length){
            if(isVowel(chrArr[i - k])) countVowels--;
            if(isVowel(chrArr[i])) countVowels++;

            maxVowels = countVowels > maxVowels ? countVowels : maxVowels;
            i++;
        }

        return maxVowels;
    }

    public boolean isVowel(char chr) {
        return switch (chr) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}