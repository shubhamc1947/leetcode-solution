class Solution {
    private int digitSum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
    public int countLargestGroup(int n) {
        int[] count = new int[37]; 

        for (int i = 1; i <= n; i++) 
            count[digitSum(i)]++;

        int maxi = 0;
        for (int c : count)
            maxi = Math.max(maxi, c);

        int grpsCount = 0;
        for (int cnt : count)
            if (cnt == maxi)
                grpsCount++;

        return grpsCount;
    }
}