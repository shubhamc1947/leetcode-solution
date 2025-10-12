class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        int currMaxi=0;
        int maxi=Integer.MIN_VALUE;
        int currMini=0;
        int mini=Integer.MAX_VALUE;
        int totSum=0;
        for(int i=0;i<n;i++){
            currMaxi=Math.max(arr[i],currMaxi+arr[i]);
            maxi=Math.max(currMaxi,maxi);

            currMini=Math.min(arr[i],currMini+arr[i]);
            mini=Math.min(currMini,mini);
            totSum+=arr[i];
        }
        System.out.println(totSum+" "+mini+" "+maxi);

        if(maxi<0) return maxi;
        return Math.max(maxi,totSum-mini);
        
    }
}