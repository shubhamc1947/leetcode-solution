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
        int dp[][][]=new int[n+1][2][3];// buy=>0,1 , cap=>2,1,0
        
        //base i==n ? j=0,1  k=2,1,0
        // dp[n][0][2]=0;
        // dp[n][1][2]=0;
        // dp[n][0][1]=0;
        // dp[n][1][1]=0;
        // dp[n][0][0]=0;
        // dp[n][1][0]=0;

        // //base cap=0 ? i=0-> <=n and j=0,1 
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<2;j++){
        //         dp[i][j][0]=0;
        //     }
        // }

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int cap=1;cap<3;cap++){//tricky as cap =0 return 0 so run for 1
                    if(buy==1){ // we can sell
                        int currSell=arr[i]+dp[i+1][0][cap-1];
                        int notSell=dp[i+1][1][cap];
                        dp[i][buy][cap]= Math.max(currSell,notSell);
                    }else{ // we can buy buy=0
                        int currBuy=-arr[i]+ dp[i+1][1][cap];
                        int notBuy= dp[i+1][0][cap];
                        dp[i][buy][cap]= Math.max(currBuy,notBuy);
                    }
                }
            }
        }


        return dp[0][0][2];

    }
}