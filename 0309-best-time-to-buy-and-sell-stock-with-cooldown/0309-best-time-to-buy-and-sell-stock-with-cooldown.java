class Solution {
    // public int func(int arr[],int idx,int buy,int n,int dp[][]){
    //     if(idx>=n) return 0;
    //     if(dp[idx][buy]!=-1) return dp[idx][buy];
    //     if(buy==1){ //sell
    //         int currSell=arr[idx]+func(arr,idx+2,0,n,dp);
    //         int notSell=0+func(arr,idx+1,1,n,dp);
    //         return dp[idx][buy]= Math.max(currSell,notSell);
    //     }else{//buy
    //         // System.out.println(idx);
    //         int currBuy=-arr[idx]+func(arr,idx+1,1,n,dp);
    //         int notBuy=0+func(arr,idx+1,0,n,dp);
    //         return dp[idx][buy]= Math.max(currBuy,notBuy);
    //     }
    // }
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