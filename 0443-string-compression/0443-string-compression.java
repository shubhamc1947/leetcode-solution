class Solution {
    public int compress(char[] c) {
        int n = c.length;
        if (n == 0) return 0;
        int w = 0;
        int r = 0;
        while (r < n) {
            char x = c[r];
            int cnt = 0;
            while (r < n && c[r] == x) {
                r++;
                cnt++;
            }
            c[w++] = x;
            if (cnt > 1) {
                for (char d : Integer.toString(cnt).toCharArray()) {
                    c[w++] = d;
                }
            }
        }
        return w;
    }
}