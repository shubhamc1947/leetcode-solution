class Solution {
    public int helper(List<List<Integer>> arr, int i,int j,int n){
        if(i==n-1) return arr.get(i).get(j);
        int bottom=helper(arr,i+1,j,n);
        int dia=helper(arr,i+1,j+1,n);
        return arr.get(i).get(j)+Math.min(bottom,dia);
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int n=arr.size();
        int dp[][]=new int[n][n];
        
        for(int j=0;j<n;j++){
            dp[n-1][j]=arr.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int bottom = dp[i+1][j];
                int dia =dp[i+1][j+1];
                dp[i][j]=arr.get(i).get(j)+Math.min(bottom,dia);
            }
        }
        return dp[0][0];
    }
}