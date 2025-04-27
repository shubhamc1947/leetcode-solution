class Solution {
    
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int m=arr.get(n-1).size();

        int dp[][]=new int[n][m];
        
        //base case
        for(int j=0;j<m;j++){
            dp[n-1][j]=arr.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int bottom=dp[i+1][j]+arr.get(i).get(j);
                int dia=dp[i+1][j+1]+arr.get(i).get(j);
                dp[i][j]=Math.min(bottom,dia);
            }
        }
        return dp[0][0];
    }
}