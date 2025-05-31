class Solution {
    public int func(int arr[],int tar,int idx,int dp[][]){
        if(idx==0){
            if(tar%arr[0]==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[idx][tar]!=-1) return dp[idx][tar];

        //not Take
        int notTake=0+func(arr,tar,idx-1,dp);

        int take=0;
        if(tar>=arr[idx]){
            take=func(arr,tar-arr[idx],idx,dp);
        }
        return dp[idx][tar]= take+notTake;
    }
    public int change(int tar, int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n][tar+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,tar,n-1,dp);
    }
}