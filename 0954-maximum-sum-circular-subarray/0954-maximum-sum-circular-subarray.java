class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        int maxi=arr[0];
        int mini=arr[0];
        int currMax=0,currMin=0;
        int totSum=0;
        for(int i=0;i<n;i++){
            if(currMax<0) currMax=0;
            currMax+=arr[i];
            maxi=Math.max(maxi,currMax);

            if(currMin>0) currMin=0;
            currMin+=arr[i];
            mini=Math.min(mini,currMin);
            totSum+=arr[i];
        }

        return maxi>0?Math.max(maxi,totSum-mini) : maxi;
    }
}