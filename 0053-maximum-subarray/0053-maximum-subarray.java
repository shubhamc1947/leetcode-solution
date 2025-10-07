class Solution {
    public int maxSubArray(int[] arr) {
        int n=arr.length;
        int currSum=0;
        int ans=arr[0];
        for(int i=0;i<n;i++){
            currSum=Math.max(currSum+arr[i],arr[i]);

            ans=Math.max(currSum,ans);
        }
        return ans;
    }
}