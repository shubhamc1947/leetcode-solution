class Solution {
    public int helper(List<List<Integer>> tri,int i,int j,int n, int dp[][]){
        if(i==n-1) return tri.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int bottom= tri.get(i).get(j)+helper(tri,i+1,j,n,dp);
        int dia=tri.get(i).get(j)+helper(tri,i+1,j+1,n,dp);
        return dp[i][j]= Math.min(bottom,dia);
    }
    public int minimumTotal(List<List<Integer>> tri) {
        int n=tri.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        // return helper(tri,0,0,n,dp);
        for(int j=0;j<n;j++){
            dp[n-1][j]=tri.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int bottom= tri.get(i).get(j)+dp[i+1][j];
                int dia=tri.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]= Math.min(bottom,dia);
            }
        }

        return dp[0][0];
    }
}