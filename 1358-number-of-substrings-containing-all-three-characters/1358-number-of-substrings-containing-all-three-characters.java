class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] freq = new int[3];
        int left = 0, ans = 0;
        int n = s.length();
        char[] arr = s.toCharArray();

        for (int right = 0; right < n; right++) {
            freq[arr[right] - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += n - right;
                freq[arr[left++] - 'a']--;
            }
        }

        return ans;
    }
}