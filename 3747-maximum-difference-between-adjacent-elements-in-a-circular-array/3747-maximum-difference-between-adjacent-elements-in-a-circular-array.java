class Solution {
    public int maxAdjacentDistance(int[] arr) {
        int diff=Integer.MIN_VALUE;

        for(int i=0;i<arr.length-1;i++){
            diff=Math.max(diff,Math.abs(arr[i]-arr[i+1]));
        }
        diff=Math.max(diff,Math.abs(arr[arr.length-1]-arr[0]));
        return  diff;
    }

}