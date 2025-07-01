class Solution {
    public int func(List<List<Integer>> arr,int n,int i,int j,int dp[][]){
        if(i==n-1){
            return arr.get(i).get(j);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int bottom=arr.get(i).get(j)+func(arr,n,i+1,j,dp);
        int dia=arr.get(i).get(j)+func(arr,n,i+1,j+1,dp);
        return dp[i][j]= Math.min(bottom,dia);
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(arr,n,0,0,dp);
    }
}