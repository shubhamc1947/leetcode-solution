class Solution {
    public int maxSubArray(int[] arr) {
        int currSum=arr[0];
        int maxiSum=arr[0];
        for(int i=1;i<arr.length;i++){
            currSum=Math.max(currSum+arr[i],arr[i]);

            maxiSum=Math.max(currSum,maxiSum);
        }
        return maxiSum;
    }
}