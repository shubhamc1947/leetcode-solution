class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+2][2];
        for(int idx=n-1;idx>=0;idx--){
            int currSell=arr[idx]+dp[idx+2][0];
            int notSell=0+dp[idx+1][1];
            dp[idx][1]= Math.max(currSell,notSell);
            // System.out.println(idx);
            int currBuy=-arr[idx]+dp[idx+1][1];
            int notBuy=0+dp[idx+1][0];
            dp[idx][0]= Math.max(currBuy,notBuy);
        }
        
        return dp[0][0];

    }
}