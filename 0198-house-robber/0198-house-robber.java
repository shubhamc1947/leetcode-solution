class Solution {
   
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);

        int dp[]=new int[n];

        dp[0] = arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int idx=2;idx<n;idx++){
            int take=0+dp[idx-1];
            int notTake=arr[idx]+dp[idx-2];
            dp[idx]= Math.max(take,notTake);
        }
        
        return dp[n-1];
    }
}