class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int totalCandies = 1;
        int up = 1, down = 0, peak = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                totalCandies += up;
            } else if (ratings[i] < ratings[i - 1]) {
                down++;
                up = 1;
                totalCandies += down;
                if (down >= peak) {
                    totalCandies++;
                }
            } else {
                up = 1;
                down = 0;
                peak = 1;
                totalCandies += 1;
            }
        }
        
        return totalCandies;
    }
}