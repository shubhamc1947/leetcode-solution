class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+2][2];
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                if(buy==1){ //sell
                    int currSell=arr[idx]+dp[idx+2][0];
                    int notSell=0+dp[idx+1][1];
                    dp[idx][buy]= Math.max(currSell,notSell);
                }else{//buy
                    // System.out.println(idx);
                    int currBuy=-arr[idx]+dp[idx+1][1];
                    int notBuy=0+dp[idx+1][0];
                    dp[idx][buy]= Math.max(currBuy,notBuy);
                }
            }
        }
        
        return dp[0][0];

    }
}