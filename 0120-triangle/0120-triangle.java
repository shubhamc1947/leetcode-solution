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
        
        int prev[]=new int[n];
        for(int j=0;j<n;j++){
            prev[j]=tri.get(n-1).get(j);
        }
        int temp[]=new int[n];
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int bottom= tri.get(i).get(j)+prev[j];
                int dia=tri.get(i).get(j)+prev[j+1];
                temp[j]= Math.min(bottom,dia);
            }
            prev=temp;
        }

        return prev[0];
    }
}