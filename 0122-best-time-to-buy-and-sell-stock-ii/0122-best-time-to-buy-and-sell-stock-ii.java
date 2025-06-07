class Solution {
    
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+1][2];// one extra for base case 

        //base case 
        dp[n][0]=dp[n][1]=0;//no need by default but added
        for(int idx=n-1;idx>=0;idx--){
            for(int j=0;j<2;j++){
                if(j==1){
                    //either sell here 
                    int currSell=arr[idx]+dp[idx+1][0];
                    // or don't sell here
                    int notSell=dp[idx+1][1];
                    dp[idx][j]= Math.max(currSell,notSell);
                }else{// buy==0
                    // either buy here
                    int currBuy=-arr[idx]+dp[idx+1][1];
                    int notBuy=dp[idx+1][0];
                    dp[idx][j]= Math.max(currBuy,notBuy);
                }
            }
        }
        return dp[0][0];
    }
}