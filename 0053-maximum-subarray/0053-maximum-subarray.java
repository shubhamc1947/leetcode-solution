class Solution {
    public int maxSubArray(int[] arr) {
        int ans=arr[0];
        int n=arr.length;
        int currSum=0;
        for(int i=0;i<n;i++){
            if(currSum<0){
                currSum=0;
            }
            currSum+=arr[i];
            ans=Math.max(ans,currSum);
        }
        return ans;
    }
}