class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int n = word.length();
        int limit = n - numFriends + 1;
        char[] arr = word.toCharArray();
        int i = 0, j = 1, k = 0;
        while (j + k < n) {
            if (arr[i + k] == arr[j + k]) {
                k++;
            } else if (arr[i + k] < arr[j + k]) {
                i = j;
                j = i + 1;
                k = 0;
            } else {
                j = j + k + 1;
                k = 0;
            }
        }
        int end = Math.min(i + limit, n);
        return word.substring(i, end);
    }
}