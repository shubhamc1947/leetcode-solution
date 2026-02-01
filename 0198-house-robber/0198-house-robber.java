class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        int prev2=arr[0];
        int prev1=Math.max(arr[0],arr[1]);
        for(int idx=2;idx<n;idx++){
            int take=arr[idx]+prev2;
            int notTake=0+prev1;
            int curr=Math.max(take,notTake);

            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}