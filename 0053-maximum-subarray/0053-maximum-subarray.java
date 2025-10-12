class Solution {
    public int maxSubArray(int[] arr) {
        int n=arr.length;
        int curr=-1;
        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            curr=Math.max(arr[i],curr+arr[i]);
            maxi=Math.max(maxi,curr);
        }
        return maxi;
    }
}