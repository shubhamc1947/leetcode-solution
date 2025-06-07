class Solution {
    public int maxProfit(int[] arr, int fee) {
        int n=arr.length;

        int dp[][]=new int[n+1][2];
        
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    //sell
                    int currSell=arr[idx]-fee+ dp[idx+1][0];
                    int notSell= dp[idx+1][1];
                    dp[idx][buy] = Math.max(currSell,notSell);
                }else{//0
                    //buy
                    int currBuy=-arr[idx]+ dp[idx+1][1];
                    int notBuy=dp[idx+1][0];
                    dp[idx][buy] = Math.max(currBuy,notBuy);
                }
            }
        }
        return dp[0][0];
    }
}