class Solution {
    public int func(int arr[],int fee,int idx,int n,int buy,int dp[][]){
        if(idx==n){
            return 0;
        }
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            //sell
            int currSell=arr[idx]-fee+func(arr,fee,idx+1,n,0,dp);
            int notSell=func(arr,fee,idx+1,n,1,dp);
            return dp[idx][buy] = Math.max(currSell,notSell);
        }else{//0
            //buy
            int currBuy=-arr[idx]+func(arr,fee,idx+1,n,1,dp);
            int notBuy=func(arr,fee,idx+1,n,0,dp);
            return dp[idx][buy] = Math.max(currBuy,notBuy);
        }
    }
    public int maxProfit(int[] arr, int fee) {
        int n=arr.length;

        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,fee,0,arr.length,0,dp);
    }
}