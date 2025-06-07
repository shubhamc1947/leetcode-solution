class Solution {
    public int func(int arr[],int i,int buy,int cap,int n,int dp[][][]){
        if(cap==0)return 0;
        if(i==n) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        if(buy==1){ // we can sell
            int currSell=arr[i]+func(arr,i+1,0,cap-1,n,dp);
            int notSell=func(arr,i+1,1,cap,n,dp);
            return dp[i][buy][cap]= Math.max(currSell,notSell);
        }else{ // we can buy buy=0
            int currBuy=-arr[i]+func(arr,i+1,1,cap,n,dp);
            int notBuy=func(arr,i+1,0,cap,n,dp);
            return dp[i][buy][cap]= Math.max(currBuy,notBuy);
        }

    }
    public int maxProfit(int[] arr) {    
        int n=arr.length;
        int dp[][][]=new int[n][2][3];// buy=>0,1 , cap=>2,1,0
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(arr,0,0,2,n,dp);

    }
}