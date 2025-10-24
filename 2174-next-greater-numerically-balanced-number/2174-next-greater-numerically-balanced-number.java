import java.util.*;

class Solution {
    boolean bal(long n) {
        Map<Long, Long> occ = new HashMap<>();
        while (n > 0) {
            long d = n % 10;
            occ.put(d, occ.getOrDefault(d, 0L) + 1);
            n /= 10;
        }
        for (Map.Entry<Long, Long> e : occ.entrySet()) {
            if (!e.getKey().equals(e.getValue())) return false;
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        for (long i = n + 1; i < Long.MAX_VALUE; i++) {
            if (bal(i)) return (int) i;
        }
        return -1;
    }
}