class Solution {
    
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+1][n+1];
        //n-1=>0 and n-1=>-1
        for(int idx=n-1;idx>=0;idx--){
            for(int prev=n-1;prev>=-1;prev--){
                int notTake=0+dp[idx+1][prev+1];
                int take=Integer.MIN_VALUE;
                if(prev==-1|| arr[idx]>arr[prev]){
                    take=1+ dp[idx+1][idx+1];
                }
                dp[idx][prev+1]= Math.max(take,notTake);
            }
        }
        return dp[0][0];
    }
}