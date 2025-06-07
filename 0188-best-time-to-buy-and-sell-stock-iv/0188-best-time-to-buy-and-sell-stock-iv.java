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
        int dp[][][]=new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(arr,0,0,k,n,dp);
    }
}