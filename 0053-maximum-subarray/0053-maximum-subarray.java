class Solution {
    public int maxSubArray(int[] arr) {
        int n=arr.length;
        int currSum=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currSum=Math.max(currSum+arr[i],arr[i]);
            maxi=Math.max(maxi,currSum);
        }
        return maxi;
    }
}