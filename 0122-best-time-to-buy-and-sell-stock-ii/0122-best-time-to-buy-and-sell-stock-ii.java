class Solution {
  
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+1][2];

        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                int notTake= dp[idx+1][buy];

                //take
                int take=-(int)1e8;
                if(buy==0){
                        take=-arr[idx]+ dp[idx+1][1];
                }else{
                        take=arr[idx]+dp[idx+1][0];
                }
                dp[idx][buy]= Math.max(take,notTake);
            }
        }

        // n-1=>0
        
        return dp[0][0];
    }
}