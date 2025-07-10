class Solution {
    public int func(int arr[],int idx,int n,int buy,int dp[][]){
        if(idx==n) return 0;

        if(dp[idx][buy]!=-1) return dp[idx][buy];
        //not take
        int notTake=func(arr,idx+1,n,buy,dp);

        //take
        int take=-(int)1e8;
        if(buy==0){
             take=-arr[idx]+func(arr,idx+1,n,1,dp);
        }else{
             take=arr[idx]+func(arr,idx+1,n,0,dp);
        }
        return dp[idx][buy]= Math.max(take,notTake); 
    }
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+1][2];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,0,arr.length,0,dp);
    }
}