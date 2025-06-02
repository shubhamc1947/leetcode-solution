class Solution {
    //One Based indexing solution
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    //
                    int take=dp[i-1][j-1];//take the current char from s
                    int notTake=dp[i-1][j];//dont take the current char from s
                    dp[i][j]= take+notTake;
                }else{
                    // don't Take
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}