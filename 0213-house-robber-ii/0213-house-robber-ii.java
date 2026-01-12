class Solution {
    public int helper(int arr[],int idx,int dp[]){
        if(idx==0) return arr[0];
        if(idx==1) return Math.max(arr[0],arr[1]);
        if(dp[idx]!=-1) return dp[idx];
        //take
        int take=helper(arr,idx-2,dp)+arr[idx];
        //nottake
        int notTake=helper(arr,idx-1,dp)+0;
        dp[idx]=Math.max(take,notTake);
        return dp[idx];
    }
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        int takeFirstEle[]=new int[n-1];
        int takeSecondElement[]=new int[n-1];

        for(int i=0;i<n-1;i++){
            takeFirstEle[i]=arr[i];
            takeSecondElement[i]=arr[i+1];
        }
        int dp[]=new int[n-1];
        Arrays.fill(dp,-1);
        int first=helper(takeFirstEle,n-2,dp);
        Arrays.fill(dp,-1);
        int second=helper(takeSecondElement,n-2,dp);
        return Math.max(first,second);
    }
}