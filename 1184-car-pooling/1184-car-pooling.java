class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int road[]=new int[1001];
        int tripLen=trips.length;
        for(int i=0;i<tripLen;i++){
            road[trips[i][1]]+=trips[i][0];
            road[trips[i][2]]-=trips[i][0];
        }
        int currPassengers=0;
        for(int i=0;i<1001;i++){
            currPassengers+=road[i];
            if(currPassengers>capacity) return false;
        }
        return true;
    }
}