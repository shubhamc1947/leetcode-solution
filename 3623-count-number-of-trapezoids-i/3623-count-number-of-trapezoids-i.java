class Solution {
    public int countTrapezoids(int[][] points) {
        // Brute Force Approach : 
        // T.C = O(NLogN)
        // S.C = O(N)

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        List<Long> pointCnt = new ArrayList<>();

        int n = points.length;
        int i = 0, j = 0;
        while (j < n) {
            if (points[i][1] == points[j][1]) {
                while (j < n && points[i][1] == points[j][1]) j++;

                long count = (long)j-i;
                long pairs = count*(count-1)/2;
                pointCnt.add(pairs);
            } else j++;

            i = j;
        }

        int size = pointCnt.size();

        long[] suffSum = new long[size];
        suffSum[size-1] = pointCnt.get(size-1);
        for(int k = size-2; k >= 0; k--) suffSum[k] = suffSum[k+1] + pointCnt.get(k);


        int mod = (int)(1e9+7);
        long ans = 0;
        for(int k = 0; k < size-1; k++) {
            ans = ans%mod + (pointCnt.get(k) * suffSum[k+1])%mod;
        }
        return (int)ans;
    }
}