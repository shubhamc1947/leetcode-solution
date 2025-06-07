class Solution {
    public int func(int arr[],int idx,int buy,int n,int dp[][]){
        if(idx>=n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){ //sell
            int currSell=arr[idx]+func(arr,idx+2,0,n,dp);
            int notSell=0+func(arr,idx+1,1,n,dp);
            return dp[idx][buy]= Math.max(currSell,notSell);
        }else{//buy
            // System.out.println(idx);
            int currBuy=-arr[idx]+func(arr,idx+1,1,n,dp);
            int notBuy=0+func(arr,idx+1,0,n,dp);
            return dp[idx][buy]= Math.max(currBuy,notBuy);
        }
    }
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,0,0,arr.length,dp);

    }
}