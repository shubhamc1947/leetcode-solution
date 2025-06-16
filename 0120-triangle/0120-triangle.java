class Solution {
    public int func(List<List<Integer>> arr,int i,int j,int n,int dp[][]){
        if(i==n-1) return arr.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int bottom=func(arr,i+1,j,n,dp)+arr.get(i).get(j);
        int dia=func(arr,i+1,j+1,n,dp)+arr.get(i).get(j);
        return dp[i][j]= Math.min(bottom,dia);
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,0,0,n,dp);
    }
}