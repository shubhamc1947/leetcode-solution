class Solution {
    public int func(int arr[],int idx,int buy,int n,int k,int dp[][][]){
        if(idx==n) return 0;
        if(k==2) return 0;
        if(dp[idx][buy][k]!=-1) return dp[idx][buy][k];
        //nottake
        int notTake=func(arr,idx+1,buy,n,k,dp);

        //take
        int take=-(int)1e9;
        if(buy==0){
            take= -arr[idx]+ func(arr,idx+1,1,n,k,dp);
        }else{
            take=arr[idx]+func(arr,idx+1,0,n,k+1,dp);
        }
        return dp[idx][buy][k]= Math.max(take,notTake);
    }
    public int maxProfit(int[] arr) {
        // 0=>n
        int n=arr.length;
        int k=3;
        int dp[][][]=new int[n+1][2][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(arr,0,0,arr.length,0,dp);
    }
}