class Solution {
    public int largestAltitude(int[] gain) {
        int maxi=Math.max(0,gain[0]);
        for(int i=1;i<gain.length;i++){
            gain[i]=gain[i]+gain[i-1];
            maxi=Math.max(gain[i],maxi);
        }
        return maxi;
    }
}
