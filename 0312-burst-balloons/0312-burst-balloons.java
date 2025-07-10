class Solution {
    public int func(ArrayList<Integer> arr,int i,int j,int dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxi=Integer.MIN_VALUE;
        for(int x=i;x<=j;x++){
            int curr=arr.get(x)*arr.get(i-1)*arr.get(j+1)+func(arr,i,x-1,dp)+func(arr,x+1,j,dp);
            maxi=Math.max(maxi,curr);
        }
        return dp[i][j]= maxi;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        for(int i=0;i<n;i++) arr.add(nums[i]);
        arr.add(1);
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n+1;i++) Arrays.fill(dp[i],-1);
        return func(arr,1,n,dp);

    }
}