class Solution {

    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = getPrimes(left, right);

        if (primes.size() <= 1) return new int[]{-1, -1};
        
        int gap = Integer.MAX_VALUE;
        int[] ret = new int[]{-1, -1};
        for (int i = 0; i < primes.size() - 1; i++) {
            if (primes.get(i + 1) - primes.get(i) < gap) {
                ret[0] = primes.get(i);
                ret[1] = primes.get(i + 1);
                gap = primes.get(i + 1) - primes.get(i);
            }
        }

        return ret;
    }


    // linear complexity to find all primes

    private List<Integer> getPrimes(int left, int n) {
        int[] primes = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) primes[cnt++] = i;

            for (int j = 0; primes[j] * i <= n; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            if (primes[i] >= left && primes[i] <= n) {
                ret.add(primes[i]);
            }
        }
        return ret;
    }

    
}