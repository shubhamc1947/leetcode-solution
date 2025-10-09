class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int in_car = 0;
        int[] increase = new int[1001];
        for (int i = 0; i < trips.length; i ++) { 
            increase[trips[i][1]] += trips[i][0];
            increase[trips[i][2]] -= trips[i][0];
        }
        for (int i = 0; i <= 1000; i ++) {
            in_car += increase[i];
            if (in_car > capacity) return false; 
        }
        return true;
    }
}