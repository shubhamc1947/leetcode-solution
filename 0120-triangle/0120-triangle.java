class Solution {
    public int f(List<List<Integer>>arr,int i,int j,int n,int m,int dp[][] ){
        if(i==n-1) return arr.get(i).get(j);

        if(dp[i][j]!=-1) return dp[i][j];
        int bottom =f(arr,i+1,j,n,m,dp)+arr.get(i).get(j);
        int diag=f(arr,i+1,j+1,n,m,dp)+arr.get(i).get(j);

        return dp[i][j]= Math.min(bottom,diag);

    }
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int m=arr.get(n-1).size();

        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return f(arr,0,0,n,m,dp);
    }
}