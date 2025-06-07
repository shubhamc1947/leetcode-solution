class Solution {
    public int func(int arr[],int idx,int buy,int cap,int n,int dp[][][]){
        if(idx==n || cap==0) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==1){//we can sell
            int currSell=arr[idx]+func(arr,idx+1,0,cap-1,n,dp);
            int notSell=0+func(arr,idx+1,1,cap,n,dp);
            return dp[idx][buy][cap]= Math.max(currSell,notSell);
        }else{//buy =0
            int currBuy=-arr[idx]+func(arr,idx+1,1,cap,n,dp);
            int notBuy =func(arr,idx+1,0,cap,n,dp);
            return dp[idx][buy][cap]= Math.max(currBuy,notBuy);
        }
    }
    public int maxProfit(int k, int[] arr) {
        int n=arr.length;
        int dp[][][]=new int[n+1][2][k+1];
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                for(int cap=k;cap>0;cap--){
                    if(buy==1){//we can sell
                        int currSell=arr[idx]+dp[idx+1][0][cap-1];
                        int notSell=0+ dp[idx+1][1][cap];
                        dp[idx][buy][cap]= Math.max(currSell,notSell);
                    }else{//buy =0
                        // System.out.println(cap);
                        int currBuy=-arr[idx]+dp[idx+1][1][cap];
                        int notBuy =dp[idx+1][0][cap];
                        dp[idx][buy][cap]= Math.max(currBuy,notBuy);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}