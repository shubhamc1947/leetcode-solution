class Solution {
    public int helper(int []prices,int idx,int buy,int n, int dp[][]){
        if(idx==n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            //
            int buyToday=-prices[idx]+helper(prices,idx+1,0,n,dp);
            int notBuyToday=0+helper(prices,idx+1,1,n,dp);
            return dp[idx][buy]= Math.max(buyToday,notBuyToday);
        }else{
            int sellToday=prices[idx]+helper(prices,idx+1,1,n,dp);
            int notSellToday=0+helper(prices,idx+1,0,n,dp);
            return dp[idx][buy]= Math.max(sellToday,notSellToday);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(prices,0,1,n,dp);
    }
}