class Solution {
    public int maxSubArray(int[] arr) {
        int curr=arr[0];
        int maxi=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            curr=Math.max(curr+arr[i],arr[i]);
            maxi=Math.max(maxi,curr);
        }
        return maxi;
    }
}