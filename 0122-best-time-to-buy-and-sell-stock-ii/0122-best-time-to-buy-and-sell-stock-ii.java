class Solution {
    // public int helper(int []prices,int idx,int buy,int n, int dp[][]){
    //     if(idx==n) return 0;
    //     if(dp[idx][buy]!=-1) return dp[idx][buy];
    //     if(buy==1){
    //         //
    //         int buyToday=-prices[idx]+helper(prices,idx+1,0,n,dp);
    //         int notBuyToday=0+helper(prices,idx+1,1,n,dp);
    //         return dp[idx][buy]= Math.max(buyToday,notBuyToday);
    //     }else{
    //         int sellToday=prices[idx]+helper(prices,idx+1,1,n,dp);
    //         int notSellToday=0+helper(prices,idx+1,0,n,dp);
    //         return dp[idx][buy]= Math.max(sellToday,notSellToday);
    //     }
    // }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int prev[]=new int[2];

        for(int idx=n-1;idx>=0;idx--){
            int temp[]=new int[2];
            for(int buy=0;buy<2;buy++){
                if(buy==1){
                    int buyToday=-prices[idx]+ prev[0];
                    int notBuyToday=0+ prev[1];
                    temp[buy]= Math.max(buyToday,notBuyToday);
                }else{
                    int sellToday=prices[idx]+prev[1];
                    int notSellToday=0+ prev[0];
                    temp[buy]= Math.max(sellToday,notSellToday);
                }
            }
            prev=temp;
        }
        return prev[1];
    }
}