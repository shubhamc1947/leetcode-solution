class Solution {
 
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int dp[][]=new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j]=arr.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int bottom=arr.get(i).get(j)+dp[i+1][j];
                int dia=arr.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]= Math.min(bottom,dia);
            }
        }
        return dp[0][0];
    }
}