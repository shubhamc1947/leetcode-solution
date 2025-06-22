import java.util.*;
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int rem = s.length() % k;
        if (rem != 0) {
            s += String.valueOf(fill).repeat(k - rem);
        }
        int n = s.length() / k;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.substring(i * k, i * k + k);
        }
        return res;
    }
}