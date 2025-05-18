class Solution {
    public int func(int i,int j, List<List<Integer>> arr,int n,int dp[][]){
        if(i==n-1) return arr.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int bottom=func(i+1,j,arr,n,dp)+arr.get(i).get(j);
        int diagonal=func(i+1,j+1,arr,n,dp)+arr.get(i).get(j);
        return dp[i][j]= Math.min(bottom,diagonal);
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,arr,n,dp);
    }
}